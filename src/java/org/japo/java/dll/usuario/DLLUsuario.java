package org.japo.java.dll.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.sql.DataSource;
import org.japo.java.entities.Usuario;
import org.japo.java.entities.Usuarios;
import org.japo.java.libraries.UtilesServlets;

/**
 *
 * @author Sergio García Trincado - elfragger@gmail.com
 */
public final class DLLUsuario {

    // Acceso a la Base de Datos ( Pool de Conexiones )
    private DataSource ds;

    public DLLUsuario(ServletConfig config) {
        ds = UtilesServlets.obtenerDataSource(config);
    }

    // CONSULTA
    public final Usuario consultar(String user) {

        // Referencia
        Usuario usuario = null;

        // SQL
        String sql = ""
                + "SELECT "
                + "usuarios.id AS id, "
                + "usuarios.user AS user, "
                + "usuarios.pass AS pass, "
                + "usuarios.avatar AS avatar, "
                + "usuarios.perfil AS perfil, "
                + "perfiles.info AS perfil_info "
                + "FROM "
                + "usuarios "
                + "INNER JOIN "
                + "perfiles ON perfiles.id = usuarios.perfil "
                + "WHERE "
                + "usuarios.user=?";

        // Busqueda
        try {
            try (
                    Connection conn = ds.getConnection();
                    PreparedStatement ps = conn.prepareStatement(sql)) {

                // Parametrizar la Sentencia
                ps.setString(1, user);

                // BD > Lista de Entidades
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        // File Actual > Campos
                        int id = rs.getInt("id");
                        String pass = rs.getString("pass");
                        String avatar = rs.getString("avatar");
                        int perfil = rs.getInt("perfil");
                        String perfilInfo = rs.getString("perfil_info");

                        usuario = new Usuario(id, user, pass, avatar, perfil, perfilInfo);
                    }
                }

            }

        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
        }

        // Retorno
        return usuario;

    }

    // LISTADO ( GALERÍA ) 
    public final List<Usuario> listar() {

        // SQL
        String sql = ""
                + "SELECT "
                + "usuarios.id AS id, "
                + "usuarios.user AS user, "
                + "usuarios.pass AS pass, "
                + "usuarios.avatar AS avatar, "
                + "usuarios.perfil AS perfil, "
                + "perfiles.info AS perfil_info "
                + "FROM "
                + "usuarios "
                + "INNER JOIN "
                + "perfiles ON perfiles.id = usuarios.perfil";

        // Coleccion 
        List<Usuario> usuarios = new ArrayList<>();

        // Busqueda
        try {
            try (
                    Connection conn = ds.getConnection();
                    PreparedStatement ps = conn.prepareStatement(sql)) {

                // BD > Lista de Entidades
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        // File Actual > Campos
                        int id = rs.getInt("id");
                        String user = rs.getString("user");
                        String pass = rs.getString("pass");
                        String avatar = rs.getString("avatar");
                        int perfil = rs.getInt("perfil");
                        String perfilInfo = rs.getString("perfil_info");

                        Usuario usuario = new Usuario(id, user, pass, avatar, perfil, perfilInfo);

                        usuarios.add(usuario);
                    }
                }

            }

        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
        }

        // Retorno
        return usuarios;
    }
    
    // BORRADO USUARIO
    public final boolean borrar(String user) {
        
        boolean semaforo = false;
        
        // SQL
        String sql = ""
                + "DELETE "
                + "FROM "
                + "usuarios "
                + "WHERE "
                + "usuarios.user=?";
        
        try {
            Connection conn = ds.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            // Parametrizar la Sentencia
            ps.setString(1, user);
            
            ps.executeUpdate();
            
            semaforo = true;

        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        
        return semaforo; 
    }
    
    
    // Inserción Usuarios
    public final boolean insertar(Usuarios u) {
        
        // SQL
        String sql = "INSERT INTO usuarios "
                + "(id, user, pass, avatar, perfil) "
                + "VALUES (?, ?, ?, ?, ?);";

        // Número de registros afectados
        int numReg = 0;

        // Obtención del Contexto
        try (
                    
            Connection conn = ds.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
                
            // Parametrizar Sentencia
            ps.setInt(1, u.getId());
            ps.setString(2, u.getUser());
            ps.setString(3, u.getPass());
            ps.setString(4, u.getAvatar());
            ps.setInt(5, u.getPerfil());

            // Insertar el Producto
            numReg = ps.executeUpdate();
                
            } catch (SQLException | NullPointerException e) {
                System.out.println(e.getMessage());
            }

        return numReg == 1;
    }
    
    // Obtener Usuarios por ID
    public final Usuarios obtenerUsuariosID(int _id) throws SQLException {
        // SQL
        String sql = "SELECT * FROM usuarios WHERE id=?";

        // Referencia de las Categorias
        Usuarios u = null;

            try (
                Connection conn = ds.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
                
                // Parametrizar Statement
                ps.setInt(1, _id);

                // Obtener las Categorias
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        // Obtener Campos
                        int id = rs.getInt("id");
                        String user = rs.getString("user");
                        String pass = rs.getString("pass");
                        String avatar = rs.getString("avatar");
                        int perfil = rs.getInt("perfil");

                        // Instanciar Categorias
                        u = new Usuarios(id, user, pass, avatar, perfil);
                    }
                }

            }

        return u;
    }
    
    // Modificar Usuarios
    public final boolean modificar(Usuarios u) {
        // SQL
        String sql = "UPDATE usuarios "
                        + "SET user=?, pass=?, avatar=?, perfil=? "
                + "WHERE id=?";

        // Número de registros afectados
        int numReg = 0;

        try (
            Connection conn = ds.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            // Parametrizar Sentencia
            ps.setString(1, u.getUser());
            ps.setString(2, u.getPass());
            ps.setString(3, u.getAvatar());
            ps.setInt(4, u.getPerfil());
            ps.setInt(5, u.getId());

            // Actualizar las Categorias
            numReg = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }

        return numReg == 1;
    }

}
