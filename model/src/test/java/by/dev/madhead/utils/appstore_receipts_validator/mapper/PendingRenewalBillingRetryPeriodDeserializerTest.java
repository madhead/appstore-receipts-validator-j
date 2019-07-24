package by.dev.madhead.utils.appstore_receipts_validator.mapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Objects;
import java.util.StringJoiner;

public class PendingRenewalBillingRetryPeriodDeserializerTest {
    private ObjectMapper objectMapper;

    @BeforeEach
    private void beforeEach() {
        this.objectMapper = ObjectMapperFactory.defaultObjectMapper();
    }

    @ParameterizedTest
    @ValueSource(strings = {"true", "false"})
    public void testDeserialization(final String value) throws Exception {
        Assertions.assertEquals(
            new BillingRetryPeriodHolder(
                Boolean.valueOf(value)
            ),
            objectMapper.readValue(
                getClass().getResource("PendingRenewalBillingRetryPeriodDeserializerTest/testDeserialization_" + value + ".json"),
                BillingRetryPeriodHolder.class
            )
        );
    }

    @Test
    public void testDeserializationUnknownValue() {
        Assertions.assertThrows(
            JsonMappingException.class,
            () -> objectMapper.readValue(
                getClass().getResource("PendingRenewalBillingRetryPeriodDeserializerTest/testDeserializationUnknownValue.json"),
                BillingRetryPeriodHolder.class
            )
        );
    }

    @Test
    public void testDeserializationInvalidValue() {
        Assertions.assertThrows(
            JsonMappingException.class,
            () -> objectMapper.readValue(
                getClass().getResource("PendingRenewalBillingRetryPeriodDeserializerTest/testDeserializationInvalidValue.json"),
                BillingRetryPeriodHolder.class
            )
        );
    }

    private static class BillingRetryPeriodHolder {
        @JsonProperty("is_in_billing_retry_period")
        @JsonDeserialize(using = PendingRenewalBillingRetryPeriodDeserializer.class)
        private Boolean inBillingRetryPeriod;

        public BillingRetryPeriodHolder() {
        }

        public BillingRetryPeriodHolder(final Boolean inBillingRetryPeriod) {
            this.inBillingRetryPeriod = inBillingRetryPeriod;
        }

        public Boolean getInBillingRetryPeriod() {
            return inBillingRetryPeriod;
        }

        public void setInBillingRetryPeriod(Boolean inBillingRetryPeriod) {
            this.inBillingRetryPeriod = inBillingRetryPeriod;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            final BillingRetryPeriodHolder that = (BillingRetryPeriodHolder) o;

            return Objects.equals(inBillingRetryPeriod, that.inBillingRetryPeriod);
        }

        @Override
        public int hashCode() {
            return Objects.hash(inBillingRetryPeriod);
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", BillingRetryPeriodHolder.class.getSimpleName() + "[", "]")
                .add("inBillingRetryPeriod=" + inBillingRetryPeriod)
                .toString();
        }
    }
}
