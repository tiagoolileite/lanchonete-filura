package br.com.fiap.lanchonetefilura.persistence.repository.jpa

import br.com.fiap.lanchonetefilura.persistence.dto.CategoriaDTO
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CategoriaJpaRepository : JpaRepository<CategoriaDTO, UUID>
