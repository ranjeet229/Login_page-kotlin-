package com.example.login_page

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.login_page.databinding.ActivityCameraPermissionBinding

class CameraPermission : AppCompatActivity() {

    private lateinit var binding: ActivityCameraPermissionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize view binding
        binding = ActivityCameraPermissionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val button = binding.btncamera
        val locationButton = binding.btnlocation
        val storageButton = binding.btnstorage
        val bluetoothButton = binding.btnbluetooth
        val wifiButton = binding.btnwifi

        button.setOnClickListener {
            requestCameraPermission()
        }

        locationButton.setOnClickListener {
            requestLocationPermission()
        }

        storageButton.setOnClickListener {
            requestStoragePermission()
        }

        bluetoothButton.setOnClickListener {
            requestBluetoothPermission()
        }

        wifiButton.setOnClickListener {
            requestWifiPermission()
        }
    }

    private val requestCameraPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                openCamera()
            } else {
                Toast.makeText(this, "Camera permission denied", Toast.LENGTH_SHORT).show()
            }
        }

    private val requestLocationPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                accessLocation()
            } else {
                Toast.makeText(this, "Location permission denied", Toast.LENGTH_SHORT).show()
            }
        }

    private val requestStoragePermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                accessStorage()
            } else {
                Toast.makeText(this, "Storage permission denied", Toast.LENGTH_SHORT).show()
            }
        }

    private val requestBluetoothPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                accessBluetooth()
            } else {
                Toast.makeText(this, "Bluetooth permission denied", Toast.LENGTH_SHORT).show()
            }
        }

    private val requestWifiPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                accessWifi()
            } else {
                Toast.makeText(this, "WiFi permission denied", Toast.LENGTH_SHORT).show()
            }
        }

    private fun requestCameraPermission() {
        when {
            ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED -> {
                openCamera()
            }
            shouldShowRequestPermissionRationale(Manifest.permission.CAMERA) -> {
                Toast.makeText(this, "Camera access is required to take photos", Toast.LENGTH_LONG).show()
                requestCameraPermissionLauncher.launch(Manifest.permission.CAMERA)
            }
            else -> {
                requestCameraPermissionLauncher.launch(Manifest.permission.CAMERA)
            }
        }
    }

    private fun requestLocationPermission() {
        when {
            ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED -> {
                accessLocation()
            }
            shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION) -> {
                Toast.makeText(this, "Location access is required to use location features", Toast.LENGTH_LONG).show()
                requestLocationPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
            }
            else -> {
                requestLocationPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
            }
        }
    }

    private fun requestStoragePermission() {
        when {
            ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED -> {
                accessStorage()
            }
            shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE) -> {
                Toast.makeText(this, "Storage access is required to save files", Toast.LENGTH_LONG).show()
                requestStoragePermissionLauncher.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            }
            else -> {
                requestStoragePermissionLauncher.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            }
        }
    }

    private fun requestBluetoothPermission() {
        val bluetoothPermission = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            Manifest.permission.BLUETOOTH_CONNECT
        } else {
            Manifest.permission.BLUETOOTH
        }

        when {
            ContextCompat.checkSelfPermission(this, bluetoothPermission) == PackageManager.PERMISSION_GRANTED -> {
                accessBluetooth()
            }
            shouldShowRequestPermissionRationale(bluetoothPermission) -> {
                Toast.makeText(this, "Bluetooth access is required for this feature", Toast.LENGTH_LONG).show()
                requestBluetoothPermissionLauncher.launch(bluetoothPermission)
            }
            else -> {
                requestBluetoothPermissionLauncher.launch(bluetoothPermission)
            }
        }
    }

    private fun requestWifiPermission() {
        when {
            ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED -> {
                accessWifi()
            }
            shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION) -> {
                Toast.makeText(this, "WiFi access requires location permission", Toast.LENGTH_LONG).show()
                requestWifiPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
            }
            else -> {
                requestWifiPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
            }
        }
    }

    // Implicit intents
    private fun openCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (cameraIntent.resolveActivity(packageManager) != null) {
            startActivity(cameraIntent)
        } else {
            Toast.makeText(this, "Camera not available", Toast.LENGTH_SHORT).show()
        }
    }

    private fun accessLocation() {
        Toast.makeText(this, "Location accessed", Toast.LENGTH_SHORT).show()
    }

    private fun accessStorage() {
        Toast.makeText(this, "Storage accessed", Toast.LENGTH_SHORT).show()
    }

    private fun accessBluetooth() {
        Toast.makeText(this, "Bluetooth accessed", Toast.LENGTH_SHORT).show()
    }

    private fun accessWifi() {
        Toast.makeText(this, "WiFi accessed", Toast.LENGTH_SHORT).show()
    }
}
