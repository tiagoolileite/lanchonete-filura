package br.com.fiap.lanchonetefilura.domain.dto.impl

import br.com.fiap.lanchonetefilura.domain.dto.ProdutoDomainDTO
import java.util.*

data class ProdutoDomainDTOImpl(

    override var id : UUID? = UUID.randomUUID(),

    override var nome : String? = null,

    override var descricao : String? = null,

    override var preco : Double? = null,

    override var categoria : CategoriaDomainDTOImpl? = null,

    override val pedidos : List<PedidoDomainDTOImpl>? = null
) : ProdutoDomainDTO
