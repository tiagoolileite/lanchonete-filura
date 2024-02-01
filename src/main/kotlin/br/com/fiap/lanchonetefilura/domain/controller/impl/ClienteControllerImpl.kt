package br.com.fiap.lanchonetefilura.domain.controller.impl

import br.com.fiap.lanchonetefilura.api.model.cliente.ClienteResponse
import br.com.fiap.lanchonetefilura.domain.adapter.ClienteAdapter
import br.com.fiap.lanchonetefilura.domain.controller.ClienteController
import br.com.fiap.lanchonetefilura.domain.dto.impl.ClienteDTO
import br.com.fiap.lanchonetefilura.domain.usecase.ClienteUseCase
import org.springframework.stereotype.Component

@Component
class ClienteControllerImpl(
    val useCase: ClienteUseCase,
    val adapter: ClienteAdapter
) : ClienteController {
    override fun listarClientes(): List<ClienteResponse> {

        val clientesDTO: List<ClienteDTO> = useCase.listarClientes()

        return adapter.adaptarListaDeCliente(clientesDTO)
    }

    override fun cadastrarCliente(email: String?, nome: String?, cpf: String?): ClienteResponse {

        val clienteDTO: ClienteDTO = useCase.cadastrarCliente(
            email, nome, cpf
        )

        return adapter.adaptarCliente(clienteDTO)
    }

    override fun buscarClientePeloCpf(cpf: String): ClienteResponse {

        val clienteDTO: ClienteDTO = useCase.buscarClientePeloCpf(cpf)

        return adapter.adaptarCliente(clienteDTO)
    }
}