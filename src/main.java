
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CityRepository repository = new CityRepository();
        CityService service = new CityService(repository);

        System.out.println("=== City Counter ===");

        while (true) {
            System.out.print("Enter city name (or 'exit' to finish): ");
            String name = scanner.nextLine().trim();

            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Enter area: ");
            String area = scanner.nextLine().trim();

            System.out.print("Enter population: ");
            int population;

            try {
                population = Integer.parseInt(scanner.nextLine().trim());

                if (population < 0) {
                    System.out.println("Population cannot be negative.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number for population.");
                continue;
            }

            try {
                service.registerCity(name, area, population);
                System.out.println("City registered successfully!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("\nTotal registered cities: " + service.totalCities());

        scanner.close();
    }
}
