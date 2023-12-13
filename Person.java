
public class Person extends Profile {
    private Interests interests;

    private Person(Builder builder) {
        super(builder.name, builder.age, builder.height, builder.gender, builder.sign);
        this.interests = builder.interests;
    }

    // Static inner Builder class
    public static class Builder {
        private String name;
        private int age;
        private int height;
        private String gender;
        private String sign;
        private Interests interests;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withAge(int age) {
            this.age = age;
            return this;
        }

        public Builder withHeight(int height) {
            this.height = height;
            return this;
        }

        public Builder withGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder withSign(String sign) {
            this.sign = sign;
            return this;
        }

        public Builder withInterests(Interests interests) {
            this.interests = interests;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    // Getter for interests
    public Interests getInterests() {
        return interests;
    }

    // Setter for interests
    public void setInterests(Interests interests) {
        this.interests = interests;
    }

    @Override
    public String getName() {
        return super.getName(); 
    }

    public String toString() {
        return "Person {" +
                "\n  Name: " + getName() +
                "\n  Profile: " + super.toString() + 
                ",\n  Interests: " + interests.toString() + 
                "\n}";
    }
}
