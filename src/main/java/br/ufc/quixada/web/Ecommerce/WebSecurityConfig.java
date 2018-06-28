package br.ufc.quixada.web.Ecommerce;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource datasource;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/404", "/js**", "/css**", "/images**", "/fonts**", "/login**").permitAll()
                .antMatchers("/Admin/**").hasRole("ADMIN")
                .anyRequest().permitAll()
                .and()
            .formLogin()
                .loginPage("/login").usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/Admin/",true)
                .permitAll()
                .and()
            .logout();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //auth.jdbcAuthentication().dataSource(datasource)
 //       	.usersByUsernameQuery(
   // 			"select login,senha,1 from pessoa where login=?")
    //		.authoritiesByUsernameQuery(
    	//		"select pessoa.login,papel.nome from pessoa,papel_pessoa,papel where pessoa.login=? and pessoa.id=papel_pessoa.pessoa_id and papel_pessoa.papel_id = papel.id");
           auth.inMemoryAuthentication()
           .withUser("admin").password("{noop}4567").roles("ADMIN");
    }
    
    
}

