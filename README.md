City Counter

City Counter is a small Java terminal program made for our Software Design and Architecture term project. The user enters cities one by one (city name, area and population). Every city is saved in a database, and when the user types exit the program shows how many cities were registered.

Features
Asks the user for a city name, the area it is in, and its population
Checks the input before saving
Saves every valid city in the database
Lets the user enter as many cities as they want
Stops when the user types exit and prints the total number of registered cities
Requirements
The user enters a city name.
The user enters the area (region) of the city.
The user enters the population of the city.
The program saves the city in the database.
The user can enter multiple cities.
When the user types exit, the program stops asking for input and shows the total.
Input rules
City name and area cannot be empty.
Population must be a whole number greater than 0.
The same city in the same area cannot be registered twice, so the count is not inflated.
Technologies
Language: Java
Database: SQLite (through JDBC)
Editor: Visual Studio Code
Version control: Git and GitHub
Project Structure
src/
├── Main.java
├── CityService.java
├── CityRepository.java
└── City.java
File	What it does
Main.java	The user interface. Asks the user for input, prints messages and the final total. This is the file we run.
CityService.java	The business logic. Checks the input and decides if a city can be saved.
CityRepository.java	The data access. Saves cities in the database and counts them.
City.java	The model. Holds the data of one city (id, name, area, population).
Architecture

The program is split into layers, and each layer has only one job. A layer only talks to the layer next to it.

Main  →  CityService  →  CityRepository  →  Database
(input)    (rules)        (saving/counting)

Why we did it this way: if we change the database or the way the user enters data later, we only need to change one file and the others stay the same.

How It Works
Main asks the user for the city name, area and population.
Main sends the values to CityService.
CityService checks them. If something is wrong, it throws an error and Main prints the message.
If everything is fine, CityService sends a City to CityRepository, which saves it.
When the user types exit, Main asks CityService for the total, CityService asks CityRepository to count, and Main prints the result.
Example Run
City Counter (type 'exit' as the city name to finish)
City name (or exit): Istanbul
Area: Marmara
Population: 15000000
Saved.
City name (or exit): Istanbul
Area: Marmara
Population: 15000000
City already registered
City name (or exit): Ankara
Area: Central Anatolia
Population: 5700000
Saved.
City name (or exit): exit
Total cities registered: 2
How to Run
Install a JDK. To check, run java -version and javac -version in the terminal.
Clone the repository:
   git clone <repository-url>
Open the project folder in VS Code (with the Extension Pack for Java installed).
Open src/Main.java and click Run above the main method.
Type the city details when asked, and type exit to finish.
Team
Khadija: City.java, CityService.java
Sepher: Main.java, CityRepository.java
