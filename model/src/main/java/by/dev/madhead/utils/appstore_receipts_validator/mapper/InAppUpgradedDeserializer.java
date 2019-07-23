package by.dev.madhead.utils.appstore_receipts_validator.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class InAppUpgradedDeserializer extends StdScalarDeserializer<Boolean> {

    public InAppUpgradedDeserializer() {
        super(Boolean.class);
    }

    @Override
    public Boolean deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        if (p.currentToken() != JsonToken.VALUE_STRING) {
            throw new InvalidFormatException(p, "Invalid In App Upgraded", null, Boolean.class);
        } else {
            switch (p.getValueAsString()) {
                case "true":
                    return Boolean.TRUE;
                default:
                    return Boolean.FALSE;
            }
        }
    }
}
