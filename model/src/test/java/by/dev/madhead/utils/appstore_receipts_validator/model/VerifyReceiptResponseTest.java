package by.dev.madhead.utils.appstore_receipts_validator.model;

import by.dev.madhead.utils.appstore_receipts_validator.mapper.ObjectMapperFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VerifyReceiptResponseTest {
    private ObjectMapper objectMapper;

    @BeforeEach
    private void bedoreEach() {
        this.objectMapper = ObjectMapperFactory.defaultObjectMapper();
    }

    @Test
    public void testDeserialization() throws Exception {
        final VerifyReceiptResponse value = objectMapper.readValue(
            getClass().getResource("VerifyReceiptResponseTest/testDeserialization.json"),
            VerifyReceiptResponse.class
        );

        Assertions.assertEquals(VerifyReceiptResponse.Status.VALID, value.getStatus());
        Assertions.assertNotNull(value.getReceipt());
        Assertions.assertEquals("latest_receipt", value.getLatestReceipt());
        Assertions.assertEquals(1, value.getLatestReceiptInfo().size());
        Assertions.assertNotNull(value.getLatestExpiredReceiptInfo());
        Assertions.assertEquals(Boolean.TRUE, value.getRetryable());
    }

    @Test
    public void testDeserializationSingleLatestReceiptInfo() throws Exception {
        final VerifyReceiptResponse value = objectMapper.readValue(
            getClass().getResource("VerifyReceiptResponseTest/testDeserializationSingleLatestReceiptInfo.json"),
            VerifyReceiptResponse.class
        );

        Assertions.assertEquals(1, value.getLatestReceiptInfo().size());
    }

    @Test
    public void testEquals() {
        EqualsVerifier.forClass(VerifyReceiptResponse.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    @Test
    public void testToString() throws Exception {
        Assertions.assertNotNull(
            objectMapper.readValue(getClass().getResource("VerifyReceiptResponseTest/testToString.json"), VerifyReceiptResponse.class).toString()
        );
    }
}
