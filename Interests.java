public class Interests {
    private String creativity;
    private String sports;
    private String food;
    private String hobby;
    private String music;
    private String favoriteBooks;
    private String favoriteMovies;
    private String travelDestinations;
    private String personalityTraits;
    private String hometown;
    private String job;

    // Parameterized constructor
    public Interests(String creativity, String sports, String food, String hobby, String music,
                     String favoriteBooks, String favoriteMovies, String travelDestinations,
                     String personalityTraits, String hometown, String job) {
        this.creativity = creativity;
        this.sports = sports;
        this.food = food;
        this.hobby = hobby;
        this.music = music;
        this.favoriteBooks = favoriteBooks;
        this.favoriteMovies = favoriteMovies;
        this.travelDestinations = travelDestinations;
        this.personalityTraits = personalityTraits;
        this.hometown = hometown;
        this.job = job;
    }

    // Getters and setters for each field (not shown for brevity)
    public String getCreativity() {
        return creativity;
    }

    public void setCreativity(String creativity) {
        this.creativity = creativity;
    }

    public String getSports() {
        return sports;
    }

    public void setSports(String sports) {
        this.sports = sports;
    }
    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getFavoriteBooks() {
        return favoriteBooks;
    }

    public void setFavoriteBooks(String favoriteBooks) {
        this.favoriteBooks = favoriteBooks;
    }

    public String getFavoriteMovies() {
        return favoriteMovies;
    }

    public void setFavoriteMovies(String favoriteMovies) {
        this.favoriteMovies = favoriteMovies;
    }

    public String getTravelDestinations() {
        return travelDestinations;
    }

    public void setTravelDestinations(String travelDestinations) {
        this.travelDestinations = travelDestinations;
    }

    public String getPersonalityTraits() {
        return personalityTraits;
    }

    public void setPersonalityTraits(String personalityTraits) {
        this.personalityTraits = personalityTraits;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }


    @Override
    public String toString() {
        return "Interests {" +
               "\n  Creativity: '" + creativity + '\'' +
               ",\n  Sports: '" + sports + '\'' +
               ",\n  Food: '" + food + '\'' +
               ",\n  Hobby: '" + hobby + '\'' +
               ",\n  Music: '" + music + '\'' +
               ",\n  Favorite Books: '" + favoriteBooks + '\'' +
               ",\n  Favorite Movies: '" + favoriteMovies + '\'' +
               ",\n  Travel Destinations: '" + travelDestinations + '\'' +
               ",\n  Personality Traits: '" + personalityTraits + '\'' +
               ",\n  Hometown: '" + hometown + '\'' +
               ",\n  Job: '" + job + '\'' +
               "\n}";
    }
    public double calculateCompatibilityScore(Interests other) {
        double score = 0;
        double totalFields = 11; // total number of interest fields
        if (!this.creativity.isEmpty() && this.creativity.equals(other.creativity)) score++;
        if (!this.sports.isEmpty() && this.sports.equals(other.sports)) score++;
        if (!this.food.isEmpty() && this.food.equals(other.food)) score++;
        if (!this.hobby.isEmpty() && this.hobby.equals(other.hobby)) score++;
        if (!this.music.isEmpty() && this.music.equals(other.music)) score++;
        if (!this.favoriteBooks.isEmpty() && this.favoriteBooks.equals(other.favoriteBooks)) score++;
        if (!this.favoriteMovies.isEmpty() && this.favoriteMovies.equals(other.favoriteMovies)) score++;
        if (!this.travelDestinations.isEmpty() && this.travelDestinations.equals(other.travelDestinations)) score++;
        if (!this.personalityTraits.isEmpty() && this.personalityTraits.equals(other.personalityTraits)) score++;
        if (!this.hometown.isEmpty() && this.hometown.equals(other.hometown)) score++;
        if (!this.job.isEmpty() && this.job.equals(other.job)) score++;

        return (score / totalFields) * 100; // return percentage
    }
}
