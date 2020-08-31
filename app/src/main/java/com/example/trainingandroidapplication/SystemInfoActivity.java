package com.example.trainingandroidapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.widget.TextView;
import android.widget.Toast;

public class SystemInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_info);
        setTitle("SystemInfoActivity");

        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);

        TextView textView = findViewById(R.id.textViewSystemInfo);
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("BOARD: " + Build.BOARD);
        stringBuilder.append("\n\n");

        stringBuilder.append("BOOTLOADER: " + Build.BOOTLOADER);
        stringBuilder.append("\n\n");

        stringBuilder.append("BRAND: " + Build.BRAND);
        stringBuilder.append("\n\n");

        stringBuilder.append("DEVICE: " + Build.DEVICE);
        stringBuilder.append("\n\n");

        stringBuilder.append("DISPLAY: " + Build.DISPLAY);
        stringBuilder.append("\n\n");

        stringBuilder.append("FINGERPRINT: " + Build.FINGERPRINT);
        stringBuilder.append("\n\n");

        stringBuilder.append("HARDWARE: " + Build.HARDWARE);
        stringBuilder.append("\n\n");

        stringBuilder.append("HOST: " + Build.HOST);
        stringBuilder.append("\n\n");

        stringBuilder.append("ID: " + Build.ID);
        stringBuilder.append("\n\n");

        stringBuilder.append("MANUFACTURER: " + Build.MANUFACTURER);
        stringBuilder.append("\n\n");

        stringBuilder.append("MODEL: " + Build.MODEL);
        stringBuilder.append("\n\n");

        stringBuilder.append("PRODUCT: " + Build.PRODUCT);
        stringBuilder.append("\n\n");

        stringBuilder.append("TAGS: " + Build.TAGS);
        stringBuilder.append("\n\n");

        stringBuilder.append("TYPE: " + Build.TYPE);
        stringBuilder.append("\n\n");

        stringBuilder.append("UNKNOWN: " + Build.UNKNOWN);
        stringBuilder.append("\n\n");

        stringBuilder.append("USER: " + Build.USER);
        stringBuilder.append("\n\n");

        stringBuilder.append("SUPPORTED_ABIS: " + Build.SUPPORTED_ABIS);
        stringBuilder.append("\n\n");

        stringBuilder.append("TIME: " + Build.TIME);
        stringBuilder.append("\n\n");

        stringBuilder.append("SUPPORTED_32_BIT_ABIS: " + Build.SUPPORTED_32_BIT_ABIS);
        stringBuilder.append("\n\n");

        stringBuilder.append("SUPPORTED_64_BIT_ABIS: " + Build.SUPPORTED_64_BIT_ABIS);
        stringBuilder.append("\n\n");

        stringBuilder.append("CPU_ABI1: " + Build.CPU_ABI);
        stringBuilder.append("\n\n");

        stringBuilder.append("CPU_ABI2: " + Build.CPU_ABI2);
        stringBuilder.append("\n\n");

        stringBuilder.append("RADIO: " + Build.RADIO);
        stringBuilder.append("\n\n");

        stringBuilder.append("SERIAL: " + Build.SERIAL);
        stringBuilder.append("\n\n");

        stringBuilder.append("Partition.PARTITION_NAME_SYSTEM: " + Build.Partition.PARTITION_NAME_SYSTEM);
        stringBuilder.append("\n\n");

        stringBuilder.append("VERSION.BASE_OS: " + Build.VERSION.BASE_OS);
        stringBuilder.append("\n\n");

        stringBuilder.append("VERSION.CODENAME: " + Build.VERSION.CODENAME);
        stringBuilder.append("\n\n");

        stringBuilder.append("VERSION.INCREMENTAL: " + Build.VERSION.INCREMENTAL);
        stringBuilder.append("\n\n");

        stringBuilder.append("VERSION.SDK_INT: " + Build.VERSION.SDK_INT);
        stringBuilder.append("\n\n");

        stringBuilder.append("VERSION.PREVIEW_SDK_INT: " + Build.VERSION.PREVIEW_SDK_INT);
        stringBuilder.append("\n\n");

        stringBuilder.append("VERSION.SECURITY_PATCH: " + Build.VERSION.SECURITY_PATCH);
        stringBuilder.append("\n\n");

        stringBuilder.append("VERSION.RELEASE: " + Build.VERSION.RELEASE);
        stringBuilder.append("\n\n");


        int permissionStatus = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE);
        int permissionStatus2 = ContextCompat.checkSelfPermission(this, Manifest.permission.LOCATION_HARDWARE);

        if (permissionStatus == PackageManager.PERMISSION_GRANTED && permissionStatus2 == PackageManager.PERMISSION_GRANTED) {

            stringBuilder.append("DeviceSoftwareVersion: " + telephonyManager.getDeviceSoftwareVersion());
            stringBuilder.append("\n\n");

            stringBuilder.append("GroupIdLevel1: " + telephonyManager.getGroupIdLevel1());
            stringBuilder.append("\n\n");

            stringBuilder.append("Line1Number: " + telephonyManager.getLine1Number());
            stringBuilder.append("\n\n");

            stringBuilder.append("MmsUAProfUrl: " + telephonyManager.getMmsUAProfUrl());
            stringBuilder.append("\n\n");

            stringBuilder.append("NetworkCountryIso: " + telephonyManager.getNetworkCountryIso());
            stringBuilder.append("\n\n");

            stringBuilder.append("NetworkOperator: " + telephonyManager.getNetworkOperator());
            stringBuilder.append("\n\n");

            stringBuilder.append("NetworkOperatorName: " + telephonyManager.getNetworkOperatorName());
            stringBuilder.append("\n\n");

            stringBuilder.append("DeviceId: " + telephonyManager.getDeviceId());
            stringBuilder.append("\n\n");

            stringBuilder.append("AllCellInfo: " + telephonyManager.getAllCellInfo());
            stringBuilder.append("\n\n");

            stringBuilder.append("CallState: " + telephonyManager.getCallState());
            stringBuilder.append("\n\n");

            stringBuilder.append("isWorldPhone: " + telephonyManager.isWorldPhone());
            stringBuilder.append("\n\n");

            stringBuilder.append("isNetworkRoaming: " + telephonyManager.isNetworkRoaming());
            stringBuilder.append("\n\n");

            stringBuilder.append("isSmsCapable: " + telephonyManager.isSmsCapable());
            stringBuilder.append("\n\n");

            stringBuilder.append("isVoiceCapable: " + telephonyManager.isVoiceCapable());
            stringBuilder.append("\n\n");
        } else {
            Toast.makeText(this,"Enable permission in settings",Toast.LENGTH_SHORT).show();
        }




        textView.setText(stringBuilder);
    }
}
