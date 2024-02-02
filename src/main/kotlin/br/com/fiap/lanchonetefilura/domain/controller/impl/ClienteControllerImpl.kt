package br.com.fiap.lanchonetefilura.domain.controller.impl

import br.com.fiap.lanchonetefilura.domain.controller.ClienteController
import br.com.fiap.lanchonetefilura.domain.dto.ClienteDomainDTO
import br.com.fiap.lanchonetefilura.domain.usecase.ClienteUseCase
import br.com.fiap.lanchonetefilura.infra.dto.impl.ClienteDTOImpl
import org.springframework.stereotype.Component

@Component
class ClienteControllerImpl(
    val useCase: ClienteUseCase
) : ClienteController {
    override fun listarClientes(): List<ClienteDTOImpl> {
        return useCase.listarClientes()
    }

    override fun cadastrarCliente(email: String?, nome: String?, cpf: String?): ClienteDTOImpl {
        return useCase.cadastrarCliente(
            nome = nome,
            email = email,
            cpf = cpf
        )
    }

    override fun buscarClientePeloCpf(cpf: String): ClienteDTOImpl {
        return useCase.buscarClientePeloCpf(cpf)
    }
}