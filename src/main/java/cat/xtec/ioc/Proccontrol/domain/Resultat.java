package cat.xtec.ioc.Proccontrol.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Aquesta classe model conté propietats, constructor, getter i setter de resultat
 * @author JoseAndrade
 */
@Entity
@Table(name = "resultat")
public class Resultat implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "resultat_id")
    private long idResultat;

    /**
    * JPA permet tenir una referència sense la columna típica ID i s'encarregarà
    * de realitzar un SELECT adicional per carregar l'entitat
    */    
    @ManyToOne(optional = false, cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private Usuari usuari;
    
    @ManyToOne(optional = false, cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private Proces proces;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on", nullable = false)
    private Date dataRegistre;

    @Column(name = "comentari_passos", nullable = true)
    private String[] comentariPassos;
    
    @Column(name = "temps_passos", nullable = false)
    private long[] tempsPassos;

    @Column(name = "temps_total", nullable = false)
    private long tempsTotal;

    public Resultat() {
    }

    public Resultat(long idResultat, Usuari usuari, Proces proces, Date dataRegistre, String[] comentariPassos, long[] tempsPassos, long tempsTotal) {
        this.idResultat = idResultat;
        this.usuari = usuari;
        this.proces = proces;
        this.dataRegistre = dataRegistre;
        this.comentariPassos = comentariPassos;
        this.tempsPassos = tempsPassos;
        this.tempsTotal = tempsTotal;
    }

    public long getIdResultat() {
        return idResultat;
    }

    public void setIdResultat(long idResultat) {
        this.idResultat = idResultat;
    }

    public Usuari getUsuari() {
        return usuari;
    }

    public void setUsuari(Usuari usuari) {
        this.usuari = usuari;
    }

    public Proces getProces() {
        return proces;
    }

    public void setProces(Proces proces) {
        this.proces = proces;
    }

    public Date getDataRegistre() {
        return dataRegistre;
    }

    public void setDataRegistre(Date dataRegistre) {
        this.dataRegistre = dataRegistre;
    }

    public String[] getComentariPassos() {
        return comentariPassos;
    }

    public void setComentariPassos(String[] comentariPassos) {
        this.comentariPassos = comentariPassos;
    }

    public long[] getTempsPassos() {
        return tempsPassos;
    }

    public void setTempsPassos(long[] tempsPassos) {
        this.tempsPassos = tempsPassos;
    }

    public long getTempsTotal() {
        return tempsTotal;
    }

    public void setTempsTotal(long tempsTotal) {
        this.tempsTotal = tempsTotal;
    }

}
