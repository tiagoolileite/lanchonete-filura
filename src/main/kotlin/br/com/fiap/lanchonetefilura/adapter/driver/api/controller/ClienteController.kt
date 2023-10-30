package br.com.fiap.lanchonetefilura.adapter.driver.api.controller

import br.com.fiap.lanchonetefilura.adapter.driver.api.extensions.converterClienteModelToClienteResponse
import br.com.fiap.lanchonetefilura.adapter.driver.api.extensions.converterListaClienteModelToListaClienteResponse
import br.com.fiap.lanchonetefilura.adapter.driver.api.request.ClienteRequestImpl
import br.com.fiap.lanchonetefilura.adapter.driver.api.response.ClienteResponse
import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper.logger
import br.com.fiap.lanchonetefilura.core.applications.usecases.ClienteUseCase
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RequestBody

@RestController
@RequestMapping("api/cliente")
class ClienteController (private val useCase: ClienteUseCase) {

    @GetMapping("/clientes")
    fun getClientes(): ResponseEntity<List<ClienteResponse>> {

        logger.info("[FILURA]: Listando clientes")
        val clientes = useCase.getClientes()

        val clientesResponse = clientes?.converterListaClienteModelToListaClienteResponse()

        return ResponseEntity.ok(clientesResponse).let { response ->
            logger.info("[FILURA]: Busca por clientes realizada com sucesso")
            response
        }
    }

    @GetMapping
    fun getClienteByCpf(@RequestParam cpf: String): ResponseEntity<ClienteResponse> {

        logger.info("[FILURA]: Buscando cliente pelo CPF")
        val clienteModel = useCase.getClienteByCpf(cpf)

        val clienteResponse = clienteModel.converterClienteModelToClienteResponse()

        return ResponseEntity.ok(clienteResponse).let { response ->
            logger.info("[FILURA]: Busca por cliente pelo CPF realizada com sucesso")
            response
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveCliente(@RequestBody @Valid clienteRequest: ClienteRequestImpl): ResponseEntity<ClienteResponse> {

        logger.info("[FILURA]: Salvando Cliente")
        val clienteModel = useCase.saveCliente(clienteRequest)

        val clienteResponse = clienteModel.converterClienteModelToClienteResponse()

        return ResponseEntity.ok(clienteResponse).let { response ->
            logger.info("[FILURA]: Cliente salvo com sucesso")
            response
        }
    }
}