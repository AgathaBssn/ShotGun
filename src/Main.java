package src;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenue dans mon jeu !");
        System.out.print("Entre ton nom : ");
        String nom = sc.nextLine();

        System.out.println("Salut " + nom + " !");
        sc.close();
    }
}