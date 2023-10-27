package br.com.fiap.lanchonetefilura.core.domain.model

import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Column
import jakarta.persistence.GenerationType
import java.util.UUID

@Entity
@Table(name="categoria")
data class CategoriaModel(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "categoria_id")
    val id: UUID? = null,
    @Column(unique = true)
    val descricao: String? = null,
)