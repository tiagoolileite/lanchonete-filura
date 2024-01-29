package br.com.fiap.lanchonetefilura.domain.usecase.impl

import br.com.fiap.lanchonetefilura.domain.entity.Categoria
import br.com.fiap.lanchonetefilura.domain.gateway.CategoriaGateway
import br.com.fiap.lanchonetefilura.domain.usecase.CategoriaUseCase
import br.com.fiap.lanchonetefilura.infra.dto.CategoriaDTO
import org.springframework.stereotype.Component
import java.lang.Error
import java.util.*

@Component
class CategoriaUseCaseImpl(val gateway: CategoriaGateway) : CategoriaUseCase {
    override fun cadastrarCategoria(descricao: String): CategoriaDTO {

        val categoria = Categoria()

        categoria.validaDescricao(descricao)

        return gateway.cadastrarCategoria(descricao)
    }

    override fun listarCategorias(): List<CategoriaDTO> {
        return gateway.listarCategorias()
    }

    override fun buscarCategoriaPeloId(categoriaId: UUID?): CategoriaDTO? {

        val categoria = gateway.buscarCategoriaPeloId(categoriaId)

        if (categoria?.id == null) {
            throw Error("Categoria não localizada")
        }

        return categoria
    }
}