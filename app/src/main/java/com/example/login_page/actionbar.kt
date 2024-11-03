package com.example.login_page

import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class actionbar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_actionbar)

        val img1=findViewById<ImageView>(R.id.imgrelative)
        val img2=findViewById<ImageView>(R.id.img2relative)
        val text=findViewById<TextView>(R.id.txtrelative)
        val button=findViewById<Button>(R.id.btnrelative)
    }
}