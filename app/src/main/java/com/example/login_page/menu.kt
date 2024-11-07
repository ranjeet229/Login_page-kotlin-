package com.example.login_page

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        val button1=findViewById<Button>(R.id.button1)
        val button2=findViewById<Button>(R.id.button2)


        button1.setOnClickListener {
            showPopupMenu(it, "Button 1")
        }

        button2.setOnClickListener { showPopupMenu(it, "Button 2") }
    }

    private fun showPopupMenu(view: View, buttonName: String) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { menuItem: MenuItem ->
            when (menuItem.itemId) {
                R.id.option1 -> {
                    Toast.makeText(this, "$buttonName: Option 1 selected", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.option2 -> {
                    Toast.makeText(this, "$buttonName: Option 2 selected", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.option3 -> {
                    Toast.makeText(this, "$buttonName: Option 3 selected", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        popupMenu.show()
    }
}