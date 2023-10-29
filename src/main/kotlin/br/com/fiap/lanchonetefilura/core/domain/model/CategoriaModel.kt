package br.com.fiap.lanchonetefilura.core.domain.model

import br.com.fiap.lanchonetefilura.core.domain.dto.CategoriaDTO
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
    override val id: UUID? = UUID.randomUUID(),

    @Column(unique = true, nullable = false)
    override val descricao: String? = null

) : CategoriaDTO