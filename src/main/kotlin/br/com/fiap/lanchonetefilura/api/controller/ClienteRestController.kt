package br.com.fiap.lanchonetefilura.api.controller

import br.com.fiap.lanchonetefilura.api.mapper.ClienteMapper
import br.com.fiap.lanchonetefilura.api.model.cliente.ClienteRequest
import br.com.fiap.lanchonetefilura.api.model.cliente.ClienteResponse
import br.com.fiap.lanchonetefilura.domain.entity.Cliente
import br.com.fiap.lanchonetefilura.domain.usecase.ClienteUseCase
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/cliente")
class ClienteRestController(
    val useCase: ClienteUseCase,
    val mapper: ClienteMapper
) {
    @GetMapping("/clientes")
    fun listarClientes(): ResponseEntity<List<ClienteResponse>> {

        LoggerHelper.logger.info("${LoggerHelper.LOG_TAG_APP}: Solicitando listagem de clientes")

        val clientes: List<Cliente> =
            useCase.listarClientes()

        val clientesResponse: List<ClienteResponse> = mapper.mapeiaClientesResponse(clientes = clientes)

        return ResponseEntity.ok(clientesResponse).let { response ->
            LoggerHelper.logger.info("[FILURA]: Busca por clientes realizada com sucesso")
            response
        }
    }

    @GetMapping
    fun buscarClientePeloCpf(@RequestParam cpf: String): ResponseEntity<ClienteResponse> {

        LoggerHelper.logger.info("${LoggerHelper.LOG_TAG_APP}: Solicitando consulta de cliente")

        val cliente: Cliente? = useCase.buscarClientePeloCpf(cpf = cpf)

        val clienteResponse: ClienteResponse? = cliente?.let { mapper.mapeiaClienteResponse(cliente = it) }

        return ResponseEntity.ok(clienteResponse).let { response ->
            LoggerHelper.logger.info("${LoggerHelper.LOG_TAG_APP}:  Consulta de cliente realizada com sucesso!")
            response
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrarCliente(@RequestBody @Valid clienteRequest: ClienteRequest): ResponseEntity<ClienteResponse> {

        LoggerHelper.logger.info("${LoggerHelper.LOG_TAG_APP}:  Solicitando cadastro de cliente")

        val cliente: Cliente? = useCase.cadastrarCliente(
            email = clienteRequest.email,
            nome = clienteRequest.nome,
            cpf = clienteRequest.cpf
        )

        val clienteResponse: ClienteResponse? = cliente?.let { mapper.mapeiaClienteResponse(cliente = it) }

        return ResponseEntity.ok(clienteResponse).let { response ->
            LoggerHelper.logger.info("${LoggerHelper.LOG_TAG_APP}:  Cliente cadastrado com sucesso!")
            response
        }
    }
}
