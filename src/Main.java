import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static List<Room> rooms = new ArrayList<>();
    private static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        initializeData(); // Données de test
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("\n=== Programme de réservation de salle  ===");
            System.out.println("1. Listes des salles ");
            System.out.println("2. Réservation de salle ");
            System.out.println("3. Quitter ");
            System.out.println("Tapez votre choix : ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Liste des salles");
                    break;
                case 2:
                    System.out.println("Réserver une salle");
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        }
    }

    private static void initializeData() {
        // Ajouter 2 salles de test
        Room room1 = new Room("B101", 30);
        room1.addEquipment("Projector");
        rooms.add(room1);

        Room room2 = new Room("A201", 50);
        rooms.add(room2);

        // Ajouter 1 utilisateur test
        users.add(new User("alice@email.com", "Alice"));
    }

    }
