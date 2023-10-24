package br.com.fiap.lanchonetefilura.adapter.driver.api.controller

import br.com.fiap.lanchonetefilura.core.applications.usecases.ClienteUseCase
import br.com.fiap.lanchonetefilura.core.domain.model.ClienteModel
import br.com.fiap.lanchonetefilura.adapter.driver.api.shared.logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception

@RestController
@RequestMapping("/clientes")
class ClienteController (private val useCase: ClienteUseCase) {

    @GetMapping
    fun getClientes(): ResponseEntity<ArrayList<ClienteModel>> {
        try {
            useCase.getClientes()
            logger.info("Lista de clientes requisitada com sucesso")
            return ResponseEntity.ok(useCase.getClientes())
        } catch (e: Exception) {
            logger.error("Falha ao listar clientes: ${e.message}")
            return ResponseEntity.badRequest().build()
        }
    }
}