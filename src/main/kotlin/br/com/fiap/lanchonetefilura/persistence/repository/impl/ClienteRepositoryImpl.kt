package br.com.fiap.lanchonetefilura.persistence.repository.impl

import br.com.fiap.lanchonetefilura.domain.entity.Cliente
import br.com.fiap.lanchonetefilura.persistence.adapter.ClienteAdapter
import br.com.fiap.lanchonetefilura.persistence.dto.ClienteDTO
import br.com.fiap.lanchonetefilura.persistence.repository.ClienteRepository
import br.com.fiap.lanchonetefilura.persistence.repository.jpa.ClienteJpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ClienteRepositoryImpl(
    private val repository: ClienteJpaRepository,
    private val adapter: ClienteAdapter
) : ClienteRepository {
    override fun listarClientes(): List<Cliente> {

        val clientesDTO: List<ClienteDTO> = repository.findAll()

        return adapter.adaptarClientesDtoParaClientes(clientesDTO)
    }

    override fun cadastrarCliente(cliente : Cliente): Cliente {

        val clienteDTO: ClienteDTO = adapter.adaptarClienteParaClienteDTO(cliente)

        return adapter.adaptarClienteDTOParaCliente(
            repository.save(clienteDTO)
        )
    }

    override fun buscarClientePeloCpf(cpf: String): Cliente? {

        val clienteDTO: ClienteDTO? = repository.findClienteByCpf(cpf)

        return clienteDTO?.let { adapter.adaptarClienteDTOParaCliente(it) }
    }

    override fun buscarClientePeloId(clienteId: UUID): Optional<Cliente> {

        val clienteDTO: Optional<ClienteDTO> = repository.findById(clienteId)

        return Optional.of(adapter.adaptarClienteDTOParaCliente(clienteDTO.get()))
    }
}