package com.example.contatos.model

data class Projetos(
    var nome: String,
    var prazo: String,
    var imagem: Int,
    var descricao: String,
    var emEspera: Boolean,
    var emAndamento: Boolean,
    var concluido: Boolean
)
