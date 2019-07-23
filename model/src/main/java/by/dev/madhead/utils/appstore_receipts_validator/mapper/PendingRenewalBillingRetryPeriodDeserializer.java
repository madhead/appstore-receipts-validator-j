package by.dev.madhead.utils.appstore_receipts_validator.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class PendingRenewalBillingRetryPeriodDeserializer extends StdScalarDeserializer<Boolean> {
    protected PendingRenewalBillingRetryPeriodDeserializer() {
        super(Boolean.class);
    }

    @Override
    public Boolean deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (p.currentToken() != JsonToken.VALUE_STRING) {
            throw new InvalidFormatException(p, "Invalid Billing Retry Period", null, Boolean.class);
        } else {
            switch (p.getValueAsString()) {
                case "0":
                    return Boolean.FALSE;
                case "1":
                    return Boolean.TRUE;
                default:
                    throw new InvalidFormatException(p, "Unknown Billing Retry Period", null, Boolean.class);
            }
        }
    }
}
