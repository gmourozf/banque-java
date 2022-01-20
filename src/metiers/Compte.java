package metiers;

/**
 *
 * @author admin
 */
public class Compte implements ICompte{
    private String numero;
    private Double solde;

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getSolde() {
        return this.solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    @Override
    public void verser(double montant) {
        if (montant > 0) {
            setSolde(getSolde() + montant);
        }
    }
     public Compte(String numero, double montant) {
        setNumero(numero);
        setSolde(montant);
    }   
    
    
    
}
