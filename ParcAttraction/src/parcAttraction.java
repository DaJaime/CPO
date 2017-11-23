public class parcAttraction {
    public static String nom;
    public static int capacite;
    public static double prixBillet;
    public static double prixBillet5;
    public int tarifNormal = 0;
    public int tarifCinq = 0;
    public int tarifReduit = 0;
    public int tarifReduitCinq = 0;

    public parcAttraction (String parNom, int parCapacite, double parPrixBillet) {
        this.nom = parNom;
        this.capacite = parCapacite;
        this.prixBillet = parPrixBillet;
        this.prixBillet5 = parPrixBillet * 0.8;
    }

    public int nbPlacesDispo(){
        return capacite - (tarifNormal + tarifCinq + tarifReduit + tarifReduitCinq);
    }

    public void vendreBillets(int nb, Tarif tarif){
        if (this.nbPlacesDispo() - nb < 0)  {
            System.out.println("Nombre de places disponible insufisant");
        }
        else {
            switch (tarif.getNom()) {
                case "tarifNormalt":
                    tarifNormal = tarifNormal + nb; break;
                case "tarifCinqt":
                    tarifCinq = tarifCinq + nb; break;
                case "tarifReduitt":
                    tarifReduit = tarifReduit + nb; break;
                case "tarifReduitCinqt":
                    tarifReduitCinq = tarifReduitCinq + nb; break;
            }
        }
    }

    public void reinitialiser(){
        this.tarifNormal = 0;
        this.tarifCinq = 0;
        this.tarifReduitCinq = 0;
        this.tarifReduit = 0;
    }

    public double chiffreAffaires(){
        return (tarifNormal * prixBillet) + (tarifCinq * prixBillet5) + (tarifReduit * (prixBillet * 0.7)) + (tarifReduitCinq * (prixBillet5 * 0.7));
    }

    double tauxRemplissage(){
        return (((tarifNormal + tarifCinq + tarifReduit + tarifReduitCinq)/capacite) * 100);
    }

    public String toString (){
        StringBuffer sb = new StringBuffer() ;
        sb.append(this.nom).append("\n")
                .append("Capacité : ").append(this.capacite).append("\n")
                .append("Tarif normal : ").append(this.prixBillet).append("\n")
                .append("Tarif pour 5 : ").append(this.prixBillet5).append("\n")
                .append(tarifNormal).append(" Billet vendu au tarif normal \n")
                .append(tarifCinq).append(" Billet vendu au tarif 5 \n")
                .append(tarifReduit).append(" Billet vendu au tarif réduit \n")
                .append(tarifReduitCinq).append(" Billet vendu au tarif réduit 5 \n");
        return sb.toString();
    }


}
