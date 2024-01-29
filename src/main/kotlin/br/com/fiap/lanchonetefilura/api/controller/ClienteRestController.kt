package br.com.fiap.lanchonetefilura.api.controller

import br.com.fiap.lanchonetefilura.api.model.cliente.ClienteRequest
import br.com.fiap.lanchonetefilura.api.model.cliente.ClienteResponse
import br.com.fiap.lanchonetefilura.domain.controller.ClienteController
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/cliente")
class ClienteRestController(val controller: ClienteController) {
    @GetMapping("/clientes")
    fun listarClientes(): ResponseEntity<List<ClienteResponse>> {

        LoggerHelper.logger.info("[FILURA]: Listando clientes")

        val clientesResponse: List<ClienteResponse> =
            controller.listarClientes()

        return ResponseEntity.ok(clientesResponse).let { response ->
            LoggerHelper.logger.info("[FILURA]: Busca por clientes realizada com sucesso")
            response
        }
    }

    @GetMapping
    fun buscarClientePeloCpf(@RequestParam cpf: String): ResponseEntity<ClienteResponse> {

        LoggerHelper.logger.info("[FILURA]: Buscando cliente pelo CPF")
        val clienteResponse = controller.buscarClientePeloCpf(cpf)

        return ResponseEntity.ok(clienteResponse).let { response ->
            LoggerHelper.logger.info("[FILURA]: Busca por cliente pelo CPF realizada com sucesso")
            response
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrarCliente(@RequestBody @Valid clienteRequest: ClienteRequest): ResponseEntity<ClienteResponse> {

        LoggerHelper.logger.info("[FILURA]: Salvando Cliente")
        val clienteResponse: ClienteResponse = controller.cadastrarCliente(
            clienteRequest.email,
            clienteRequest.nome,
            clienteRequest.cpf
        )

        return ResponseEntity.ok(clienteResponse).let { response ->
            LoggerHelper.logger.info("[FILURA]: Cliente salvo com sucesso")
            response
        }
    }
}
