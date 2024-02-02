package br.com.fiap.lanchonetefilura.domain.dto.impl

import br.com.fiap.lanchonetefilura.domain.dto.CategoriaDomainDTO
import java.util.*

data class CategoriaDomainDTOImpl(
    override var id: UUID = UUID.randomUUID(),
    override val descricao: String? = null
) : CategoriaDomainDTO