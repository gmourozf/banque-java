package utilitaires;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Outils {

    /**
     * Transforme une chaîne de caractère en une
     * variable de type Date. La chaîne doit être
     * au format français : "jj/mm/aaaa"
     * @param unedate : chaîne au bon format
     * @return Date
     */
    public static Date stringToDate(String unedate) {
        Date datesortie = null;
        try {
            SimpleDateFormat defFormat = new SimpleDateFormat("dd/MM/yyyy");
            datesortie = defFormat.parse(unedate);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return datesortie;
    }

    /**
     * Transforme une variable de type Date en une
     * chaîne de caractère au format français :
     * "jj/mm/aaaa"
     * @param uneDate : Date Java
     * @return chaîne au bon format
     */
    public static String dateToString(Date uneDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(uneDate);
    }

    /**
     * Retourne la date du jour sous forme
     * d'une Date Java
     * @return Date du jour
     */
    public static Date dateJour() {
        Calendar c = Calendar.getInstance();
        return c.getTime();
    }

    /**
     * Retourne l'année d'une Date Java
     * @param uneDate Date java dont on veut l'année
     * @return année de la date
     */
    public static int getAnnee(Date uneDate) {
        Calendar c = Calendar.getInstance();
        c.setTime(uneDate);
        return c.get(Calendar.YEAR);
    }

    /*
     Exemples d'utilisation 
     Date dateJour = Outils.stringToDate("29/04/1952");
     System.out.println(dateJour);
     Date d = new Date();
     String dateStr = Outils.dateToString(d);
     System.out.println(dateStr);
     int annee = Outils.getAnnee(d);
     System.out.println(annee);
     */
}
