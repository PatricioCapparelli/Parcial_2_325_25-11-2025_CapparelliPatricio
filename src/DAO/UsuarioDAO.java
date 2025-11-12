package DAO;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.JPAUtil;
import app.Usuario;
import java.util.List;

public class UsuarioDAO {

    // CREATE
    public void crear(Usuario u) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        em.close();
    }

    // READ - Buscar por ID
    public Usuario buscar(long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Usuario u = em.find(Usuario.class, id);
        em.close();
        return u;
    }

    // READ - Listar todos
    public List<Usuario> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        Query q = em.createQuery("SELECT u FROM Usuario u");
        List<Usuario> usuarios = q.getResultList();
        em.close();
        return usuarios;
    }

    // UPDATE
    public void actualizar(Usuario u) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();
        em.close();
    }

    // DELETE
    public void eliminar(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Usuario u = em.find(Usuario.class, id);

        if (u != null) {
            em.getTransaction().begin();
            em.remove(u);
            em.getTransaction().commit();
        }

        em.close();
    }
}
