package app;

import DAO.UsuarioDAO;

public class Main {

    public static void main(String[] args) {

        UsuarioDAO dao = new UsuarioDAO();

        // CREATE
        dao.crear(new Usuario("Patricio", "Capparelli00@hotmail.com"));
        dao.crear(new Usuario("Julia", "JuuMrlo@hotmail.com"));


        // READ
        System.out.println("Buscando Usuario (ID=2)");
        System.out.println(dao.buscar(2L));

        // READ ALL
        System.out.println("\nLista Completa");
        for (Usuario user : dao.listarTodos()) {
            System.out.println(user);
        }

        // UPDATE
        Usuario u1 = dao.buscar(1L);
        u1.setEmail("nuevo_correo@example.com");
        dao.actualizar(u1);

        // DELETE
        dao.eliminar(2L);

        System.out.println("\nLista Completa");
        for (Usuario user : dao.listarTodos()) {
            System.out.println(user);
        }
    }
}
