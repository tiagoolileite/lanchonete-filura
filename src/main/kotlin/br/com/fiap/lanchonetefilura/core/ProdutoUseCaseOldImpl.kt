package br.com.fiap.lanchonetefilura.core

/*
@Component
class ProdutoUseCaseOldImpl (
    private val produtoRepository: ProdutoRepository,
    private val categoriaRepository: CategoriaRepository
) : ProdutoUseCaseOld {

    override fun getProdutos(): List<ProdutoModel>? {

        return  produtoRepository.getProdutos()
    }

    override fun getProdutosByCategoria(categoriaId: UUID): List<ProdutoModel>? {

        return produtoRepository.getProdutosByCategoria(categoriaId = categoriaId)
    }

    */
/*override fun saveProduto(produtoRequest: ProdutoRequest): ProdutoModel? {

        val categoriaModel = produtoRequest.categoriaId.let { categoriaRepository.getCategoriaById(it) }

        categoriaModel?.let {} ?: throw CategoriaInvalidaException()

        val produto = produtoRequest.converterProdutoRequestToProdutoModel(categoriaModel = categoriaModel)

        val produtoModel = produto.editCategoriaModel(categoriaModel)

        return produtoRepository.saveProduto(produtoModel = produtoModel)
    }*//*


    */
/*override fun updateProduto(produtoRequest: ProdutoRequest, produtoId: UUID): ProdutoModel? {

        val produto = produtoRepository.getProdutoById(produtoId)

        produto?.let {} ?: throw ProdutoNaoEncontradoException()

        val categoriaModel = produtoRequest.categoriaId.let { categoriaRepository.getCategoriaById(it) }

        categoriaModel?.let {} ?: throw CategoriaInvalidaException()

        val produtoModel = produto.editCategoriaModel(categoriaModel)

        return produtoRepository.updateProduto(produtoModel = produtoModel)
    }*//*


    override fun deleteProduto(id: UUID) {
        val produto = produtoRepository.getProdutoById(id)

        produto?.let {} ?: throw ProdutoNaoEncontradoException()

        try {
            produtoRepository.deleteProduto(id = id)
        } catch (ex: Exception) { throw ProdutoNaoDeletadoException() }
    }

}*/
