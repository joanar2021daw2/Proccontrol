package cat.xtec.ioc.Proccontrol.domain;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 *
 * @author JoseAndrade
 */
@Entity
@Table(name = "referencia")
public class Referencia implements Serializable {

    @Id
    @Column(name = "referencia_id")
    @GeneratedValue
    private long idReferencia;

    @Column(name = "nom", nullable = false)
    private String nom;

    /*L'entitat Referencia pot tenir múltiples resultats(propietari de la relació 
    és a Resultat "ManyToOne Referencia referencia"*/
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "referencia")
    @OrderBy("created_on asc")
    private Set<Resultat> resultat;

    //La entitat Refernecia pot tenir múltiples processos
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "referencia")
    private Set<Proces> processos;

    @ManyToOne
    @JoinColumn(name = "fk_instalacio")
    private Instalacio instalacio;

    public Referencia() {
    }

    public Referencia(int idReferencaia, String nom, Set<Resultat> resultat, Set<Proces> processos, Instalacio inst) {
        this.idReferencia = idReferencaia;
        this.nom = nom;
        this.resultat = resultat;
        this.processos = processos;
        this.instalacio = inst;
    }

    public long getIdReferencia() {
        return idReferencia;
    }

    public void setIdReferencaia(long idReferencia) {
        this.idReferencia = idReferencia;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Resultat> getResultat() {
        return resultat;
    }

    public void setResultat(Set<Resultat> resultat) {
        this.resultat = resultat;
    }

    public Set<Proces> getProcessos() {
        return processos;
    }

    public void setProcessos(Set<Proces> processos) {
        this.processos = processos;
    }

    public Instalacio getInstalacio() {
        return instalacio;
    }

    public void setInstalacio(Instalacio instalacio) {
        this.instalacio = instalacio;
    }



}
