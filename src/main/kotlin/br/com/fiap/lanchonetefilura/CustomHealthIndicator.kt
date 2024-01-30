package br.com.fiap.lanchonetefilura

import br.com.fiap.lanchonetefilura.shared.helper.LoggerHelper
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.actuate.health.AbstractHealthIndicator
import org.springframework.boot.actuate.health.Health
import org.springframework.stereotype.Component
import java.sql.DriverManager

@Component
class CustomHealthIndicator (
    @Value("\${spring.datasource.url}") private val databaseUrl: String,
    @Value("\${spring.datasource.username}") private val databaseUser: String,
    @Value("\${spring.datasource.password}") private val databasePassword: String
): AbstractHealthIndicator() {

    override fun doHealthCheck(builder: Health.Builder) {
        try {
            LoggerHelper.logger.info("Conectando com o BD")
            DriverManager.getConnection(databaseUrl, databaseUser, databasePassword).use { connection ->
                LoggerHelper.logger.info(connection.toString())
                builder.up().withDetail("message", "Banco de dados está ativo")
            }
        } catch (ex: Exception) {
            LoggerHelper.logger.info("Falha ao conectar no BD: ${ex.message}")
            builder.down().withDetail("message", "Falha ao conectar no Banco de Dados: ${ex.message}")
        }
    }
}