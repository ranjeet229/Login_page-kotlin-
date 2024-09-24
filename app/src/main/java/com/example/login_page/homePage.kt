package com.example.login_page

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class homePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_page)

        var hello = findViewById<TextView>(R.id.txthello)
        var button = findViewById<Button>(R.id.btnlist)

        button.setOnClickListener {

            var intent = Intent(this, listview::class.java)
            startActivity(intent)
        }

    }
}