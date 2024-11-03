package com.example.login_page

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import android.view.inputmethod.InputMethodManager
import androidx.activity.enableEdgeToEdge
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_page)

        val usernameField = findViewById<EditText>(R.id.txtusername)
        val passwordField = findViewById<EditText>(R.id.txtpass)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener { view ->
            val username = usernameField.text.toString()
            val password = passwordField.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {

                //to remove the keyboard
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, 0)

                val snackBar = Snackbar.make(view, "Login Successfully", Snackbar.LENGTH_LONG)
                val snackBarView = snackBar.view
                snackBarView.setBackgroundColor(ContextCompat.getColor(this, R.color.green))

                snackBar.show()

                // val intent = Intent(this, homePage::class.java)
                // startActivity(intent)

            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_LONG).show()
            }
        }
    }
}
