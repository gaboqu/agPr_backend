
package com.porfolio.crud.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="experiencias")
public class ExpModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String url_logo_exp;
    private String empresa;
    private String fechas_ing_egr;
    private String funciones;
    
    //CONSTRUCTORES

    public ExpModel() {
    }

    public ExpModel(Long id, String url_logo_exp, String empresa, String fechas_ing_egr, String funciones) {
        this.id = id;
        this.url_logo_exp = url_logo_exp;
        this.empresa = empresa;
        this.fechas_ing_egr = fechas_ing_egr;
        this.funciones = funciones;
    }
    
    //GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl_logo_exp() {
        return url_logo_exp;
    }

    public void setUrl_logo_exp(String url_logo_exp) {
        this.url_logo_exp = url_logo_exp;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getFechas_ing_egr() {
        return fechas_ing_egr;
    }

    public void setFechas_ing_egr(String fechas_ing_egr) {
        this.fechas_ing_egr = fechas_ing_egr;
    }

    public String getFunciones() {
        return funciones;
    }

    public void setFunciones(String funciones) {
        this.funciones = funciones;
    }

    
    
}
