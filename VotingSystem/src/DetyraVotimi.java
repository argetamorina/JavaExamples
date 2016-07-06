import javax.swing.*;

/**
 * Created by argetamorina on 3/4/2016.
 *
 * Detyra ne vijim i mundeson shfrytzuesit qe te votoj per zgjedhje e rektorit te UP-se.
 */
public class DetyraVotimi
{
    public int perfundo;
    public int voto;
    public int nje = 1;
    public int dy = 2;
    public int kandidati1;
    public int kandidati2;
    public int abstenim;

    public DetyraVotimi() {
        String[] options2 = {
                "Vazhdo"
        };
        int vazhdo = JOptionPane.showOptionDialog(null,
                "Platforma e votimit online ku mund te votoni per rektor te UP per kandidati 1 dhe kandidatin 2.", "Platforma e votimit online",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options2,
                options2[0]);
        int mosha = Integer.parseInt(JOptionPane.showInputDialog("Ju lutem shenoni moshen tuaj ?"));
        if (mosha >= 18) {
            do {
                String[] options1 = {
                        "Kandidati 1",
                        "Kandidati 2",
                        "Abstenim"
                };
                this.voto = JOptionPane.showOptionDialog(null,
                        "Per te votuar per ndonjerin nga kandidatet per rektor te UP klikonin njerin nga butonet e me poshtem ?  ", "Platforma e votimit online",
                        JOptionPane.PLAIN_MESSAGE,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options1,
                        options1[0]);
                if (this.voto == 0)
                    setKandidati1();
                else if (this.voto == 1)
                    setKandidati2();
                else
                    setAbstenim();
                String[] options = {
                        "Po",
                        "Jo"
                };
                int perfundo1 = JOptionPane.showOptionDialog(null,
                        "Desheroni te vazhdoni me tutje me votimin ?  ", "Platforma e votimit online",
                        JOptionPane.PLAIN_MESSAGE,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
                this.perfundo = perfundo1;
            }
            while (this.perfundo == 0);
            // System.out.println(this.perfundo);
            System.out.println(this.voto);
        } else {
            JOptionPane.showMessageDialog(null, "Nuk keni te drejt vote");
            System.exit(0);
        }
    }

    public int getKandidati1()
    {
        return kandidati1;
    }

    public int getKandidati2()
    {
        return kandidati2;
    }

    public int getAbstenim()
    {
        return abstenim;
    }

    public void setKandidati1()
    {
        ++kandidati1;
    }

    public void setKandidati2()
    {
        ++kandidati2;
    }

    public void setAbstenim()
    {
        ++abstenim;
    }

//    if(mosha<18){
//        JOptionPane.showMessageDialog(null, "Nuk keni te drejt vote.");
//}
    public static void main(String[] args)
    {
        DetyraVotimi detyra = new DetyraVotimi();
        JOptionPane.showMessageDialog(null, "Kandidati i pare ka grumbulluar gjithsej " + detyra.getKandidati1() + " vota Kandidati i dyte ka gumbulluar gjithsej " + detyra.getKandidati2() + " vota dhe gjithsej jane " + detyra.getAbstenim() + " abstenime.");
        System.exit(0);
    }
}