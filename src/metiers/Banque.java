
package metiers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class Banque {

    private String raisonSociale;
    private List<Client> lesClients;
    private List<Employe> lesEmployes;

    public Banque(String raisonSociale) {
        this.raisonSociale = raisonSociale;
        this.lesClients = new ArrayList<Client>();
        this.lesEmployes = new ArrayList<Employe>();
    }

    public List<Client> getLesClients() {
        return lesClients;
    }

    public List<Employe> getLesEmployes() {
        return lesEmployes;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public double calculerCA() {
        double caBanque = 0;

        if (!this.lesClients.isEmpty()) {

            for (Client unClient : lesClients) {

                caBanque += unClient.calculPatrimoine();
            }

        }

        return caBanque;
    }

    public void addEmployee(Employe unEmploye) {
        this.lesEmployes.add(unEmploye);
    }

    public void addClient(Client client) {
        this.lesClients.add(client);
    }

    public Administratif getAdministratifByName(String nomAdministratif) {

        Administratif unAdministratif;
        unAdministratif = null;
        for (Employe unEmploye : this.lesEmployes) {

            if (unEmploye instanceof Administratif) {

                if (unEmploye.getNom().equals(nomAdministratif)) {
                    unAdministratif = (Administratif) unEmploye;
                    break;
                }
            }

        }

        return unAdministratif;

    }

    public Commercial getCommercialByName(String nomCommercial) {

        Commercial unCommercial;
        unCommercial = null;
        for (Employe unEmploye : this.lesEmployes) {

            if (unEmploye instanceof Commercial) {

                if (unEmploye.getNom().equals(nomCommercial)) {
                    unCommercial = (Commercial) unEmploye;
                    break;
                }
            }
        }
        return unCommercial;

    }

    public void getSalairesEmployee() {

        for (Employe unEmploye : this.lesEmployes) {

            System.out.println("Salaire de l'employer  : " + unEmploye.getNom() + " " + unEmploye.calculerSalaire() + " du service : " + unEmploye.getService().getLibelle());
        }

    }

}
