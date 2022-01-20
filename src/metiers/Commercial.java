
package metiers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author admin
 */
public class Commercial extends Employe {

    private Double tauxCommission;
    private List<Client> lesClients;

    public Commercial(Double tauxCommission, String nom, String prenom, Double salaireBase, Date dateEmbauche, Service service) {
        super(nom, prenom, salaireBase, dateEmbauche, service);
        this.tauxCommission = tauxCommission;
        this.lesClients = new ArrayList<Client>();
    }

    public Double getTauxCommission() {
        return tauxCommission;
    }

    public void setTauxCommission(Double tauxCommission) {
        this.tauxCommission = tauxCommission;
    }
    
    
     public List<Client> getLesClients() {
        return lesClients;
    }

    public void setLesClients(List<Client> lesClients) {
        this.lesClients = lesClients;
    }

    public void addClient(Client unClient) {
        this.lesClients.add(unClient);
    }

    public Client getClientByName(String nomClient) {
       
        Client monClient;
        monClient = null;
        for (Client unClient : this.lesClients) {
            if (unClient.getNom().equals(nomClient)) {
                monClient = unClient;
                break;
            }
        }

        return monClient;
       

    }

    @Override
    public Double calculerSalaire() {

        return super.getSalaireBase() + super.getService().getPrime() + calculerCommission();
    }

    public double calculerCommission() {
            
        return (this.calculPatrimoineDesClients()*(this.tauxCommission/100)) ; 
    }

    public double calculPatrimoineDesClients() {
        double caDesClients = 0;
        // recuperation du Ca de tous les client
        if (!this.lesClients.isEmpty()){
            for (Client unClient : this.lesClients) {
                caDesClients += unClient.calculPatrimoine();
                
            }
        }
        return caDesClients;
    }

   

}
