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

public class InAppAutoRenewStatusDeserializerTest {
    private static class AutoRenewStatusHolder {
        @JsonProperty("auto_renew_status")
        private InApp.AutoRenewStatus autoRenewStatus;

        public AutoRenewStatusHolder() {
        }

        public AutoRenewStatusHolder(final InApp.AutoRenewStatus autoRenewStatus) {
            this.autoRenewStatus = autoRenewStatus;
        }

        public InApp.AutoRenewStatus getAutoRenewStatus() {
            return autoRenewStatus;
        }

        public void setAutoRenewStatus(final InApp.AutoRenewStatus autoRenewStatus) {
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
            return MoreObjects
                .toStringHelper(this)
                .add("autoRenewStatus", autoRenewStatus)
                .toString();
        }
    }

    private ObjectMapper objectMapper;

    @BeforeEach
    private void bedoreEach() {
        this.objectMapper = ObjectMapperFactory.defaultObjectMapper();
    }

    @ParameterizedTest
    @EnumSource(InApp.AutoRenewStatus.class)
    public void testDeserialization(final InApp.AutoRenewStatus value) throws Exception {
        Assertions.assertEquals(
            new AutoRenewStatusHolder(
                value
            ),
            objectMapper.readValue(getClass().getResource("InAppAutoRenewStatusDeserializerTest/testDeserialization_" + value.name() + ".json"), AutoRenewStatusHolder.class)
        );
    }

    @Test
    public void testDeserializationUnknownValue() {
        Assertions.assertThrows(
            JsonMappingException.class,
            () -> objectMapper.readValue(getClass().getResource("InAppAutoRenewStatusDeserializerTest/testDeserializationUnknownValue.json"), AutoRenewStatusHolder.class)
        );
    }

    @Test
    public void testDeserializationInvalidValue() {
        Assertions.assertThrows(
            JsonMappingException.class,
            () -> objectMapper.readValue(getClass().getResource("InAppAutoRenewStatusDeserializerTest/testDeserializationInvalidValue.json"), AutoRenewStatusHolder.class)
        );
    }
}
