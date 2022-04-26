package com.example.minichallengechapter6aplikasihitungbmi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.minichallengechapter6aplikasihitungbmi.R
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_use_thread.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_threadFragment)
        }
        button_use_hanlder_thread.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_handlerThreadFragment)
        }
    }
}