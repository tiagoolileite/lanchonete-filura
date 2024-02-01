package br.com.fiap.lanchonetefilura.domain.controller.impl

import br.com.fiap.lanchonetefilura.domain.controller.ClienteController
import br.com.fiap.lanchonetefilura.domain.dto.ClienteDomainDTO
import br.com.fiap.lanchonetefilura.domain.usecase.ClienteUseCase
import org.springframework.stereotype.Component

@Component
class ClienteControllerImpl(
    val useCase: ClienteUseCase
) : ClienteController {
    override fun listarClientes(): List<ClienteDomainDTO> {
        return useCase.listarClientes()
    }

    override fun cadastrarCliente(email: String?, nome: String?, cpf: String?): ClienteDomainDTO {
        return useCase.cadastrarCliente(
            nome = nome,
            email = email,
            cpf = cpf
        )
    }

    override fun buscarClientePeloCpf(cpf: String): ClienteDomainDTO {
        return useCase.buscarClientePeloCpf(cpf = cpf)
    }
}