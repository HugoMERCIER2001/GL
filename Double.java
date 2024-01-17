public class Double {
    private double x;

    public Double(double x){
        this.x = x;
    }

    public void setX(double x){
        this.x = x;
    }

    public double getX(){
        return this.x;
    }

    public double getAbsX(){
        return Math.abs(this.getX());
    }

    public int getExposant(){
        int left = 0;
        int right = 2047;
        while(left < right){
            int mid = left + (right - left)/2;
            float valeurSup = (float) Math.pow(2,(mid - 1022));
            float valeurInf = (float) Math.pow(2, (mid - 1023));
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


    public double getULP(){
        int e = this.getExposant();
        double valeurUlp = Math.pow(2, (e - 1075));
        return valeurUlp;
    }


    public int factorielle(int n){
        int produit = 1;
        for(int i = 1; i <= n; i++){
            produit = produit * i;
        }
        return produit;
    }

    public double getSinus(){
        //Fonction qui renvoie le sinus approximé du flottant.
        //if(this.getAbsX() > 1){
        //    this.setX(this.getAbsX() / 4);
        //}
        double somme = 0.0;//On initialise la somme à 0.
        double terme = (double) this.x;//On commence avec le terme pour n = 0 dans le développement en série entière du sinus.
        Double sommeDouble = new Double(somme);//typa en Flottant obligatoire pour la méthode getUlp.
        int compteur = 0;
        System.out.println("On test le nombre" + this.getX());
        while((sommeDouble.getULP()) <= Math.abs(terme)){ //Tant que U_n <= a_n ...
            somme += terme;
            compteur += 1;
            double terme1 = Math.pow(-1, compteur);
            double terme2 = Math.pow(this.getX(), 2 * compteur + 1)/this.factorielle(2 * compteur + 1);
            terme = terme1 * terme2;
            sommeDouble.setX(somme);
        }
        System.out.println(" Et on a que l'ulp de la somme partielle vaut : " + sommeDouble.getULP() + "et le vrai ULP vaut : " + Math.ulp(sommeDouble.getX()) + "\n Et le prochain terme est : " + Math.abs(terme));
        return somme;
    }

}
