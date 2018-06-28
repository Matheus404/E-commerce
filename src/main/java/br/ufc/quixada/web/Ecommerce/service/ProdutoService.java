package br.ufc.quixada.web.Ecommerce.service;

import java.util.List;

import br.ufc.quixada.web.Ecommerce.model.Produto;


public interface ProdutoService {
	
	void salvarEditarProduto(Produto produto);
	List<Produto> listarProdutos();
	Produto buscarProduto(Long idProduto);
	void removerProduto(Long idProduto);
	Produto buscarProdutoPorCodigo(int codigo);
	

}
