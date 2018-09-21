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

public class InAppPriceConsentStatusDeserializerTest {
    private static class PriceConsentStatusHolder {
        @JsonProperty("price_consent_status")
        private InApp.PriceConsentStatus priceConsentStatus;

        public PriceConsentStatusHolder() {
        }

        public PriceConsentStatusHolder(final InApp.PriceConsentStatus priceConsentStatus) {
            this.priceConsentStatus = priceConsentStatus;
        }

        public InApp.PriceConsentStatus getPriceConsentStatus() {
            return priceConsentStatus;
        }

        public void setPriceConsentStatus(final InApp.PriceConsentStatus priceConsentStatus) {
            this.priceConsentStatus = priceConsentStatus;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            final PriceConsentStatusHolder that = (PriceConsentStatusHolder) o;

            return priceConsentStatus == that.priceConsentStatus;
        }

        @Override
        public int hashCode() {
            return Objects.hash(priceConsentStatus);
        }

        @Override
        public String toString() {
            return MoreObjects
                .toStringHelper(this)
                .add("priceConsentStatus", priceConsentStatus)
                .toString();
        }
    }

    private ObjectMapper objectMapper;

    @BeforeEach
    private void bedoreEach() {
        this.objectMapper = ObjectMapperFactory.defaultObjectMapper();
    }

    @ParameterizedTest
    @EnumSource(InApp.PriceConsentStatus.class)
    public void testDeserialization(final InApp.PriceConsentStatus value) throws Exception {
        Assertions.assertEquals(
            new PriceConsentStatusHolder(
                value
            ),
            objectMapper.readValue(getClass().getResource("InAppPriceConsentStatusDeserializerTest/testDeserialization_" + value.name() + ".json"), PriceConsentStatusHolder.class)
        );
    }

    @Test
    public void testDeserializationUnknownValue() {
        Assertions.assertThrows(
            JsonMappingException.class,
            () -> objectMapper.readValue(getClass().getResource("InAppPriceConsentStatusDeserializerTest/testDeserializationUnknownValue.json"), PriceConsentStatusHolder.class)
        );
    }

    @Test
    public void testDeserializationInvalidValue() {
        Assertions.assertThrows(
            JsonMappingException.class,
            () -> objectMapper.readValue(getClass().getResource("InAppPriceConsentStatusDeserializerTest/testDeserializationInvalidValue.json"), PriceConsentStatusHolder.class)
        );
    }
}
