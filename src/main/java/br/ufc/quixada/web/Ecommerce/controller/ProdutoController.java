package br.ufc.quixada.web.Ecommerce.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufc.quixada.web.Ecommerce.model.Produto;
import br.ufc.quixada.web.Ecommerce.service.ProdutoService;


@Controller
@RequestMapping("Produto")
public class ProdutoController {
	
	public static String PAG_INICIO_PRODUTO = "Produto/index";
	public static String REDIRECT_PAG_INICIO_PRODUTO = "redirect:/Produto/";
	public static String PAG_EDITAR_PRODUTO = "Produto/editar";
	
	@Autowired
	private ProdutoService produtoService;
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String inicio(Model model){
		
		model.addAttribute("produtos", produtoService.listarProdutos());
		
		return PAG_INICIO_PRODUTO;
	}
	
	@RequestMapping(value="/Cadastrar", method=RequestMethod.POST)
	public String cadastrarProduto(Model model, @Valid @ModelAttribute("produto") Produto produto, RedirectAttributes redirect){
				
		if(produto != null){
			
			try{
				Produto p = produtoService.buscarProdutoPorCodigo(produto.getCodigo());
				if(p != null){
					redirect.addFlashAttribute("error", "Código do produto já cadastrado");
					return REDIRECT_PAG_INICIO_PRODUTO;
				}
				redirect.addFlashAttribute("sucesso", "Produto cadastrado com sucesso");
				produtoService.salvarEditarProduto(produto);
				
			}catch(Exception e){
				redirect.addFlashAttribute("error", "Código do produto não deve ser vazio");
				return REDIRECT_PAG_INICIO_PRODUTO;
			}
			
			
		}else{
			redirect.addFlashAttribute("error", "Produto inválido");
			return REDIRECT_PAG_INICIO_PRODUTO;
		}
		
		return REDIRECT_PAG_INICIO_PRODUTO;
		
	}
	@RequestMapping(value="/Editar", method=RequestMethod.POST)
	public String editarProduto(Model model, @Valid @ModelAttribute("produto") Produto produto, RedirectAttributes redirect){
		
		if(produto != null){
			
			try{
				Produto p = produtoService.buscarProduto(produto.getId());
				if(p == null){
					redirect.addFlashAttribute("error", "Produto inexistente");
					return REDIRECT_PAG_INICIO_PRODUTO;
				}else{
					//como o código não pode se repetir, é checado se o cliente faz alteração
					//no código do produto a ser editado
					if(p.getCodigo() == produto.getCodigo()){
						redirect.addFlashAttribute("sucesso", "Produto cadastrado com sucesso");
						produtoService.salvarEditarProduto(produto);
					}else{
						Produto ptest = produtoService.buscarProdutoPorCodigo(produto.getCodigo());
						if(ptest == null){
							redirect.addFlashAttribute("sucesso", "Produto cadastrado com sucesso");
							produtoService.salvarEditarProduto(produto);
						}else{
							redirect.addFlashAttribute("error", "Código do produto já cadastrado, tente um código que não esteja no sistema.");
							return REDIRECT_PAG_INICIO_PRODUTO;
						}
					}					
				}
				
				
			}catch(Exception e){
				redirect.addFlashAttribute("error", "Código do produto não deve ser vazio");
				return REDIRECT_PAG_INICIO_PRODUTO;
			}
			
			
		}else{
			redirect.addFlashAttribute("error", "Produto inválido");
			return REDIRECT_PAG_INICIO_PRODUTO;
		}			
			
		
		return REDIRECT_PAG_INICIO_PRODUTO;
		
	}
	@RequestMapping(value="/Editar/{idProduto}", method=RequestMethod.GET)
	public String editarGet(Model model, @PathVariable("idProduto") Long idProduto, RedirectAttributes redirect){
		
		try{
			Produto p = produtoService.buscarProduto(idProduto);
			model.addAttribute("produto", p);
			return PAG_EDITAR_PRODUTO;
		}catch(Exception e){
			redirect.addFlashAttribute("error", "Produto inválido");
			return REDIRECT_PAG_INICIO_PRODUTO;
		}
	}
	
	@RequestMapping(value="/Deletar/{idProduto}", method=RequestMethod.GET)
	public String deletarGet(Model model, @PathVariable("idProduto") Long idProduto, RedirectAttributes redirect) {
		try {
			produtoService.removerProduto(idProduto);
			return REDIRECT_PAG_INICIO_PRODUTO;
		} catch (Exception e) {
			redirect.addFlashAttribute("error", "Erro ao deletar produto");
			return REDIRECT_PAG_INICIO_PRODUTO;
		}
	}

}
