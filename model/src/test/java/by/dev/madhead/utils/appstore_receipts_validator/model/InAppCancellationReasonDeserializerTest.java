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

public class InAppCancellationReasonDeserializerTest {
    private static class CancellationReasonHolder {
        @JsonProperty("cancellation_reason")
        private InApp.CancellationReason cancellationReason;

        public CancellationReasonHolder() {
        }

        public CancellationReasonHolder(final InApp.CancellationReason cancellationReason) {
            this.cancellationReason = cancellationReason;
        }

        public InApp.CancellationReason getCancellationReason() {
            return cancellationReason;
        }

        public void setCancellationReason(InApp.CancellationReason cancellationReason) {
            this.cancellationReason = cancellationReason;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            final CancellationReasonHolder that = (CancellationReasonHolder) o;

            return cancellationReason == that.cancellationReason;
        }

        @Override
        public int hashCode() {
            return Objects.hash(cancellationReason);
        }

        @Override
        public String toString() {
            return MoreObjects
                .toStringHelper(this)
                .add("cancellationReason", cancellationReason)
                .toString();
        }
    }

    private ObjectMapper objectMapper;

    @BeforeEach
    private void bedoreEach() {
        this.objectMapper = ObjectMapperFactory.defaultObjectMapper();
    }

    @ParameterizedTest
    @EnumSource(InApp.CancellationReason.class)
    public void testDeserialization(final InApp.CancellationReason value) throws Exception {
        Assertions.assertEquals(
            new CancellationReasonHolder(
                value
            ),
            objectMapper.readValue(getClass().getResource("InAppCancellationReasonDeserializerTest/testDeserialization_" + value.name() + ".json"), CancellationReasonHolder.class)
        );
    }

    @Test
    public void testDeserializationUnknownValue() throws Exception {
        Assertions.assertThrows(
            JsonMappingException.class,
            () -> objectMapper.readValue(getClass().getResource("InAppCancellationReasonDeserializerTest/testDeserializationUnknownValue.json"), CancellationReasonHolder.class)
        );
    }

    @Test
    public void testDeserializationInvalidValue() throws Exception {
        Assertions.assertThrows(
            JsonMappingException.class,
            () -> objectMapper.readValue(getClass().getResource("InAppCancellationReasonDeserializerTest/testDeserializationInvalidValue.json"), CancellationReasonHolder.class)
        );
    }
}
