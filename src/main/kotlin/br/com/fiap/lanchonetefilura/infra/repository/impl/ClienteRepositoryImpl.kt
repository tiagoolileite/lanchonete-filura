package br.com.fiap.lanchonetefilura.infra.repository.impl

import br.com.fiap.lanchonetefilura.domain.entity.Cliente
import br.com.fiap.lanchonetefilura.infra.repository.ClienteRepository
import br.com.fiap.lanchonetefilura.infra.repository.jpa.ClienteJpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ClienteRepositoryImpl(private val repository: ClienteJpaRepository) : ClienteRepository {
    override fun listarClientes(): List<Cliente> {
        return repository.findAll()
    }

    override fun cadastrarCliente(clienteDomainDTO : Cliente): Cliente {

        val cliente = Cliente(
            id = clienteDomainDTO.id,
            cpf = clienteDomainDTO.cpf,
            nome = clienteDomainDTO.nome,
            email = clienteDomainDTO.email
        )

        return repository.save(cliente)
    }

    override fun buscarClientePeloCpf(cpf: String): Cliente? {

        return repository.findClienteByCpf(cpf)
    }

    override fun buscarClientePeloId(clienteId: UUID): Optional<Cliente> {

        val clienteOptionalDTOImpl: Optional<Cliente> = repository.findById(clienteId)

        return Optional.of(clienteOptionalDTOImpl.get())
    }
}