package cat.xtec.ioc.Proccontrol.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author JoseAndrade
 */
@Entity
@Table(name = "seccio")
public class Seccio implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "seccio_id")
    private long idSeccio;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "tipus_produccio", nullable = false)
    private String tipusProduccio;

    //La Secció conté instal·lacions
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "seccio")
    private Set<Instalacio> instalacions;

    public Seccio() {
    }

    public Seccio(long idSeccio, String nom, String tipusProduccio, Set<Instalacio> instalacions) {
        this.idSeccio = idSeccio;
        this.nom = nom;
        this.tipusProduccio = tipusProduccio;
        this.instalacions = instalacions;
    }

    public long getIdSeccio() {
        return idSeccio;
    }

    public void setIdSeccio(long idSeccio) {
        this.idSeccio = idSeccio;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTipusProduccio() {
        return tipusProduccio;
    }

    public void setTipusProduccio(String tipusProduccio) {
        this.tipusProduccio = tipusProduccio;
    }

    @JsonBackReference
    public Set<Instalacio> getInstalacions() {
        return instalacions;
    }

    public void setInstalacions(Set<Instalacio> instalacions) {
        this.instalacions = instalacions;
    }

}
