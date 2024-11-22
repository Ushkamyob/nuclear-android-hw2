package com.nuclan2024.hw2

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class FragmentBA : Fragment() {

    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_ba, container, false)
        Log.d("a", "FragmentBA created")
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            val openFragmentBBButton: Button = rootView.findViewById(R.id.open_fragment_bb)
            openFragmentBBButton.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, FragmentBB())
                    .addToBackStack(null)
                    .commit()
            }
        }

        parentFragmentManager.setFragmentResultListener("requestKey", this) {_, bundle ->
            val color = bundle.getInt("color")
            rootView.setBackgroundColor(color)

        }

        return rootView
    }

    override fun onDestroyView() {
        Log.d("a", "FragmentBA destroyed")
        super.onDestroyView()
    }
}