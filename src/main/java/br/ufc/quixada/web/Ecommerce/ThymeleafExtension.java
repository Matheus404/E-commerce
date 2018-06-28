package br.ufc.quixada.web.Ecommerce;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.FileTemplateResolver;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
public class ThymeleafExtension {

	@Autowired
	private SpringTemplateEngine templateEngine;

	@PostConstruct
	public void extension(){
		//Esse resolver é que impede a chamada aos controllers não ficar em loop, não edite se não tiver certeza do que esta fazendo.
		FileTemplateResolver resolver = new FileTemplateResolver();
		resolver.setPrefix("src/main/resources/templates/");
		resolver.setSuffix(".html");
		resolver.setTemplateMode("HTML5");
		resolver.setOrder(templateEngine.getTemplateResolvers().size());
		resolver.setCacheable(false);
		templateEngine.addTemplateResolver(resolver);
		 
		templateEngine.addDialect(new LayoutDialect());

		
	}
		
}