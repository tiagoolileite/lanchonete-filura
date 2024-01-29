package br.com.fiap.lanchonetefilura.infra.dto

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "cliente")
data class ClienteDTO(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "cliente_id", columnDefinition = "UUID")
    val id: UUID = UUID.randomUUID(),

    @Column(unique = true)
    val cpf: String? = null,

    @Column(nullable = false)
    val nome: String? = null,

    @Column(nullable = false)
    val email: String? = null

)
