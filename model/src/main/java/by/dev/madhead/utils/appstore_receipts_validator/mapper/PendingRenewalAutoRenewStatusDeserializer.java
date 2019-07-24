package by.dev.madhead.utils.appstore_receipts_validator.mapper;

import by.dev.madhead.utils.appstore_receipts_validator.model.PendingRenewal;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class PendingRenewalAutoRenewStatusDeserializer extends StdScalarDeserializer<PendingRenewal.AutoRenewStatus> {
    public PendingRenewalAutoRenewStatusDeserializer() {
        super(PendingRenewal.AutoRenewStatus.class);
    }

    @Override
    public PendingRenewal.AutoRenewStatus deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {
        if (p.currentToken() != JsonToken.VALUE_STRING) {
            throw new InvalidFormatException(p, "Invalid Autorenew Status", null, PendingRenewal.AutoRenewStatus.class);
        } else {
            switch (p.getValueAsString()) {
                case "0":
                    return PendingRenewal.AutoRenewStatus.OFF;
                case "1":
                    return PendingRenewal.AutoRenewStatus.ON;
                default:
                    throw new InvalidFormatException(p, "Unknown Autorenew Status", null, PendingRenewal.AutoRenewStatus.class);
            }
        }
    }
}
