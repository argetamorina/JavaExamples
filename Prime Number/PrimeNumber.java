import javax.swing.*;

/**
 * Created by argeta on 5/8/2016.
 *
 */

public class PrimeNumber {
    int input;
    String total = "";
    int[] number;

    public boolean primeNumber(int n) {
        number = new int[n];

        boolean answer = false;
        for (int i = 2; i * 2 <= number.length; i++) {
            if ((n % i) == 0) {
               // total = total + n + " ";
                return answer;
            }
        }
        for(int i=3; i*i <= number.length; i+=2) {
            if(n %i==0)
                return answer;
        }
        answer = true;
        return answer;
    }

    public String isPrime(int n) {
        String answer = "";
        if (!primeNumber(n)){
            for (int i = 2; i <= number.length; i++){
                if (n % i == 0){
                    answer = answer + i + " ";
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        PrimeNumber prime = new PrimeNumber();
        int n = Integer.parseInt(JOptionPane.showInputDialog("Enter a number: "));
        prime.primeNumber(n);
        if (prime.primeNumber(n)){
            JOptionPane.showMessageDialog(null, "Is a prime number ");
        }else{
            JOptionPane.showMessageDialog(null, "Result isn't a prime number");
            JOptionPane.showMessageDialog(null, " The divisor of the number " + n + " is: "+ prime.isPrime(n));
        }

       // System.out.println(prime.isPrime(n));
    }

}
