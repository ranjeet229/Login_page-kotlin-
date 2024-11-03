package com.example.login_page

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.login_page.databinding.ActivityCameraPermissionBinding

class CameraPermission : AppCompatActivity() {

    private lateinit var binding: ActivityCameraPermissionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initialize view binding
        binding = ActivityCameraPermissionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val button = binding.btncamera

        button.setOnClickListener {
            requestCameraPermission()
        }
    }

    val requestCameraPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                Toast.makeText(this, "Camera permission granted", Toast.LENGTH_SHORT).show()
                // Add camera-related functionality here
            } else {
                Toast.makeText(this, "Camera permission denied", Toast.LENGTH_SHORT).show()
            }
        }


    private fun requestCameraPermission() {
        when {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED -> {
                // Permission is already granted
                Toast.makeText(this, "Camera permission already granted", Toast.LENGTH_SHORT).show()
            }

            shouldShowRequestPermissionRationale(Manifest.permission.CAMERA) -> {
                // Explain to the user why the permission is needed
                Toast.makeText(this, "Camera access is required to take photos", Toast.LENGTH_LONG).show()
                requestCameraPermissionLauncher.launch(Manifest.permission.CAMERA)
            }

            else -> {
                // Directly request the permission
                requestCameraPermissionLauncher.launch(Manifest.permission.CAMERA)
            }
        }
    }
}
