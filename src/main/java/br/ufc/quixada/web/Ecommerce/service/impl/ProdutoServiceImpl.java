package br.ufc.quixada.web.Ecommerce.service.impl;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.ufc.quixada.web.Ecommerce.model.Produto;
import br.ufc.quixada.web.Ecommerce.repository.ProdutoRepository;
import br.ufc.quixada.web.Ecommerce.service.ProdutoService;

@Named
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override
	public void salvarEditarProduto(Produto produto) {
		produtoRepository.save(produto);
	}

	@Override
	public List<Produto> listarProdutos() {
		return produtoRepository.findAll();
	}

	@Override
	public Produto buscarProduto(Long idProduto) {
		 return produtoRepository.getOne(idProduto);
	}

	@Override
	public void removerProduto(Long idProduto) {
		produtoRepository.deleteById(idProduto);
	}

	@Override
	public Produto buscarProdutoPorCodigo(int codigo) {
		return produtoRepository.findProdutoByCodigo(codigo);
	}

}
