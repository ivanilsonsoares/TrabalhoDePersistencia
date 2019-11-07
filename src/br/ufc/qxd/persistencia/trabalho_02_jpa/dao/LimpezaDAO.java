package br.ufc.qxd.persistencia.trabalho_02_jpa.dao;

import java.util.List;

import br.ufc.qxd.persistencia.trabalho_02_jpa.model.Limpeza;


public interface LimpezaDAO  extends GenericDAO<Limpeza> {
	
	
	public List<Limpeza> findByCargo(String cargo);


}
