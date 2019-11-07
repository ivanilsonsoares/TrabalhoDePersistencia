package br.ufc.qxd.persistencia.trabalho_02_jpa.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.ufc.qxd.persistencia.trabalho_02_jpa.JPAUtil.JPAUtil;
import br.ufc.qxd.persistencia.trabalho_02_jpa.dao.*;
import br.ufc.qxd.persistencia.trabalho_02_jpa.model.*;

public class LimpezaJPADAO extends GenericJPADAO<Limpeza> implements LimpezaDAO {

	public LimpezaJPADAO() {
		super(Limpeza.class);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Limpeza> findByCargo(String cargo) {
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("SELECT L FROM Limpeza L"
									+ " WHERE L.cargo LIKE :cargo");
		query.setParameter("cargo", cargo+"%");
		return query.getResultList();
	}	
	
	

	
}
