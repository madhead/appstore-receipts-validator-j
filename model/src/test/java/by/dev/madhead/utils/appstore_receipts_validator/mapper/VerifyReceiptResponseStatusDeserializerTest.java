package by.dev.madhead.utils.appstore_receipts_validator.mapper;

import by.dev.madhead.utils.appstore_receipts_validator.model.VerifyReceiptResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.Objects;
import java.util.StringJoiner;

public class VerifyReceiptResponseStatusDeserializerTest {
    private ObjectMapper objectMapper;

    @BeforeEach
    private void beforeEach() {
        this.objectMapper = ObjectMapperFactory.defaultObjectMapper();
    }

    @ParameterizedTest
    @EnumSource(value = VerifyReceiptResponse.Status.class, mode = EnumSource.Mode.EXCLUDE, names = {"WRONG_ENVIRONMENT", "INTERNAL_ERROR"})
    public void testDeserialization(final VerifyReceiptResponse.Status value) throws Exception {
        Assertions.assertEquals(
            new VerifyReceiptResponseStatusHolder(
                value
            ),
            objectMapper.readValue(
                getClass().getResource("VerifyReceiptResponseStatusDeserializerTest/testDeserialization_" + value.name() + ".json"),
                VerifyReceiptResponseStatusHolder.class
            )
        );
    }

    @Test
    public void testDeserializationWrongEnvironment() throws Exception {
        Assertions.assertEquals(
            new VerifyReceiptResponseStatusHolder(
                VerifyReceiptResponse.Status.WRONG_ENVIRONMENT
            ),
            objectMapper.readValue(
                getClass().getResource("VerifyReceiptResponseStatusDeserializerTest/testDeserializationWrongEnvironment1.json"),
                VerifyReceiptResponseStatusHolder.class
            )
        );
        Assertions.assertEquals(
            new VerifyReceiptResponseStatusHolder(
                VerifyReceiptResponse.Status.WRONG_ENVIRONMENT
            ),
            objectMapper.readValue(
                getClass().getResource("VerifyReceiptResponseStatusDeserializerTest/testDeserializationWrongEnvironment2.json"),
                VerifyReceiptResponseStatusHolder.class
            )
        );
    }

    @Test
    public void testDeserializationInternalError() throws Exception {
        Assertions.assertEquals(
            new VerifyReceiptResponseStatusHolder(
                VerifyReceiptResponse.Status.INTERNAL_ERROR
            ),
            objectMapper.readValue(
                getClass().getResource("VerifyReceiptResponseStatusDeserializerTest/testDeserializationInternalError.json"),
                VerifyReceiptResponseStatusHolder.class
            )
        );
    }

    @Test
    public void testDeserializationUnknownValue() {
        Assertions.assertThrows(
            JsonMappingException.class,
            () -> objectMapper.readValue(
                getClass().getResource("VerifyReceiptResponseStatusDeserializerTest/testDeserializationUnknownValue1.json"),
                VerifyReceiptResponseStatusHolder.class
            )
        );
        Assertions.assertThrows(
            JsonMappingException.class,
            () -> objectMapper.readValue(
                getClass().getResource("VerifyReceiptResponseStatusDeserializerTest/testDeserializationUnknownValue2.json"),
                VerifyReceiptResponseStatusHolder.class
            )
        );
    }

    @Test
    public void testDeserializationInvalidValue() {
        Assertions.assertThrows(
            JsonMappingException.class,
            () -> objectMapper.readValue(
                getClass().getResource("VerifyReceiptResponseStatusDeserializerTest/testDeserializationInvalidValue.json"),
                VerifyReceiptResponseStatusHolder.class
            )
        );
    }

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
            return new StringJoiner(", ", VerifyReceiptResponseStatusHolder.class.getSimpleName() + "[", "]")
                .add("status=" + status)
                .toString();
        }
    }
}
