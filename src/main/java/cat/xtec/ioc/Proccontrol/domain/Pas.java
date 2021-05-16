/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.xtec.ioc.Proccontrol.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Aquesta classe model conté propietats, constructor, getter i setter de pas de procés
 * @author JoseAndrade
 */
@Entity
@Table(name = "pas")
public class Pas {

    @Id
    @GeneratedValue
    @Column(name = "id_pas")
    private long idPas;

    @Column(name = "titol")
    private String titol;

    @Column(name = "descripcio", length = 1000)
    private String descripcio;

    @Column(name = "num_pas")
    private int numeroDePas;

    @Lob
    @Column(name = "imagte", nullable = true)
    private String imatge;

    @ManyToOne
    @JoinColumn(name = "fk_proces", updatable = false)
    private Proces proces;

    public Pas() {
    }

    public Pas(long idPas, String titol, String descripcio, int numeroDePas, String imatge, Proces proces) {
        this.idPas = idPas;
        this.titol = titol;
        this.descripcio = descripcio;
        this.numeroDePas = numeroDePas;
        this.imatge = imatge;
        this.proces = proces;
    }

    public long getIdPas() {
        return idPas;
    }

    public void setIdPas(long idPas) {
        this.idPas = idPas;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public int getNumeroDePas() {
        return numeroDePas;
    }

    public void setNumeroDePas(int numeroDePas) {
        this.numeroDePas = numeroDePas;
    }

    public String getImatge() {
        return imatge;
    }

    public void setImatge(String imatge) {
        this.imatge = imatge;
    }

    public Proces getProces() {
        return proces;
    }

    public void setProces(Proces proces) {
        this.proces = proces;
    }

}
