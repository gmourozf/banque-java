
package banque2;

import java.util.Scanner;
import metiers.Administratif;
import metiers.Banque;
import metiers.Client;
import metiers.Commercial;
import metiers.CompteCourant;
import metiers.CompteEpargne;
import metiers.Service;
import utilitaires.Outils;

/**
 *
 * @author admin
 */
public class Banque2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String raisonSociale;
        Service serviceAdministratif = new Service("Administratif", 0.0);
        Service serviceCommercial = new Service("Commercial", 0.0);
        Scanner sc = new Scanner(System.in);

        Banque uneBanque = uneBanque = new Banque("Banque du code");

        Administratif employeAdministratif1 = new Administratif("DAF", "Jean", "VEUT", 4000.0, Outils.stringToDate("02/02/2015"), serviceAdministratif);
        Administratif employeAdministratif2 = new Administratif("Comptable", "Paul", "COMTE", 4000.0, Outils.stringToDate("02/02/2015"), serviceAdministratif);
        Commercial commercial1 = new Commercial(15.00, "Didier", "VIDANDE", 2000.0, Outils.stringToDate("04/02/2015"), serviceCommercial);
        Commercial commercial2 = new Commercial(15.00, "Phil", "DEFFER", 2000.0, Outils.stringToDate("11/02/2015"), serviceCommercial);

		//creation des clients et ajout de compte
        Client client1 = new Client("Pouce", "Pouce");
        client1.addCompte(new CompteCourant("CC0001", 400.0, 300.0));
        client1.addCompte(new CompteEpargne("CE0001", 2000.0, 0.02, Outils.stringToDate("11/02/2015")));

        Client client2 = new Client("Jones", "Tom");
        client2.addCompte(new CompteCourant("CC0002", 1000.0, 500.0));
        client2.addCompte(new CompteEpargne("CE0002", 4000.0, 0.02, Outils.stringToDate("11/02/2015")));

        Client client3 = new Client("Petty", "Tom");
        client3.addCompte(new CompteCourant("CC0003", 1500.0, 300.0));
        client3.addCompte(new CompteEpargne("CE0003", 12000.0, 0.02, Outils.stringToDate("11/02/2015")));

        Client client4 = new Client("Edisson", "Thomas");
        client4.addCompte(new CompteCourant("CC0004", 400.0, 300.0));
        client4.addCompte(new CompteEpargne("CE0004", 2000.0, 0.03, Outils.stringToDate("11/02/2015")));

        Client client5 = new Client("Kent", "Clark");
        client5.addCompte(new CompteCourant("CC0005", 400.0, 300.0));

        Client client6 = new Client("Mitchell", "Eddy");
        client6.addCompte(new CompteCourant("CC0006", 400.0, 300.0));
        client6.addCompte(new CompteCourant("CC0007", 600.0, 400.0));
        client6.addCompte(new CompteEpargne("CE0006", 2000.0, 0.04, Outils.stringToDate("11/02/2015")));

        uneBanque.addClient(client1);
        uneBanque.addClient(client2);
        uneBanque.addClient(client3);
        uneBanque.addClient(client4);
        uneBanque.addClient(client5);
        uneBanque.addClient(client6);

        
        commercial1.addClient(client1);
        commercial1.addClient(client2);
        commercial1.addClient(client3);
        commercial2.addClient(client4);
        commercial2.addClient(client5);
        commercial2.addClient(client6);
        
        uneBanque.addEmployee(employeAdministratif1);
        uneBanque.addEmployee(employeAdministratif2);
        uneBanque.addEmployee(commercial1);
        uneBanque.addEmployee(commercial2);



        System.out.println("Salaire de tout les employes : ");
        uneBanque.getSalairesEmployee();

        System.out.println("Patrimoine de tous les clients ");
        double patrimoine = 0.0;
        
        // pour chaque client d'un commercial on affiche le patrimoine 
        for (Client unClient : uneBanque.getLesClients()) {

            System.out.println("patrimoine du client :" + unClient.getNom() + " " + unClient.calculPatrimoine());

        }


    }

}
