package br.ufc.quixada.web.Ecommerce.service.impl;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.ufc.quixada.web.Ecommerce.model.Cliente;
import br.ufc.quixada.web.Ecommerce.repository.ClienteRepository;
import br.ufc.quixada.web.Ecommerce.service.ClienteService;

@Named 
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public void salvarEditarCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	@Override
	public List<Cliente> listarClientes(){
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		return clienteRepository.getOne(id);
	}

	@Override
	public void deletarCliente(Long id) {
		clienteRepository.deleteById(id);
	}
}
