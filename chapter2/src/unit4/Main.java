package unit4;

public class Main {


    public static double mean(double[] arr, int n) {
        double sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        double avg = sum / n+1;

        return avg;
    }
    public static void main(String[] args) {
        double[] array = {1.2, 1.4, 1.2};
        System.out.println(mean(array,1));
    }
}



