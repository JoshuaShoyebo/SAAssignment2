import java.util.Arrays;

public class ExpertCompetitor extends Competitor {
    private String Field;

    public ExpertCompetitor(int competitorNumber, String forename, String Surname, String country, String Gender, int age, int[] scores, String Field) {
        super(competitorNumber, forename, Surname, country, "Expert", Gender, age, scores);
        this.Field = Field;
    }
    public String getField() {
        return Field;}

    public void setField() {
        this.Field = Field;
    }
    @Override
    public double getOverallScore() {
        int[] scores = getScores();        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        return (double) sum / scores.length;
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
        details.append("Field: ").append(Field).append("\n");
        details.append("Overall score: ").append(getOverallScore()).append("\n");
        return details.toString();
    }
    public String getShortDetailss() {
        return "CN " + getCompetitorNumber() + " (" + getForename().substring(0, 1) + getSurname().substring(getSurname().lastIndexOf(" ") + 1)
                + ") has overall score " + getOverallScore() + "and is in the field of " + Field;

    }


}
