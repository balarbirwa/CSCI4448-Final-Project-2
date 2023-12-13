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
            if (parts.length >= 16) { 
                Interests interests = new Interests(parts[6].trim(), parts[7].trim(), parts[8].trim(),
                        parts[9].trim(), parts[10].trim(), parts[11].trim(),
                        parts[12].trim(), parts[13].trim(), parts[14].trim(),
                        parts[15].trim(), parts[15].trim()); 

                // New builder pattern
                Person person = new Person.Builder()
                        .withName(parts[0].trim())
                        .withAge(Integer.parseInt(parts[1].trim()))
                        .withHeight(Integer.parseInt(parts[2].trim()))
                        .withGender(parts[3].trim())
                        .withSign(parts[4].trim())
                        .withInterests(interests)
                        .build();

                people.add(person);
            }
        }

        return people;
    }

    public Person getMostCompatiblePerson(String currentUserFile, String otherUsersFile) throws IOException {
        List<Person> currentUserList = readPeopleFromFile(currentUserFile);
        if (currentUserList.isEmpty()) {
            System.out.println("No current user found in file: " + currentUserFile);
            return null;
        }
        Person currentUser = currentUserList.get(0);
        List<Person> otherPeople = readPeopleFromFile(otherUsersFile);

        Person mostCompatiblePerson = null;
        double highestScore = 0;

        System.out.println("People with compatibility greater than 0:");
        for (Person other : otherPeople) {
            double score = currentUser.getInterests().calculateCompatibilityScore(other.getInterests());
            if (score > 0) {
                System.out.printf("Compatibility with %s: %.2f%%\n", other.getName(), score);
            }
            if (score > highestScore) {
                highestScore = score;
                mostCompatiblePerson = other;
            }
        }

        return mostCompatiblePerson;
    }

}
