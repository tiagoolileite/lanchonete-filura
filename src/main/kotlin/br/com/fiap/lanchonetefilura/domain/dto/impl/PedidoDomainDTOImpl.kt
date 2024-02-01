package br.com.fiap.lanchonetefilura.domain.dto.impl

import br.com.fiap.lanchonetefilura.domain.dto.PedidoDomainDTO
import java.util.*

class PedidoDomainDTOImpl(
    override val id : UUID? = UUID.randomUUID(),
    override val senha : Int,
    override val etapa : String,
    override val cliente : ClienteDomainDTOImpl?,
    override val produtos : List<ProdutoDomainDTOImpl>,
    override var preco : Double,
    override var pago : Boolean
) : PedidoDomainDTO