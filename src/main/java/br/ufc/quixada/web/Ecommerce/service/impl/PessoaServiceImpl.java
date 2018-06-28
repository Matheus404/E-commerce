package br.ufc.quixada.web.Ecommerce.service.impl;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.ufc.quixada.web.Ecommerce.model.Papel;
import br.ufc.quixada.web.Ecommerce.repository.PapelRepository;
import br.ufc.quixada.web.Ecommerce.service.PessoaService;

@Named 
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	private PapelRepository papelRepository;
	
	@Override
	public Papel buscarPapelPorNome(String papel) {
		return papelRepository.findByNome(papel);
	}
	
}
