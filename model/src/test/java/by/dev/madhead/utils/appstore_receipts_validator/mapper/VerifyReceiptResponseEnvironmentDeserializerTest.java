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

public class VerifyReceiptResponseEnvironmentDeserializerTest {

    private ObjectMapper objectMapper;

    @BeforeEach
    private void beforeEach() {
        this.objectMapper = ObjectMapperFactory.defaultObjectMapper();
    }

    @ParameterizedTest
    @EnumSource(VerifyReceiptResponse.Environment.class)
    public void testDeserialization(final VerifyReceiptResponse.Environment environment) throws Exception {
        Assertions.assertEquals(
            new VerifyReceiptResponseEnvironmentDeserializerHolder(
                environment
            ),
            objectMapper.readValue(
                getClass().getResource("VerifyReceiptResponseEnvironmentDeserializerTest/testDeserialization_" + environment.name() + ".json"),
                VerifyReceiptResponseEnvironmentDeserializerHolder.class
            )
        );
    }

    @Test
    public void testDeserializationUnknownValue() {
        Assertions.assertThrows(
            JsonMappingException.class,
            () -> objectMapper.readValue(
                getClass().getResource("VerifyReceiptResponseEnvironmentDeserializerTest/testDeserializationUnknownValue.json"),
                VerifyReceiptResponseEnvironmentDeserializerHolder.class
            )
        );
    }

    @Test
    public void testDeserializationInvalidValue() {
        Assertions.assertThrows(
            JsonMappingException.class,
            () -> objectMapper.readValue(
                getClass().getResource("VerifyReceiptResponseEnvironmentDeserializerTest/testDeserializationInvalidValue.json"),
                VerifyReceiptResponseEnvironmentDeserializerHolder.class
            )
        );
    }

    private static class VerifyReceiptResponseEnvironmentDeserializerHolder {

        @JsonProperty("environment")
        private VerifyReceiptResponse.Environment environment;

        public VerifyReceiptResponseEnvironmentDeserializerHolder() {
        }

        public VerifyReceiptResponseEnvironmentDeserializerHolder(final VerifyReceiptResponse.Environment environment) {
            this.environment = environment;
        }

        public VerifyReceiptResponse.Environment getEnvironment() {
            return environment;
        }

        public void setEnvironment(VerifyReceiptResponse.Environment environment) {
            this.environment = environment;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            VerifyReceiptResponseEnvironmentDeserializerHolder that = (VerifyReceiptResponseEnvironmentDeserializerHolder) o;
            return environment == that.environment;
        }

        @Override
        public int hashCode() {
            return Objects.hash(environment);
        }
    }
}


