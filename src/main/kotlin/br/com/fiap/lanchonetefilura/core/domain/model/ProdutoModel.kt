package br.com.fiap.lanchonetefilura.core.domain.model

import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Column
import jakarta.persistence.GenerationType
import jakarta.persistence.ManyToOne
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import java.util.UUID

@Entity
@Table(name="produto")
data class ProdutoModel (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "produto_id")
    var id: UUID? = UUID.randomUUID(),
    @Column(nullable = false)
    var nome: String? = null,
    @Column(nullable = false)
    var descricao: String? = null,
    @Column(nullable = false)
    var preco: Double? = null,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id")
    var categoria: CategoriaModel? = null
)