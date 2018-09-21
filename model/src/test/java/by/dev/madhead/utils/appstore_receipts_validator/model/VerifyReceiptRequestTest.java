package by.dev.madhead.utils.appstore_receipts_validator.model;

import by.dev.madhead.utils.appstore_receipts_validator.mapper.ObjectMapperFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.nio.charset.StandardCharsets;

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

        JSONAssert.assertEquals(Resources.toString(getClass().getResource("VerifyReceiptRequestTest/testJSONSerializationAllFields.json"), StandardCharsets.UTF_8), objectMapper.writeValueAsString(request), true);
    }

    @Test
    public void testJSONSerializationSomeFields() throws Exception {
        final VerifyReceiptRequest request = new VerifyReceiptRequest(
            "0DEBA631B837DB11DC3B4D3E9D0F27A0A0031A584B97F74B07C758211F3AA4A9"
        );

        JSONAssert.assertEquals(Resources.toString(getClass().getResource("VerifyReceiptRequestTest/testJSONSerializationSomeFields.json"), StandardCharsets.UTF_8), objectMapper.writeValueAsString(request), true);
    }
}
