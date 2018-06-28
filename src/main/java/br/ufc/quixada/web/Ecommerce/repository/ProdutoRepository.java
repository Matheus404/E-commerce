package br.ufc.quixada.web.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ufc.quixada.web.Ecommerce.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	@Query("select p from Produto p where p.codigo = :codigo")
	Produto findProdutoByCodigo(@Param("codigo")int codigo);

}
