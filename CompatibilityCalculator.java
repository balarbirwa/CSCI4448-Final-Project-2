
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
            String[] parts = line.split(", ");
            // Ensure there are enough parts to construct a Person object
            if (parts.length >= 17) { // changed to 17 to accommodate 11 Interests and 6 Person parameters
                Interests interests = new Interests(parts[6], parts[7], parts[8], parts[9], parts[10], 
                                                    parts[11], parts[12], parts[13], parts[14], parts[15], parts[16]);
                people.add(new Person(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2].replace(" cm", "")), 
                            parts[3], parts[4], interests)); // parts[5] is removed as it's not needed
            }
        }
    
        return people;
    }
    

    public void calculateCompatibility(String currentUserFile, String otherUsersFile) throws IOException {
        Person currentUser = readPeopleFromFile(currentUserFile).get(0); // assumes single line for current user
        List<Person> otherPeople = readPeopleFromFile(otherUsersFile);

        for (Person other : otherPeople) {
            double score = currentUser.getInterests().calculateCompatibilityScore(other.getInterests());
            System.out.printf("Compatibility with %s: %.2f%%\n", other.getName(), score);
        }
    }
}
