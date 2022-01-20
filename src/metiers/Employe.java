
package metiers;

import java.util.Date;
import utilitaires.Outils;
import static utilitaires.Outils.dateJour;

/**
 *
 * @author admin
 */
public abstract class Employe {
   private String nom;
   private String prenom;
   private Double salaireBase;
   private Date dateEmbauche;
   private Service service;

    public String getNom() {
        return nom;
    }

    public Employe(String nom, String prenom, Double salaireBase, Date dateEmbauche, Service service) {
        this.nom = nom;
        this.prenom = prenom;
        this.salaireBase = salaireBase;
        this.dateEmbauche = dateEmbauche;
        this.service = service;
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

    public Double getSalaireBase() {
        return salaireBase;
    }

    public void setSalaireBase(Double salaireBase) {
        this.salaireBase = salaireBase;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
   
   
   public abstract Double calculerSalaire();
   
   public int anciennete(){
       Date dateCourant = new Date();       
       return Outils.getAnnee(dateCourant) - Outils.getAnnee(this.getDateEmbauche());
       
   }
}
