package br.ufc.qxd.persistencia.trabalho_02_jpa.controle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import br.ufc.qxd.persistencia.trabalho_02_jpa.model.Pesquisador;
import br.ufc.qxd.persistencia.trabalho_02_jpa.model.PesquisadorProjeto;
import br.ufc.qxd.persistencia.trabalho_02_jpa.model.Projetos;



public class PesquisadorProjetoControle {
	public void adicionarPesquisadorPes(int projeto, int horasPorProjeto, int idPer) {
		
		Projetos projetoDAO = new Projetos(projeto);
		Pesquisador P = new Pesquisador(idPer);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		PesquisadorProjeto pespro = new PesquisadorProjeto(P,projetoDAO,horasPorProjeto); 
		
		try {
			tx.begin();
			em.persist(pespro);
			tx.commit();
		} catch(IllegalStateException | PersistenceException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}


public void adicionarProjetoPor(int pesquisador) {
	
	Pesquisador f = new Pesquisador(pesquisador);

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	
	PesquisadorProjeto proPro = new PesquisadorProjeto(f); 
	
	try {
		tx.begin();
		em.persist(proPro);
		tx.commit();
	} catch(IllegalStateException | PersistenceException e) {
		tx.rollback();
		e.printStackTrace();
	} finally {
		em.close();
	}
}

}
