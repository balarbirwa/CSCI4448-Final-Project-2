import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class CompatibilityCalculator {

    public List<Person> readPeopleFromFile(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        List<Person> people = new ArrayList<>();
    
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length >= 16) { // Ensure there are enough parts to construct a Person object
                // Assuming the last field (parts[15]) is the 11th interest
                Interests interests = new Interests(parts[6].trim(), parts[7].trim(), parts[8].trim(), 
                                                    parts[9].trim(), parts[10].trim(), parts[11].trim(), 
                                                    parts[12].trim(), parts[13].trim(), parts[14].trim(), 
                                                    parts[15].trim(), parts[15].trim()); // Repeated the last part for the 11th parameter
    
                people.add(new Person(parts[0].trim(), Integer.parseInt(parts[1].trim()), 
                                      Integer.parseInt(parts[2].trim()), parts[3].trim(), 
                                      parts[4].trim(), interests));
            }
        }
    
        return people;
    }

    public void calculateCompatibility(String currentUserFile, String otherUsersFile) throws IOException {
        List<Person> currentUserList = readPeopleFromFile(currentUserFile); 
        if (currentUserList.isEmpty()) {
            System.out.println("No current user found in file: " + currentUserFile);
            return;
        }
        Person currentUser = currentUserList.get(0); // Assumes single line for current user
        List<Person> otherPeople = readPeopleFromFile(otherUsersFile);

        for (Person other : otherPeople) {
            double score = currentUser.getInterests().calculateCompatibilityScore(other.getInterests());
            System.out.printf("Compatibility with %s: %.2f%%\n", other.getName(), score);
        }
    }
}
