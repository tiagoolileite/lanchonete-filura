package br.com.fiap.lanchonetefilura.domain.gateway.impl

import br.com.fiap.lanchonetefilura.domain.entity.Categoria
import br.com.fiap.lanchonetefilura.domain.gateway.CategoriaGateway
import br.com.fiap.lanchonetefilura.persistence.repository.CategoriaRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class CategoriaGatewayImpl(
    val repository: CategoriaRepository
) : CategoriaGateway {
    override fun cadastrarCategoria(categoria: Categoria): Categoria {

        return repository.cadastrarCategoria(categoria = categoria)
    }

    override fun listarCategorias(): List<Categoria> {

        return repository.listarCategorias()
    }

    override fun buscarCategoriaPeloId(categoriaId: UUID): Optional<Categoria> {

        return repository.buscarCategoriaPeloId(categoriaId)
    }
}