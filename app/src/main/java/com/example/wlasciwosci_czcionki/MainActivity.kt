package com.example.wlasciwosci_czcionki

import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
lateinit var spinner: SeekBar
lateinit var button_next: Button
lateinit var cytat: TextView
lateinit var text_rozmiar: TextView
var process_float: Float = 0.0f
var aktywny_napis: Int = 2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        spinner = findViewById(R.id.Spinner)
        button_next = findViewById(R.id.Button_next)
        cytat = findViewById(R.id.Cytat)
        text_rozmiar = findViewById(R.id.Text_rozmiar)

        val powitanie = arrayOf("Dzień dobry", "Good Morning", "Buenos dias");

        spinner.setOnSeekBarChangeListener( object : SeekBar.OnSeekBarChangeListener {
            // Handle when the progress changes
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {}

            // Handle when the user starts tracking touch
            override fun onStartTrackingTouch(seek: SeekBar) {}

            // Handle when the user stops tracking touch
            override fun onStopTrackingTouch(seek: SeekBar) {

                // miejsce na mój kod!!
                process_float = (1 * seek.progress).toFloat()

                text_rozmiar.text = "Rozmiar: " + process_float.toInt()
                cytat.textSize = process_float;

            }
        })

        button_next.setOnClickListener {
            if(aktywny_napis<2){
                aktywny_napis++
                cytat.text = powitanie[aktywny_napis]
            }
            else{
                aktywny_napis = 0
                cytat.text = powitanie[aktywny_napis]
            }
        }

    }
}