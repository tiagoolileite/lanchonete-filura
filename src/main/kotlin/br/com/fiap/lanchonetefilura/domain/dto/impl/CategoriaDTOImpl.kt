package br.com.fiap.lanchonetefilura.domain.dto.impl

import br.com.fiap.lanchonetefilura.domain.dto.CategoriaDTO
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name="categoria")
data class CategoriaDTOImpl(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "categoria_id", columnDefinition = "UUID")
    override var id: UUID = UUID.randomUUID(),

    @Column(unique = true, nullable = false)
    override val descricao: String? = null
) : CategoriaDTO