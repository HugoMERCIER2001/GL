import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.lang.Float;

public class TestSin {
    public static void main(String[] args) {
        //int numberOfValue = 1000;
        //Random random = new Random();
        Float test1 = Float.valueOf((float) 0.28135902);
        Float test2 = Float.valueOf((float) 0.4605053);
        Float test3 = Float.valueOf((float) 0.5665219);
        Float test4 = Float.valueOf((float) 0.079188466);
        Float test5 = Float.valueOf((float) 0.48998064);
        Float test6 = Float.valueOf((float) 0.36382526);
        List<Float> floatList = new ArrayList<>();
        floatList.add(test1);
        floatList.add(test2);
        floatList.add(test3);
        floatList.add(test4);
        floatList.add(test5);
        floatList.add(test6);
        int nbrErreur = 0;
        for(int i = 0; i < floatList.size(); i++){
            //float RandomFloat = random.nextFloat();
            //Flottant Test1 = new Flottant(random.nextFloat());
            Flottant Test1 = new Flottant(floatList.get(i));
            System.out.println("Float " + Test1.getX());
            float erreur = Test1.getSinus() - (float) Math.sin((double) Test1.getX());
            System.out.println("sinus attendu " + (float) Math.sin((double) Test1.getX()));
            System.out.println("l'écart de l'erreur est de :" + erreur);
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
