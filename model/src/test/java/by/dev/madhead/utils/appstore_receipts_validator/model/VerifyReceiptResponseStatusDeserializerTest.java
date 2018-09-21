package by.dev.madhead.utils.appstore_receipts_validator.model;

import by.dev.madhead.utils.appstore_receipts_validator.mapper.ObjectMapperFactory;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.Objects;

public class VerifyReceiptResponseStatusDeserializerTest {
    private static class VerifyReceiptResponseStatusHolder {
        @JsonProperty("status")
        private VerifyReceiptResponse.Status status;

        public VerifyReceiptResponseStatusHolder() {
        }

        public VerifyReceiptResponseStatusHolder(final VerifyReceiptResponse.Status status) {
            this.status = status;
        }

        public VerifyReceiptResponse.Status getStatus() {
            return status;
        }

        public void setStatus(final VerifyReceiptResponse.Status status) {
            this.status = status;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            final VerifyReceiptResponseStatusHolder that = (VerifyReceiptResponseStatusHolder) o;

            return status == that.status;
        }

        @Override
        public int hashCode() {
            return Objects.hash(status);
        }

        @Override
        public String toString() {
            return MoreObjects
                .toStringHelper(this)
                .add("status", status)
                .toString();
        }
    }

    private ObjectMapper objectMapper;

    @BeforeEach
    private void bedoreEach() {
        this.objectMapper = ObjectMapperFactory.defaultObjectMapper();
    }

    @ParameterizedTest
    @EnumSource(VerifyReceiptResponse.Status.class)
    public void testDeserialization(final VerifyReceiptResponse.Status value) throws Exception {
        Assertions.assertEquals(
            new VerifyReceiptResponseStatusHolder(
                value
            ),
            objectMapper.readValue(getClass().getResource("VerifyReceiptResponseStatusDeserializerTest/testDeserialization_" + value.name() + ".json"), VerifyReceiptResponseStatusHolder.class)
        );
    }

    @Test
    public void testDeserializationUnknownValue() throws Exception {
        Assertions.assertThrows(
            JsonMappingException.class,
            () -> objectMapper.readValue(getClass().getResource("VerifyReceiptResponseStatusDeserializerTest/testDeserializationUnknownValue.json"), VerifyReceiptResponseStatusHolder.class)
        );
    }

    @Test
    public void testDeserializationInvalidValue() throws Exception {
        Assertions.assertThrows(
            JsonMappingException.class,
            () -> objectMapper.readValue(getClass().getResource("VerifyReceiptResponseStatusDeserializerTest/testDeserializationInvalidValue.json"), VerifyReceiptResponseStatusHolder.class)
        );
    }
}
