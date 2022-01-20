
package metiers;

/**
 *
 * @author admin
 */
public class CompteCourant  extends Compte implements ICompreCourant, ICompteCCEE {

    private Double decouvert;

    public Double getDecouvert() {
        return this.decouvert;
    }

    public void setDecouvert(Double decouvert) {
        if (decouvert >= 0)
            decouvert = decouvert * -1;
        this.decouvert = decouvert;
    }

    public CompteCourant(String numero, Double montant, Double decouvert) {
        super(numero, montant);
        setDecouvert(decouvert);
    }

    public boolean retirer(double montant) {
        boolean operationRealise = true;
        double solde = getSolde();
        if ((solde - getDecouvert()) > montant) {
            setSolde(solde - montant);
        } else {
            operationRealise = false;
        }
        return operationRealise;

    }
    
    public boolean virer(double montant, CompteCourant unCompte) {
        boolean operationRealise = retirer(montant);
        if (operationRealise) {
            unCompte.verser(montant);
        }
        return operationRealise;
    }
    
   
    @Override
    public Boolean virer(double montant, Compte unCompte) {
        boolean operationRealise = retirer(montant);
        if (operationRealise) {
            unCompte.verser(montant);
        }
        return operationRealise;
    }
    
}
