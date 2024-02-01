package br.com.fiap.lanchonetefilura.shared.helper

import br.com.fiap.lanchonetefilura.LanchonetefiluraApplication
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object LoggerHelper {
    val logger: Logger = LoggerFactory.getLogger(LanchonetefiluraApplication::class.java)

    const val LOG_TAG_APP = "[FILURA]"
    const val LOG_TAG_ERROR = "[ERROR]"
}