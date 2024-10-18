package com.nuclan2024.hw2

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.button.MaterialButton
import kotlin.random.Random

class FragmentBB : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_bb, container, false)
        Log.d("b", "FragmentBB created")
        val sendColorButton = rootView.findViewById<MaterialButton>(R.id.sendColor)
        sendColorButton.setOnClickListener {
            val color = generateRandomColor()
            val result = Bundle().apply { putInt("color", color) }
            parentFragmentManager.setFragmentResult("requestKey", result)
        }
        return rootView
    }

    private fun generateRandomColor(): Int {
        return Color.argb(255, Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
    }

    override fun onDestroyView() {
        Log.d("b", "FragmentBB destroyed")
        super.onDestroyView()
    }
}