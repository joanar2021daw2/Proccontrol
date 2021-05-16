package cat.xtec.ioc.Proccontrol.domain;

import java.io.Serializable;
import java.util.Calendar;
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
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Usuari usuari;

    /**
     * JPA permet tenir una referència sense la columna típica ID i s'encarregarà
     * de realitzar un SELECT adicional per carregar l'entitat
     */
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Referencia referencia;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on", nullable = false)
    private Calendar dataRegistre;

    @Column(name = "temps_passos", nullable = false)
    private String tempsPassos;

    @Column(name = "temps_total", nullable = false)
    private int tempsTotal;

    public Resultat() {
    }

    public Resultat(Integer idResultat, Usuari usuari, Referencia referencia, Calendar dataRegistre, String tempsPassos, int tempsTotal) {
        this.idResultat = idResultat;
        this.usuari = usuari;
        this.referencia = referencia;
        this.dataRegistre = dataRegistre;
        this.tempsPassos = tempsPassos;
        this.tempsTotal = tempsTotal;
    }

    public long getIdResultat() {
        return idResultat;
    }

    public void setIdResultat(Integer idResultat) {
        this.idResultat = idResultat;
    }

    public Usuari getUsuari() {
        return usuari;
    }

    public void setUsuari(Usuari usuari) {
        this.usuari = usuari;
    }

    public Referencia getReferencia() {
        return referencia;
    }

    public void setReferencia(Referencia referencia) {
        this.referencia = referencia;
    }

    public Calendar getDataRegistre() {
        return dataRegistre;
    }

    public void setDataRegistre(Calendar dataRegistre) {
        this.dataRegistre = dataRegistre;
    }

    public String getTempsPassos() {
        return tempsPassos;
    }

    public void setTempsPassos(String tempsPassos) {
        this.tempsPassos = tempsPassos;
    }

    public int getTempsTotal() {
        return tempsTotal;
    }

    public void setTempsTotal(int tempsTotal) {
        this.tempsTotal = tempsTotal;
    }

}
