package by.dev.madhead.utils.appstore_receipts_validator.mapper;

import by.dev.madhead.utils.appstore_receipts_validator.model.InApp;
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

public class InAppExpirationIntentDeserializerTest {
    private static class ExpirationIntentHolder {
        @JsonProperty("expiration_intent")
        private InApp.ExpirationIntent expirationIntent;

        public ExpirationIntentHolder() {
        }

        public ExpirationIntentHolder(final InApp.ExpirationIntent expirationIntent) {
            this.expirationIntent = expirationIntent;
        }

        public InApp.ExpirationIntent getExpirationIntent() {
            return expirationIntent;
        }

        public void setExpirationIntent(final InApp.ExpirationIntent expirationIntent) {
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
            return MoreObjects
                .toStringHelper(this)
                .add("expirationIntent", expirationIntent)
                .toString();
        }
    }

    private ObjectMapper objectMapper;

    @BeforeEach
    private void bedoreEach() {
        this.objectMapper = ObjectMapperFactory.defaultObjectMapper();
    }

    @ParameterizedTest
    @EnumSource(InApp.ExpirationIntent.class)
    public void testDeserialization(final InApp.ExpirationIntent value) throws Exception {
        Assertions.assertEquals(
            new ExpirationIntentHolder(
                value
            ),
            objectMapper.readValue(getClass().getResource("InAppExpirationIntentDeserializerTest/testDeserialization_" + value.name() + ".json"), ExpirationIntentHolder.class)
        );
    }

    @Test
    public void testDeserializationUnknownValue() {
        Assertions.assertThrows(
            JsonMappingException.class,
            () -> objectMapper.readValue(getClass().getResource("InAppExpirationIntentDeserializerTest/testDeserializationUnknownValue.json"), ExpirationIntentHolder.class)
        );
    }

    @Test
    public void testDeserializationInvalidValue() {
        Assertions.assertThrows(
            JsonMappingException.class,
            () -> objectMapper.readValue(getClass().getResource("InAppExpirationIntentDeserializerTest/testDeserializationInvalidValue.json"), ExpirationIntentHolder.class)
        );
    }
}
