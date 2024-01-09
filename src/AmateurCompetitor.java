public class AmateurCompetitor extends Competitor {

    private String relationship;

    public AmateurCompetitor(int competitorNumber, String forename, String Surname, String country, String Gender, int age, int[] scores, String relationship) {
        super(competitorNumber, forename, Surname, country, "Novice", Gender, age, scores);
        this.relationship = relationship;
    }

    public String getrelationship() {
        return relationship;}

    public void setrelationship() {
        this.relationship =relationship;
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
        details.append("Relationship Status: ").append(relationship).append("\n");
        details.append("Overall score: ").append(getOverallScore()).append("\n");
        return details.toString();
    }

    @Override
    public String getShortDetailss() {
            return "CN " + getCompetitorNumber() + " (" + getForename().substring(0, 1) + getSurname().substring(getSurname().lastIndexOf(" ") + 1)
                    + ") has overall score " + getOverallScore() + "and a relationship status : " + relationship;
        }
    }


