import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // input scan
        Scanner scanner = new Scanner(System.in);

        DBHandler dbHandler = new DBHandler();

        System.out.println("Social Network DB Manager");

        boolean running = true;

        while (running) {
            printMenu();

            System.out.print("Enter your choice: ");
            int choice = -1;

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    // INSERT NEW PROFILE
                    System.out.println("\n--- Add New Profile ---");
                    System.out.print("Enter username: ");
                    String nameToAdd = scanner.nextLine();

                    System.out.print("Enter followers count: ");
                    int followersToAdd = 0;
                    if(scanner.hasNextInt()) {
                        followersToAdd = scanner.nextInt();
                        scanner.nextLine();
                    }

                    Profile newProfile = new Profile(nameToAdd, followersToAdd);
                    dbHandler.addProfile(newProfile);
                    break;

                case 2:
                    // SELECT ALL PROFILES
                    System.out.println("\n--- All Profiles from DB ---");
                    List<Profile> profiles = dbHandler.getAllProfiles();
                    if (profiles.isEmpty()) {
                        System.out.println("Database is empty.");
                    } else {
                        for (Profile p : profiles) {
                            System.out.println(p.toString());
                        }
                    }
                    break;

                case 3:
                    // UPDATE PROFILE
                    System.out.println("\n--- Update Followers Count ---");
                    System.out.print("Enter username to update: ");
                    String nameToUpdate = scanner.nextLine();

                    System.out.print("Enter new followers count: ");
                    int newCount = 0;
                    if(scanner.hasNextInt()) {
                        newCount = scanner.nextInt();
                        scanner.nextLine();
                    }

                    dbHandler.updateFollowers(nameToUpdate, newCount);
                    break;

                case 4:
                    // DELETE PROFILE
                    System.out.println("\n--- Delete Profile ---");
                    System.out.print("Enter username to delete: ");
                    String nameToDelete = scanner.nextLine();

                    dbHandler.deleteProfile(nameToDelete);
                    break;

                case 0:
                    // KILL PROGRAM
                    System.out.println("Exiting program. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Unknown command. Please try again.");
            }
            System.out.println("----------------------------------------");
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\nSELECT ACTION:");
        System.out.println("1. Add Profile (INSERT)");
        System.out.println("2. Show All Profiles (SELECT)");
        System.out.println("3. Update Followers (UPDATE)");
        System.out.println("4. Delete Profile (DELETE)");
        System.out.println("0. Exit");
    }
}