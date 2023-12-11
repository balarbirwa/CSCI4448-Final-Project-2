
public class Profile {

    private String name;
    private int age;
    private int height;
    private String gender;
    private String sign;
    // Default constructor
    public Profile() {
        this.name = "";
        this.age = 0;
        this.height = 0;
        this.gender = "";
        this.sign = "";
    }

    // Parameterized constructor
    public Profile(String n, int a, int h, String g, String ss) {
        this.name = n;
        this.age = a;
        this.height = h;
        this.gender = g;
        this.sign = ss;
    }

    // Getters

    public String getName()
    {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public String getGender() {
        return gender;
    }

    public String getStarSign() {
        return sign;
    }

    // Setters
    public void setName(String n){
        this.name = n;
    }


    public void setAge(int a) {
        this.age = a;
    }

    public void setHeight(int h) {
        this.height = h;
    }

    public void setGender(String g) {
        this.gender = g;
    }

    public void setStarSign(String ss) {
        this.sign = ss;
    }
}
