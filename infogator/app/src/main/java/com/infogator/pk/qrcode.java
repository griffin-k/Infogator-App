package com.infogator.pk;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.IOException;

public class qrcode extends AppCompatActivity implements SurfaceHolder.Callback, Camera.PreviewCallback {

    private static final int PERMISSION_REQUEST_CAMERA = 1;

    private Camera camera;
    private SurfaceHolder surfaceHolder;
    private SurfaceView surfaceView;
    private Button scanButton;
    private boolean isScanning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);

        surfaceView = findViewById(R.id.camera_preview);
        surfaceHolder = surfaceView.getHolder();
        scanButton = findViewById(R.id.scan_button);

        surfaceHolder.addCallback(this);

        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isScanning) {
                    stopScanning();
                } else {
                    startScanning();
                }
            }
        });
    }

    private void startScanning() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST_CAMERA);
        } else {
            try {
                camera = Camera.open();
                camera.setPreviewDisplay(surfaceHolder);

                // Set the camera orientation
                Camera.Parameters parameters = camera.getParameters();
                int rotation = getWindowManager().getDefaultDisplay().getRotation();
                int degrees = 0;
                switch (rotation) {
                    case Surface.ROTATION_0:
                        degrees = 0;
                        break;
                    case Surface.ROTATION_90:
                        degrees = 90;
                        break;
                    case Surface.ROTATION_180:
                        degrees = 180;
                        break;
                    case Surface.ROTATION_270:
                        degrees = 270;
                        break;
                }
                int cameraOrientation;
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(Camera.CameraInfo.CAMERA_FACING_BACK, cameraInfo);
                cameraOrientation = (cameraInfo.orientation - degrees + 360) % 360;
                parameters.setRotation(cameraOrientation);
                camera.setDisplayOrientation(cameraOrientation);
                camera.setParameters(parameters);

                camera.setPreviewCallback(this);
                camera.startPreview();
                isScanning = true;
                scanButton.setText("Stop Scanning");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void stopScanning() {
        if (camera != null) {
            camera.setPreviewCallback(null);
            camera.stopPreview();
            camera.release();
            camera = null;
            isScanning = false;
            scanButton.setText("Scan QR Code");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CAMERA) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startScanning();
            } else {
                Toast.makeText(this, "Camera permission required", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // Do nothing
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        // Do nothing
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        stopScanning();
    }

    @Override
    public void onPreviewFrame(byte[] data, Camera camera) {
        // Process the preview frame data here (e.g., decode QR code)
        // For simplicity, the QR code decoding process is not included in this code snippet.
        // Let's assume the scanned QR code contains a URL.
        String scannedUrl = "https://example.com"; // Replace with the actual scanned URL
        openLink(scannedUrl);
    }

    private void openLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "No app to handle URL", Toast.LENGTH_SHORT).show();
        }
    }
}

