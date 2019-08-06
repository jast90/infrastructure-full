package me.jastz.common.json.result;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author zhiwen
 */
public class IResultSerializer extends StdSerializer<IResult> {

    private Locale locale;

    public IResultSerializer() {
        this(null);
    }

    public IResultSerializer(Class<IResult> t) {
        super(t);
        this.locale = Locale.getDefault();
    }

    @Override
    public void serialize(IResult value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("resultCode", value.getResultCode());
        ResourceBundle resourceBundle;
        String msg = null;
        try {
            if (value.getResultCode() == 0) {
                resourceBundle = ResourceBundle.getBundle("i18n.success", this.locale);
            } else {
                resourceBundle = ResourceBundle.getBundle("i18n.fail", this.locale);
            }
            if (resourceBundle != null) {
                msg = resourceBundle.getString(value.toString());
            }
        } catch (Exception e) {
        }
        if (msg == null || "".equals(msg)) {
            msg = value.toString();
        }
        gen.writeStringField("resultMsg", msg);
        gen.writeEndObject();
    }
}
