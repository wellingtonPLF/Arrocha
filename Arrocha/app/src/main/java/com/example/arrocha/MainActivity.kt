package com.example.arrocha

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    private lateinit var btStart: Button
    private lateinit var tvTitle: TextView
    private lateinit var etResposta : EditText
    private lateinit var btResponder: Button

    private lateinit var numeroAleatorio: numeroAleatorio

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.btStart = findViewById(R.id.btStart)
        this.tvTitle = findViewById(R.id.tvTitle)
        this.etResposta = findViewById(R.id.etResposta)
        this.btResponder = findViewById(R.id.btResponder)

        this.btStart.setOnClickListener({
            this.btStart.setVisibility(View.INVISIBLE)
            this.tvTitle.setVisibility(View.VISIBLE)
            this.numeroAleatorio = numeroAleatorio(1,100)
            Log.i("APP_ARROCHA", this.numeroAleatorio.getnumber().toString())
        })

        this.btResponder.setOnClickListener{
            var resposta = this.etResposta.text.toString().toInt()
            this.etResposta.getText().clear()
            if(resposta == this.numeroAleatorio.getnumber() || resposta <= this.numeroAleatorio.getInicio() || resposta >= this.numeroAleatorio.getFim()){
                winLose("Perdeu")
                atualiza()
            }
            else if(this.numeroAleatorio.getnumber() < resposta){
                this.numeroAleatorio.setFim(resposta)
                this.tvTitle.text = this.numeroAleatorio.getIntervalo()
            }
            else{
                this.numeroAleatorio.setInicio(resposta)
                this.tvTitle.text = this.numeroAleatorio.getIntervalo()

            }
            if(this.numeroAleatorio.dif() == 2){
                winLose("Ganhou")
                atualiza()
            }
        }
    }

    fun winLose(msg: String){
        var telaWinLose = Intent(this, WinLose::class.java)
        telaWinLose.putExtra("MENSAGEM", msg)
        startActivity(telaWinLose)
    }

    fun atualiza(){
        this.numeroAleatorio.setInicio(1)
        this.numeroAleatorio.setFim(100)
        this.numeroAleatorio.newRandom()
        Log.i("APP_ARROCHA", this.numeroAleatorio.getnumber().toString())
        this.tvTitle.text = "[1..100]"
    }
}