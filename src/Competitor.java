import java.util.Arrays;

public class Competitor {

    private int competitorNumber;
    private String forename;
    private String Surname;
    private String country;
    private String level;
    private int age;
    private static int[] scores; // Array of integer scores

    // Constructor
    public Competitor(int competitorNumber, String forename, String Surname, String country, String level, int age, int[] scores) {
        this.competitorNumber = competitorNumber;
        this.forename = forename;
        this.Surname = Surname;
        this.country = country;
        this.level = level;
        this.age = age;
        this.scores = scores.clone(); // Clone array
    }

    // Getters and setters (omitted for brevity)
    // Getters
    public int getCompetitorNumber() {
        return competitorNumber;
    }

    public String getForename() {
        return forename;
    }

    public String getSurname() {
        return Surname;
    }

    public String getCountry() {
        return country;
    }

    public String getLevel() {
        return level;
    }

    public int getAge() {
        return age;
    }

    // Setters
    public void setCompetitorNumber(int competitorNumber) {
        this.competitorNumber = competitorNumber;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }
    public void setSurname(String surname) {
        this.Surname = Surname;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // In the Competitor clas


    // Abstract method to be implemented in subclasses
    public int getOverallScore() {
        return 5;
    }


    public String getFullDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Competitor number: ").append(competitorNumber).append("\n");
        details.append("ForeName: ").append(forename).append("\n");
        details.append("surname: ").append(Surname).append("\n");
        details.append("Country: ").append(country).append("\n");
        details.append("Level: ").append(level).append("\n");
        details.append("Age: ").append(age).append("\n");
        details.append("Scores: ").append(Arrays.toString(scores)).append("\n");

        return details.toString();
    }

    public String getShortDetails() {
        return "CN " + competitorNumber + " (" + forename.substring(0, 1) + Surname.substring(Surname.lastIndexOf(" ") +1 )
                + ") has overall score " + getOverallScore();
    }

    public static int[] getScoreArray() {
        System.out.print("Scores: ");
        for (int item : scores) {
            System.out.print(item + " ,");
        }
        System.out.println();
        return scores;
    }

}
