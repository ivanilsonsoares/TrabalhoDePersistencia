package br.ufc.qxd.persistencia.trabalho_02_jpa.controle;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import br.ufc.qxd.persistencia.trabalho_02_jpa.dao.FuncionarioDAO;
import br.ufc.qxd.persistencia.trabalho_02_jpa.dao.LimpezaDAO;
import br.ufc.qxd.persistencia.trabalho_02_jpa.dao.PesquisadorDAO;
import br.ufc.qxd.persistencia.trabalho_02_jpa.dao.SecretarioDAO;
import br.ufc.qxd.persistencia.trabalho_02_jpa.jpa.dao.FuncionarioJPADAO;
import br.ufc.qxd.persistencia.trabalho_02_jpa.jpa.dao.LimpezaJPADAO;
import br.ufc.qxd.persistencia.trabalho_02_jpa.jpa.dao.PesquisadorJPADAO;
import br.ufc.qxd.persistencia.trabalho_02_jpa.jpa.dao.SecretarioJPADAO;
import br.ufc.qxd.persistencia.trabalho_02_jpa.model.Departamento;
import br.ufc.qxd.persistencia.trabalho_02_jpa.model.Endereco;
import br.ufc.qxd.persistencia.trabalho_02_jpa.model.Funcionario;
import br.ufc.qxd.persistencia.trabalho_02_jpa.model.Limpeza;
import br.ufc.qxd.persistencia.trabalho_02_jpa.model.Pesquisador;
import br.ufc.qxd.persistencia.trabalho_02_jpa.model.Secretario;



public class FuncionarioControle {

