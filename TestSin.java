import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.lang.Float;

public class TestSin {
    public static void main(String[] args) {
        //int numberOfValue = 1000;
        //Random random = new Random();
        Float test0 = Float.valueOf((float) 0.60000000);//On pour une valeur entre 0 et 1.
        Float test1 = Float.valueOf((float) -0.53636355);//On teste pour une valeur entre -1 et 0.
        Float test2 = Float.valueOf((float) 1.86475346); //On teste pour une valeur entre 1 et 2.
        System.out.println(Math.sin(5.412301) + " " + Math.sin(0.8708844));
        Float test3 = Float.valueOf((float) -1.8536894); //On test pour une valeur entre -1 et -2.
        Float test4 = Float.valueOf((float) -2.3535783); //On test pour une valeur entre -2 et -3.
        Float test5 = Float.valueOf((float) 2.5356673); //On test pour une valeur entre 2 et 3.
        Float test6 = Float.valueOf((float) 4.4656366);
        Float test7 = Float.valueOf((float) 5.4123013); 
        Float test8 = Float.valueOf((float) 6.7132736);
        Float test9 = Float.valueOf((float) 7.600);
        Float test10 = Float.valueOf((float) 8.500);
        List<Float> floatList = new ArrayList<>();
        floatList.add(test0);
        floatList.add(test1);
        floatList.add(test2);
        floatList.add(test3);
        floatList.add(test4);
        floatList.add(test5);
        floatList.add(test6);
        floatList.add(test7);
        floatList.add(test8);
        floatList.add(test9);
        floatList.add(test10);
        int nbrErreur = 0;
        for(int i = 0; i < floatList.size(); i++){
            //float RandomFloat = random.nextFloat();
            //Flottant Test1 = new Flottant(random.nextFloat());
            Flottant Test1 = new Flottant(floatList.get(i));
            System.out.println("Float " + Test1.getX());
            Flottant TestSauv = new Flottant(floatList.get(i));
            float erreur = Test1.getRealSinus() - (float) Math.sin((double) TestSauv.getX());
            //System.out.println("Et l'ULP du sinus vaut : " + Sinus.getUlp());
            //System.out.println("sinus attendu " + (float) Math.sin((double) Test1.getX()));
            Flottant Sinus = new Flottant((float) Math.sin((double) TestSauv.getX()));
            System.out.println("l'écart de l'erreur est de :" + erreur);
            System.out.println("l'ulp du sinus vaut : " + Sinus.getUlp());
            System.out.println("---------------------------------------------------");
            if(erreur != 0){
                nbrErreur += 1;
                System.out.println("ERRRRRROOOOORRRRRR");
            }
            System.out.println("---------------------------------------------------");
        }
        System.out.println("Le nombre d'erreur faite est de : " + nbrErreur);
    }
}
