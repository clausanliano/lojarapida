package br.senac.rn.controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import br.senac.rn.dao.CategoriaDAO;
import br.senac.rn.model.Categoria;

@ManagedBean (name = "categoria")
public class CategoriaMBean extends AbstractController<Categoria> {

    private Categoria categoria = new Categoria();

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public List<Categoria> getListaCompleta() {
        CategoriaDAO dao = new CategoriaDAO();
        try {
            return dao.findAll();
        } finally {
            dao.close();
        }
    }

    public String salvar() {
        CategoriaDAO dao = new CategoriaDAO();
        try {
            if (categoria.getId() == 0) {
                dao.create(categoria);
                addInfo(categoria.toString() + "Categoria INSERIDA com sucesso!");
            } else {
                dao.update(categoria);
                addInfo(categoria.toString() + "Categoria EDITADA com sucesso!");
            }
            
        } finally {
            categoria = new Categoria();
            dao.close();
        }
        return null;
    }

    public String selecionar(Categoria categoria) {
        this.categoria = categoria;
        return null;
    }

    public String deletar(Categoria categoria) {
        CategoriaDAO dao = new CategoriaDAO();
        try {
            dao.delete(categoria);
            addInfo("Categoria apagada com sucesso!");
        } finally {
            dao.close();
        }
        return null;
    }
	
}