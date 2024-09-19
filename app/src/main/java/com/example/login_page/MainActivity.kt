package com.example.login_page

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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


        var usernameField = findViewById<EditText>(R.id.txtusername)
        var passwordField = findViewById<EditText>(R.id.txtpass)
        var numberField = findViewById<EditText>(R.id.txtnum)
        var loginButton = findViewById<Button>(R.id.loginButton)
        var textView1 = findViewById<TextView>(R.id.button1)

        loginButton.setOnClickListener {
            var username = usernameField.text.toString()
            var password = passwordField.text.toString()
            var number = numberField.text.toString()


            if (username.isNotEmpty() && password.isNotEmpty() && number.isNotEmpty()) {
                //Toast.makeText(this, "Login Successfully", Toast.LENGTH_LONG).show()
                var a = usernameField.text.toString()
                textView1.text=a
                var b = passwordField.text.toString()
                textView1.text=b
                var c = numberField.text.toString()
                textView1.text=c


            }
        }
    }
}