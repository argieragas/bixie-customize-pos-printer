package com.bixie.customize.pos.printer;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothSocket;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.util.Log;

import com.dantsu.escposprinter.EscPosPrinter;
import com.dantsu.escposprinter.textparser.PrinterTextParserImg;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import java.io.IOException;

@SuppressLint("MissingPermission")
@CapacitorPlugin(name = "BixiePOSPrinter")
public class BixiePOSPrinterPlugin extends Plugin {

    EscPosPrinter printer;
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
            EscPosPrinter printer = new EscPosPrinter(implementation.deviceConnection, 203, 48f, 32);
            printer
                    .printFormattedText(
                            "[C]<img>" + PrinterTextParserImg.bitmapToHexadecimalString(printer, Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.header), 384, 176, true))+"</img>\n" +
                                    "[L]\n" +
                                    "[C]<u><font size='big' margin-top='10px'>ORDER N°045</font></u>\n" +
                                    "[L]<b>BEAUTIFUL SHIRT</b>\n "+
                                    "[C]<img>" + PrinterTextParserImg.bitmapToHexadecimalString(printer, Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.blank), 384, 10, true))+"</img>\n" +
                                    "[L]<b><font size='big' margin-top='10px'>ORDER N°045</font></b> \n"+
                                    "[C]<img>" + PrinterTextParserImg.bitmapToHexadecimalString(printer, Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.blank), 384, 20, true))+"</img>\n" +
                                    "[L]<b>BEAUTIFUL SHIRT</b> \n"+
                                    "[L]<b margin-top='10px'>BEAUTIFUL SHIRT</b> \n"+
                                    "[L]<b>BEAUTIFUL SHIRT</b> "+
                                    "[L]\n" +
                                    "[C]================================\n" +
                                    "[L]\n" +
                                    "[L]<b>BEAUTIFUL SHIRT</b>[R]9.99e\n" +
                                    "[C]================================\n" +
                                    "[L]\n" +
                                    "[C]<barcode type='ean13' height='10'>831254784551</barcode>\n" +
                                    "[C]<qrcode size='20'>https://dantsu.com/</qrcode>"
                    );
        } catch (Exception e) {
            ret.put("value", e.getMessage());
        }
        call.resolve(ret);
    }

}
