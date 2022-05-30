package org.japo.java.dll.perfil;

import org.japo.java.dll.usuario.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.sql.DataSource;
import org.japo.java.entities.Perfil;
import org.japo.java.entities.Usuario;
import org.japo.java.entities.Usuarios;
import org.japo.java.libraries.UtilesServlets;

/**
 *
 * @author Sergio García Trincado - elfragger@gmail.com
 */
public final class DLLPerfil {

    // Acceso a la Base de Datos ( Pool de Conexiones )
    private DataSource ds;

    public DLLPerfil(ServletConfig config) {
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
    public final List<Perfil> listar() {

        // SQL
        String sql = ""
                + "SELECT "
                + "perfiles.id AS id, "
                + "perfiles.nombre AS nombre, "
                + "perfiles.info AS info "
                + "FROM "
                + "perfiles";

        // Coleccion 
        List<Perfil> perfiles = new ArrayList<>();

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
                        String nombre = rs.getString("nombre");
                        String info = rs.getString("info");

                        Perfil perfil = new Perfil(id, nombre, info);

                        perfiles.add(perfil);
                    }
                }

            }

        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
        }

        // Retorno
        return perfiles;
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

}
