import javax.swing.*;

/**
 * Created by arget on 4/23/2016.
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s)
    { String answer = "";
        for ( int i = 0;  i != s.length();  i = i + 1 )
        { if ( helpMethod(answer, s.charAt(i)) )
        { answer = answer + s.charAt(i); }
        }
        return answer;
    }
    private boolean helpMethod(String a, char c)
    { boolean answer = true;
        for ( int j = 0;  j != a.length();  j = j + 1 )
        { answer = answer  &&  (c != a.charAt(j)); }
        return answer;
    }
    public static void main(String[] args){
        String a = JOptionPane.showInputDialog("Write a word :");
        JOptionPane.showMessageDialog(null, " Your remove duplicate letters from "+ a + " is :" + new RemoveDuplicateLetters().removeDuplicateLetters(a));
    }
}
