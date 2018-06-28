package br.ufc.quixada.web.Ecommerce.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginLogoutController {
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	private String logout(HttpSession session){
		session.invalidate();
		return "redirect:/login";
	}
	
	@RequestMapping(value={"/", "/login", ""},method=RequestMethod.GET)
	private ModelAndView login(@RequestParam(value = "error", required = false) String error,
								@RequestParam(value = "logout", required = false) String logout, HttpSession http){
			ModelAndView model = new ModelAndView();
			if (error != null) {
				model.addObject("error", "Usuário e/ou senha inválidos!");
			}
			if (logout != null) {
				model.addObject("msg", "Logout efetuado com sucesso.");
			}
			model.setViewName("login");
			return model;
	}
}
