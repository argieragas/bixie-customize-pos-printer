package com.bixie.customize.pos.printer;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;

import com.getcapacitor.JSObject;

import java.util.UUID;

@SuppressLint("MissingPermission")
public class BixiePOSPrinter {
    UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private BluetoothAdapter bluetoothAdapter;

    public BluetoothSocket socket;

    public BixiePOSPrinter() {
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    public JSObject connectToDevice(String deviceAddress) {
        JSObject object = new JSObject();
        BluetoothDevice device = bluetoothAdapter.getRemoteDevice(deviceAddress);
        try {
            socket = device.createRfcommSocketToServiceRecord(uuid);
            socket.connect();
            String message = "Hello, " + deviceAddress + "!";
            socket.getOutputStream().write(message.getBytes());
            System.out.println("Connected to Bluetooth device");
            object.put("success", "Connected to Bluetooth device");
        } catch (Exception e) {
            object.put("error", e.getMessage());
        }
        return object;
    }

}