	public void adicionarPesquisador(String nomeFuncionario, String ruaFuncionario,
									int numeroCasaFuncionario, String cidadeFuncionario, String bairroFuncionario, String estadoFuncionario,
									String sexoFuncionario, String dataAniversarioFuncionario, float salarioFuncionario, 
									int idDepartamentoFuncionario, String areaAtuacaoPesquisador, 
									int idprojeto,int horasTrabalhadasPesquisador) {		
		
		Departamento D = new Departamento(idDepartamentoFuncionario);
		Funcionario c = new Funcionario(nomeFuncionario, sexoFuncionario, dataAniversarioFuncionario,salarioFuncionario,D);
		
		c.setNumeroDepartamento(D);
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		em.persist(c);
		tx.commit();
		
		
		int id = c.getId();
		
		Funcionario Ef = new Funcionario(id);
		Pesquisador P = new Pesquisador(areaAtuacaoPesquisador);
		
		Endereco Ec =new Endereco(ruaFuncionario, numeroCasaFuncionario, cidadeFuncionario, bairroFuncionario, estadoFuncionario,Ef);
		

		try {
			tx.begin();
			em.persist(Ec);
			em.persist(P);
			tx.commit();
		} catch(IllegalStateException | PersistenceException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		

		new PesquisadorProjetoControle().adicionarPesquisadorPes(idprojeto,horasTrabalhadasPesquisador,(id-1));
		
	}
	
	public void adicionarPesquisadorSemProjeto(String nomeFuncionario, String ruaFuncionario,
			int numeroCasaFuncionario, String cidadeFuncionario, String bairroFuncionario, String estadoFuncionario,
			String sexoFuncionario, String dataAniversarioFuncionario, float salarioFuncionario, 
			int idDepartamentoFuncionario, String areaAtuacaoPesquisador) {		

			Departamento D = new Departamento(idDepartamentoFuncionario);
			Funcionario c = new Funcionario(nomeFuncionario, sexoFuncionario, dataAniversarioFuncionario,salarioFuncionario,D);

			c.setNumeroDepartamento(D);
			EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("dev");
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
			em.persist(c);
			tx.commit();
			
			
			int id = c.getId();
			
			Funcionario Ef = new Funcionario(id);
			Pesquisador P = new Pesquisador(areaAtuacaoPesquisador);
			
			Endereco Ec =new Endereco(ruaFuncionario, numeroCasaFuncionario, cidadeFuncionario, bairroFuncionario, estadoFuncionario,Ef);
			
			
			try {
				tx.begin();
				em.persist(Ec);
				em.persist(P);
				tx.commit();
			} catch(IllegalStateException | PersistenceException e) {
				tx.rollback();
				e.printStackTrace();
			} finally {
				em.close();
			}


}

	public static void adicionarSecretario(String nomeFuncionario, String ruaFuncionario,
											int numeroCasaFuncionario, String cidadeFuncionario, String bairroFuncionario, String estadoFuncionario,
											String sexoFuncionario, String dataAniversarioFuncionario, float salarioFuncionario,
											int idDepartamentoFuncionario, String grauEscolaridadeSecretario) {

		Departamento D = new Departamento(idDepartamentoFuncionario);

		Funcionario c = new Funcionario(nomeFuncionario, sexoFuncionario, dataAniversarioFuncionario,salarioFuncionario,D);
		c.setNumeroDepartamento(D);
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();


		tx.begin();
		em.persist(c);
		tx.commit();


		int id = c.getId();
		Funcionario Ef = new Funcionario(id);
		Secretario S = new Secretario(grauEscolaridadeSecretario,Ef);
		Endereco Ec =new Endereco(ruaFuncionario, numeroCasaFuncionario, cidadeFuncionario, bairroFuncionario, estadoFuncionario,Ef);


		try {
			tx.begin();
			em.persist(Ec);
			em.persist(S);

			tx.commit();
		} catch(IllegalStateException | PersistenceException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}	

	public void adicionarFuncionarioLimpeza(String nomeFuncionario, String ruaFuncionario,
			int numeroCasaFuncionario, String cidadeFuncionario, String bairroFuncionario, String estadoFuncionario,
			String sexoFuncionario, String dataAniversarioFuncionario, float salarioFuncionario,
			int idDepartamentoFuncionario, String cargo, int jornadaTrabalhoFuncionarioLimpeza) {

		
		
		Departamento D = new Departamento(idDepartamentoFuncionario);

		Funcionario c = new Funcionario(nomeFuncionario, sexoFuncionario, dataAniversarioFuncionario,salarioFuncionario
				, D);
		c.setNumeroDepartamento(D);
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		tx.commit();
	
		int id = c.getId();
		Funcionario Ef = new Funcionario(id);
		Limpeza L = new Limpeza(cargo, jornadaTrabalhoFuncionarioLimpeza);
		Endereco Ec =new Endereco(ruaFuncionario, numeroCasaFuncionario, cidadeFuncionario, bairroFuncionario, estadoFuncionario,Ef);


		try {
			tx.begin();
			em.persist(Ec);
			em.persist(L);

			tx.commit();
		} catch(IllegalStateException | PersistenceException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}

		
	}
	
	public void adicionarFuncionarioLimpezaGerenciada(String nomeFuncionario, String ruaFuncionario,
			int numeroCasaFuncionario, String cidadeFuncionario, String bairroFuncionario, String estadoFuncionario,
			String sexoFuncionario, String dataAniversarioFuncionario, float salarioFuncionario,
			int idDepartamentoFuncionario, String cargo, int jornadaTrabalhoFuncionarioLimpeza,int gerenciado) {

		
		
		Departamento D = new Departamento(idDepartamentoFuncionario);

		Funcionario c = new Funcionario(nomeFuncionario, sexoFuncionario, dataAniversarioFuncionario,salarioFuncionario,D);
		c.setNumeroDepartamento(D);
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		tx.commit();
		Limpeza G = new Limpeza(gerenciado);
		int id = c.getId();
		Funcionario Ef = new Funcionario(id);
		Limpeza L = new Limpeza(cargo, jornadaTrabalhoFuncionarioLimpeza,G);
		Endereco Ec =new Endereco(ruaFuncionario, numeroCasaFuncionario, cidadeFuncionario, bairroFuncionario, estadoFuncionario,Ef);


		try {
			tx.begin();
			em.persist(Ec);
			em.persist(L);

			tx.commit();
		} catch(IllegalStateException | PersistenceException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}

		
	}

	public void removerFuncionario(int id) {
		FuncionarioDAO funcionarioDAO = new FuncionarioJPADAO();

		try {
			funcionarioDAO.beginTransaction();

			funcionarioDAO.delete(funcionarioDAO.find(id));

			funcionarioDAO.commit();
		} catch (IllegalStateException | PersistenceException e) {
			funcionarioDAO.rollback();

			e.printStackTrace();
		} finally {
			try {
				funcionarioDAO.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Limpeza> buscarFuncionariosLimpeza() {
		LimpezaDAO limpezaDAO = new LimpezaJPADAO();
		return limpezaDAO.findAll();
	}
	
	public List<Secretario> buscarFuncionariosSecretario() {
		SecretarioDAO secretarioDAO = new SecretarioJPADAO();
		return secretarioDAO.findAll();
	}
	
	public List<Pesquisador> buscarFuncionariosPesquisador() {
		PesquisadorDAO pesquisadorDAO = new PesquisadorJPADAO();
		return pesquisadorDAO.findAll();
	}
	
	public List<Funcionario> buscarFuncionarios() {
		FuncionarioDAO funcionarioDAO = new FuncionarioJPADAO();
		return funcionarioDAO.findAll();
	}

	public Funcionario buscarFuncionarioPorNumero(int id) {
		FuncionarioDAO funcionarioDAO = new FuncionarioJPADAO();

		return funcionarioDAO.find(id);
	}

}
