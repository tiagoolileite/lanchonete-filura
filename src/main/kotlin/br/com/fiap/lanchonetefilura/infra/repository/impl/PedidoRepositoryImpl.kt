package br.com.fiap.lanchonetefilura.infra.repository.impl

import br.com.fiap.lanchonetefilura.domain.dto.PedidoDomainDTO
import br.com.fiap.lanchonetefilura.infra.adapter.ClienteInfraAdapter
import br.com.fiap.lanchonetefilura.infra.adapter.ProdutoInfraAdapter
import br.com.fiap.lanchonetefilura.infra.dto.PedidoDTO
import br.com.fiap.lanchonetefilura.infra.dto.impl.PedidoDTOImpl
import br.com.fiap.lanchonetefilura.infra.repository.PedidoRepository
import br.com.fiap.lanchonetefilura.infra.repository.jpa.PedidoJpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class PedidoRepositoryImpl(
    private val repository: PedidoJpaRepository,
    private val clienteInfraAdapter : ClienteInfraAdapter,
    private val produtoInfraAdapter : ProdutoInfraAdapter
) : PedidoRepository {

    override fun listarPedidos(): List<PedidoDTO> {
        return repository.findAll()
    }

    override fun criarPedido(pedidoDomainDTO : PedidoDomainDTO): PedidoDTO {

        val pedidoDTO = pedidoDomainDTO.id?.let {
            PedidoDTOImpl(
                id = it,
                senha = pedidoDomainDTO.senha,
                etapa = pedidoDomainDTO.etapa,
                cliente = clienteInfraAdapter.adaptarClienteDomainDtoEmDtoImpl(pedidoDomainDTO.cliente),
                produtos = produtoInfraAdapter.adaptarProdutosDomainDtoEmDtoImpl(pedidoDomainDTO.produtos)
                )

        }

        return pedidoDTO?.let { repository.save(it) } ?: throw Exception("Falha ao criar pedido")
    }

    override fun buscarPedidoPeloId(pedidoId: UUID): Optional<PedidoDTOImpl> {
        return repository.findById(pedidoId)
    }

    override fun pagarPedido(pedidoDomainDTO : PedidoDomainDTO): PedidoDTO {

        val pedidoDTO = pedidoDomainDTO.id?.let {
            PedidoDTOImpl(
                id = it,
                senha = pedidoDomainDTO.senha,
                etapa = pedidoDomainDTO.etapa,
                cliente = clienteInfraAdapter.adaptarClienteDomainDtoEmDtoImpl(pedidoDomainDTO.cliente),
                produtos = produtoInfraAdapter.adaptarProdutosDomainDtoEmDtoImpl(pedidoDomainDTO.produtos),
                preco = pedidoDomainDTO.preco,
                pago = pedidoDomainDTO.pago
                )
        }

        return pedidoDTO?.let { repository.save(it) } ?: throw Exception("Falha ao registrar pagamento do pedido")
    }
}