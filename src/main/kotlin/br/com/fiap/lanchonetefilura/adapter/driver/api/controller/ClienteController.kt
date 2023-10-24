package br.com.fiap.lanchonetefilura.adapter.driver.api.controller

import br.com.fiap.lanchonetefilura.adapter.driver.api.shared.ApiHelper.logger
import br.com.fiap.lanchonetefilura.core.applications.usecases.ClienteUseCase
import br.com.fiap.lanchonetefilura.core.domain.model.ClienteModel
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/clientes")
class ClienteController (private val useCase: ClienteUseCase) {

    @GetMapping
    fun getClientes(): ResponseEntity<ArrayList<ClienteModel>> {

        val clientes = useCase.getClientes()

        logger.info("Lista de clientes requisitada com sucesso")

        return ResponseEntity.ok(clientes)

    }
}