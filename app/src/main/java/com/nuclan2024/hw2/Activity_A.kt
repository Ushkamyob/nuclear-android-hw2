package com.nuclan2024.hw2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Activity_A : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_a)

    }

    override fun onStart() {
        super.onStart()
        val openActivityB = findViewById<Button>(R.id.open_activity_b)
        openActivityB.setOnClickListener {
            val intent = Intent(this, Activity_B::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)

            startActivity(intent)
        }
        val openFragmentB = findViewById<Button>(R.id.open_fragment_b)
        openFragmentB.setOnClickListener {

        }
    }
}