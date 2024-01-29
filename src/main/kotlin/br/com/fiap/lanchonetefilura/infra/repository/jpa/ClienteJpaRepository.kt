package br.com.fiap.lanchonetefilura.infra.repository.jpa

import br.com.fiap.lanchonetefilura.core.domain.model.ClienteModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ClienteJpaRepository : JpaRepository<ClienteModel, UUID> {

    fun findClienteByCpf(cpf: String): ClienteModel?
}