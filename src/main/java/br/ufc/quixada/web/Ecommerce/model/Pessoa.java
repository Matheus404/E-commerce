package br.ufc.quixada.web.Ecommerce.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String cpf;
	private String email; 
	private String telefone;
	private String login;
	private String senha;
	
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
		
	@ManyToMany
	@JoinTable(name = "papel_pessoa", joinColumns = @JoinColumn(name = "pessoa_id"), inverseJoinColumns = @JoinColumn(name = "papel_id"))
	private List<Papel> papeis;
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Sexo getSexo() {
		return sexo;
	}



	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}



	public List<Papel> getPapeis() {
		return papeis;
	}



	public void setPapeis(List<Papel> papeis) {
		this.papeis = papeis;
	}
	



	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}




	public enum Sexo {
		MASCULINO("Masculino"),
		FEMENINO("Femenino");	
		
		private String descricao;
		
		private Sexo(String descricaoItem) {
			setDescricaoItem(descricaoItem);
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricaoItem(String descricaoItem) {
			this.descricao = descricaoItem;
		}
		
	}




	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
}