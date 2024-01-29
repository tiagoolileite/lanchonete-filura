package br.com.fiap.lanchonetefilura.api.controller

import br.com.fiap.lanchonetefilura.api.model.pedido.PedidoResponse
import br.com.fiap.lanchonetefilura.domain.controller.PedidoController
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

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
}

/*

class PedidoController (private val pedidoUseCase: PedidoUseCase) {



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun savePedido(
        @RequestBody @Valid pedidoRequest: PedidoRequestImpl
    ): ResponseEntity<PedidoResponse> {

        logger.info("[FILURA]: Salvando Pedido")
        val pedido: PedidoModel? = pedidoUseCase.savePedido(pedidoRequest)

        val pedidoResponse: PedidoResponse? = pedido?.converterPedidoModelToPedidoResponse()

        return ResponseEntity.ok(pedidoResponse).let { response ->
            logger.info("[FILURA]: Pedido salvo com sucesso")
            response
        }
    }

    @PutMapping("/etapa")
    @ResponseStatus(HttpStatus.OK)
    fun updateEtapaPedido(
        @RequestParam etapa: String,
        @RequestParam("pedido_id") pedidoId: UUID
    ): ResponseEntity<PedidoResponse> {

        logger.info("[FILURA]: Atualização etapa do pedido")
        val pedido: PedidoModel? = pedidoUseCase.updateEtapaPedido(
                pedidoId = pedidoId,
                etapa = etapa
            )?.updateEtapaPedidoModel(etapa = etapa)

        val pedidoResponse = pedido?.converterPedidoModelToPedidoResponse()

        return ResponseEntity.ok(pedidoResponse).let { response ->
            logger.info("[FILURA]: Etapa do pedido atualizado com sucesso")
            response
        }
    }

    @PutMapping("/pagamento")
    @ResponseStatus(HttpStatus.OK)
    fun updateStatusPagamentoPedido(
        @RequestParam("pedido_id") pedidoId: UUID
    ): ResponseEntity<PedidoResponse> {

        logger.info("[FILURA]: Atualização status do pagamento do pedido")
        val pedido: PedidoModel? = pedidoUseCase.updateStatusPagamentoPedido(
            pedidoId = pedidoId,
        )?.updateEtapaPedidoModel(etapa = "Recebido")

        pedido?.pago = true

        val pedidoResponse = pedido?.converterPedidoModelToPedidoResponse()

        return ResponseEntity.ok(pedidoResponse).let { response ->
            logger.info("[FILURA]: Status do pagamento do pedido atualizado com sucesso")
            response
        }
    }
}*/