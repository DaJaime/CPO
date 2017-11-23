public class main {
    public static void main(String[] args) {
        parcAttraction pa = new parcAttraction("Parc MiageWonderland ", 180, 38.5);
        Tarif tarifNormal = new Tarif(1);
        Tarif tarifCinq = new Tarif(2);
        Tarif tarifReduit = new Tarif(3);
        Tarif tarifReduitCinq = new Tarif(4);

        pa.vendreBillets(24, tarifNormal);
        pa.vendreBillets(19, tarifCinq);
        pa.vendreBillets(32, tarifReduit);
        pa.vendreBillets(23, tarifReduitCinq);
        System.out.println(pa.toString());
        System.out.println("Chiffre d'affaires : " + pa.chiffreAffaires());
        System.out.println("Taux de remplissage : " + pa.tauxRemplissage());
    }
}
