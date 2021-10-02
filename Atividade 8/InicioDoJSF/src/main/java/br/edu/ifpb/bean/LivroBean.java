package br.edu.ifpb.bean;

import br.edu.ifpb.domain.Livro;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LivroBean {

    private Livro livro = new Livro();

    public Livro getLivro() {
        return livro;
    }
    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public void gravar() {
        System.out.println("Gravando livro " + this.livro.getTitulo());
    }
}
