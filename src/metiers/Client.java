
package metiers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class Client {

    private String nom;
    private String prenom;
    private List<Compte> lesComptes;

    public Client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.lesComptes = new ArrayList<Compte>();
        
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<Compte> getLesComptes() {
        return this.lesComptes;
    }   
    /*ajoute un compte courant a la liste des comptes courant du client */
    public void addCompte(Compte unCompte) {
        this.lesComptes.add(unCompte);

    }

    public double calculPatrimoine() {

        double patrimoine = 0;

        // recuperation des soldes des comptes courant du client 
        if (!this.lesComptes.isEmpty()) {

            for (Compte unCompte : lesComptes) {

                patrimoine += unCompte.getSolde();
            }

        }        

        return patrimoine;

    }
}
