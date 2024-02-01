package br.com.fiap.lanchonetefilura.domain.dto.impl

import br.com.fiap.lanchonetefilura.domain.dto.ProdutoDomainDTO
import br.com.fiap.lanchonetefilura.infra.dto.impl.CategoriaDTOImpl
import java.util.*

data class ProdutoDomainDTOImpl (

    override var id: UUID? = UUID.randomUUID(),

    override var nome: String? = null,

    override var descricao: String? = null,

    override var preco: Double? = null,

    override var categoria: CategoriaDTOImpl? = null,

    override val pedidos: List<PedidoDTO>? = null
) : ProdutoDomainDTO
