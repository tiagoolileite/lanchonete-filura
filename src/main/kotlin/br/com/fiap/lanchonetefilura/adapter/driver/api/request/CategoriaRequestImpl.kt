package br.com.fiap.lanchonetefilura.adapter.driver.api.request

import br.com.fiap.lanchonetefilura.core.domain.request.CategoriaRequestOld
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

class CategoriaRequestImpl (
    @NotNull(message = "descricao não pode estar vazia")
    @NotEmpty(message = "descricao não pode estar vazio")
    override var descricao: String? = ""
) : CategoriaRequestOld
