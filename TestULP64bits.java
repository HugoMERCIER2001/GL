import java.util.Random;


public class TestULP64bits {
    public static void main(String[] args) {
        int numberOfValue = 1000;
        Random random = new Random();
        int nbrErreur = 0;
        for(int i = 0; i < numberOfValue; i++){
            double RandomDouble = random.nextDouble();
            Double Test1 = new Double(RandomDouble);
            System.out.println("La valeur de l'exposant du nombre " + Test1.getX() + " vaut " + Test1.getExposant());
            System.out.println("La valeur de l'ulp du nombre est " + Test1.getULP());
            System.out.println("La valeur attendu de l'ulp est  " + Math.ulp(Test1.getX()));
            System.out.println("La différence entre les deux ULP vaut " + (Test1.getULP() - Math.ulp(Test1.getX())));
            if((Test1.getULP() - Math.ulp(Test1.getX())) != 0){
                nbrErreur += 1;
            }
        }
        System.out.println("Hugo tu as " + nbrErreur + " erreurs sur les " + numberOfValue + " test.");
        System.out.println("HUGO TU ES LE BOSSSSSSSSS");
    }    
}
