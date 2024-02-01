package br.com.fiap.lanchonetefilura.infra.repository.impl

import br.com.fiap.lanchonetefilura.domain.dto.ClienteDomainDTO
import br.com.fiap.lanchonetefilura.infra.dto.ClienteDTO
import br.com.fiap.lanchonetefilura.infra.dto.impl.ClienteDTOImpl
import br.com.fiap.lanchonetefilura.infra.repository.ClienteRepository
import br.com.fiap.lanchonetefilura.infra.repository.jpa.ClienteJpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ClienteRepositoryImpl(private val repository: ClienteJpaRepository) : ClienteRepository {
    override fun listarClientes(): List<ClienteDTO> {
        return repository.findAll()
    }

    override fun cadastrarCliente(clienteDomainDTO : ClienteDomainDTO): ClienteDTO {

        val clienteDTO = ClienteDTOImpl(
            id = clienteDomainDTO.id,
            cpf = clienteDomainDTO.cpf,
            nome = clienteDomainDTO.nome,
            email = clienteDomainDTO.email
        )

        return repository.save(clienteDTO)
    }

    override fun buscarClientePeloCpf(cpf: String): ClienteDTO? {

        return repository.findClienteByCpf(cpf)
    }

    override fun buscarClientePeloId(clienteId: UUID): Optional<ClienteDTO> {

        val clienteOptionalDTOImpl: Optional<ClienteDTOImpl> = repository.findById(clienteId)

        return Optional.of(clienteOptionalDTOImpl.get())
    }
}