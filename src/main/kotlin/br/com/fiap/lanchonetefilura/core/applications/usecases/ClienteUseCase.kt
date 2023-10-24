package br.com.fiap.lanchonetefilura.core.applications.usecases

import br.com.fiap.lanchonetefilura.core.domain.model.ClienteModel

interface ClienteUseCase {
    fun getClientes(): ArrayList<ClienteModel>
}