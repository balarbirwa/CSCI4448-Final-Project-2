public class Trait {
    private String traitName;
    private String description;

    // Constructor
    public Trait(String traitName, String description) {
        this.traitName = traitName;
        this.description = description;
    }

    // Getter for traitName
    public String getTraitName() {
        return traitName;
    }

    // toString method for displaying the trait
    @Override
    public String toString() {
        return "Trait: " + traitName + ", Description: " + description;
    }
}

