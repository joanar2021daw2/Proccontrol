package cat.xtec.ioc.Proccontrol.domain;

import cat.xtec.ioc.Proccontrol.ConstraintValidator.NotExistingNumOperari;
import cat.xtec.ioc.Proccontrol.ConstraintValidator.OnCreate;
import cat.xtec.ioc.Proccontrol.ConstraintValidator.OnUpdate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 * Aquesta classe model conté propietats, constructor, getter i setter d'usuari
 *
 * @author JoseAndrade
 */
@Entity
@Table(name = "usuari")
public class Usuari implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private long userId;

    @NotExistingNumOperari(groups = OnUpdate.class)
    @NotNull(message = "Has d'indicar un número d'operari")
    @Column(name = "num_operari", nullable = false, unique = true)
    private long numOperari;

    @NotBlank(message = "Has d'indicar el nom")
    @Column(name = "nom", length = 20, nullable = false)
    private String nom;

    @NotBlank(message = "Has d'indicar un cognom")
    @Column(name = "cognom1", length = 20, nullable = false)
    private String cognom1;

    @NotBlank(message = "Has d'indicar el segon cognom")
    @Column(name = "cognom2", length = 20, nullable = false)
    private String cognom2;

    @Column(name = "rol", nullable = false)
    private String rol;

    @NotBlank(message = "Has de posar una contrasenya")
    @Length(min = 4, message  = "La contrasenya ha de tenir mínim 4 caràcters")
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "active", columnDefinition = "BOOLEAN DEFAULT true", nullable = false)
    private Boolean active;

    /*
     * Usuari conté resultats, mappedBy per indicar que és una relació bidireccional
     * és a dir, tindrà també una rel·lació capa l'entitat Usuari
     * Cascade remove per tal d'eliminar els resultats quan s'elimina un usuari.
     */
    @JsonIgnoreProperties("usuari")
    @OneToMany(cascade = {CascadeType.REMOVE}, fetch = FetchType.EAGER, mappedBy = "usuari")
    private Set<Resultat> resultats;

    public Usuari() {
    }

    public Usuari(long userId, long numOperari, String nom, String cognom1, String cognom2, String rol, String password, Boolean active, Set<Resultat> resultats) {
        this.userId = userId;
        this.numOperari = numOperari;
        this.nom = nom;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
        this.rol = rol;
        this.password = password;
        this.active = active;
        this.resultats = resultats;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getNumOperari() {
        return numOperari;
    }

    public void setNumOperari(long numOperari) {
        this.numOperari = numOperari;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<Resultat> getResultats() {
        return resultats;
    }

    public void setResultats(Set<Resultat> resultats) {
        this.resultats = resultats;
    }

}
