package br.ufc.quixada.web.Ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.ufc.quixada.web.Ecommerce.service.impl.ClienteServiceImpl;

@Controller
@RequestMapping("Cliente")
public class ClienteController {
	
	private static final String PAG_CADASTRAR_CLIENTE =  "Cliente/cadastrarcliente";
	private static final String PAG_LISTA_CLIENTES = "Cliente/clientes";
	private static final String PAG_REDIRECT_CADASTRAR_CLIENTE = "redirect:/Cliente/clientes";
	
	@Autowired
	private ClienteServiceImpl clienteService;
	
	@RequestMapping(value="/", method= RequestMethod.GET)
	public String inicio(Model model){
		model.addAttribute("clientes", clienteService.listarClientes());
		
		return PAG_LISTA_CLIENTES;
	}
}
