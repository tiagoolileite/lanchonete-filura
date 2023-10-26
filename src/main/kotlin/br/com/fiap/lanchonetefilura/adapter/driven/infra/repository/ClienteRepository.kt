package br.com.fiap.lanchonetefilura.adapter.driven.infra.repository

import br.com.fiap.lanchonetefilura.core.domain.model.ClienteModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ClienteRepository : JpaRepository<ClienteModel, UUID> {

    fun findClienteByCpf(cpf: String): ClienteModel?
}