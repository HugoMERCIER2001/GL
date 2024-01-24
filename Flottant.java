import java.util.ArrayList;

public class Flottant{
    private float x;

    public Flottant(float x){
        this.x = x;
    }

    public float getX(){
        return this.x;
    }

    public void setX(float x){
        this.x = x;
    }

    public float getAbsX(){
        return Math.abs(this.x);
    }

    public int getExposant(){
        //On realise une methode de recherche dichotomique pour obtenir l'exposant du flottant dans sa représentation IEEE754.
        int left = 0;
        int right = 255;
        while(left < right){
            int mid = left + (right - left)/2;
            float valeurSup = (float) Math.pow(2,(mid - 126));
            float valeurInf = (float) Math.pow(2, (mid - 127));
            if(valeurInf <= this.getAbsX() && this.getAbsX() < valeurSup){
                return mid;
            }
            if(this.getAbsX() < valeurInf){
                right = mid;
            }
            if(this.getAbsX() > valeurSup){
                left = mid;
            }
            if(this.getAbsX() == valeurSup){
                return mid + 1;
            }
        }
        if(left == right && right == 0){
           return 0; 
        }
        return -1;
    }

    public float getUlp(){
        int exposant = this.getExposant();
        float valeurUlp = (float) Math.pow(2, (exposant - 150));
        return valeurUlp;
    }

    public int factorielle(int n){
        int produit = 1;
        for(int i = 1; i <= n; i++){
            produit = produit * i;
        }
        return produit;
    }

    public float getSinus(){
        //On redéfinie le sinus pour que le flottant sur lequel il le calcul se trouve entre 0 et 1.
        float somme = 0.0f;//On initialise la somme à 0.
        Flottant sommeFlottant = new Flottant(somme);//typa en Flottant obligatoire pour la méthode getUlp.
        int compteur = 7;//On initialise le compteur a 5, et on décroit ensuite de 1 par tour de boucle pour calculer les 5 premiers termes de la somme.
        float terme;
        while(compteur >= 0){ //Tant que on a pas calculé les 5 premiers termes.
            int exposant = (2 * compteur) + 1;
            //System.out.println("la valeur de l'exposant est " + exposant);
            float terme1 = (float) Math.pow(-1, compteur);
            float terme2 = (float) Math.pow(this.x, exposant)/this.factorielle(exposant);
            //System.out.println("Pour le terme avec n = " + compteur + " on a comme terme2 " + terme2 + " et comme factorielle " + this.factorielle(exposant));
            terme = terme1 * terme2;
            somme += terme;//On met à jour la somme.
            sommeFlottant.setX(somme);
            //System.out.println("Pour le terme avec n = " + compteur + " on a " + terme);
            compteur -= 1;//On met à jour le compteur.
        }
        return somme;
    }

    public float getPi(){
        return (float) Math.PI;
    }

    public float getRealSinus(){
        int coefficient = 1;
        //On vérifie si on est entre 0 et 1 :
        if (this.getAbsX() <= 1.0f && this.getAbsX() >= 0.0f){
                return this.getSinus();
        }
        //On vérifie si on est entre [-Pi/2, -1] U [1, PI/2] :
        if(this.getAbsX() <= ((float) Math.PI / 2) && this.getAbsX() > 1.0f){
            float newx = (float) Math.PI / 2 - this.getAbsX();
            if(this.getX() >= 0){
                this.setX(newx);
                return this.getCosinus();
            }
            else{
                this.setX(newx);
                return -this.getSinus();
            }
        }
        //On vérifie si c'est entre -Pi et Pi
        if(this.getX() <= (float) Math.PI && this.getX() >= - (float) Math.PI){
            //Si entre [Pi/2, PI]
            if(this.getX() > 0){
                float newx = (float) Math.PI - this.getX();
                this.setX(newx);
                return this.getRealSinus();
            }
            else{
                float newx = (float) Math.PI - this.getAbsX();
                this.setX(newx);
                return -this.getRealSinus();
            }
        }
        //Maintenant si la valeur est pas entre -Pi et Pi
        else{
            float newx = this.getX() % ((float) Math.PI) - (float) Math.PI;
            this.setX(newx);
            return this.getRealSinus();
        }
    }


    public float getCosinus(){
        //Fonction qui renvoie le sinus approximé du flottant.
        //if(this.getAbsX() > 1){
        //    this.setX(this.getAbsX() / 4);
        //}
        float somme = 0.0f;//On initialise la somme à 0.
        float terme = 1.0f;//On commence avec le terme pour n = 0 dans le développement en série entière du sinus.
        Flottant sommeFlottant = new Flottant(somme);//typa en Flottant obligatoire pour la méthode getUlp.
        int compteur = 0;
        ArrayList<Float> listeTerms = new ArrayList<>();
        while((sommeFlottant.getUlp()) <= (float) Math.abs(terme) || compteur <= 15){ //Tant que U_n <= a_n ...
            somme += terme;
            listeTerms.add(terme);
            compteur += 1;
            float terme1 = (float) Math.pow(-1, compteur);
            float terme2 = (float) Math.pow(this.x, 2 * compteur)/this.factorielle(2 * compteur);
            terme = terme1 * terme2;
            sommeFlottant.setX(somme);
        }
        float sommeFinale = 0.0f;
        for (int i = listeTerms.size() - 1; i >= 0; i--){
            sommeFinale += listeTerms.get(i);
        }
        return sommeFinale;
    }
}

