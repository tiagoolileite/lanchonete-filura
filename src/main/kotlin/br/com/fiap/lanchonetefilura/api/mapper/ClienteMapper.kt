package br.com.fiap.lanchonetefilura.api.mapper

import br.com.fiap.lanchonetefilura.api.model.cliente.ClienteResponse
import br.com.fiap.lanchonetefilura.domain.entity.Cliente

interface ClienteMapper {

    fun mapeiaClientesResponse(clientes: List<Cliente>): List<ClienteResponse>

    fun mapeiaClienteResponse(cliente : Cliente?) : ClienteResponse

}
