package br.com.fiap.lanchonetefilura.infra.repository.impl

import br.com.fiap.lanchonetefilura.domain.dto.impl.ClienteDTO
import br.com.fiap.lanchonetefilura.infra.repository.ClienteRepository
import br.com.fiap.lanchonetefilura.infra.repository.jpa.ClienteJpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ClienteRepositoryImpl(private val repository: ClienteJpaRepository) : ClienteRepository {
    /*override fun getClientes(): List<ClienteDTO>? {

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
    }*/

    override fun listarClientes(): List<ClienteDTO> {

        return repository.findAll()
    }

    override fun cadastrarCliente(email: String?, nome: String?, cpf: String?): ClienteDTO {

        return repository.save(
            ClienteDTO(
            email = email, nome = nome, cpf = cpf
        )
        )
    }

    override fun buscarClientePeloCpf(cpf: String): ClienteDTO? {

        return repository.findClienteByCpf(cpf)
    }

    override fun buscarClientePeloId(clienteId: UUID): Optional<ClienteDTO> {

        return repository.findById(clienteId)
    }
}