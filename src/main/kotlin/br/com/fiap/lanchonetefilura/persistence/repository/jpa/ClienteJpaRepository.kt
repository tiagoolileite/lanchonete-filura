package br.com.fiap.lanchonetefilura.persistence.repository.jpa

import br.com.fiap.lanchonetefilura.persistence.dto.ClienteDTO
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ClienteJpaRepository : JpaRepository<ClienteDTO, UUID> {

    fun findClienteByCpf(cpf: String): ClienteDTO?
}