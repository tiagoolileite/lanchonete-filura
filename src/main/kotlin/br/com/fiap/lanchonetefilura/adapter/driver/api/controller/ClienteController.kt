package br.com.fiap.lanchonetefilura.adapter.driver.api.controller

import br.com.fiap.lanchonetefilura.adapter.driver.api.request.ClienteRequest
import br.com.fiap.lanchonetefilura.adapter.driver.api.shared.ApiHelper.logger
import br.com.fiap.lanchonetefilura.core.applications.usecases.ClienteUseCase
import br.com.fiap.lanchonetefilura.core.domain.model.ClienteModel
import jakarta.validation.Valid
import org.hibernate.annotations.Parameter
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/clientes")
class ClienteController (private val useCase: ClienteUseCase) {

    @GetMapping
    fun findAllClientes(): ResponseEntity<ArrayList<ClienteModel>> {

        val clientes = useCase.findAllClientes()

        logger.info("Lista de clientes requisitada com sucesso")

        return ResponseEntity.ok(clientes)

    }

    @GetMapping("/cliente")
    fun findClienteByCpf(@RequestParam cpf: String): ResponseEntity<ClienteModel> {

        val cliente = useCase.findClienteByCpf(cpf)

        logger.info("Sucesso na consulta do Cliente!")

        return ResponseEntity.ok(cliente)

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveCliente(@RequestBody @Valid clienteRequest: ClienteRequest): ResponseEntity<ClienteModel> {

        val cliente = useCase.saveCliente(clienteRequest)

        return ResponseEntity.ok(cliente)
    }
}