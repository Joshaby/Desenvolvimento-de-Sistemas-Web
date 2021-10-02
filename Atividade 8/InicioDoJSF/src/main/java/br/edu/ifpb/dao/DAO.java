package br.edu.ifpb.dao;

import br.edu.ifpb.dao.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class DAO<T> {

    private final Class<T> classe;

    public DAO(Class<T> classe) {
        this.classe = classe;
    }

    public void adicionar(T t) {
        EntityManager entityManager = new JPAUtil().getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void atualiza(T t) {
        EntityManager entityManager = new JPAUtil().getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(t);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<T> listaTodos() {
        EntityManager entityManager = new JPAUtil().getEntityManager();
        CriteriaQuery<T> query = entityManager.getCriteriaBuilder().createQuery(classe);
        query.select(query.from(classe));
        List<T> lista = entityManager.createQuery(query).getResultList();
        entityManager.close();
        return lista;
    }

    public T buscaPorId(Integer id) {
        EntityManager entityManager = new JPAUtil().getEntityManager();
        T instanctia = entityManager.find(classe, id);
        entityManager.close();
        return instanctia;
    }
}
