package com.example.wlasciwosci_czcionki

import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
lateinit var spinner: SeekBar;
lateinit var button: Button
var wielkosc_czcionki: Int = 14
lateinit var pole: TextView

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
        button = findViewById(R.id.Button_next)
        pole = findViewById(R.id.Text_pole)

        val powitanie = arrayOf("Dzień dobry", "Good Morning", "Buenos dias");

        spinner.setOnSeekBarChangeListener( object : SeekBar.OnSeekBarChangeListener {
            // Handle when the progress changes
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {}

            // Handle when the user starts tracking touch
            override fun onStartTrackingTouch(seek: SeekBar) {}

            // Handle when the user stops tracking touch
            override fun onStopTrackingTouch(seek: SeekBar) {

                // miejsce na mój kod!!

                val output = "Progress is: " + seek.progress + "%"
                Toast.makeText(this@MainActivity, output , Toast.LENGTH_SHORT).show()
            }
        })

    }
}