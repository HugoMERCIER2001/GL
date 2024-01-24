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
            float Pi = (float) Math.PI;
            Random random = new Random();
            int nbrErreurUlp = 0;
            int nbrErreur = 0;
            for(int j = 0; j < i; j++){
                float RandomFloat = -random.nextFloat();
                System.out.println("" + RandomFloat);
                Flottant Test1 = new Flottant(RandomFloat);
                float erreur = Test1.getSinus() - (float) Math.sin((double) Test1.getX());
                Flottant Sinus = new Flottant(Test1.getSinus());
                valeurs += Test1.getSinus() + ", ";
                if(erreur != 0){
                    nbrErreur += 1;
                }
            }
            System.out.println(nbrErreur);
        }
    }        
}