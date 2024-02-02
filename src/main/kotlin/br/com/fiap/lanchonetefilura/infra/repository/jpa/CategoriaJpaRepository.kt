package br.com.fiap.lanchonetefilura.infra.repository.jpa

import br.com.fiap.lanchonetefilura.infra.dto.CategoriaDTOImpl
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CategoriaJpaRepository : JpaRepository<CategoriaDTOImpl, UUID>
