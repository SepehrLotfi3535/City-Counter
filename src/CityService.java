
public class CityService {
    private final CityRepository repository;

    public CityService(CityRepository repository) {
        this.repository = repository;
    }

    public void registerCity(String name, String area, int population) {
        name = name.trim();
        area = area.trim();

        if (name.isEmpty() || area.isEmpty()) {
            throw new IllegalArgumentException(
                "City and area cannot be empty"
            );
        }

        if (population < 0) {
            throw new IllegalArgumentException(
                "Population cannot be negative"
            );
        }

        if (repository.exists(name, area)) {
            throw new IllegalArgumentException(
                "City already registered"
            );
        }

        repository.add(new City(name, area, population));
    }

    public int totalCities() {
        return repository.count();
    }
}
