package br.com.fiap.lanchonetefilura.core.domain.model

import br.com.fiap.lanchonetefilura.core.domain.dto.ClienteDTO
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Column
import jakarta.persistence.GenerationType
import java.util.UUID

@Entity
@Table(name = "cliente")
data class ClienteModel(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "cliente_id")
    override val id: UUID = UUID.randomUUID(),

    @Column(nullable = false, unique = true)
    override val cpf: String? = null,

    @Column(nullable = false)
    override val nome: String? = null,

    @Column(nullable = false)
    override val email: String? = null

) : ClienteDTO