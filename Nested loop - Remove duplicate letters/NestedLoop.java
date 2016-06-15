/**
 * Created by arget on 4/23/2016.
 */
public class NestedLoop {
    public static void metoda1() {
        for (int i = 0; i <= 3; i = i + 1){
            for (int j = 0; j <= i; j = j + 1) {
                System.out.print(i + " " + j + "  ");
            }
        System.out.println();}
    }
    public static void metoda2(){
        for (int i =3 ; 0<=i; i = i - 1){
            for (int j = 0; j <=i; j = j + 1){
                System.out.print(j + " " + i + "  ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args){
        metoda1();
        System.out.println();
        metoda2();
    }
}
