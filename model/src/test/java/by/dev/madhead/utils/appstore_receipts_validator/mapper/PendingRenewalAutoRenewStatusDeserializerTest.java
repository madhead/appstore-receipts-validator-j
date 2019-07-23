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

public class PendingRenewalAutoRenewStatusDeserializerTest {
    private ObjectMapper objectMapper;

    @BeforeEach
    private void beforeEach() {
        this.objectMapper = ObjectMapperFactory.defaultObjectMapper();
    }

    @ParameterizedTest
    @EnumSource(PendingRenewal.AutoRenewStatus.class)
    public void testDeserialization(final PendingRenewal.AutoRenewStatus value) throws Exception {
        Assertions.assertEquals(
            new AutoRenewStatusHolder(
                value
            ),
            objectMapper.readValue(
                getClass().getResource("PendingRenewalAutoRenewStatusDeserializerTest/testDeserialization_" + value.name() + ".json"),
                AutoRenewStatusHolder.class
            )
        );
    }

    @Test
    public void testDeserializationUnknownValue() {
        Assertions.assertThrows(
            JsonMappingException.class,
            () -> objectMapper.readValue(
                getClass().getResource("PendingRenewalAutoRenewStatusDeserializerTest/testDeserializationUnknownValue.json"),
                AutoRenewStatusHolder.class
            )
        );
    }

    @Test
    public void testDeserializationInvalidValue() {
        Assertions.assertThrows(
            JsonMappingException.class,
            () -> objectMapper.readValue(
                getClass().getResource("PendingRenewalAutoRenewStatusDeserializerTest/testDeserializationInvalidValue.json"),
                AutoRenewStatusHolder.class
            )
        );
    }

    private static class AutoRenewStatusHolder {
        @JsonProperty("auto_renew_status")
        private PendingRenewal.AutoRenewStatus autoRenewStatus;

        public AutoRenewStatusHolder() {
        }

        public AutoRenewStatusHolder(final PendingRenewal.AutoRenewStatus autoRenewStatus) {
            this.autoRenewStatus = autoRenewStatus;
        }

        public PendingRenewal.AutoRenewStatus getAutoRenewStatus() {
            return autoRenewStatus;
        }

        public void setAutoRenewStatus(final PendingRenewal.AutoRenewStatus autoRenewStatus) {
            this.autoRenewStatus = autoRenewStatus;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            final AutoRenewStatusHolder that = (AutoRenewStatusHolder) o;

            return autoRenewStatus == that.autoRenewStatus;
        }

        @Override
        public int hashCode() {
            return Objects.hash(autoRenewStatus);
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", AutoRenewStatusHolder.class.getSimpleName() + "[", "]")
                .add("autoRenewStatus=" + autoRenewStatus)
                .toString();
        }
    }
}
