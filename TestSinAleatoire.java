import java.util.Random;

public class TestSinAleatoire {
    public static void main(String[] args) {
        //fonction qui test avec n valeurs (pour n allant de 0 à N) choisient aléaoirement la précision de notre sinus.
        //renvoi le taux d'erreur pour chaque valeur de n.
        int N = 1000;
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
                float RandomFloat = random.nextFloat();
                Flottant Test1 = new Flottant(RandomFloat);
                float erreur = Test1.getSinus() - (float) Math.sin((double) Test1.getX());
                if(erreur != 0){
                    nbrErreur += 1;
                    }
                Flottant Sinus = new Flottant(Test1.getSinus());
                if(erreur == Sinus.getUlp()){
                    nbrErreurUlp += 1;
                }
            }
            System.out.println(nbrErreur + " " + nbrErreurUlp);
        }
        System.out.println(valeurs);
    }        
}
