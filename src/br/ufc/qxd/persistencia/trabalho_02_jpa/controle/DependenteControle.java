package br.ufc.qxd.persistencia.trabalho_02_jpa.controle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import br.ufc.qxd.persistencia.trabalho_02_jpa.model.Dependentes;
import br.ufc.qxd.persistencia.trabalho_02_jpa.model.Funcionario;

public class DependenteControle {
	
	public static void InserirDependente(String nomeDependente, String sexo, String dataNascimento, String grauDeParentesco, int idFuncionario) {
		

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Funcionario Ef = new Funcionario(idFuncionario);
		try {
			tx.begin();
			em.persist(new Dependentes(nomeDependente, sexo, dataNascimento, grauDeParentesco, Ef));
			tx.commit();
		} catch(IllegalStateException | PersistenceException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}

	}
}
