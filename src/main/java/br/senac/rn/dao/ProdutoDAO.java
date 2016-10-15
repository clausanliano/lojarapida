package br.senac.rn.dao;

import br.senac.rn.model.Produto;

public class ProdutoDAO extends GenericDAO<Produto> {

    @Override
    public Class<Produto> getClassType() {
        return Produto.class;
    }

}
