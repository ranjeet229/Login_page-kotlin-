package com.example.login_page

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val usernameField = findViewById<EditText>(R.id.txtusername)
        val passwordField = findViewById<EditText>(R.id.txtpass)
        val loginButton = findViewById<Button>(R.id.loginButton)


        loginButton.setOnClickListener {
            val username = usernameField.text.toString()
            val password = passwordField.text.toString()


            if (username.isEmpty()) {
                usernameField.error = "Please complete the username field"
            }

            if (password.isEmpty()) {
                passwordField.error = "Please complete the password field"
            }

            if (username.isNotEmpty() && password.isNotEmpty()) {
                Toast.makeText(this, "Login Successfully", Toast.LENGTH_LONG).show()
            }
        }
    }
}