package br.com.fiap.lanchonetefilura.core.domain.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name="categoria_old")
data class CategoriaModel(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "categoria_id")
    val id: UUID = UUID.randomUUID(),

    @Column(unique = true, nullable = false)
    val descricao: String? = null

)