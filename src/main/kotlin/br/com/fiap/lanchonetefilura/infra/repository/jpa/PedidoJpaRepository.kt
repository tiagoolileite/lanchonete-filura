package br.com.fiap.lanchonetefilura.infra.repository.jpa

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PedidoJpaRepository : JpaRepository<PedidoModel, UUID>