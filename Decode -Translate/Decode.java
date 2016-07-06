/**
 * Created by argeta on 5/8/2016.
 */
import javax.swing.*;
public class Decode
{
    private static char decode(int[] code, int i)
    { char c = '*';
        boolean found = false;
        int index = 0;
        while ( !found  &&  index != code.length )
        { if ( code[index] == i )
        { found = true;
            if ( index == 0 )
            { c = ' '; }
            else { c = (char)(index + 'a' - 1); }
        }
        else { index = index + 1; }
        }
        return c;
    }

    public static void main(String[] args)
{ int[] code = new int[27];
    int k = Integer.parseInt(JOptionPane.showInputDialog
            ("Type seed an integer: "));
    code[0] = k;
    for ( int i = 1;  i != code.length;  i = i+1 )
    { code[i] = (int)((code[i-1] * 1.3) + 1); }

    String answer = "";
    boolean processing = true;
    while ( processing )
    {  String input = JOptionPane.showInputDialog
            ("Type an integer to decode or nothing, to quit: ");
        if ( input.equals("") )
        { processing = false; }
        else { char c = decode(code, new Integer(input));
            answer = answer + c;
        }
    }
    System.out.println(answer);
}
}
