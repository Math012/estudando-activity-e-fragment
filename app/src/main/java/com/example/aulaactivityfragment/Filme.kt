package com.example.aulaactivityfragment

import java.io.Serializable

data class Filme(
    val nome:String,
    val descricao: String,
    val avalicao: Double,
    val diretor: String,
    val distribuidor: String
): Serializable
