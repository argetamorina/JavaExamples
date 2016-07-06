/**
 * Created by argeta on 5/8/2016.
 */
import javax.swing.*;
public class Translate
{ public static void main(String[] args)
{ int[] code = new int[27];
    int k = Integer.parseInt(JOptionPane.showInputDialog
            ("Type seed (an integer): "));
    code[0] = k;
    for ( int i = 1;  i != code.length;  i = i+1 )
    { code[i] = (code[i-1] * 2) + 1; }

    String input_line = JOptionPane.showInputDialog("Type sentence to encode:");
    for ( int j = 0;  j != input_line.length();  j = j+1)
    { char c = input_line.charAt(j);
        if ( c == ' ' )
        { System.out.println(code[0]); }
        else if ( c >= 'a'  &&  c <= 'z' )
        { int index = (c - 'a') + 1;
            System.out.println(code[index]);
        }
        else { System.out.println("error: bad input character"); }
    }
}
}

