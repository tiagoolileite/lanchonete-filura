package br.com.fiap.lanchonetefilura.infra.repository.jpa

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ClienteJpaRepository : JpaRepository<ClienteModel, UUID> {

    fun findClienteByCpf(cpf: String): ClienteModel?
}