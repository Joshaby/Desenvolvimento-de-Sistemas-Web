package br.edu.ifpb.bean;

import br.edu.ifpb.dao.DAO;
import br.edu.ifpb.domain.Autor;
import br.edu.ifpb.domain.Livro;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
public class LivroBean {

    private Livro livro = new Livro();
    private Integer autorId;

    public Livro getLivro() {
        return livro;
    }
    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    public Integer getAutorId() {
        return autorId;
    }
    public void setAutorId(Integer autorId) {
        this.autorId = autorId;
    }

    public void gravar() {
        System.out.println("Gravando livro " + this.livro.getTitulo());

        if (livro.getAutores().isEmpty()) {
            throw new RuntimeException("Livro deve ter pelo menos um autor!");
        }
        new DAO<>(Livro.class).adicionar(livro);
    }
    public void gravarAutor() {
        Autor autor = new DAO<>(Autor.class).buscaPorId(this.autorId);
        this.livro.addAutor(autor);
    }

    public List<Autor> getAutores() {
        return new DAO<>(Autor.class).listaTodos();
    }

    public List<Autor> getAutoresDoLivro() {
        return this.livro.getAutores();
    }
}
