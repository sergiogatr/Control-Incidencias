package org.japo.java.entities;

import java.io.Serializable;
import java.util.Objects;
import org.japo.java.libraries.UtilesPerfiles;
import org.japo.java.libraries.UtilesUsuarios;

/**
 *
 * @author Sergio García Trincado - elfragger@gmail.com
 */
public final class Usuarios implements Serializable {
    
    
    private int id;
    private String user;
    private String pass;
    private String avatar;
    private int perfil;


    public Usuarios() {
        
        id = UtilesUsuarios.DEF_ID;
        user = UtilesUsuarios.DEF_USER;
        pass = UtilesUsuarios.DEF_PASS;
        avatar = UtilesUsuarios.DEF_AVATAR;
        perfil = UtilesPerfiles.DEF_ID;
        
    }

    public Usuarios(int id, String user, String pass, String avatar, int perfil) {
        
        if (UtilesUsuarios.validarId(id)) {
            this.id = id;
        } else {
            this.id = UtilesUsuarios.DEF_ID;
        }
        
        
        if (UtilesUsuarios.validarUser(user)) {
            this.user = user;
        } else {
            this.user = UtilesUsuarios.DEF_USER;
        }
        
        
        if (UtilesUsuarios.validarPass(pass)) {
            this.pass = pass;
        } else {
            this.pass = UtilesUsuarios.DEF_PASS;
        }
        
        
        if (UtilesUsuarios.validarAvatar(avatar)) {
            this.avatar = avatar;
        } else {
            this.avatar = UtilesUsuarios.DEF_AVATAR;
        }
        
        
        if (UtilesPerfiles.validarId(perfil)) {
            this.perfil = perfil;
        } else {
            this.perfil = UtilesPerfiles.DEF_ID;
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (UtilesUsuarios.validarId(id)) {
            this.id = id;
        }
    }
    

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        if (UtilesUsuarios.validarUser(user)) {
            this.user = user;
        }
    }

    
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        if (UtilesUsuarios.validarPass(pass)) {
            this.pass = pass;
        }
    }
    

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        if (UtilesUsuarios.validarAvatar(avatar)) {
            this.avatar = avatar;
        }
    }
    
    
    public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        if (UtilesPerfiles.validarId(perfil)) {
            this.perfil = perfil;
        }
    }
    
    @Override
    public boolean equals(Object o) {
        
        boolean testOK = false;
        
        if (o instanceof Usuarios) {
            Usuarios u = (Usuarios) o;
            testOK = 
            
            id == u.getId() &&
            user.equals(u.getUser()) &&
            pass.equals(u.getPass()) &&
            avatar.equals(u.getAvatar()) &&
            perfil == u.getPerfil();
        }
        
        return testOK;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.user);
        hash = 53 * hash + Objects.hashCode(this.pass);
        hash = 53 * hash + Objects.hashCode(this.avatar);
        hash = 53 * hash + this.perfil;
        return hash;
    }


 
}
