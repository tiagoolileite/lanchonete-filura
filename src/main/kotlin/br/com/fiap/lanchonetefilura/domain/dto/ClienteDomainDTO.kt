package br.com.fiap.lanchonetefilura.domain.dto

import java.util.*

interface ClienteDomainDTO {

    var id : UUID

    val cpf : String?

    val nome : String?

    val email : String?

}
