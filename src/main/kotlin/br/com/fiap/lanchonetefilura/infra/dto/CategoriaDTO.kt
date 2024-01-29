package br.com.fiap.lanchonetefilura.infra.dto

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name="categoria")
data class CategoriaDTO(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "categoria_id", columnDefinition = "UUID")
    val id: UUID = UUID.randomUUID(),

    @Column(unique = true, nullable = false)
    val descricao: String? = null

)