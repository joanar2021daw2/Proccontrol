package cat.xtec.ioc.Proccontrol.domain;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author JoseAndrade
 */
@Entity
@Table(name = "instalacio")
public class Instalacio implements Serializable{
    
    @Id
    @GeneratedValue
    @Column (name = "instalacio_id")
    private long idInstalacio;
 
    @Column (name="nom", nullable = false)
    private String nom;
    
    //La instal·lació conté referències
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Set<Referencia> referencies;
    
    @ManyToOne(optional = false, cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Seccio seccio;
    
    public Instalacio(){
    }

    public Instalacio(int idInstalacio, String nom, Set<Referencia> referencies, Seccio seccio) {
        this.idInstalacio = idInstalacio;
        this.nom = nom;
        this.referencies = referencies;
        this.seccio = seccio;
    }

    public long getIdInstalacio() {
        return idInstalacio;
    }

    public void setIdInstalacio(long idInstalacio) {
        this.idInstalacio = idInstalacio;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Referencia> getReferencies() {
        return referencies;
    }

    public void setReferencies(Set<Referencia> referencies) {
        this.referencies = referencies;
    }

    public Seccio getSeccio() {
        return seccio;
    }

    public void setSeccio(Seccio seccio) {
        this.seccio = seccio;
    }
    
    
    
}
