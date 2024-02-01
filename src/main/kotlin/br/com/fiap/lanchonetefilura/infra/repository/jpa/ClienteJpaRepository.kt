package br.com.fiap.lanchonetefilura.infra.repository.jpa

import br.com.fiap.lanchonetefilura.domain.dto.impl.ClienteDTO
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ClienteJpaRepository : JpaRepository<ClienteDTO, UUID> {

    fun findClienteByCpf(cpf: String): ClienteDTO?
}