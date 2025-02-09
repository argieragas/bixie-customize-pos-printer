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

    private BixiePOSPrinter implementation = new BixiePOSPrinter();

    EscPosPrinter printer;
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
        printer = new EscPosPrinter(implementation.deviceConnection, 203, 48f, 32);
        call.resolve(ret);
    }

    @PluginMethod
    public void printTicket (PluginCall call) {
        JSObject ret = new JSObject();
        try {
            String firstName = call.getString("firstName");
            String drawDate = call.getString("drawDate");
            String datePrinted = call.getString("datePrinted");
            String drawTime = call.getString("drawTime");
            String qrcode = call.getString("qrcode");
            Srting games = call.getString("games");
            String total = call.getString("total");
            String agentCode = call.getString("agentCode");
            
            ret.put("success","");
        } catch (Exception e) {
            ret.put("error", e.getMessage());
        }
        call.resolve(ret);
    }

    @PluginMethod
    public void testPrint(PluginCall call) {
        JSObject ret = new JSObject();
        try {
            /*printer.printFormattedText(
                    "[C]<img>" + PrinterTextParserImg.bitmapToHexadecimalString(printer, Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.header), 384, 176, true))+"</img>\n" +
                            "[L]\n" +
                            "[C]<u><font size='big'>ORDER N°045</font></u>\n" +
                            "[L]\n" +
                            "[C]================================\n" +
                            "[L]\n" +
                            "[L]<b>BEAUTIFUL SHIRT</b>[R]9.99e\n" +
                            "[L]<font size='small'></font>\n"+
                            "[L]  + Size : S\n" +
                            "[L]\n" +
                            "[L]\n" +
                            "[C]--------------------------------\n" +
                            "[R]TOTAL PRICE :[R]34.98e\n" +
                            "[R]TAX :[R]4.23e\n" +
                            "[L]\n" +
                            "[C]================================\n" +
                            "[L]\n" +
                            "[L]<font size='tall'>Customer :</font>\n" +
                            "[L]Raymond DUPONT\n" +
                            "[L]5 rue des girafes\n" +
                            "[L]31547 PERPETES\n" +
                            "[L]Tel : +33801201456\n" +
                            "[L]\n" +
                            "[C]<barcode type='ean13' height='10'>831254784551</barcode>\n" +
                            "[C]<qrcode size='20'>https://dantsu.com/</qrcode>", 40);*/

            printer.printFormattedText("[C]<font size='tall'>Test print!</font>\n<qrcode size='15'>123456789</qrcode>", 60);
        } catch (Exception e) {
            ret.put("value", e.getMessage());
        }
        call.resolve(ret);
    }

}
