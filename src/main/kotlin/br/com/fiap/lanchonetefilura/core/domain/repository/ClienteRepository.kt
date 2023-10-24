package br.com.fiap.lanchonetefilura.core.domain.repository

import br.com.fiap.lanchonetefilura.core.domain.model.ClienteModel

interface ClienteRepository {
    fun getClientes(): ArrayList<ClienteModel>
}