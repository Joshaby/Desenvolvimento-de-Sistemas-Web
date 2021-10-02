package br.edu.ifpb.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "AUTOR")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @ManyToMany(mappedBy = "autores")
    private List<Livro> livros = new ArrayList<>();

    public void addLivro(Livro livro) {
        livros.add(livro);
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
