package br.com.fiap.lanchonetefilura.core.domain.model

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name="CLIENTE")
data class ClienteModel(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID = UUID.randomUUID(),
    val cpf: String? = null,
    val nome: String? = null,
    val email: String? = null
)