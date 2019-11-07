package br.ufc.qxd.persistencia.trabalho_02_jpa.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Projetos{

	@Id  
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="projeto_id")
	private int idPro;
	private String nome;
	private int tempoDesenvolvimento;

	@OneToMany(mappedBy="projeto", cascade = CascadeType.ALL)
	private List<PesquisadorProjeto> pesquisador;
	@ManyToOne
	@JoinColumn(name="departamento_id")
	private Departamento departamento;
	public Projetos() {

	}
	
	public Projetos( List<PesquisadorProjeto> pesquisador) {
		this.pesquisador = pesquisador;
	}
	
	public Projetos(int idPro) {
		this.idPro = idPro;
	}

	public Projetos(int idPro, String nome, int tempoDesenvolvimento) {
		this.idPro = idPro;
		this.nome = nome;
		this.tempoDesenvolvimento = tempoDesenvolvimento;

	}
	
	public Projetos(String nome, int tempoDesenvolvimento) {
		this.nome = nome;
		this.tempoDesenvolvimento = tempoDesenvolvimento;

	}
	
	public Projetos(String nome, int tempoDesenvolvimento, Departamento departamento) {
		this.nome = nome;
		this.tempoDesenvolvimento = tempoDesenvolvimento;
		this.departamento = departamento;
	}
	
	public Projetos(String nome, int tempoDesenvolvimento, Departamento departamento, List<PesquisadorProjeto> pesquisador) {
		this.nome = nome;
		this.tempoDesenvolvimento = tempoDesenvolvimento;
		this.departamento = departamento;
		this.pesquisador = pesquisador;

	}

	public int getIdPro() {
		return idPro;
	}

	public void setIdPro(int idPro) {
		this.idPro = idPro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTempoDesenvolvimento() {
		return tempoDesenvolvimento;
	}

	public void setTempoDesenvolvimento(int tempoDesenvolvimento) {
		this.tempoDesenvolvimento = tempoDesenvolvimento;
	}

	public List<PesquisadorProjeto> getPesquisador() {
		return pesquisador;
	}

	public void setPesquisador(List<PesquisadorProjeto> pesquisador) {
		this.pesquisador = pesquisador;
	}

	@Override
	public String toString() {
		return "Projetos [idPro=" + idPro + ", nome=" + nome + ", tempoDesenvolvimento=" + tempoDesenvolvimento + "]";
	}

	





}
