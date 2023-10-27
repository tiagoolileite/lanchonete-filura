package br.com.fiap.lanchonetefilura.core.domain.model

import jakarta.persistence.*

@Entity
@Table(name="categoria")
data class CategoriaModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_id")
    val id: Int? = null,
    @Column(unique = true)
    val descricao: String? = null,
)