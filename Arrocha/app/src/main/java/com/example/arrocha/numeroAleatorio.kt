package com.example.arrocha

class numeroAleatorio{
    private var inicio: Int
    private var fim: Int
    private var numeroR : Int

    constructor(inicio: Int,fim : Int){
        this.inicio = inicio
        this.fim = fim
        this.numeroR = (this.inicio+1..this.fim-1).random()
    }

    fun setInicio(inicio : Int){
        this.inicio = inicio
    }

    fun setFim(fim : Int){
        this.fim = fim
    }

    fun getnumber() : Int{
        return this.numeroR
    }

    fun dif() : Int{
        return this.fim - this.inicio
    }

    fun getInicio() : Int{
        return this.inicio
    }

    fun getFim() : Int{
        return this.fim
    }

    fun newRandom(){
        this.numeroR = (this.inicio+1..this.fim-1).random()
    }

    fun getIntervalo() : String{
        return "["+this.inicio.toString() +".."+this.fim.toString()+"]"
    }
}