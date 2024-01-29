package br.com.fiap.lanchonetefilura.core

/*
@Component
class ClienteUseCaseImpl (private val repository: ClienteRepository) : ClienteUseCase {
    override fun getClientes(): List<ClienteModel>? {

        return repository.getClientes()
    }

    override fun getClienteByCpf(cpf: String): ClienteModel? {

        val cliente: ClienteModel? = repository.getClienteByCpf(cpf = cpf)

        cliente?.let {} ?: throw ClienteNaoEncontradoException()

        return cliente
    }

    override fun saveCliente(clienteRequest: ClienteRequest): ClienteModel? {

        val clienteByCpf: ClienteModel? = repository.getClienteByCpf(cpf = clienteRequest.cpf)

        clienteByCpf?.let {
            logger.error("Cliente já estava cadastrado na base")
            throw ClienteJaExisteException(it)
        }

        return repository.saveCliente(clienteRequest)
    }
}*/
