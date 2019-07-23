package by.dev.madhead.utils.appstore_receipts_validator.mapper;

import by.dev.madhead.utils.appstore_receipts_validator.model.PendingRenewal;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class PendingRenewalPriceConsentStatusDeserializer extends StdScalarDeserializer<PendingRenewal.PriceConsentStatus> {
    public PendingRenewalPriceConsentStatusDeserializer() {
        super(PendingRenewal.PriceConsentStatus.class);
    }

    @Override
    public PendingRenewal.PriceConsentStatus deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {
        if (p.currentToken() != JsonToken.VALUE_STRING) {
            throw new InvalidFormatException(p, "Invalid Price Consent Status", null, PendingRenewal.PriceConsentStatus.class);
        } else {
            switch (p.getValueAsString()) {
                case "0":
                    return PendingRenewal.PriceConsentStatus.NO_ACTION;
                case "1":
                    return PendingRenewal.PriceConsentStatus.AGREED;
                default:
                    throw new InvalidFormatException(p, "Unknown Price Consent Status", null, PendingRenewal.PriceConsentStatus.class);
            }
        }
    }
}
