import javax.swing.*;

/**
 * Created by arget on 3/17/2016.
 * 
 */
public class BankAccount {

    private int balance;
    private int end;

    public BankAccount(int amount) {

        this.balance = amount;
        do {
            String input = JOptionPane.showInputDialog("Write your account username ? ");
            String a = "A";
            String b = "B";
            String bankPeople = "BP";
            if (input.toUpperCase().equals(a) || input.toUpperCase().equals(bankPeople)) {
                do{
                    int code = Integer.parseInt(JOptionPane.showInputDialog("Write your password ?"));

                        if (code == 1234 || code == 2134) {
                            String[] options = {
                            "Deposit",
                            "Withdraw"
                        };
                    int pressButton = JOptionPane.showOptionDialog(null,
                            "Press one of the buttons:  ", "Bank Account",
                            JOptionPane.PLAIN_MESSAGE,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options,
                            options[0]);
                    if (pressButton == 0) {
                        int dA = Integer.parseInt(JOptionPane.showInputDialog("How much do you want to deposit ?"));
                       if (this.depositA(dA) == true){
                            JOptionPane.showMessageDialog(null, "You deposited " + dA + " and now in total you have  " + this.balance + "  ");
                       }else {
                           JOptionPane.showMessageDialog(null, "You're not allowed to enter negative values." + "" );
                       }
                    }
                    if (pressButton == 1) {
                        int wA = Integer.parseInt(JOptionPane.showInputDialog("How much do you want to withdraw ?"));
                            if (this.withDrawA(wA) == true) {
                                JOptionPane.showMessageDialog(null, "You withdrawed " + wA + " and now in total you have  " + this.balance + "  ");
                            }else {
                                JOptionPane.showMessageDialog(null, "You're not allowed to enter negative values." );
                            }
                    }
                        System.exit(0);
                        } else {
                        String[] options1 = {
                                "Yes",
                                "No"
                        };
                        this.end = JOptionPane.showOptionDialog(null,
                                "Your username is wrong. Do you want to try again  ?  ", "Bank Account",
                                JOptionPane.PLAIN_MESSAGE,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                options1,
                                options1[0]);
                    }
                } while(this.end == 0);}

                if (input.toUpperCase().equals(b) || input.toUpperCase().equals(bankPeople)) {
                    do {
                        int code = Integer.parseInt(JOptionPane.showInputDialog("Write your password ?"));

                        if (code == 4321 || code == 2134) {
                            String[] options = {
                                    "Deposit",
                                    "Withdraw"
                            };
                            int pressButton = JOptionPane.showOptionDialog(null,
                                    "Press one of the buttons:  ", "Bank Account",
                                    JOptionPane.PLAIN_MESSAGE,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    options,
                                    options[0]);
                            if (pressButton == 0) {
                                int dB = Integer.parseInt(JOptionPane.showInputDialog("How much do you want to deposit ?"));
                                if (this.depositB(dB) == true) {
                                    JOptionPane.showMessageDialog(null, "You deposited " + dB + " and now in total you have  " + this.balance + "  ");
                                }else {
                                    JOptionPane.showMessageDialog(null, "You're not allowed to enter negative values." );
                                }
                            }
                            if (pressButton == 1) {
                                int wB = Integer.parseInt(JOptionPane.showInputDialog("How much do you want to withdraw ?"));
                                if (this.withDrawB(wB) == true) {
                                    JOptionPane.showMessageDialog(null, "You withdrawed " + wB + " and now in total you have  " + this.withDrawA(wB) + "  ");
                                }else{
                                    JOptionPane.showMessageDialog(null, "You're not allowed to enter negative values." );
                                }
                            }
                            System.exit(0);
                        } else {
                            String[] options2 = {
                                    "Yes",
                                    "No"
                            };
                            this.end = JOptionPane.showOptionDialog(null,
                                    "Your username is wrong. Do you want to try again  ?  ", "Bank Account",
                                    JOptionPane.PLAIN_MESSAGE,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    options2,
                                    options2[0]);
                        }
                    } while (this.end == 0);

                }else
                     {
                    String[] options = {
                            "Yes",
                            "No"
                    };
                    int end1 = JOptionPane.showOptionDialog(null,
                            "Your username is wrong. Do you want to try again  ?  ", "Bank Account",
                            JOptionPane.PLAIN_MESSAGE,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options,
                            options[0]);
                    this.end = end1;
                }
        }
            while (this.end == 0) ;

    }

    public boolean depositA(int amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        }else {
            return false;
        }
    }



    public boolean withDrawA(int amount) {
        if (amount > 0) {
            this.balance -= amount;
            return true;
        }else {
            return false;
        }
    }

    public boolean depositB(int amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        }else {
            return false;
        }
    }

    public boolean withDrawB(int amount) {
        if (amount > 0) {
            this.balance -= amount;
            return true;
        }else {
            return false;
        }
    }
    public static void main(String[] args)
    {
        BankAccount bank = new BankAccount(500);

    }
}
