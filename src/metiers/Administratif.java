package metiers;

import java.util.Date;

/**
 *
 * @author admin
 */
public class Administratif extends Employe {
    private String function;

    public Administratif(String function, String nom, String prenom, Double salaireBase, Date dateEmbauche, Service service) {
        super(nom, prenom, salaireBase, dateEmbauche, service);
        this.function = function;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
    
    
    
    @Override
    public Double calculerSalaire() {
        
    return super.getSalaireBase() + super.getService().getPrime();
    
    
    }
    
    
    
    
}
