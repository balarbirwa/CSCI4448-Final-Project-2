import java.util.Arrays;
import java.util.List;

public class TraitList {
    public static List<Trait> getAllTraits() {
        return Arrays.asList(
            new Trait("Outgoing", "Comfortable in social settings and meeting new people."),
            new Trait("Empathetic", "Able to understand and share the feelings of others."),
            new Trait("Creative", "Skilled in creating and thinking of new ideas."),
            new Trait("Adventurous", "Eager to explore new experiences."),
            new Trait("Intellectual", "Enjoying intellectual discussions and pursuits."),
            new Trait("Humorous", "Has a good sense of humor and enjoys making people laugh."),
            new Trait("Passionate", "Deeply committed and enthusiastic about certain ideas or activities."),
            new Trait("Practical", "Focused on dealing with things sensibly and realistically."),
            new Trait("Ambitious", "Having a strong desire and determination to succeed."),
            new Trait("Caring", "Displaying kindness and concern for others.")
        );
    }
}
