package by.dev.madhead.utils.appstore_receipts_validator.mapper;

import by.dev.madhead.utils.appstore_receipts_validator.model.InApp;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class InAppAutoRenewStatusDeserializer extends StdScalarDeserializer<InApp.AutoRenewStatus> {
    public InAppAutoRenewStatusDeserializer() {
        super(InApp.AutoRenewStatus.class);
    }

    @Override
    public InApp.AutoRenewStatus deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {
        if (p.currentToken() != JsonToken.VALUE_STRING) {
            throw new InvalidFormatException(p, "Invalid Autorenew Status", null, InApp.AutoRenewStatus.class);
        } else {
            switch (p.getValueAsString()) {
                case "0":
                    return InApp.AutoRenewStatus.OFF;
                case "1":
                    return InApp.AutoRenewStatus.ON;
                default:
                    throw new InvalidFormatException(p, "Unknown Autorenew Status", null, InApp.AutoRenewStatus.class);
            }
        }
    }
}
