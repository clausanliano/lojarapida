package br.senac.rn.controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import br.senac.rn.dao.ClienteDAO;
import br.senac.rn.model.Cliente;

@ManagedBean
public class ClienteMBean extends AbstractController<Cliente> {

    private Cliente cliente = new Cliente();
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getListaCompleta() {
        ClienteDAO dao = new ClienteDAO();
        try {
            return dao.findAll();
        } finally {
            dao.close();
        }
    }

    public String salvar() {
        ClienteDAO dao = new ClienteDAO();
        try {
            if (cliente.getId()==0) {
                dao.create(cliente);
                cliente = new Cliente();
            } else {
                dao.update(cliente);
            }
            addInfo("Cliente salvo com sucesso!");
        } finally {
            dao.close();
        }
        return null;
    }

    public String selecionar(Cliente cliente) {
        this.cliente = cliente;
        return null;
    }

    public String deletar(Cliente cliente) {
        ClienteDAO dao = new ClienteDAO();
        try {
            dao.delete(cliente);
            addInfo("Cliente apagado com sucesso!");
        } finally {
            dao.close();
        }
        return null;
    }
	
}
