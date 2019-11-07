package br.ufc.qxd.persistencia.trabalho_02_jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PesquisadorProjeto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="funcionarioId")
	private Pesquisador pesquisador;
	
	@ManyToOne
	@JoinColumn(name="projetoId")
	private Projetos projeto;
	
	private int horasPorProjeto;

	
	
	
	public PesquisadorProjeto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PesquisadorProjeto(Pesquisador pesquisador, Projetos projeto, int horasPorProjeto) {
		super();
		this.pesquisador = pesquisador;
		this.projeto = projeto;
		this.horasPorProjeto = horasPorProjeto;
	}
	
	public PesquisadorProjeto(Projetos projeto, int horasPorProjeto) {
		super();
		this.projeto = projeto;
		this.horasPorProjeto = horasPorProjeto;
	}
	
	public PesquisadorProjeto(Pesquisador pesquisador) {
		super();
		this.pesquisador = pesquisador;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pesquisador getPesquisador() {
		return pesquisador;
	}

	public void setPesquisador(Pesquisador pesquisador) {
		this.pesquisador = pesquisador;
	}

	public Projetos getProjeto() {
		return projeto;
	}

	public void setProjeto(Projetos projeto) {
		this.projeto = projeto;
	}

	public int getHorasPorProjeto() {
		return horasPorProjeto;
	}

	public void setHorasPorProjeto(int horasPorProjeto) {
		this.horasPorProjeto = horasPorProjeto;
	}

	@Override
	public String toString() {
		return "PesquisadorProjeto [id=" + this.id + ", pesquisador=" + this.pesquisador + ", projeto=" + this.projeto
				+ ", horasPorProjeto=" + this.horasPorProjeto + "]";
	}

	
	

	
	
	
	
	
}