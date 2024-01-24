public class TestConvergence {
    public static void main(String[] args) {
    float terme = 1; 
    for(int i = 1;  i < 100; i++){
        float factorielle = 1.0f;
        for(int j = 1; j <= i; j++){
            factorielle *= j;
        }
        terme = ((float) Math.pow(2, i))/factorielle;
        System.out.println("terme pour i = " + i + " on a : " + terme);
    }
    }
}
