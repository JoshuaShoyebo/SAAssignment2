import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;


public abstract class Competitor {

    private int competitorNumber;
    private String forename;
    private String Surname;
    private String country;
    private String level;
    private String Gender;
    private int age;
    private int[] scores; // Array of integer scores

    // Constructor
    public Competitor(int competitorNumber, String forename, String Surname, String country, String level, String Gender, int age, int[] scores) {
        this.competitorNumber = competitorNumber;
        this.forename = forename;
        this.Surname = Surname;
        this.country = country;
        this.level = level;
        this.Gender = Gender;
        this.age = age;
        this.scores = scores.clone(); // Clone array
    }

    // Getters and setters

    public int getCompetitorNumber() {
        return competitorNumber;
    }

    public String getForename() {
        return this.forename;
    }

    public String getSurname() {
        return this.Surname;
    }

    public String getCountry() {
        return this.country;
    }

    public String getLevel() {
        return this.level;
    }

    public String getGender() {
        return this.Gender;
    }

    public int getAge() {
        return this.age;
    }


    // Setters
    public void setCompetitorNumber(int competitorNumber) {
        this.competitorNumber = competitorNumber;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setScores(int[] scores) {
        this.scores = scores.clone();
    }


    public double getOverallScore() {
        double totalScore = 0;
        for (double score : scores) {
            totalScore += score;
        }
        return (double) totalScore;
    }

    public double getAverageScore() {
        double totalScore = 0;
        for (double score : scores) {
            totalScore += score;
        }
        return (double) totalScore / scores.length;

    }

    public int getMinScore() {
        return Arrays.stream(scores).min().orElse(0);
    }

    public int getMaxScore() {
        return Arrays.stream(scores).max().orElse(0);
    }

    public String getFullDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Competitor number: ").append(competitorNumber).append("\n");
        details.append("ForeName: ").append(forename).append("\n");
        details.append("surname: ").append(Surname).append("\n");
        details.append("Country: ").append(country).append("\n");
        details.append("Level: ").append(level).append("\n");
        details.append("Gender: ").append(Gender).append("\n");
        details.append("Age: ").append(age).append("\n");
        details.append("Average score: ").append(getAverageScore()).append("\n");
        details.append("Max score: ").append(getMaxScore()).append("\n");
        details.append("Min score: ").append(getMinScore()).append("\n");
        details.append("Overall score: ").append(getOverallScore()).append("\n");
        details.append("Scores: ").append(Arrays.toString(scores)).append("\n");

        return details.toString();
    }

    public abstract String getFullDetailss();
    public abstract String getShortDetailss();

    ;

    public String getFullDetailsTable() {
        String details = String.format("| %-18s | %-14s | %-14s | %-9s | %-6s | %-6s | %-10d | %-10.2f | %-10d | %-10d | %-10.2f | ",
                competitorNumber, forename, Surname, country, Gender, level, age, getAverageScore(), getMaxScore(), getMinScore(), getOverallScore());
        return details;
    }

    public String getShortDetails() {
        return "CN " + competitorNumber + " (" + forename.substring(0, 1) + Surname.substring(Surname.lastIndexOf(" ") + 1)
                + ") has overall score " + getOverallScore();
    }

    public int[] getScores() {
        return Arrays.copyOf(scores, scores.length);
    }
    public int[] getScoreArray() {
        System.out.print("Scores: ");
        for (int item : this.scores) {
            System.out.print(item + " ,");
        }
        System.out.println();
        return this.scores;

    }
}
