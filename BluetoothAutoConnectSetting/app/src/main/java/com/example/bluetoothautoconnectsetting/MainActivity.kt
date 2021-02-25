package com.example.bluetoothautoconnectsetting

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(applicationContext,"coming soon", Toast.LENGTH_SHORT).show()
        var bluetoothManager: BluetoothManager;
        ActivityCompat.OnRequestPermissionsResultCallback { requestCode, permissions, grantResults ->
            {
                Log.d("applicationContext","request code is $requestCode")
                for (permission in permissions){
                    Log.d("applicationContext","permission is is $permission")
                }
                for (grantResult in grantResults){
                    Log.d("applicationContext","grantResult is is $grantResult")
                }
                val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()
                if (bluetoothAdapter == null) {
                    // Device doesn't support Bluetooth
                    Log.d("applicationContext", "bluetooth Adapter not granted");
                }
                var devicesUI = findViewById<android.view.View>(android.r.id."bluetoothDeives");

            }
        }
        Log.d("application logs","reached here")
        //onRequestPermissionsResult( code,result, grants );
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            Log.d("application logs","the sdk version is ${Build.VERSION.SDK_INT}")

            if (
                    ContextCompat.checkSelfPermission(baseContext,Manifest.permission.ACCESS_BACKGROUND_LOCATION)
                    != PackageManager.PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission(baseContext,Manifest.permission.BLUETOOTH_ADMIN)
                    != PackageManager.PERMISSION_GRANTED
            ) {
                Log.d("application logs","permission not granted")
                ActivityCompat.requestPermissions(
                        this, emptyArray<String>().plus(Manifest.permission.ACCESS_BACKGROUND_LOCATION).plus( Manifest.permission.BLUETOOTH_ADMIN),
                        1)
            }
        }



    }


}