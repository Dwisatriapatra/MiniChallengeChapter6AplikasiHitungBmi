package com.example.minichallengechapter6aplikasihitungbmi.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.minichallengechapter6aplikasihitungbmi.R
import kotlinx.android.synthetic.main.fragment_handler_thread.*
import kotlinx.android.synthetic.main.fragment_thread.*

class HandlerThreadFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_handler_thread, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handlerThreadImplementation()
    }

    private fun handlerThreadImplementation() {
        val handler = object : Handler(Looper.getMainLooper()){
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                handler_thread_result.text = msg.obj as String
            }
        }
        Thread(Runnable {
            handler_thread_button_hitung.setOnClickListener {
                val beratBadan = handler_thread_input_berat_badan.text.toString().toDouble()
                val tinggiBadan = handler_thread_input_tinggi_badan.text.toString().toDouble() / 100
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

                val message = Message.obtain()
                message.obj = "Kategori : $kategori"
                message.target = handler
                message.sendToTarget()
            }
        }).start()
    }
}