package cat.xtec.ioc.Proccontrol.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author JoseAndrade
 */
@Entity
@Table(name = "proces")
public class Proces implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "proces_id")
    private long idProces;

    @Column(name = "nom", nullable = false)
    private String nom;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Referencia referencia;

    @Column(name = "num_passos", nullable = false)
    private int numPassos;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "regist_data", nullable = false)
    private Date dataRegistre;

    /**
     * OneToOne, ja que existeix una profunda relació entre l'entitat origen i
     * destí, de tal forma que l'entitat destí pertany a l'entitat origen i
     * nomès a aquesta. L'exisatència de l'entitat destí(RESULTAT) depend de
     * l'entitat origen(PROCES)
     */
    @JoinColumn(name = "fk_resultat", updatable = false)
    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Resultat resultat;

    public Proces() {
    }

    public Proces(long idProces, String nom, Referencia referencia, int numPassos, Date dataRegistre, Resultat resultat) {
        this.idProces = idProces;
        this.nom = nom;
        this.referencia = referencia;
        this.numPassos = numPassos;
        this.dataRegistre = dataRegistre;
        this.resultat = resultat;
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

    public Date getDataRegistre() {
        return dataRegistre;
    }

    public void setDataRegistre(Date dataRegistre) {
        this.dataRegistre = dataRegistre;
    }

    public Resultat getResultat() {
        return resultat;
    }

    public void setResultat(Resultat resultat) {
        this.resultat = resultat;
    }

 
}
