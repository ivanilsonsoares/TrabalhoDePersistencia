package br.ufc.qxd.persistencia.trabalho_02_jpa.model;

import java.util.List;

import javax.persistence.Entity;


@Entity
public class Secretario extends Funcionario{

	private String grauDeEscolaridade;

	public Secretario() {

	}
	
	

	public Secretario(String grauDeEscolaridade, Funcionario funcionario) {
		super();
		this.grauDeEscolaridade = grauDeEscolaridade;
	}

	

	public Secretario(int id, String nome, String sexo, String dataAniversario, float salario, Endereco endereco,
			Departamento numeroDepartamento, List<Dependentes> dependentes, String grauDeEscolaridade) {
		super(id, nome, sexo, dataAniversario, salario, endereco, numeroDepartamento, dependentes);
		this.grauDeEscolaridade = grauDeEscolaridade;
	}

	public Secretario(int id, String nome, String sexo, String dataAniversario, float salario, Endereco endereco,
			String grauDeEscolaridade) {
		super(id, nome, sexo, dataAniversario, salario, endereco);
		this.grauDeEscolaridade = grauDeEscolaridade;
	}
	
	public Secretario( String nome, String sexo, String dataAniversario, float salario, Endereco endereco,
			String grauDeEscolaridade) {
		super(nome, sexo, dataAniversario, salario, endereco);
		this.grauDeEscolaridade = grauDeEscolaridade;
	}

	public String getGrauDeEscolaridade() {
		return grauDeEscolaridade;
	}

	public void setGrauDeEscolaridade(String grauDeEscolaridade) {
		this.grauDeEscolaridade = grauDeEscolaridade;
	}



	@Override
	public String toString() {
		return "Secretario [grauDeEscolaridade=" + this.grauDeEscolaridade + "]";
	}



	


	

	
	
	

	






}
