package br.com.fiap.lanchonetefilura.infra.dto.impl

import br.com.fiap.lanchonetefilura.infra.dto.PedidoDTO
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "pedido")
@JsonIgnoreProperties
data class PedidoDTOImpl (

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "pedido_id", columnDefinition = "UUID")
    override val id: UUID = UUID.randomUUID(),

    @Column(name = "senha", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    override val senha: Int = 1,

    @Column(name = "etapa", nullable = false)
    override val etapa: String = "pendente pagamento",

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = true)
    override val cliente: ClienteDTOImpl? = null,

    @ManyToMany
    @JoinTable(
        name = "pedidos_produtos",
        joinColumns = [JoinColumn(name = "pedido_id")],
        inverseJoinColumns = [JoinColumn(name = "produto_id")]
    )
    override val produtos: List<ProdutoDTOImpl> = arrayListOf(),

    @Column(name = "preco", nullable = false)
    override var preco: Double = 0.0,

    @Column(name = "pago", nullable = false)
    override var pago: Boolean = false
) : PedidoDTO
