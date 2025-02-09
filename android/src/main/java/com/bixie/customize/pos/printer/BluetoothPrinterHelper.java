package com.bixie.customize.pos.printer;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Log;

import java.io.IOException;
import java.io.OutputStream;
import java.util.BitSet;

@SuppressLint("MissingPermission")
public class BluetoothPrinterHelper {

    private static final String TAG = "BluetoothPrinter";
    public OutputStream outputStream;
    private BluetoothSocket socket;
    public Bitmap loadBitmapFromResource(Context context, int resourceId) {
        return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), resourceId), 150, 127, true);
    }

    public BluetoothPrinterHelper(BluetoothSocket socket) throws IOException {
        this.socket = socket;
        this.outputStream = socket.getOutputStream();
    }
    public void printImage(int resourceId, Context context) {
        Bitmap bmp = loadBitmapFromResource(context, resourceId);
        try {
            outputStream.write(BitmapConverter.decodeBitmap(bmp));
        } catch (Exception e) {
            Log.i("printImage", e.getMessage());
        }
    }

    public void open() throws IOException {
        try {
            socket.connect();
        } catch (IOException e) {
            throw e;
        }
    }

    public void close() {
        try {
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            Log.e(TAG, "Error closing socket", e);
        }
    }
}