package com.bixie.customize.pos.printer;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothSocket;

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
            BluetoothSocket socket = implementation.socket;
            socket.connect();
            socket.getOutputStream().write("Hello, World!".getBytes());
            helper.printImage(R.drawable.header, getContext());
        } catch (Exception e) {
            ret.put("value", e.getMessage());
        }
        call.resolve(ret);
    }

}
