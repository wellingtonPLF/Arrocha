package com.example.arrocha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class WinLose : AppCompatActivity() {
    private lateinit var tvLose: TextView
    private lateinit var tvWin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win_lose)

        this.tvLose = findViewById(R.id.tvLose)
        this.tvWin = findViewById(R.id.tvWin)

        if (intent.getStringExtra("MENSAGEM") == "Perdeu"){
            tvLose.setVisibility(View.VISIBLE)
        }

        this.tvLose.setOnClickListener{
            finish()
        }
        this.tvWin.setOnClickListener{
            finish()
        }
    }
}