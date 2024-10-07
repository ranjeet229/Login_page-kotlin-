package com.example.login_page

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class spinner : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)

        val spinner1 = findViewById<Spinner>(R.id.spinner)

        val spinnerList = listOf("English","Hindi","Marathi","French","spanish")
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerList)

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner1.adapter = arrayAdapter

        Toast.makeText(this,  "spinner Page", Toast.LENGTH_SHORT).show()
    }
}