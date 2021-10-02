package br.edu.ifpb.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "LIVRO")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String isbn;
    private double preco;
    private String dataLancamento;
    @ManyToMany
    @JoinTable(name = "LIVRO_AUTOR",
            joinColumns = @JoinColumn(name = "LIVRO_ID"),
            inverseJoinColumns = @JoinColumn(name = "AUTOR_ID")
    )
    private List<Autor> autores = new ArrayList<>();

    public void addAutor(Autor autor) {
        autores.add(autor);
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public String getDataLancamento() {
        return dataLancamento;
    }
    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
    public List<Autor> getAutores() {
        return autores;
    }
    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
}
