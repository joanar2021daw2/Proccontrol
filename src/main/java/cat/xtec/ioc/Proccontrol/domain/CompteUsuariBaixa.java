package cat.xtec.ioc.Proccontrol.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author JoseAndrade
 */
@Entity
@Table(name = "comptes_baixa")
public class CompteUsuariBaixa implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_baixa")
    private long idCompteUsuariBaixa;

    @Column(name = "nom", length = 20, nullable = false)
    private String nom;

    @Column(name = "cognom1", length = 20, nullable = false)
    private String cognom1;

    @Column(name = "cognom2", length = 20, nullable = false)
    private String cognom2;

    @Column(name = "num_operari", nullable = false, unique = true)
    private long numOperari;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_baixa", nullable = false)
    private Date dataBaixaCompte;

    public CompteUsuariBaixa() {
    }

    public CompteUsuariBaixa(long idCompteUsuariBaixa, String nom, String cognom1, String cognom2, long numOperari, Date dataBaixaCompte) {
        this.idCompteUsuariBaixa = idCompteUsuariBaixa;
        this.nom = nom;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
        this.numOperari = numOperari;
        this.dataBaixaCompte = dataBaixaCompte;
    }

    public long getIdCompteUsuariBaixa() {
        return idCompteUsuariBaixa;
    }

    public void setIdCompteUsuariBaixa(long idCompteUsuariBaixa) {
        this.idCompteUsuariBaixa = idCompteUsuariBaixa;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom1() {
        return cognom1;
    }

    public void setCognom1(String cognom1) {
        this.cognom1 = cognom1;
    }

    public String getCognom2() {
        return cognom2;
    }

    public void setCognom2(String cognom2) {
        this.cognom2 = cognom2;
    }

    public long getNumOperari() {
        return numOperari;
    }

    public void setNumOperari(long numOperari) {
        this.numOperari = numOperari;
    }

    public Date getDataBaixaCompte() {
        return dataBaixaCompte;
    }

    public void setDataBaixaCompte(Date dataBaixaCompte) {
        this.dataBaixaCompte = dataBaixaCompte;
    }

  

}
