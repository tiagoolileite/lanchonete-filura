package br.com.fiap.lanchonetefilura.domain.usecase.impl

import br.com.fiap.lanchonetefilura.domain.entity.Categoria
import br.com.fiap.lanchonetefilura.domain.exceptions.categoria.CategoriaNaoEncontradaException
import br.com.fiap.lanchonetefilura.domain.gateway.CategoriaGateway
import br.com.fiap.lanchonetefilura.domain.usecase.CategoriaUseCase
import org.springframework.stereotype.Component
import java.util.*

@Component
class CategoriaUseCaseImpl(
    val gateway: CategoriaGateway
) : CategoriaUseCase {
    override fun cadastrarCategoria(descricao: String): Categoria {

        val categoria = Categoria(descricao = descricao)

        return gateway.cadastrarCategoria(categoria = categoria)
    }

    override fun listarCategorias(): List<Categoria> {
        return gateway.listarCategorias()
    }

    override fun buscarCategoriaPeloId(categoriaId: UUID): Categoria? {

        val categoria: Optional<Categoria> = gateway.buscarCategoriaPeloId(categoriaId = categoriaId)

        if (categoria.isEmpty) {
            throw CategoriaNaoEncontradaException()
        }

        return categoria.get()
    }
}