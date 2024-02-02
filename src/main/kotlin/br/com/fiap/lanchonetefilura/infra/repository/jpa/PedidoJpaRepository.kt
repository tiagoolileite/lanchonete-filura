package br.com.fiap.lanchonetefilura.infra.repository.jpa

import br.com.fiap.lanchonetefilura.infra.dto.PedidoDTOImpl
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PedidoJpaRepository : JpaRepository<PedidoDTOImpl, UUID>