package br.com.fiap.lanchonetefilura.infra.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "pedido")
@JsonIgnoreProperties
data class PedidoDTO (

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "pedido_id", columnDefinition = "UUID")
    val id: UUID = UUID.randomUUID(),

    @Column(name = "senha", nullable = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var senha: Int? = null,

    @Column(name = "etapa", nullable = false)
    val etapa: String = "pendente pagamento",

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = true)
    val cliente: ClienteDTO? = null,

    @ManyToMany
    @JoinTable(
        name = "pedidos_produtos",
        joinColumns = [JoinColumn(name = "pedido_id")],
        inverseJoinColumns = [JoinColumn(name = "produto_id")]
    )
    val produtos: List<ProdutoDTO> = arrayListOf(),

    @Column(name = "preco", nullable = false)
    var preco: Double = 0.0,

    @Column(name = "pago", nullable = false)
    var pago: Boolean = false
)
