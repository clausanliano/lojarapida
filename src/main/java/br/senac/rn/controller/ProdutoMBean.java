package br.senac.rn.controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import br.senac.rn.dao.CategoriaDAO;
import br.senac.rn.dao.ProdutoDAO;
import br.senac.rn.model.Categoria;
import br.senac.rn.model.Produto;

@ManagedBean
public class ProdutoMBean extends AbstractController<Produto> {
	
    private Produto produto = new Produto();
    private Categoria categoria = new Categoria();
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Produto> getListaCompleta() {
        ProdutoDAO pDao = new ProdutoDAO();
        try {
            return pDao.findAll();
        } finally {
            pDao.close();
        }
    }

    public List<Categoria> getCarregarCategorias() {           
        CategoriaDAO cDao = new CategoriaDAO();
        try {
            return cDao.findAll();  
        } finally {
            cDao.close();
        }         
    }  

    public String salvar() {
        ProdutoDAO pDao = new ProdutoDAO();
        try {
            if (produto.getId()==0) {
                produto.setCategoria(categoria);
                pDao.create(produto);
                produto = new Produto();
            } else {
                pDao.update(produto);
            }
            addInfo("Produto "+produto.getDenominacao()+" salvo com sucesso!");
        } finally {
            pDao.close();
        }
        return null;
    }

    public String selecionar(Produto produto){
        this.produto = produto;
        return null;
    }

    public String deletar(Produto produto) {
        ProdutoDAO pDao = new ProdutoDAO();
        try {
            pDao.delete(produto);
            addInfo("Produto "+produto.getDenominacao()+" apagado com sucesso!");
        } finally {
            pDao.close();
        }
        return null;
    }
	
}
