import java.util.Random;

public class TestSinAléatoire64bits {
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
                double RandomDouble = random.nextDouble();
                Double Test1 = new Double(RandomDouble);
                double erreur = Test1.getSinus() - Math.sin(Test1.getX());
                System.out.println("l'erreur vaut :" + erreur);
                if(erreur != 0){
                    nbrErreur += 1;
                }
            }
            System.out.println(nbrErreur);
        }
    }        
}