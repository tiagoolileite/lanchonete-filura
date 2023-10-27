package br.com.fiap.lanchonetefilura.core.domain.model

import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Column
import jakarta.persistence.GenerationType
import java.util.UUID

@Entity
@Table(name="cliente")
data class ClienteModel(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "cliente_id")
    val id: UUID = UUID.randomUUID(),
    @Column(nullable = false)
    val cpf: String? = null,
    @Column(nullable = false)
    val nome: String? = null,
    @Column(nullable = false)
    val email: String? = null
)