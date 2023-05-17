
package com.porfolio.crud.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "persona")
public class PersonaModel  {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nombre;
    private String descripcion;
    private String url_foto;
    private String email;
    private String password;
    private String frase1;
    private String frase2;

    public PersonaModel() {
    }

    public PersonaModel(Long id, String nombre, String descripcion, String url_foto, String email, String password, String frase1, String frase2) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url_foto = url_foto;
        this.email = email;
        this.password = password;
        this.frase1 = frase1;
        this.frase2 = frase2;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String decripcion) {
        this.descripcion = decripcion;
    }

    public String getUrl_foto() {
        return url_foto;
    }

    public void setUrl_foto(String url_foto) {
        this.url_foto = url_foto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
     public String getFrase1() {
        return frase1;
    }

    public void setFrase1(String password) {
        this.frase1 = password;
    }
    
     public String getFrase2() {
        return frase2;
    }

    public void setFrase2(String password) {
        this.frase2 = password;
    }
}
