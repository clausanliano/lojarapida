package br.senac.rn.dao;

import br.senac.rn.model.Categoria;

public class CategoriaDAO extends GenericDAO<Categoria> {

    @Override
    public Class<Categoria> getClassType() {
        return Categoria.class;
    }
	
}