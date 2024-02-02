package br.com.fiap.lanchonetefilura.infra.repository.jpa

import br.com.fiap.lanchonetefilura.infra.dto.ClienteDTO
import br.com.fiap.lanchonetefilura.infra.dto.impl.ClienteDTOImpl
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ClienteJpaRepository : JpaRepository<ClienteDTOImpl, UUID> {

    fun findClienteByCpf(cpf: String): ClienteDTO?
}