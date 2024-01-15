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
        //Fonction qui renvoie le sinus approximé du flottant.
        float somme = 0.0f;//On initialise la somme à 0.
        float terme = (float) this.x;//On commence avec le terme pour n = 0 dans le développement en série entière du sinus.
        Flottant sommeFlottant = new Flottant(somme);//typa en Flottant obligatoire pour la méthode getUlp.
        int compteur = 0;
        while((sommeFlottant.getUlp()) <= (float) Math.abs(terme)){ //Tant que U_n <= a_n ...
            somme += terme;
            compteur += 1;
            float terme1 = (float) Math.pow(-1, compteur);
            float terme2 = (float) Math.pow(this.x, 2 * compteur + 1)/this.factorielle(2 * compteur + 1);
            terme = terme1 * terme2;
            sommeFlottant.setX(somme);
        }
        System.out.println(sommeFlottant.getUlp());
        return somme;
    }
}