package com.nuclan2024.hw2

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView

class Activity_A : AppCompatActivity() {
    var newIntentCount: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_a)
        savedInstanceState?.let {
            newIntentCount = savedInstanceState.getInt("newIntentCount")
            if (newIntentCount > 0) setNewIntentText()
        }
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
            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, FragmentBA())
                    .addToBackStack(null)
                    .commit()
                showFragment()

            } else {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_a, FragmentBA())
                    .replace(R.id.fragment_container_b, FragmentBB())
                    .addToBackStack(null)
                    .commit()
                showFragment()
                Log.d("number", supportFragmentManager.backStackEntryCount.toString())
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("newIntentCount", newIntentCount)
        super.onSaveInstanceState(outState)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)

        newIntentCount++
        setNewIntentText()
    }

    private fun setNewIntentText() {
        val textView = findViewById<TextView>(R.id.standard_text)
        textView.text = "New Intent ${newIntentCount} has been called!"
    }

    private fun showFragment() {
        findViewById<View>(R.id.fragment_container).visibility = View.VISIBLE
        findViewById<ImageView>(R.id.image).visibility = View.GONE
        findViewById<LinearLayout>(R.id.layout_a).visibility = View.GONE
    }

    private fun showElements() {
        findViewById<ViewGroup>(R.id.fragment_container).visibility = View.GONE
        findViewById<ImageView>(R.id.image).visibility = View.VISIBLE
        findViewById<LinearLayout>(R.id.layout_a).visibility = View.VISIBLE
    }


    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            showElements()
        }
        super.onBackPressed()
    }
}