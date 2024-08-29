import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        /*
         * 2 Points: Create two lists
         * A list of Strings filled with people's names
         * A corresponding list of sets. The sets contain the countries visited
         * by the corresponding name in the other list.
         */

        // Setup
        Scanner sc = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>(List.of("DavidB", "DavidG", "Martina", "Alain",
                "Brady", "Joey", "DeAngelo", "Wren", "Afseen"));

        ArrayList<HashSet<String>> countries = new ArrayList<>();
        countries.add(new HashSet<>(List.of("America", "Mexico", "China"))); // index 0 DavidB
        countries.add(new HashSet<>(List.of("America", "Mexico", "Greece"))); // index 1 DavidG
        countries.add(new HashSet<>(List.of("America", "Italy", "Finland"))); // index 2 Martina
        countries.add(new HashSet<>(List.of("America", "Russia", "Spain"))); // index 3 Alain
        countries.add(new HashSet<>(List.of("America", "China", "UK"))); // index 4 Brady
        countries.add(new HashSet<>(List.of("America", "Germany", "France"))); // index 5 Joey
        countries.add(new HashSet<>(List.of("America", "Jamaica", "Canada"))); // index 6 DeAngelo
        countries.add(new HashSet<>(List.of("America", "Mexico", "Barcelona"))); // index 7 Wren
        countries.add(new HashSet<>(List.of("America", "India", "Canada"))); // index 8 Afseen

        boolean runProgram = true;

        while (runProgram) {

            // Body
            int choice = menu();
            if (choice == 1) {
                choice1(names, countries);
            } else if (choice == 2) {
                choice2(names, countries);

            } else if (choice == 3) {
                choice3(names, countries);
            } else if (choice == 4) {
                System.out.println("Goodbye ");
                runProgram = false;
            } else {
                System.out.println("Invalid response");
            }

        }

    }

    // methods
    public static int menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please make a selection: ");
        System.out.println("(1) Search for people who visited a country ");
        System.out.println("(2) Add a country to a person's set of visited countries ");
        System.out.println("(3) List the countries a person has visited ");
        System.out.println("(4) Quit ");
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

    public static void choice1(ArrayList<String> names, ArrayList<HashSet<String>> countries) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What country would you like to search for?");
        String country_response = sc.nextLine();
        System.out.println(String.format("The following people have visited %s:", country_response));
        for (int i = 0; i < names.size(); i++) {
            HashSet<String> cCountry = countries.get(i);
            if (cCountry.contains(country_response)) {
                System.out.println(names.get(i));
            } else {
                continue;
            }
        }
    }

    public static void choice2(ArrayList<String> names, ArrayList<HashSet<String>> countries) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Who would you like to add a country too?");
        String response_name = sc.nextLine();
        System.out.println("What country would you like to add for this person?");
        String response_country = sc.nextLine();
        for (int i = 0; i < names.size(); i++) {
            String cName = names.get(i);

            if (cName.equals(response_name)) {
                countries.get(i).add(response_country);
            } else {
                continue;
            }

        }

    }

    public static void choice3(ArrayList<String> names, ArrayList<HashSet<String>> countries) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Who would you like to see the countries they've visited?");
        String response_name = sc.nextLine();

        for (int i = 0; i < names.size(); i++) {

            String cName = names.get(i);
            if (cName.equals(response_name)) {

                System.out.println(countries.get(i));
            } else {
                
                continue;
            }
        }

    }

}
