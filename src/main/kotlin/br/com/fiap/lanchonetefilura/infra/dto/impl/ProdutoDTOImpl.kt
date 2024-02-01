package br.com.fiap.lanchonetefilura.infra.dto.impl

import br.com.fiap.lanchonetefilura.domain.dto.ProdutoDomainDTO
import br.com.fiap.lanchonetefilura.domain.dto.impl.PedidoDTO
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name="produto")
data class ProdutoDTOImpl (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "produto_id", columnDefinition = "UUID")
    override var id: UUID? = UUID.randomUUID(),

    @Column(nullable = false)
    override var nome: String? = null,

    @Column(nullable = false)
    override var descricao: String? = null,

    @Column(nullable = false)
    override var preco: Double? = null,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id")
    override var categoria: CategoriaDTOImpl? = null,

    @ManyToMany(mappedBy = "produtos")
    @JsonIgnore
    override val pedidos: List<PedidoDTO>? = null
) : ProdutoDomainDTO