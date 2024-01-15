import java.util.Random;

public class TestUlp {
    public static void main(String[] args) {
        int numberOfValue = 1000000;
        Random random = new Random();
        int nbrErreur = 0;
        for(int i = 0; i < numberOfValue; i++){
            float RandomFloat = random.nextFloat();
            Flottant Test1 = new Flottant(RandomFloat);
            System.out.println("La valeur de l'exposant du nombre " + Test1.getX() + " vaut " + Test1.getExposant());
            System.out.println("La valeur de l'ulp du nombre est " + Test1.getUlp());
            System.out.println("La valeur attendu de l'ulp est  " + Math.ulp(Test1.getX()));
            System.out.println("La différence entre les deux ULP vaut " + (Test1.getUlp() - Math.ulp(Test1.getX())));
            if((Test1.getUlp() - Math.ulp(Test1.getX())) != 0){
                nbrErreur += 1;
            }
        }
        System.out.println("Hugo tu as " + nbrErreur + " erreurs sur les " + numberOfValue + " test.");
        System.out.println("HUGO TU ES LE BOSSSSSSSSS");
    }
}