import java.util.Random;

public class TestCosinusAleatoire {
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
                float RandomFloat = random.nextFloat();
                Flottant Test1 = new Flottant(RandomFloat);
                float erreur = Test1.getCosinus() - (float) Math.cos((double) Test1.getX());
                Flottant Cosinus = new Flottant(Test1.getCosinus());
                if(erreur != 0){
                    nbrErreur += 1;
                    if(Math.abs(erreur) == Cosinus.getUlp()){
                        nbrErreurUlp += 1;
                    }
                }
            };
            System.out.println(nbrErreur);
        }
    }        
}
