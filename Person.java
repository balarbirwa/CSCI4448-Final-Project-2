//import person.Interests;
//import ./Interests;

public class Person extends Profile {
    private Interests interests;

    // Default constructor
    public Person() {
        super(); // Calls the default constructor of Profile
        this.interests = new Interests("", "", "", "", "", "", "", "", "", "", "");
    }

    // Parameterized constructor
    public Person(String name, int age, int height, String gender, String sign, Interests interests) {
        super(name, age, height, gender, sign); // Pass name to Profile
        this.interests = interests;
    }

    // Getter and setter for interests
    public Interests getInterests() {
        return interests;
    }

    public void setInterests(Interests interests) {
        this.interests = interests;
    }

    @Override
    public String getName() {
        return super.getName(); // Assuming the getName method is defined in the Profile class
    }
    public String toString() {
        return "Person {" +
               "\n  Profile: " + super.toString() + // Calls toString of Profile class
               ",\n  Interests: " + interests.toString() + // Calls toString of Interests class
               "\n}";
    }
}
