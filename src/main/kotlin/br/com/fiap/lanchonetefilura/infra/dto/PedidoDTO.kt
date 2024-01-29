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

    @Column(name = "senha", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val senha: Int = 1, //Código da ordem do pedido, será controlado por SEQUENCE no BD

    @Column(name = "etapa", nullable = false)
    val etapa: String = "Pendente pagamento",

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = true)
    val cliente: ClienteDTO? = null,

    @ManyToMany
    @JoinTable(
        name = "pedidos_produtos",
        joinColumns = arrayOf(JoinColumn(name = "pedido_id")),
        inverseJoinColumns = arrayOf(JoinColumn(name = "produto_id"))
    )
    val produtos: List<ProdutoDTO> = arrayListOf(),

    @Column(name = "pago", nullable = false)
    var pago: Boolean = false
)
