package by.dev.madhead.utils.appstore_receipts_validator.mapper;

import by.dev.madhead.utils.appstore_receipts_validator.model.Receipt;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.Objects;

public class ReceiptReceiptTypeDeserializerTest {

    private ObjectMapper objectMapper;

    @BeforeEach
    private void beforeEach() {
        this.objectMapper = ObjectMapperFactory.defaultObjectMapper();
    }

    @ParameterizedTest
    @EnumSource(Receipt.ReceiptType.class)
    public void testDeserialization(final Receipt.ReceiptType type) throws Exception {
        Assertions.assertEquals(
            new ReceiptTypeHolder(
                type
            ),
            objectMapper.readValue(
                getClass().getResource("ReceiptReceiptTypeDeserializerTest/testDeserialization_" + type.name() + ".json"),
                ReceiptTypeHolder.class
            )
        );
    }

    @Test
    public void testDeserializationUnknownValue() {
        Assertions.assertThrows(
            JsonMappingException.class,
            () -> objectMapper.readValue(
                getClass().getResource("ReceiptReceiptTypeDeserializerTest/testDeserializationUnknownValue.json"),
                ReceiptTypeHolder.class
            )
        );
    }

    @Test
    public void testDeserializationInvalidValue() {
        Assertions.assertThrows(
            JsonMappingException.class,
            () -> objectMapper.readValue(
                getClass().getResource("ReceiptReceiptTypeDeserializerTest/testDeserializationInvalidValue.json"),
                ReceiptTypeHolder.class
            )
        );
    }


    private static class ReceiptTypeHolder {

        @JsonProperty("receipt_type")
        private Receipt.ReceiptType receiptType;

        public ReceiptTypeHolder() {
        }

        public ReceiptTypeHolder(Receipt.ReceiptType receiptType) {
            this.receiptType = receiptType;
        }

        public Receipt.ReceiptType getReceiptType() {
            return receiptType;
        }

        public void setReceiptType(Receipt.ReceiptType receiptType) {
            this.receiptType = receiptType;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ReceiptTypeHolder that = (ReceiptTypeHolder) o;
            return receiptType == that.receiptType;
        }

        @Override
        public int hashCode() {
            return Objects.hash(receiptType);
        }
    }
}
