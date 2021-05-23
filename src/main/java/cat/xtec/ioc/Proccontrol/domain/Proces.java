package cat.xtec.ioc.Proccontrol.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Aquesta classe model conté propietats, constructor, getter i setter de procés
 *
 * @author JoseAndrade
 */
@Entity
@Table(name = "proces")
public class Proces implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "proces_id")
    private long idProces;

    @Column(name = "nom", nullable = false)
    private String nom;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Referencia referencia;

    @Column(name = "num_passos", nullable = false)
    private int numPassos;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<Pas> passos;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "regist_data", nullable = false)
    private Date dataRegistre;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Resultat> resultats;

    public Proces() {
    }

    public Proces(long idProces, String nom, Referencia referencia, int numPassos, List<Pas> passos, Date dataRegistre, List<Resultat> resultats) {
        this.idProces = idProces;
        this.nom = nom;
        this.referencia = referencia;
        this.numPassos = numPassos;
        this.passos = passos;
        this.dataRegistre = dataRegistre;
        this.resultats = resultats;
    }

    public long getIdProces() {
        return idProces;
    }

    public void setIdProces(long idProces) {
        this.idProces = idProces;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Referencia getReferencia() {
        return referencia;
    }

    public void setReferencia(Referencia referencia) {
        this.referencia = referencia;
    }

    public int getNumPassos() {
        return numPassos;
    }

    public void setNumPassos(int numPassos) {
        this.numPassos = numPassos;
    }

    public List<Pas> getPassos() {
        return passos;
    }

    public void setPassos(List<Pas> passos) {
        this.passos = passos;
    }

    public Date getDataRegistre() {
        return dataRegistre;
    }

    public void setDataRegistre(Date dataRegistre) {
        this.dataRegistre = dataRegistre;
    }

    public List<Resultat> getResultats() {
        return resultats;
    }

    public void setResultats(List<Resultat> resultats) {
        this.resultats = resultats;
    }

}
