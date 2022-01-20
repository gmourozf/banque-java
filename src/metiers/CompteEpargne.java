
package metiers;

import java.util.Date;
import utilitaires.Outils;

/**
 *
 * @author admin
 */
public class CompteEpargne extends Compte implements ICompteEpargne,ICompteCCEE{
    
    private Double tauxInterets;
    private Date dateCreation;

    public Date getDateCreation() {
        return this.dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Double getTauxInterets() {
        return tauxInterets;
    }

    public void setTauxInterets(Double tauxInterets) {
        this.tauxInterets = tauxInterets;
    }

    public CompteEpargne(String numero, double montant, double tauxInterets, Date dateCreation) {
        super(numero, montant);
        setTauxInterets(tauxInterets);
        setDateCreation(dateCreation);
    }

    public Double calculSolde() {
        return super.getSolde() + calculInterets();

    }

    public boolean retirer(double montant) {
        boolean operationRealise = true;
        double solde = calculSolde();
        if (solde >= montant) {
            setSolde((solde - montant));
            if (super.getSolde() < 0) {
                setSolde(0.0);
            }
        } else {
            operationRealise = false;
        }
        return operationRealise;
    }    
  

    @Override
    public double calculInterets() {
        double interets = 0;
    Date dateJour = new Date();
    int duree = Outils.getAnnee(dateJour) - Outils.getAnnee(getDateCreation());
    interets = super.getSolde()*getTauxInterets()*duree/100;
    return interets;
    }

    @Override
    public double calculInterets(int annee) {
      double interets = 0;
     Date dateCration = getDateCreation();
     int anneeDateCreation = Outils.getAnnee(dateCration);
     int duree = annee - anneeDateCreation;
     interets = super.getSolde()*getTauxInterets()*duree/100;
     return interets;
    }
    
    @Override 
    public Double getSolde(){
    
       return  super.getSolde() + calculInterets( Outils.getAnnee(new Date()));
    }
    
}
