package com.example.networkapp

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val prefs = getSharedPreferences("mySharedPrefs", Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString("key", "value")
        editor.apply()

        prefs.getString("key", "value")
    }
}