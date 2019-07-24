package by.dev.madhead.utils.appstore_receipts_validator.mapper;

import by.dev.madhead.utils.appstore_receipts_validator.model.PendingRenewal;
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

public class PendingRenewalExpirationIntentDeserializerTest {
    private ObjectMapper objectMapper;

    @BeforeEach
    private void beforeEach() {
        this.objectMapper = ObjectMapperFactory.defaultObjectMapper();
    }

    @ParameterizedTest
    @EnumSource(PendingRenewal.ExpirationIntent.class)
    public void testDeserialization(final PendingRenewal.ExpirationIntent value) throws Exception {
        Assertions.assertEquals(
            new ExpirationIntentHolder(
                value
            ),
            objectMapper.readValue(
                getClass().getResource("PendingRenewalExpirationIntentDeserializerTest/testDeserialization_" + value.name() + ".json"),
                ExpirationIntentHolder.class
            )
        );
    }

    @Test
    public void testDeserializationUnknownValue() {
        Assertions.assertThrows(
            JsonMappingException.class,
            () -> objectMapper.readValue(
                getClass().getResource("PendingRenewalExpirationIntentDeserializerTest/testDeserializationUnknownValue.json"),
                ExpirationIntentHolder.class
            )
        );
    }

    @Test
    public void testDeserializationInvalidValue() {
        Assertions.assertThrows(
            JsonMappingException.class,
            () -> objectMapper.readValue(
                getClass().getResource("PendingRenewalExpirationIntentDeserializerTest/testDeserializationInvalidValue.json"),
                ExpirationIntentHolder.class
            )
        );
    }

    private static class ExpirationIntentHolder {
        @JsonProperty("expiration_intent")
        private PendingRenewal.ExpirationIntent expirationIntent;

        public ExpirationIntentHolder() {
        }

        public ExpirationIntentHolder(final PendingRenewal.ExpirationIntent expirationIntent) {
            this.expirationIntent = expirationIntent;
        }

        public PendingRenewal.ExpirationIntent getExpirationIntent() {
            return expirationIntent;
        }

        public void setExpirationIntent(final PendingRenewal.ExpirationIntent expirationIntent) {
            this.expirationIntent = expirationIntent;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            final ExpirationIntentHolder that = (ExpirationIntentHolder) o;

            return expirationIntent == that.expirationIntent;
        }

        @Override
        public int hashCode() {
            return Objects.hash(expirationIntent);
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", ExpirationIntentHolder.class.getSimpleName() + "[", "]")
                .add("expirationIntent=" + expirationIntent)
                .toString();
        }
    }
}
