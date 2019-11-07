package br.ufc.qxd.persistencia.trabalho_02_jpa.controle;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import br.ufc.qxd.persistencia.trabalho_02_jpa.dao.ProjetoDAO;
import br.ufc.qxd.persistencia.trabalho_02_jpa.jpa.dao.ProjetoJPADAO;
import br.ufc.qxd.persistencia.trabalho_02_jpa.model.Departamento;
import br.ufc.qxd.persistencia.trabalho_02_jpa.model.Projetos;


public class ProjetoControle {
	
	public void adicionarProjeto(String nome, int tempoDesenvolvimento, int numeroDepartamento, int idPesquisa) {

		Departamento departamento = new DepartamentoControle().buscarDepartamentoPorNumero(numeroDepartamento);
				
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Projetos P = new Projetos(nome, tempoDesenvolvimento, departamento);
	
		try {
			tx.begin();
			em.persist(P);
			tx.commit();
		} catch(IllegalStateException | PersistenceException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		int id = P.getIdPro();
		new PesquisadorProjetoControle().adicionarPesquisadorPes(id, tempoDesenvolvimento, idPesquisa);
	}
	
	public void adicionarProjetoSemPesquisador(String nome,int tempoDesenvolvimento, int numeroDepartamento) {
		ProjetoDAO projetoDAO = new ProjetoJPADAO();

		Departamento departamento = new DepartamentoControle().buscarDepartamentoPorNumero(numeroDepartamento);
		
		try {
			projetoDAO.beginTransaction();

			projetoDAO.save(new Projetos(nome, tempoDesenvolvimento, departamento));

			projetoDAO.commit();
		} catch (IllegalStateException | PersistenceException e) {
			projetoDAO.rollback();

			e.printStackTrace();
		} finally {
			try {
				projetoDAO.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	public void removerProjeto(int idPro) {
		ProjetoDAO projetoDAO = new ProjetoJPADAO();

		try {
			projetoDAO.beginTransaction();

			projetoDAO.delete(projetoDAO.find(idPro));

			projetoDAO.commit();
		} catch (IllegalStateException | PersistenceException e) {
			projetoDAO.rollback();

			e.printStackTrace();
		} finally {
			try {
				projetoDAO.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Projetos> buscarTodosOsProjetos() {
		ProjetoDAO projetoDAO = new ProjetoJPADAO();

		return projetoDAO.findAll();
	}

	public Projetos buscarProjetoPorNumero(int idPro) {
		ProjetoDAO projetoDAO = new ProjetoJPADAO();

		return projetoDAO.find(idPro);
	}

}
