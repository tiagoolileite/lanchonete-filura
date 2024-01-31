package br.com.fiap.lanchonetefilura.api.controller

import br.com.fiap.lanchonetefilura.api.model.pedido.PedidoRequest
import br.com.fiap.lanchonetefilura.api.model.pedido.PedidoResponse
import br.com.fiap.lanchonetefilura.domain.controller.PedidoController
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/pedido")
class PedidoRestController(val controller: PedidoController) {

    @GetMapping("/pedidos")
    @ResponseStatus(HttpStatus.OK)
    fun listarPedidos(): ResponseEntity<List<PedidoResponse>> {

        LoggerHelper.logger.info("[FILURA]: Listando pedidos")
        val pedidosResponse: List<PedidoResponse> = controller.listarPedidos()

        return ResponseEntity.ok(pedidosResponse).let { response ->
            LoggerHelper.logger.info("[FILURA]: Busca por pedidos realizada com sucesso")
            response
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun criarPedido(
        @RequestBody @Valid pedidoRequest: PedidoRequest
    ): ResponseEntity<PedidoResponse> {

        LoggerHelper.logger.info("[FILURA]: Salvando Pedido")

        val pedidoResponse: PedidoResponse? = controller.criarPedido(
            pedidoRequest.clienteId, pedidoRequest.produtosId
        )

        return ResponseEntity.ok(pedidoResponse).let { response ->
            LoggerHelper.logger.info("[FILURA]: Pedido salvo com sucesso")
            response
        }
    }

    @PutMapping("/pagamento")
    @ResponseStatus(HttpStatus.OK)
    fun pagarPedido(
        @RequestParam("pedido_id") pedidoId: UUID
    ): ResponseEntity<PedidoResponse> {

        LoggerHelper.logger.info("[FILURA]: Atualização status do pagamento do pedido")

        val pedidoResponse: PedidoResponse? = controller.pagarPedido(pedidoId)

        return ResponseEntity.ok(pedidoResponse).let { response ->
            LoggerHelper.logger.info("[FILURA]: Status do pagamento do pedido atualizado com sucesso")
            response
        }
    }
}
