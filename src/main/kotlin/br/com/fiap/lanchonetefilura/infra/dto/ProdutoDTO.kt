package br.com.fiap.lanchonetefilura.infra.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name="produto")
data class ProdutoDTO (

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "produto_id", columnDefinition = "UUID")
    var id: UUID? = UUID.randomUUID(),

    @Column(nullable = false)
    var nome: String? = null,

    @Column(nullable = false)
    var descricao: String? = null,

    @Column(nullable = false)
    var preco: Double? = null,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id")
    var categoria: CategoriaDTO? = null,

    @ManyToMany(mappedBy = "produtos")
    @JsonIgnore
    val pedidos: List<PedidoDTO>? = null
)
