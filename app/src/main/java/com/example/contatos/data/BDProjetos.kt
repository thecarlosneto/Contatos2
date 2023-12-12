package com.example.contatos.data

import com.example.contatos.model.Projetos
import com.example.contatos.R

class BDProjetos {
    fun carregaListaProjetos ():List<Projetos>{
        return listOf<Projetos>(
            Projetos(nome = "Teste", prazo = "14/12/2023", imagem = R.drawable.teste, descricao = "Teste", emEspera = true, emAndamento = false, concluido = false ),
            Projetos(nome = "Teste", prazo = "14/12/2023", imagem = R.drawable.teste, descricao = "Teste", emEspera = true, emAndamento = false, concluido = false ),
            Projetos(nome = "Teste", prazo = "14/12/2023", imagem = R.drawable.teste, descricao = "Teste", emEspera = true, emAndamento = false, concluido = false ),
            Projetos(nome = "Teste", prazo = "14/12/2023", imagem = R.drawable.teste, descricao = "Teste", emEspera = true, emAndamento = false, concluido = false ),
            Projetos(nome = "Teste", prazo = "14/12/2023", imagem = R.drawable.teste, descricao = "Teste", emEspera = true, emAndamento = false, concluido = false ),
            Projetos(nome = "Teste", prazo = "14/12/2023", imagem = R.drawable.teste, descricao = "Teste", emEspera = true, emAndamento = false, concluido = false ),
            Projetos(nome = "Teste", prazo = "14/12/2023", imagem = R.drawable.teste, descricao = "Teste", emEspera = true, emAndamento = false, concluido = false ),
            Projetos(nome = "Teste", prazo = "14/12/2023", imagem = R.drawable.teste, descricao = "Teste", emEspera = true, emAndamento = false, concluido = false ),
            Projetos(nome = "Teste", prazo = "14/12/2023", imagem = R.drawable.teste, descricao = "Teste", emEspera = true, emAndamento = false, concluido = false ),
            Projetos(nome = "Teste", prazo = "14/12/2023", imagem = R.drawable.teste, descricao = "Teste", emEspera = true, emAndamento = false, concluido = false )
        )
    }
}