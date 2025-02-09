import android.bluetooth.BluetoothSocket;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.IOException;
import java.io.OutputStream;

public class BluetoothPrinterHelper {

    private static final String TAG = "BluetoothPrinter";
    private final BluetoothSocket socket;
    public OutputStream outputStream;

    public BluetoothPrinterHelper(BluetoothSocket socket) throws IOException {
        this.outputStream = socket.getOutputStream();
    }

    public void printImage(int imageResId) throws IOException {
        try {
            Bitmap bitmap = BitmapFactory.decodeResource(
                    context.getResources(),
                    imageResId
            );

            byte[] printerBytes = convertBitmapToPrinterFormat(bitmap);

            byte[] printerCommands = new byte[]{
                    0x1B, 0x40, // Initialize printer (ESC @)
                    0x1B, 0x2A, 0x21, // Select bitmap mode (ESC * m)
                    0x00, // m = 0 (8-dot single density)
                    (byte) (bitmap.getWidth() % 256), // Width low byte
                    (byte) (bitmap.getWidth() / 256), // Width high byte
                    (byte) (bitmap.getHeight() % 256), // Height low byte
                    (byte) (bitmap.getHeight() / 256) // Height high byte
            };

            // 4. Send to Socket
            outputStream.write(printerCommands);
            outputStream.write(printerBytes);
            outputStream.flush();

            // Add line feeds after printing
            byte[] lineFeeds = new byte[]{0x0A, 0x0A, 0x0A}; // 3 line feeds
            outputStream.write(lineFeeds);
            outputStream.flush();

        } catch (IOException e) {
            Log.e(TAG, "Error printing image", e);
            throw e;
        }
    }

    private byte[] convertBitmapToPrinterFormat(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] pixels = new int[width * height];
        bitmap.getPixels(pixels, 0, width, 0, 0, width, height);

        byte[] printerBytes = new byte[width * height / 8]; // Assuming 8 pixels per byte

        int byteIndex = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x += 8) {
                int byteValue = 0;
                for (int bit = 0; bit < 8; bit++) {
                    int pixelIndex = y * width + x + bit;
                    if (pixelIndex < pixels.length) {
                        int pixel = pixels[pixelIndex];
                        boolean isBlack = (pixel & 0x00FFFFFF) < 0x00808080;
                        if (isBlack) {
                            byteValue |= (0x80 >> bit); // Set the corresponding bit
                        }
                    }
                }
                printerBytes[byteIndex++] = (byte) byteValue;
            }
        }

        return printerBytes;
    }

    public void open() {
        socket.connect();
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