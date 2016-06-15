import javax.swing.*;

/**
 * Created by arget on 3/10/2016.
 */
public class LeapYear {
    public static void main(String[] args)
    {
        int year = new Integer(JOptionPane.showInputDialog("Write a year: ")).intValue();
        if ((year < 2016)&& ((year % 4) == 0 ) && ((year % 400) != 0) || ((year % 100) == 0))
        {
            JOptionPane.showMessageDialog(null, year + " it was a leap year " );
        }
        if (((year % 4) == 0 ) && ((year % 400) != 0) || ((year % 100) == 0)){
            JOptionPane.showMessageDialog(null, year + " it is a leap year " );
        }else{
            JOptionPane.showMessageDialog(null, "It isn't a leap year.");
        }
    }
}
