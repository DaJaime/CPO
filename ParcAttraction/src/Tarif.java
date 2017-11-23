public class Tarif {

    private String nom;

    public Tarif(int i){
        switch (i) {
            case 1:
                nom = "tarifNormalt"; break;
            case 2:
                nom = "tarifCinqt"; break;
            case 3:
                nom = "tarifReduitt"; break;
            case 4:
                nom = "tarifReduitCinqt"; break;
        }
        System.out.println("Veillez choisir un nombre entre 1 et 4");
    }

    public String getNom(){
        return this.nom;
    }
}
