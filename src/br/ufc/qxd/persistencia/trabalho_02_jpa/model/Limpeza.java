package br.ufc.qxd.persistencia.trabalho_02_jpa.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Limpeza.findByCargo", 
query="from Limpeza L where L.cargo = ?1")
public class Limpeza extends Funcionario {

	private String cargo;
	private int jornadaDeTrabalho;
	@ManyToOne
	@JoinColumn(name = "gerente_id")
	private Limpeza gerente;
	public Limpeza() {

	}
		
	public Limpeza(int id) {
		super(id);
	}

	public Limpeza(String nome, String sexo, String dataAniversario, float salario, Endereco endereco, String cargo, int jornadaDeTrabalho) {
		super(nome, sexo, dataAniversario, salario, endereco);
		this.cargo = cargo;
		this.jornadaDeTrabalho = jornadaDeTrabalho;
	}
	
	public Limpeza(String nome, String sexo, String dataAniversario, float salario, String cargo, int jornadaDeTrabalho) {
		super(nome, sexo, dataAniversario, salario);
		this.cargo = cargo;
		this.jornadaDeTrabalho = jornadaDeTrabalho;
	}
	
	public Limpeza(String cargo, int jornadaDeTrabalho) {
		super();
		this.cargo = cargo;
		this.jornadaDeTrabalho = jornadaDeTrabalho;
	}
	
	public Limpeza(String cargo, int jornadaDeTrabalho, Limpeza gerente) {
		super();
		this.cargo = cargo;
		this.jornadaDeTrabalho = jornadaDeTrabalho;
		this.gerente = gerente;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public int getJornadaDeTrabalho() {
		return jornadaDeTrabalho;
	}

	public void setJornadaDeTrabalho(int jornadaDeTrabalho) {
		this.jornadaDeTrabalho = jornadaDeTrabalho;
	}

	@Override
	public String toString() {
		
		return super.toString()+"Limpeza [cargo=" + this.cargo + ", jornadaDeTrabalho=" + this.jornadaDeTrabalho + ", gerente=" + this.gerente + "]";
	}

	
	
	
	
	
	
}
