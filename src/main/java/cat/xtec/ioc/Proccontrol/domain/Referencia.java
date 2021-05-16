package cat.xtec.ioc.Proccontrol.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.Table;

/**
 * Aquesta classe model conté propietats, constructor, getter i setter de referència
 * Anotem amb JsonIgnore per tal de no mostrar les instal·lacions quan es genera la 
 * resposta Json de llistar processos i fer bucle
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

    /**
     * La entitat Referencia pot tenir múltiples processos
     */
    @JsonIgnore
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "referencia")
    private Set<Proces> processos;

    @ManyToOne
    @JoinColumn(name = "fk_instalacio")
    private Instalacio instalacio;

    public Referencia() {
    }

    public Referencia(long idReferencia, String nom, Set<Proces> processos, Instalacio inst) {
        this.idReferencia = idReferencia;
        this.nom = nom;
        this.processos = processos;
        this.instalacio = inst;
    }

    public long getIdReferencia() {
        return idReferencia;
    }

    public void setIdReferencia(long idReferencia) {
        this.idReferencia = idReferencia;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
