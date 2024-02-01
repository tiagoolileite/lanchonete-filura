package br.com.fiap.lanchonetefilura.api.controller

import br.com.fiap.lanchonetefilura.api.mapper.PedidoMapper
import br.com.fiap.lanchonetefilura.api.model.pedido.PedidoRequest
import br.com.fiap.lanchonetefilura.api.model.pedido.PedidoResponse
import br.com.fiap.lanchonetefilura.domain.controller.PedidoController
import br.com.fiap.lanchonetefilura.domain.dto.PedidoDomainDTO
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/pedido")
class PedidoRestController(
    val controller: PedidoController,
    val mapper: PedidoMapper
) {

    @GetMapping("/pedidos")
    @ResponseStatus(HttpStatus.OK)
    fun listarPedidos(): ResponseEntity<List<PedidoResponse>> {

        LoggerHelper.logger.info("${LoggerHelper.LOG_TAG_APP}: Solicitando listagem de pedidos")

        val pedidosDomainDTO: List<PedidoDomainDTO> =
            controller.listarPedidos()

        val pedidosResponse: List<PedidoResponse> =
            mapper.mapeiaPedidosResponse(pedidosDomainDTO = pedidosDomainDTO)

        return ResponseEntity.ok(pedidosResponse).let { response ->
            LoggerHelper.logger.info("${LoggerHelper.LOG_TAG_APP}: Busca por pedidos realizada com sucesso!")
            response
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun criarPedido(
        @RequestBody @Valid pedidoRequest: PedidoRequest
    ): ResponseEntity<PedidoResponse> {

        LoggerHelper.logger.info("${LoggerHelper.LOG_TAG_APP}: Solicitando criação de pedido")

        val pedidoDomainDTO: PedidoDomainDTO? = controller.criarPedido(
            clienteId = pedidoRequest.clienteId,
            produtosId = pedidoRequest.produtosId
        )

        val pedidoResponse: PedidoResponse? = mapper.mapeiaPedidoResponse(
            pedidoDomainDTO = pedidoDomainDTO
        )

        return ResponseEntity.ok(pedidoResponse).let { response ->
            LoggerHelper.logger.info("${LoggerHelper.LOG_TAG_APP}: Pedido criação com sucesso")
            response
        }
    }

    @PutMapping("/pagamento")
    @ResponseStatus(HttpStatus.OK)
    fun pagarPedido(
        @RequestParam("pedido_id") pedidoId: UUID
    ): ResponseEntity<PedidoResponse> {

        LoggerHelper.logger.info("${LoggerHelper.LOG_TAG_APP}: Atualizando status do pedido")

        val pedidoDomainDTO: PedidoDomainDTO? = controller.pagarPedido(pedidoId)

        val pedidoResponse: PedidoResponse? = mapper.mapeiaPedidoResponse(pedidoDomainDTO)

        return ResponseEntity.ok(pedidoResponse).let { response ->
            LoggerHelper.logger.info("${LoggerHelper.LOG_TAG_APP}: Status do pagamento atualizado com sucesso")
            response
        }
    }
}
