package com.bixie.customize.pos.printer;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "BixiePOSPrinter")
public class BixiePOSPrinterPlugin extends Plugin {

    private BixiePOSPrinter implementation = new BixiePOSPrinter();

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    @PluginMethod
    public void SamplePrinter(PluginCall call) {
        String value = call.getString("name");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    @PluginMethod
    public void Image(PluginCall call) {
        String base64Image = call.getString("image");
        if (base64Image == null) {
            call.reject("Must provide a base64Image");
            return;
        }
        String base64Data = base64Image.replaceFirst("data:image/[^;]+;base64,", "");
        byte[] decodedBytes = Base64.decode(base64Data, Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);

        if (bitmap == null) {
            call.reject("Failed to decode image");
            return;
        }
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        String base64Return = Base64.encodeToString(byteArray, Base64.DEFAULT);
        JSObject ret = new JSObject();
        ret.put("value", base64Return);
        call.resolve(ret);
    }
}
