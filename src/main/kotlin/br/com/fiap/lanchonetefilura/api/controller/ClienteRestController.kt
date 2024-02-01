package br.com.fiap.lanchonetefilura.api.controller

import br.com.fiap.lanchonetefilura.api.mapper.ClienteMapper
import br.com.fiap.lanchonetefilura.api.model.cliente.ClienteRequest
import br.com.fiap.lanchonetefilura.api.model.cliente.ClienteResponse
import br.com.fiap.lanchonetefilura.domain.controller.ClienteController
import br.com.fiap.lanchonetefilura.infra.dto.impl.ClienteDTOImpl
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/cliente")
class ClienteRestController(
    val controller: ClienteController,
    val mapper: ClienteMapper
) {
    @GetMapping("/clientes")
    fun listarClientes(): ResponseEntity<List<ClienteResponse>> {

        LoggerHelper.logger.info("${LoggerHelper.LOG_TAG_APP}: Solicitando listagem de clientes")

        val clientesDomainDTO: List<ClienteDTOImpl> =
            controller.listarClientes()

        val clientesResponse: List<ClienteResponse> = mapper.mapeiaClientesResponse(clientesDomainDTO = clientesDomainDTO)

        return ResponseEntity.ok(clientesResponse).let { response ->
            LoggerHelper.logger.info("[FILURA]: Busca por clientes realizada com sucesso")
            response
        }
    }

    @GetMapping
    fun buscarClientePeloCpf(@RequestParam cpf: String): ResponseEntity<ClienteResponse> {

        LoggerHelper.logger.info("${LoggerHelper.LOG_TAG_APP}: Solicitando consulta de cliente")

        val clienteDomainDTO: ClienteDTOImpl = controller.buscarClientePeloCpf(cpf = cpf)

        val clienteResponse: ClienteResponse = mapper.mapeiaClienteResponse(clienteDomainDTO = clienteDomainDTO)

        return ResponseEntity.ok(clienteResponse).let { response ->
            LoggerHelper.logger.info("${LoggerHelper.LOG_TAG_APP}:  Consulta de cliente realizada com sucesso!")
            response
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrarCliente(@RequestBody @Valid clienteRequest: ClienteRequest): ResponseEntity<ClienteResponse> {

        LoggerHelper.logger.info("${LoggerHelper.LOG_TAG_APP}:  Solicitando cadastro de cliente")

        val clienteDomainDTO: ClienteDTOImpl = controller.cadastrarCliente(
            email = clienteRequest.email,
            nome = clienteRequest.nome,
            cpf = clienteRequest.cpf
        )

        val clienteResponse: ClienteResponse = mapper.mapeiaClienteResponse(clienteDomainDTO = clienteDomainDTO)

        return ResponseEntity.ok(clienteResponse).let { response ->
            LoggerHelper.logger.info("${LoggerHelper.LOG_TAG_APP}:  Cliente cadastrado com sucesso!")
            response
        }
    }
}
