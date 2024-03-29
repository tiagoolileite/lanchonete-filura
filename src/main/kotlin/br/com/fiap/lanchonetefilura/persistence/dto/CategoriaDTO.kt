package br.com.fiap.lanchonetefilura.persistence.dto

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name="categoria")
data class CategoriaDTO(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "categoria_id", columnDefinition = "UUID")
    var id: UUID = UUID.randomUUID(),

    @Column(unique = true, nullable = false)
    val descricao: String? = null
)