package com.nuclan2024.hw2

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Activity_A : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_a)
        val openActivityB = findViewById<Button>(R.id.open_activity_b)
        openActivityB.setOnClickListener {

        }
        val openFragmentB = findViewById<Button>(R.id.open_fragment_b)
        openFragmentB.setOnClickListener {

        }
    }
}