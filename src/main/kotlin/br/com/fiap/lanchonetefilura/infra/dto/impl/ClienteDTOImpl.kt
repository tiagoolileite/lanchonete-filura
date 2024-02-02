package br.com.fiap.lanchonetefilura.infra.dto.impl

import br.com.fiap.lanchonetefilura.infra.dto.ClienteDTO
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "cliente")
data class ClienteDTOImpl(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "cliente_id", columnDefinition = "UUID")
    override val id: UUID = UUID.randomUUID(),

    @Column(unique = true)
    override val cpf: String? = null,

    @Column(nullable = false)
    override val nome: String? = null,

    @Column(nullable = false)
    override val email: String? = null
) : ClienteDTO