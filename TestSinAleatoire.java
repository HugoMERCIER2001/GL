import java.util.Random;

public class TestSinAleatoire {
    public static void main(String[] args) {
        //fonction qui test avec n valeurs (pour n allant de 0 à N) choisient aléaoirement la précision de notre sinus.
        //renvoi le taux d'erreur pour chaque valeur de n.
        int N = 10000;
        int[] tableauErreur = new int[N];
        String valeurs = "";
        for(int i = 0; i < N; i++){
            tableauErreur[i] = 0;
        }
        for(int i = N-1; i < N; i++){
            System.out.println("" + i);
            Random random = new Random();
            int nbrErreur = 0;
            int nbrErreurUlp = 0;
            for(int j = 0; j < i; j++){
                System.out.println("on est au tour " + j);
                float RandomFloat = ((float) Math.PI * random.nextFloat());
                System.out.println("On pase le cap 2");
                Flottant Test1 = new Flottant(RandomFloat);
                System.out.println("Valeur testée" + RandomFloat);
                System.out.println("On pase le cap 3");
                float erreur = Test1.getSinus() - (float) Math.sin((double) Test1.getX());
                System.out.println("On pase le cap 4");
                Flottant Sinus = new Flottant(Test1.getSinus());
                System.out.println("On pase le cap 5");
                if(erreur != 0){
                    System.out.println("On pase le cap 6");
                    nbrErreur += 1;
                    valeurs += RandomFloat + ", ";
                }
            }
            System.out.println(valeurs);
        }
    }        
}
