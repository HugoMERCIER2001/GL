import java.util.Random;
import java.lang.System;

public class TestSinAléatoire {
    public static void main(String[] args) {
        //fonction qui test avec n valeurs (pour n allant de 0 à N) choisient aléaoirement la précision de notre sinus.
        //renvoi le taux d'erreur pour chaque valeur de n.
        int N = 10000;
        String valeurs = " ";
        Random random = new Random();
        int nbrErreur = 0;
        int nbrErreurUlp = 0;
        for(int i = 0; i < N; i++){
            float RandomFloat = 100 * random.nextFloat();
            Flottant Test1 = new Flottant(RandomFloat);
            Flottant TestSauv = new Flottant(RandomFloat);
            System.out.println("                                                        RandomFloat =  " + RandomFloat);
            float erreur = Test1.getRealSinus() - (float) Math.sin((double) TestSauv.getX());
            Flottant Sinus = new Flottant((float) Math.sin((double) TestSauv.getX()));
            if(erreur != 0){
                System.out.println("                                                        erreur =  " + erreur);
                System.out.println("                                                        ULP =  " + Sinus.getUlp());
                nbrErreur += 1;
                valeurs = valeurs + RandomFloat + ", ";
            }
            }

        System.out.println(nbrErreur);
        }
    }        

