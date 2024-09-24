package com.example.login_page

import android.content.Intent
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
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
        setContentView(R.layout.activity_login_page)

        var usernameField = findViewById<EditText>(R.id.txtusername)
        var passwordField = findViewById<EditText>(R.id.txtpass)
        var loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            var username = usernameField.text.toString()
            var password = passwordField.text.toString()


            if (username.isNotEmpty() && password.isNotEmpty()) {
                //Toast.makeText(this, "Login Successfully", Toast.LENGTH_LONG).show()
//                var a = usernameField.text.toString()
//                textView1.text=a

                val intent = Intent(this, homePage::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "please fill all fields", Toast.LENGTH_LONG).show()
            }
        }



    }
}