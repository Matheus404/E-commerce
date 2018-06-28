package br.ufc.quixada.web.Ecommerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufc.quixada.web.Ecommerce.model.Cliente;
import br.ufc.quixada.web.Ecommerce.service.impl.ClienteServiceImpl;

@Controller
@RequestMapping("Admin")
public class AdminController {
	
	private static final String PAG_INICIO =  "Admin/index";
	private static final String REDIRECT_PAG_INICIO =  "redirect:/Admin/";
	
	private static final String PAG_CADASTRAR_CLIENTE =  "Admin/cadastrarcliente";
	private static final String PAG_LISTA_CLIENTES = "Admin/clientes";
	private static final String PAG_REDIRECT_CADASTRAR_CLIENTE = "redirect:/Admin/Clientes";
	
	@Autowired
	private ClienteServiceImpl clienteService;

	
	@RequestMapping(value="/", method= RequestMethod.GET)
	public String inicio(){
		return PAG_INICIO;
		
	}
	
	@RequestMapping(value="/Cliente/Cadastrar", method= RequestMethod.GET)
	public String adicionarClienteGet(Model model){
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		return PAG_CADASTRAR_CLIENTE;
	}
	
	@RequestMapping(value="/Cliente/Cadastrar", method= RequestMethod.POST)
	public String adicionarClientePost(Model model, @Valid @ModelAttribute("cliente") Cliente cliente , BindingResult result, RedirectAttributes redirect ){

		if (result.hasErrors()) {
			redirect.addFlashAttribute("error", "Cliente Inválido.");
		}
		else{
			clienteService.salvarEditarCliente(cliente);
			redirect.addFlashAttribute("sucesso", "Cliente cadastrado com sucesso.");
		}
		return PAG_REDIRECT_CADASTRAR_CLIENTE;
	}
	
	@RequestMapping(value="/Clientes", method= RequestMethod.GET)
	public String clientes(Model model){
		List<Cliente> clientes = clienteService.listarClientes();
		model.addAttribute("clientes", clientes);
		return PAG_LISTA_CLIENTES;
	}

	@RequestMapping(value = "/Cliente/Excluir/{idCliente}", method = RequestMethod.GET)
	public @ResponseBody boolean excluirCliente(Model model, @PathVariable("idCliente") Long idCliente) {
		try{
			
			
			
			//produtoQntService.deletarProduttoQntdPorIdCliente(idCliente);
			clienteService.deletarCliente(idCliente);

			
		
		}catch(Exception e){
			return false;
		}
		
		return true;
	}

	@RequestMapping(value="/Cliente/{idCliente}")
	private String visulizarAlterarCliente(Model model, @PathVariable("idCliente")Long idCliente){
		Cliente cliente = clienteService.buscarPorId(idCliente);
		
		model.addAttribute("cliente", cliente);
		return PAG_CADASTRAR_CLIENTE;
	}
	
}
