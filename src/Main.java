import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static ArrayList<Room> rooms = new ArrayList<>();
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
                    displayRooms();
                    break;
                case 2:
                    bookRoom(scanner);
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

    private static void displayRooms() {
        // Afficher les salles
        System.out.println("\n--- Salles disponibles ---");
        for(Room room : rooms) {
            System.out.println(room.toString());
        }
    }

    // Choix de la salle
    private static void bookRoom(Scanner scanner) {
        int index = 0;
        int choice;

        System.out.println("Choisissez une salle : ");
        for(int i = 0; i < rooms.size(); i++) {
            System.out.println((i+1) + "." + rooms.get(i));
        };
        System.out.println("Entrer le numéro : ");
        choice = Integer.parseInt(scanner.nextLine());

        if (choice < 0 || choice > rooms.size()) {
            System.out.println("Numéro invalide !");
            return;
        }

        Room selectedRoom = rooms.get(choice);

        // Saisie de l'utilisateur
        System.out.println("Entrez votre email : ");
        String email = scanner.nextLine();

        // Vérification de l'utilisateur
        User currentUser = users.stream()
                                .filter(u -> u.getEmail().equals(email))
                                .findFirst()
                                .orElse(null);

        if(currentUser == null) {
            System.out.println("Utilisateur introuvable");
            return;
        }

        // Saisie de la date/heure
        System.out.println("Date et heure de début (AAAA-MM-JJ HH:MM) : ");
        LocalDateTime start = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        System.out.print("Durée (en heures) : ");
        int duration = Integer.parseInt(scanner.nextLine());
        LocalDateTime end = start.plusHours(duration);

        // Création de la réservation
        Booking newBooking = new Booking(start, end, selectedRoom, currentUser);
        currentUser.addBooking(newBooking);
        System.out.println("Reservation confirmée ! ");
    }
    }
