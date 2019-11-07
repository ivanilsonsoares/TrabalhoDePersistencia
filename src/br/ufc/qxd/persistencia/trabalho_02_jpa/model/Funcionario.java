package br.ufc.qxd.persistencia.trabalho_02_jpa.model;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
	@NamedQuery(name="Funcionario.findAll", query="from Funcionario")
})
public class Funcionario{


	@Id  
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="funcionario_id")
	private int id;
	
	private String nome;
	private String sexo;
	private String dataAniversario;
	private float salario;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "funcionario",cascade = CascadeType.ALL)
	private Endereco endereco;
	
	@ManyToOne
	@JoinColumn(name="departamento_id")
	private Departamento numeroDepartamento;
	
	@OneToMany(mappedBy="funcionario", cascade = CascadeType.ALL)
	private List<Dependentes> dependentes;

	public Funcionario() {

	}

	public Funcionario(int id) {
		this.id = id;
		
	}

	public Funcionario(int id, String nome, String sexo, String dataAniversario, float salario,
			Endereco endereco, Departamento numeroDepartamento, List<Dependentes> dependentes) {
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.dataAniversario = dataAniversario;
		this.salario = salario;
		this.endereco = endereco;
		this.numeroDepartamento = numeroDepartamento;
		this.dependentes = dependentes;
	}

	public Funcionario(int id, String nome, String sexo, String dataAniversario, float salario, Endereco endereco) {
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.dataAniversario = dataAniversario;
		this.salario = salario;
		this.endereco = endereco;
	}

	public Funcionario(String nome, String sexo, String dataAniversario, float salario, Endereco endereco,
			Departamento numeroDepartamento) {
		this.nome = nome;
		this.sexo = sexo;
		this.dataAniversario = dataAniversario;
		this.salario = salario;
		this.endereco = endereco;
		this.numeroDepartamento = numeroDepartamento;
	}
	
	public Funcionario(String nome, String sexo, String dataAniversario, float salario,
			Departamento numeroDepartamento) {
		this.nome = nome;
		this.sexo = sexo;
		this.dataAniversario = dataAniversario;
		this.salario = salario;
		this.numeroDepartamento = numeroDepartamento;
	}
	
	public Funcionario(String nome, String sexo, String dataAniversario, float salario) {
		this.nome = nome;
		this.sexo = sexo;
		this.dataAniversario = dataAniversario;
		this.salario = salario;
	}

	public Funcionario(String nome, String sexo, String dataAniversario, float salario, Endereco endereco) {
		this.nome = nome;
		this.sexo = sexo;
		this.dataAniversario = dataAniversario;
		this.salario = salario;
		this.endereco = endereco;
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(String dataAniversario) {
		this.dataAniversario = dataAniversario;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public Endereco getEnderecos() {
		return endereco;
	}

	public void setEnderecos(Endereco endereco) {
		this.endereco = endereco;
	}

	public Departamento getNumeroDepartamento() {
		return numeroDepartamento;
	}

	public void setNumeroDepartamento(Departamento numeroDepartamento) {
		this.numeroDepartamento = numeroDepartamento;
	}

	public List<Dependentes> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<Dependentes> dependentes) {
		this.dependentes = dependentes;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + this.id + ", nome=" + this.nome + ", sexo=" + this.sexo + ", dataAniversario=" + this.dataAniversario
				+ ", salario=" + this.salario + "]";
	}

	
	

	
	
	
	
}
