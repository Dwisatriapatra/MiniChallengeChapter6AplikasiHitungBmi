package com.example.minichallengechapter6aplikasihitungbmi.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.minichallengechapter6aplikasihitungbmi.R
import kotlinx.android.synthetic.main.fragment_thread.*

class ThreadFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thread, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        threadImplementation()
    }

    @SuppressLint("SetTextI18n")
    private fun threadImplementation() {
        Thread(Runnable {
            thread_button_hitung.setOnClickListener {
                val beratBadan = thread_input_berat_badan.text.toString().toDouble()
                val tinggiBadan = thread_input_tinggi_badan.text.toString().toDouble() / 100
                val hasilBmi = beratBadan / (tinggiBadan * tinggiBadan)
                val kategori = if(hasilBmi < 18.5){
                    "kurus"
                }else if(hasilBmi >= 18.5 && hasilBmi < 24.9){
                    "Normal"
                }else if(hasilBmi >= 24.9 && hasilBmi < 29.9){
                    "Overweight"
                }else{
                    "Obesitas"
                }

                thread_result.post(Runnable {
                    thread_result.text = "Kategori : $kategori"
                })
            }
        }).start()
    }
}