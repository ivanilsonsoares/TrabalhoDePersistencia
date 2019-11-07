package br.ufc.qxd.persistencia.trabalho_02_jpa.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Pesquisador extends Funcionario {

	private String areaDeAtuacao;
	
	@OneToMany(mappedBy="pesquisador", cascade = CascadeType.ALL)
	private List<PesquisadorProjeto> projetos;

	public Pesquisador() {

	}
	
	public Pesquisador(String nome, String sexo, String dataAniversario, float salario, Endereco endereco, String areaDeAtuacao) {
		super( nome, sexo, dataAniversario, salario,endereco);
		this.areaDeAtuacao = areaDeAtuacao;
	}
	
	public Pesquisador(String areaDeAtuacao, List<PesquisadorProjeto> projetos) {
		super();
		this.areaDeAtuacao = areaDeAtuacao;
		this.projetos = projetos;
	}
	
	public Pesquisador(String areaDeAtuacao, String horasTrabalhadas) {
		super();
		this.areaDeAtuacao = areaDeAtuacao;
	}
	
	public Pesquisador(String areaDeAtuacao) {
		super();
		this.areaDeAtuacao = areaDeAtuacao;

	}

	public Pesquisador(int id, String nome, String sexo, String dataAniversario, float salario, Endereco endereco,
			Departamento numeroDepartamento, List<Dependentes> dependentes) {
		super(id, nome, sexo, dataAniversario, salario, endereco, numeroDepartamento, dependentes);
		// TODO Auto-generated constructor stub
	}
	
	public Pesquisador(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public Pesquisador(int id, String nome, String sexo, String dataAniversario, float salario, Endereco endereco) {
		super(id, nome, sexo, dataAniversario, salario, endereco);
		// TODO Auto-generated constructor stub
	}

	public Pesquisador(String nome, String sexo, String dataAniversario, float salario, Endereco endereco,
			Departamento numeroDepartamento) {
		super(nome, sexo, dataAniversario, salario, endereco, numeroDepartamento);
		// TODO Auto-generated constructor stub
	}

	public Pesquisador(String nome, String sexo, String dataAniversario, float salario, Endereco endereco) {
		super(nome, sexo, dataAniversario, salario, endereco);
		// TODO Auto-generated constructor stub
	}

	public Pesquisador(String nome, String sexo, String dataAniversario, float salario) {
		super(nome, sexo, dataAniversario, salario);
		// TODO Auto-generated constructor stub
	}

	public String getAreaDeAtuacao() {
		return areaDeAtuacao;
	}

	public void setAreaDeAtuacao(String areaDeAtuacao) {
		this.areaDeAtuacao = areaDeAtuacao;
	}


	public List<PesquisadorProjeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<PesquisadorProjeto> projetos) {
		this.projetos = projetos;
	}

	@Override
	public String toString() {
		return super.toString()+"Pesquisador [areaDeAtuacao=" + this.areaDeAtuacao;
	}


	
	
	

	










}
