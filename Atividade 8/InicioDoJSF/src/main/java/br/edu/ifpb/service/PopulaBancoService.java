package br.edu.ifpb.service;

import br.edu.ifpb.dao.util.JPAUtil;
import br.edu.ifpb.domain.Autor;
import br.edu.ifpb.domain.Livro;

import javax.persistence.EntityManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PopulaBancoService {
    public static void main(String[] args) {

        EntityManager entityManager = new JPAUtil().getEntityManager();

        entityManager.getTransaction().begin();

        Autor assis = geraAutor("Machado de Assis");
        Autor amado = geraAutor("Jorge Amado");
        Autor coelho = geraAutor("Paulo Coelho");

        Livro casmurro = geraLivro("978-8-52-504464-8", "Dom Casmurro",
                "10/01/1899", 24.90, assis, amado);
        Livro memorias = geraLivro("978-8-50-815415-9",
                "Memorias Postumas de Bras Cubas", "01/01/1881", 19.90, assis);
        Livro quincas = geraLivro("978-8-50-804084-1", "Quincas Borba",
                "01/01/1891", 16.90, assis, coelho);


        Livro alquemista = geraLivro("978-8-57-542758-3", "O Alquimista",
                "01/01/1988", 19.90, coelho);
        Livro brida = geraLivro("978-8-50-567258-7", "Brida", "01/01/1990",
                12.90, coelho);
        Livro valkirias = geraLivro("978-8-52-812458-8", "As Valkirias",
                "01/01/1992", 29.90, coelho);
        Livro maao = geraLivro("978-8-51-892238-9", "O Diario de um Mago",
                "01/01/1987", 9.90, coelho);

        Livro capitaes = geraLivro("978-8-50-831169-1", "Capitaes da Areia",
                "01/01/1937", 6.90, amado);
        Livro flor = geraLivro("978-8-53-592569-9",
                "Dona Flor e Seus Dois Maridos", "01/01/1966", 18.90, amado);

        assis.addLivro(casmurro);
        assis.addLivro(memorias);
        assis.addLivro(quincas);
        entityManager.persist(assis);

        amado.addLivro(casmurro);
        amado.addLivro(capitaes);
        amado.addLivro(flor);
        entityManager.persist(amado);

        coelho.addLivro(quincas);
        coelho.addLivro(alquemista);
        coelho.addLivro(brida);
        coelho.addLivro(valkirias);
        coelho.addLivro(maao);
        entityManager.persist(coelho);

        entityManager.persist(casmurro);
        entityManager.persist(memorias);
        entityManager.persist(quincas);
        entityManager.persist(alquemista);
        entityManager.persist(brida);
        entityManager.persist(valkirias);
        entityManager.persist(maao);
        entityManager.persist(capitaes);
        entityManager.persist(flor);

        entityManager.getTransaction().commit();
        entityManager.close();

    }

    private static Autor geraAutor(String nome) {
        Autor autor = new Autor();
        autor.setNome(nome);
        return autor;
    }

    private static Livro geraLivro(String isbn, String titulo, String data,
                                   double preco, Autor ...autores) {
        Livro livro = new Livro();
        livro.setIsbn(isbn);
        livro.setTitulo(titulo);
        livro.setDataLancamento(data);
        livro.setPreco(preco);
        for (Autor autor : autores) {
            livro.addAutor(autor);
        }
        return livro;
    }

    @SuppressWarnings("unused")
    private static Calendar parseData(String data) {
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar;
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
