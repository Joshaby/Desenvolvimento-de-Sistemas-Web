package br.edu.ifpb.bean;

import br.edu.ifpb.dao.DAO;
import br.edu.ifpb.domain.Autor;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class AutorBean {

    private Autor autor = new Autor();

    public Autor getAutor() {
        return autor;
    }

    public void gravar() {
        System.out.println("Gravando autor" + this.autor.getNome());
        new DAO<>(Autor.class).adicionar(this.autor);
    }
}
