package br.senac.rn.dao;

import br.senac.rn.model.Cliente;

public class ClienteDAO extends GenericDAO<Cliente> {

    @Override
    public Class<Cliente> getClassType() {
        return Cliente.class;
    }

}
