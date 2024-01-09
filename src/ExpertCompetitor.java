import java.util.Arrays;

public class ExpertCompetitor extends Competitor {
    private String expertiseField;

    public ExpertCompetitor(int competitorNumber, String forename, String Surname, String country, String Gender, int age, int[] scores) {
        super(competitorNumber, forename, Surname, country, "Expert", Gender, age, scores);
    }

    @Override
    public double getOverallScore() {
        return 0;
    }

    public String getFullDetailss() {
        StringBuilder details = new StringBuilder();
        details.append("Competitor number: ").append(getCompetitorNumber()).append("\n");
        details.append("ForeName: ").append(getForename()).append("\n");
        details.append("surname: ").append(getSurname()).append("\n");
        details.append("Country: ").append(getCountry()).append("\n");
        details.append("Level: ").append(getLevel()).append("\n");
        details.append("Gender: ").append(getGender()).append("\n");
        details.append("Age: ").append(getAge()).append("\n");
        details.append("Average score: ").append(getAverageScore()).append("\n");
        details.append("Max score: ").append(getMaxScore()).append("\n");
        details.append("Min score: ").append(getMinScore()).append("\n");
        details.append("Overall score: ").append(getOverallScore()).append("\n");
        return null;
    }
    public String getShortDetails() {
        // Provide specific implementation
        return null;
    }


}
