package br.com.fiap.lanchonetefilura.domain.controller.impl

import br.com.fiap.lanchonetefilura.api.model.cliente.ClienteResponse
import br.com.fiap.lanchonetefilura.domain.controller.ClienteController
import br.com.fiap.lanchonetefilura.domain.usecase.ClienteUseCase
import br.com.fiap.lanchonetefilura.infra.dto.ClienteDTO
import org.springframework.stereotype.Component

@Component
class ClienteControllerImpl(
    val useCase: ClienteUseCase
) : ClienteController {
    override fun listarClientes(): List<ClienteResponse> {

        val clientesDTO: List<ClienteDTO> = useCase.listarClientes()

        val clientesResponse: ArrayList<ClienteResponse> = arrayListOf()

        clientesDTO.forEach {
            clientesResponse.add(
                ClienteResponse(
                id = it.id,
                cpf = it.cpf,
                nome = it.nome,
                email = it.email
            ))
        }

        return clientesResponse.toList()
    }

    override fun cadastrarCliente(email: String?, nome: String?, cpf: String?): ClienteResponse {

        val clienteDTO: ClienteDTO = useCase.cadastrarCliente(
            email, nome, cpf
        )

        return ClienteResponse(
            id = clienteDTO.id,
            cpf = clienteDTO.cpf,
            nome = clienteDTO.nome,
            email = clienteDTO.email
        )
    }

    override fun buscarClientePeloCpf(cpf: String): ClienteResponse {

        val clienteDTO: ClienteDTO = useCase.buscarClientePeloCpf(cpf)

        return ClienteResponse(
            id = clienteDTO.id,
            cpf = clienteDTO.cpf,
            nome = clienteDTO.nome,
            email = clienteDTO.email
        )
    }
}