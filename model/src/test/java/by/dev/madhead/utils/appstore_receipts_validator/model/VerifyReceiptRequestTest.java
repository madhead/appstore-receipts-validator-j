package by.dev.madhead.utils.appstore_receipts_validator.model;

import by.dev.madhead.utils.appstore_receipts_validator.mapper.ObjectMapperFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.util.Scanner;

class VerifyReceiptRequestTest {
    private ObjectMapper objectMapper;

    @BeforeEach
    private void bedoreEach() {
        this.objectMapper = ObjectMapperFactory.defaultObjectMapper();
    }

    @Test
    public void testJSONSerializationAllFields() throws Exception {
        final VerifyReceiptRequest request = new VerifyReceiptRequest(
            "0DEBA631B837DB11DC3B4D3E9D0F27A0A0031A584B97F74B07C758211F3AA4A9",
            "42e567b91c737958b7eccbb144a28d1e",
            true
        );

        JSONAssert.assertEquals(
            new Scanner(getClass().getResourceAsStream("VerifyReceiptRequestTest/testSerializationAllFields.json")).useDelimiter("\\A").next(),
            objectMapper.writeValueAsString(request),
            true
        );
    }

    @Test
    public void testJSONSerializationSomeFields() throws Exception {
        final VerifyReceiptRequest request = new VerifyReceiptRequest(
            "0DEBA631B837DB11DC3B4D3E9D0F27A0A0031A584B97F74B07C758211F3AA4A9"
        );

        JSONAssert.assertEquals(
            new Scanner(getClass().getResourceAsStream("VerifyReceiptRequestTest/testSerializationSomeFields.json")).useDelimiter("\\A").next(),
            objectMapper.writeValueAsString(request),
            true
        );
    }

    @Test
    public void testEquals() {
        EqualsVerifier.forClass(VerifyReceiptRequest.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    @Test
    public void testToString() throws Exception {
        Assertions.assertNotNull(
            objectMapper.readValue(getClass().getResource("VerifyReceiptRequestTest/testToString.json"), VerifyReceiptRequest.class).toString()
        );
    }
}
