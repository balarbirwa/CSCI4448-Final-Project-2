import java.util.Scanner;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;



public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume the remaining newline

        System.out.println("Enter your height in cm: ");
        int height = scanner.nextInt();
        scanner.nextLine(); // consume the remaining newline

        System.out.println("Enter your gender: ");
        String gender = scanner.nextLine();

        System.out.println("Enter your star sign: ");
        String sign = scanner.nextLine();

        System.out.println("Enter your job: ");
        String job = scanner.nextLine();
        // ANSI Color Codes
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_PURPLE = "\u001B[35m";

        // Collecting user inputs for each interest field
        System.out.println(ANSI_CYAN + "Enter your creativity interest: " + ANSI_RESET);
        String creativity = scanner.nextLine();

        System.out.println(ANSI_CYAN + "Enter your sports interest: " + ANSI_RESET);
        String sports = scanner.nextLine();

        System.out.println(ANSI_CYAN + "Enter your food interest: " + ANSI_RESET);
        String food = scanner.nextLine();

        System.out.println(ANSI_CYAN + "Enter your hobby: " + ANSI_RESET);
        String hobby = scanner.nextLine();

        System.out.println(ANSI_CYAN + "Enter your music interest: " + ANSI_RESET);
        String music = scanner.nextLine();

        System.out.println(ANSI_CYAN + "Enter your favorite books: " + ANSI_RESET);
        String favoriteBooks = scanner.nextLine();

        System.out.println(ANSI_CYAN + "Enter your favorite movies: " + ANSI_RESET);
        String favoriteMovies = scanner.nextLine();

        System.out.println(ANSI_CYAN + "Enter your travel destinations: " + ANSI_RESET);
        String travelDestinations = scanner.nextLine();

        System.out.println(ANSI_CYAN + "Enter your personality traits: " + ANSI_RESET);
        String personalityTraits = scanner.nextLine();

        System.out.println(ANSI_CYAN + "Enter your hometown: " + ANSI_RESET);
        String hometown = scanner.nextLine();

        // System.out.println("Enter your job: ");
        // String job = scanner.nextLine();
        // System.out.println(ANSI_CYAN + "Enter your job: " + ANSI_RESET);
        // Create an instance of Interests with the user input
        Interests myInterests = new Interests(creativity, sports, food, hobby, music, 
                                              favoriteBooks, favoriteMovies, travelDestinations, 
                                              personalityTraits, hometown, job);

        //Person person = new Person(name, age, height, gender, sign, myInterests);

        // New Builder patter for a Person
        //
        Person person = new Person.Builder()
            .withName(name)
            .withAge(age)
            .withHeight(height)
            .withGender(gender)
            .withSign(sign)
            .withInterests(myInterests)
            .build();

        StringBuilder userData = new StringBuilder();
        userData.append(name).append(",");
        userData.append(age).append(",");
        userData.append(height).append(",");
        userData.append(gender).append(",");
        userData.append(sign).append(",");
        userData.append(job).append(",");
        userData.append(creativity).append(",");
        userData.append(sports).append(",");
        userData.append(food).append(",");
        userData.append(hobby).append(",");
        userData.append(music).append(",");
        userData.append(favoriteBooks).append(",");
        userData.append(favoriteMovies).append(",");
        userData.append(travelDestinations).append(",");
        userData.append(personalityTraits).append(",");
        userData.append(hometown);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("user.txt", true))) {
            writer.write(userData.toString());
            writer.newLine(); // move to a new line for the next user
        } catch (IOException e) {
            e.printStackTrace();
        }


        List<Trait> allTraits = TraitList.getAllTraits();
        System.out.println(ANSI_YELLOW + "\nAvailable Traits:" + ANSI_RESET);
        for (Trait trait : allTraits) {
            System.out.println(ANSI_PURPLE + trait.getTraitName() + ANSI_RESET);
        }

        // Ask the user to select traits
        System.out.println(ANSI_BLUE + "\nEnter the traits you identify with (separated by commas): " + ANSI_RESET);
        String inputTraits = scanner.nextLine();
        String[] chosenTraitNames = inputTraits.split(",");

        // Display the chosen traits
        System.out.println(ANSI_YELLOW + "\nHere are your traits:" + ANSI_RESET);
        for (String traitName : chosenTraitNames) {
            traitName = traitName.trim();
            for (Trait trait : allTraits) {
                if (trait.getTraitName().equalsIgnoreCase(traitName)) {
                    System.out.println(ANSI_GREEN + trait + ANSI_RESET);
                    break;
                }
            }
        }
        System.out.println("\nHere is your profile:");
        System.out.println("+----------------+-----------------------+");
        System.out.printf("| %-14s | %-21s |\n", "Attribute", "Value");
        System.out.println("+----------------+-----------------------+");
        System.out.printf("| %-14s | %-21s |\n", "Name", person.getName());
        System.out.printf("| %-14s | %-21d |\n", "Age", person.getAge());
        System.out.printf("| %-14s | %-21d |\n", "Height", person.getHeight());
        System.out.printf("| %-14s | %-21s |\n", "Gender", person.getGender());
        System.out.printf("| %-14s | %-21s |\n", "Star Sign", person.getStarSign());
        //System.out.printf("| %-14s | %-21s |\n", "Job", person.getJob());
        // Add more lines here for each attribute
        System.out.println("+----------------+-----------------------+");

        // Display the entered interests
        System.out.println("\nHere are your interests:");
        System.out.println(myInterests);


        try {
            CompatibilityCalculator calculator = new CompatibilityCalculator();
            Person mostCompatiblePerson = calculator.getMostCompatiblePerson("user.txt", "users.txt");
        
            if (mostCompatiblePerson != null) {
                System.out.println("\nWould you like to view the profile of your most compatible person? (yes/no)");
                String response = scanner.nextLine().trim().toLowerCase();
                if (response.equals("yes")) {
                    System.out.println("Most Compatible Person's Profile:");
                    System.out.println(mostCompatiblePerson); // Assumes Person class has a meaningful toString() method
                }
            } else {
                System.out.println("No compatible person found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    

        scanner.close();
    }
}
