# City Counter

A Java terminal program that collects cities (name, area and population), saves them in a database, and shows how many cities were registered when the user types `exit`.

## Requirements
- Ask the user for a city name, area and population
- Check the input (no empty values, no duplicates, population must be a number)
- Save each city in the database
- Stop when the user types `exit` and show the total

## Structure
- `Main.java`: asks the user for input and prints messages and the total
- `CityService.java`: checks the input and decides if a city can be saved
- `CityRepository.java`: saves and counts cities in the database
- `City.java`: holds the data of one city

Flow: Main → CityService → CityRepository

## How to run
1. Clone the repo: `git clone <repo-url>`
2. Open the folder in VS Code (with the Extension Pack for Java)
3. Run `Main.java`

Team Responsibilities
- Khadija: City.java, CityService.java
- Sepehr: CityRepository.java, Main.java
