package br.ufc.qxd.persistencia.trabalho_02_jpa.jpa.dao;

import br.ufc.qxd.persistencia.trabalho_02_jpa.dao.PesquisadorProjetoDAO;
import br.ufc.qxd.persistencia.trabalho_02_jpa.model.PesquisadorProjeto;

public class PesquisadorProjetoJPADAO extends GenericJPADAO<PesquisadorProjeto> implements PesquisadorProjetoDAO {

	public PesquisadorProjetoJPADAO() {
		super(PesquisadorProjeto.class);
	}
}
