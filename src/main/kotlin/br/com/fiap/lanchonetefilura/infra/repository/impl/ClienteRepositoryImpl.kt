package br.com.fiap.lanchonetefilura.infra.repository.impl

import br.com.fiap.lanchonetefilura.api.model.cliente.ClienteRequest
import br.com.fiap.lanchonetefilura.infra.dto.ClienteDTO
import br.com.fiap.lanchonetefilura.infra.repository.ClienteRepository
import br.com.fiap.lanchonetefilura.infra.repository.jpa.ClienteJpaRepository
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper.logger
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ClienteRepositoryImpl(private val repository: ClienteJpaRepository) : ClienteRepository {
    override fun getClientes(): List<ClienteDTO>? {

        return repository.findAll()
    }

    override fun getClienteByCpf(cpf: String): ClienteDTO? {

        var cliente: ClienteDTO? = null

        try {
           cliente = repository.findClienteByCpf(cpf = cpf)
        } catch (ex: Exception) {
            logger.info("Cliente não localizado na base pelo cpf")
        }

        return cliente
    }

    override fun getClienteById(id: UUID): ClienteDTO? {

        var cliente: ClienteDTO? = null

        try {
            cliente = repository.findById(id).get()
        } catch (ex: Exception) {
            logger.info("Cliente não localizado na base pelo id")
        }

        return cliente
    }

    override fun saveCliente(clienteRequest: ClienteRequest): ClienteDTO? {


        return repository.save(ClienteDTO())
    }
}