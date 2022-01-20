
package metiers;



/**
 *
 * @author admin
 */
public class Service {

    private String libelle;
    private Double prime;

    public Service(String libelle, Double prime) {
        this.libelle = libelle;
        this.prime = prime;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Double getPrime() {
        return prime;
    }

    public void setPrime(Double prime) {
        this.prime = prime;
    }

}
