import javax.swing.*;

/**
 * Created by arget on 3/9/2016.
 */
public class Nota {
    public static void main(String[] args){
        int nota = new Integer(JOptionPane.showInputDialog("Sheno piket tuaja: ")).intValue();

        switch (nota) {
            case 100:
            case 99:
            case 98:
            case 97:
            case 96:
            case 95:
            case 94:
            case 93:
            case 92:
            case 91:
            case 90:
                JOptionPane.showMessageDialog(null, "Nota juaj eshte A");
                break;
            case 89:
            case 88:
            case 87:
            case 86:
            case 85:
            case 84:
            case 83:
            case 82:
            case 81:
            case 80:
                JOptionPane.showMessageDialog(null, "Nota juaj eshte B");
                break;
            case 79:
            case 78:
            case 77:
            case 76:
            case 75:
            case 74:
            case 73:
            case 72:
            case 71:
            case 70:
                JOptionPane.showMessageDialog(null, "Nota juaj eshte C");
                break;
            case 69:
            case 68:
            case 67:
            case 66:
            case 65:
            case 64:
            case 63:
            case 62:
            case 61:
            case 60:
                JOptionPane.showMessageDialog(null, "Nota juaj eshte D");
                break;
            case 59:
            case 58:
            case 57:
            case 56:
            case 55:
            case 54:
            case 53:
            case 52:
            case 51:
            case 50:
                JOptionPane.showMessageDialog(null, "Nota juaj eshte E");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Na vjen keq keni deshtuar. Suksese heren tjeter !");

        }

    }
}