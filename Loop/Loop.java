import javax.swing.*;

/**
 * Created by argeta on 3/26/2016.
 */
public class Loop {
    public int input;
    public int binput;
    //Exercise 1
    public int summation(int a) {
        this.input = a;
        int i = 0;
        int sum = 0;
        if (this.input >= 0)
        {
            while (i <= this.input) {
                ++i;
                sum = i + i;
            }
            JOptionPane.showMessageDialog(null, "Sum of the number " + this.input + " is " + sum);
            return sum;
        } else {
            JOptionPane.showMessageDialog(null, "Negative number");
            return 0;
        }
    }
    //Exercise 2
    public int getProduct(int a, int b)
    {
        int product = 1;
        if(b >= a)
        {
            product = a;
            int number = a;

            while (number != b)
            {
                number = number + 1;
                product = product * number;
                System.out.println(product);
            }
            JOptionPane.showMessageDialog(null, "Product of the number" + a + " " + b + " is " + product);
            return product;
        }else{
            JOptionPane.showMessageDialog(null, "Wrong number");
            return 0;
        }
    }

    public long getFactorial(int n)
    { long number = -1;
        if ( n >= 0  &&  n <= 20 )
        { int count = 0;  number = 1;
            while ( count != n )
            { count = count + 1;
                number = number * count;
            }
        }
        return number;
    }
    // Example 4
    public double getSine(double x)
    { double sin = x;
        int count = 3;
        while ( count <= 19 )
        {
            double d = Math.pow(x, count) / getFactorial(count);
            if ( (count % 4) == 3 )
            {
                sin = sin - d;
            }else {
                sin = sin + d;
            }
            count = count + 2;
        }
        return sin;

    }
    public double getCosine(double x)
    { double cos = 1;
        int count = 2;
        int number = 1;
        while ( count <= 20 ) {
            double c = Math.pow(x, count) / getFactorial(count);
            if ((count % 4) == 2) {
                cos = cos - c;
            } else {
                cos = cos + c;
            }
            count = count + 2;
        }
        return cos;
    }
    public static void main(String[] args) {
        Loop loop = new Loop();
        String[] options = {
                "All examples",
                "Some examples"
        };
        int question = JOptionPane.showOptionDialog(null,
                "We have 4 examples. Do you want execute all or some of them ?", "Loop examples",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        if (question == 0) {
            int ainput = Integer.parseInt(JOptionPane.showInputDialog("Exercise 1 .Write a number: "));
            loop.summation(ainput);

            int input2 = Integer.parseInt(JOptionPane.showInputDialog("Exercise 2 .Write a number 1 :"));
            int input3 = Integer.parseInt(JOptionPane.showInputDialog("Exercise 2 .Write a number 2 :"));
            loop.getProduct(input2, input3);

            int inputF = Integer.parseInt(JOptionPane.showInputDialog("Exercise 3 .Write a number 1 :"));
            JOptionPane.showMessageDialog(null, "Factorial of the number " + inputF + " is " + loop.getFactorial(inputF));

            double input4 = new Double(JOptionPane.showInputDialog("Exercise 4 .Write degrees for sine :"));
            double radians = Math.toRadians(input4);
            JOptionPane.showMessageDialog(null, "Sine of  " + input4 + " degrees is " + loop.getSine(radians));


            double input4c = new Double(JOptionPane.showInputDialog("Exercise 4 .Write degrees for cosine :"));
            double radiansC = Math.toRadians(input4c);
            JOptionPane.showMessageDialog(null, "Cosine of  " + input4c + " degrees is " + loop.getCosine(radiansC));

            System.exit(0);

        }else{
            String[] options1 = {
                    "1",
                    "2",
                    "3",
                    "4",

            };
            int question1 = JOptionPane.showOptionDialog(null,
                    "1. The summation of a nonnegative integer." +
                            " 2. The iterated product of two nonnegative integers  3. Factorial 4. Sinus & Cosinus", "Loop examples",
                    JOptionPane.PLAIN_MESSAGE,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options1,
                    options1[0]);
            if(question1 == 0)
            {
                int ainput = Integer.parseInt(JOptionPane.showInputDialog("Exercise 1 .  Write a number: "));
                loop.summation(ainput);
                System.exit(0);

            }
            if (question1 == 1)
            {
                int input2 = Integer.parseInt(JOptionPane.showInputDialog("Exercise 2 .Write a number 1 :"));
                int input3 = Integer.parseInt(JOptionPane.showInputDialog("Exercise 2 .Write a number 2 :"));
                loop.getProduct(input2, input3);

                System.exit(0);

            }
            if (question1 == 2)
            {
                int inputF = Integer.parseInt(JOptionPane.showInputDialog("Exercise 3 .Write a number 1 :"));
                JOptionPane.showMessageDialog(null, "Factorial of the number " + inputF + " is " + loop.getFactorial(inputF));
                System.exit(0);

            }
            if (question1 == 3)
            {
                double input4 = new Double(JOptionPane.showInputDialog("Exercise 4 .Write degrees for sine :"));
                double radians = Math.toRadians(input4);
                JOptionPane.showMessageDialog(null, "Sine of  " + input4 + " degrees is " + loop.getSine(radians));


                double input4c = new Double(JOptionPane.showInputDialog("Exercise 4 .Write degrees for cosine :"));
                double radiansC = Math.toRadians(input4c);
                JOptionPane.showMessageDialog(null, "Cosine of  " + input4c + " degrees is " + loop.getCosine(radiansC));

                System.exit(0);
            }
        }
    }
}
