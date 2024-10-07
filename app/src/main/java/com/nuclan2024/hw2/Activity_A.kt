package com.nuclan2024.hw2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Activity_A : AppCompatActivity() {
    var count: Int = 0
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
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
        val openFragmentB = findViewById<Button>(R.id.open_fragment_b)
        openFragmentB.setOnClickListener {

        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)

        val textView = findViewById<TextView>(R.id.standard_text)

        textView.text = "New Intent ${++count} has been called!"
    }
}