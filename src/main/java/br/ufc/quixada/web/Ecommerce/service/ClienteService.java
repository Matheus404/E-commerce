package br.ufc.quixada.web.Ecommerce.service;

import java.util.List;

import br.ufc.quixada.web.Ecommerce.model.Cliente;

public interface ClienteService {
	
	public void salvarEditarCliente(Cliente cliente);
	public void deletarCliente(Long id);
	public List<Cliente> listarClientes();
	public Cliente buscarPorId(Long id);
}
