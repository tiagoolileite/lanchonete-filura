package br.com.fiap.lanchonetefilura.core.domain.model

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "pedido")
data class PedidoModel (

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "pedido_id")
    val id: UUID = UUID.randomUUID(),

    @Column(name = "senha", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val senha: Int = 1, //Código da ordem do pedido, será controlado por SEQUENCE no BD

    @Column(name = "etapa", nullable = false)
    val etapa: String = "Pendente pagamento",

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = true)
    val cliente: ClienteModel? = null,

    @OneToMany //Converter para Many to Many
    val produtos: List<ProdutoModel> = arrayListOf(),

    @Column(name = "pago", nullable = false)
    var pago: Boolean = false
)