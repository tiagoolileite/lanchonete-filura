package br.com.fiap.lanchonetefilura.domain.dto.impl

import br.com.fiap.lanchonetefilura.domain.dto.ClienteDomainDTO
import java.util.*

class ClienteDomainDTOImpl (
    override var id : UUID = UUID.randomUUID(),
    override val cpf : String?,
    override val nome : String?,
    override val email : String?
) : ClienteDomainDTO