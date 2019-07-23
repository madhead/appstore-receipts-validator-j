package by.dev.madhead.utils.appstore_receipts_validator.mapper;

import by.dev.madhead.utils.appstore_receipts_validator.model.Receipt;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class ReceiptReceiptTypeDeserializer extends StdScalarDeserializer<Receipt.ReceiptType> {

    public ReceiptReceiptTypeDeserializer() {
        super(Receipt.ReceiptType.class);
    }

    @Override
    public Receipt.ReceiptType deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (p.currentToken() != JsonToken.VALUE_STRING) {
            throw new InvalidFormatException(p, "Invalid Receipt Receipt Type Environment", null, Receipt.ReceiptType.class);
        } else {
            final String value = p.getValueAsString();

            switch (value) {
                case "Production":
                    return Receipt.ReceiptType.PRODUCTION;
                case "ProductionVPP":
                    return Receipt.ReceiptType.PRODUCTIONVPP;
                case "ProductionSandbox":
                    return Receipt.ReceiptType.PRODUCTIONSANDBOX;
                case "ProductionVPPSandbox":
                    return Receipt.ReceiptType.PRODUCTIONVPPSANDBOX;
                default:
                    throw new InvalidFormatException(p, "Unknown Receipt Receipt Type Environment", null, Receipt.ReceiptType.class);
            }
        }
    }
}
