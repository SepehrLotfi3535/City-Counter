
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class CityRepository {
    private final List<City> cities = new ArrayList<>();
    private final Path file = Paths.get("cities.txt");

    public CityRepository() {
        loadCities();
    }

    private void loadCities() {
        if (!Files.exists(file)) {
            return;
        }

        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",", -1);

                if (data.length == 3) {
                    String name = data[0];
                    String area = data[1];

                    try {
                        int population = Integer.parseInt(data[2]);
                        cities.add(new City(name, area, population));
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid saved city: " + line);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Could not load saved cities: " + e.getMessage());
        }
    }

    public boolean exists(String name, String area) {
        for (City city : cities) {
            if (city.getName().equalsIgnoreCase(name)
                    && city.getArea().equalsIgnoreCase(area)) {
                return true;
            }
        }

        return false;
    }

    public void add(City city) {
        cities.add(city);

        try (BufferedWriter writer = Files.newBufferedWriter(
                file,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND)) {

            writer.write(
                city.getName() + "," +
                city.getArea() + "," +
                city.getPopulation()
            );
            writer.newLine();

        } catch (IOException e) {
            cities.remove(city);
            throw new IllegalStateException(
                "Could not save city: " + e.getMessage()
            );
        }
    }

    public int count() {
        return cities.size();
    }
}
