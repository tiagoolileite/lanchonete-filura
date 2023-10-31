package br.com.fiap.lanchonetefilura.core.domain.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
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
    var categoria: CategoriaModel? = null,

    @ManyToMany(mappedBy = "produtos")
    @JsonIgnore
    val pedidos: List<PedidoModel>? = null
)