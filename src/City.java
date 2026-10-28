
public class City {
    private String name;
    private String area;
    private int population;

    public City(String name, String area, int population) {
        this.name = name;
        this.area = area;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public String getArea() {
        return area;
    }

    public int getPopulation() {
        return population;
    }
}
