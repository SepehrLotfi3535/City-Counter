
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CityRepository {
    private List<City> cities = new ArrayList<>();
    private String file = "cities.txt";

    public CityRepository() {
        loadCities();
    }

    private void loadCities() {
        try {
            BufferedReader reader = new BufferedReader(
                new FileReader(file)
            );

            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 3) {
                    int population = Integer.parseInt(data[2]);
                    City city = new City(data[0], data[1], population);
                    cities.add(city);
                }
            }

            reader.close();

        } catch (FileNotFoundException e) {
            // No saved file yet
        } catch (IOException e) {
            System.out.println("Error reading saved cities.");
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

        try {
            BufferedWriter writer = new BufferedWriter(
                new FileWriter(file, true)
            );

            writer.write(city.getName() + "," +
                         city.getArea() + "," +
                         city.getPopulation());
            writer.newLine();
            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving city.");
        }
    }

    public int count() {
        return cities.size();
    }
}
