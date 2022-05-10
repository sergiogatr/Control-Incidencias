package org.japo.java.entities;

import java.io.Serializable;
import java.util.Objects;
import org.japo.java.libraries.UtilesPerfiles;
import org.japo.java.libraries.UtilesUsuarios;

/**
 *
 * @author Sergio García Trincado - elfragger@gmail.com
 */
public final class Usuario implements Serializable {
    
    
    private int id;
    private String user;
    private String pass;
    private String avatar;
    private int perfil;
    private String perfilInfo;


    public Usuario() {
        
        id = UtilesUsuarios.DEF_ID;
        user = UtilesUsuarios.DEF_USER;
        pass = UtilesUsuarios.DEF_PASS;
        avatar = UtilesUsuarios.DEF_AVATAR;
        perfil = UtilesPerfiles.DEF_ID;
        perfilInfo = UtilesPerfiles.DEF_INFO;
        
    }

    public Usuario(int id, String user, String pass, String avatar, int perfil, String perfilInfo) {
        
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
        
        
        if (UtilesPerfiles.validarInfo(perfilInfo)) {
            this.perfilInfo = perfilInfo;
        } else {
            this.perfilInfo = UtilesPerfiles.DEF_INFO;
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
    
    
    public String getPerfilInfo() {
        return perfilInfo;
    }

    public void setPerfilInfo(String perfilInfo) {
        if (UtilesPerfiles.validarInfo(perfilInfo)) {
            this.perfilInfo = perfilInfo;
        }
    }
    
    @Override
    public boolean equals(Object o) {
        
        boolean testOK = false;
        
        if (o instanceof Usuario) {
            Usuario u = (Usuario) o;
            testOK = 
            
            id == u.getId() &&
            user.equals(u.getUser()) &&
            pass.equals(u.getPass()) &&
            avatar.equals(u.getAvatar()) &&
            perfil == u.getPerfil() &&
            perfilInfo.equals(u.getPerfilInfo());
                    
        }
        
        return testOK;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.user);
        hash = 79 * hash + Objects.hashCode(this.pass);
        hash = 79 * hash + Objects.hashCode(this.avatar);
        hash = 79 * hash + this.perfil;
        hash = 79 * hash + Objects.hashCode(this.perfilInfo);
        return hash;
    }
 
}
