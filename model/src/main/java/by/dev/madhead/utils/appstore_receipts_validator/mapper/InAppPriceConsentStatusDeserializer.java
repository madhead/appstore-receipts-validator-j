package by.dev.madhead.utils.appstore_receipts_validator.mapper;

import by.dev.madhead.utils.appstore_receipts_validator.model.InApp;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class InAppPriceConsentStatusDeserializer extends StdScalarDeserializer<InApp.PriceConsentStatus> {
    public InAppPriceConsentStatusDeserializer() {
        super(InApp.PriceConsentStatus.class);
    }

    @Override
    public InApp.PriceConsentStatus deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {
        if (p.currentToken() != JsonToken.VALUE_STRING) {
            throw new InvalidFormatException(p, "Invalid Price Consent Status", null, InApp.PriceConsentStatus.class);
        } else {
            switch (p.getValueAsString()) {
                case "0":
                    return InApp.PriceConsentStatus.NO_ACTION;
                case "1":
                    return InApp.PriceConsentStatus.AGREED;
                default:
                    throw new InvalidFormatException(p, "Unknown Price Consent Status", null, InApp.PriceConsentStatus.class);
            }
        }
    }
}
