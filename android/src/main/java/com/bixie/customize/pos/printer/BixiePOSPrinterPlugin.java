package com.bixie.customize.pos.printer;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothSocket;
import android.graphics.Bitmap;
import android.util.Log;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import java.io.IOException;

@SuppressLint("MissingPermission")
@CapacitorPlugin(name = "BixiePOSPrinter")
public class BixiePOSPrinterPlugin extends Plugin {

    private BixiePOSPrinter implementation = new BixiePOSPrinter();
    private BluetoothPrinterHelper helper;

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", value);
        call.resolve(ret);
    }

    @PluginMethod
    public void connectToDevice(PluginCall call) {
        String address = call.getString("address");
        JSObject ret = implementation.connectToDevice(address);
        try {
            helper = new BluetoothPrinterHelper(implementation.socket);
        } catch (IOException e) {
            ret.put("error", e.getMessage());
        }
        call.resolve(ret);
    }

    @PluginMethod
    public void testPrint(PluginCall call) {
        JSObject ret = new JSObject();
        try {
            helper.open();
            helper.outputStream.write("Hello, World!\n\n\n".getBytes());
            helper.printImage(R.drawable.header, getContext());
            helper.close();
            ret.put("value", "success");
        } catch (Exception e) {
            Log.i("testPrint", e.getMessage());
            ret.put("value", e.getMessage());
        }
        call.resolve(ret);
    }

}
