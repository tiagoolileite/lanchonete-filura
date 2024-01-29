package br.com.fiap.lanchonetefilura.api.controller

class PedidoRestController {
}

/*
@RestController
@RequestMapping("api/pedido")
class PedidoController (private val pedidoUseCase: PedidoUseCase) {

    @GetMapping("/pedidos")
    @ResponseStatus(HttpStatus.OK)
    fun getPedidos(): ResponseEntity<List<PedidoResponse>> {

        logger.info("[FILURA]: Listando pedidos")
        val pedidos = pedidoUseCase.getPedidos()

        val pedidosResponse = pedidos?.converterListaPedidosModelToListaPedidosResponse()

        return ResponseEntity.ok(pedidosResponse).let { response ->
            logger.info("[FILURA]: Busca por pedidos realizada com sucesso")
            response
        }
    }

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