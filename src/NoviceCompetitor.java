public class NoviceCompetitor extends Competitor {

    private String hobby;

    public NoviceCompetitor(int competitorNumber, String forename, String Surname, String country, String Gender, int age, int[] scores, String hobby) {
        super(competitorNumber, forename, Surname, country, "Novice", Gender, age, scores);
        this.hobby = hobby;
    }
    public String getHobby() {
        return hobby;}

    public void setHobby() {
        this.hobby = hobby;
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
        details.append("Hobby: ").append(hobby).append("\n");
        details.append("Overall score: ").append(getOverallScore()).append("\n");
        return details.toString();
    }
    public String getShortDetailss() {
        return "CN " + getCompetitorNumber() + " (" + getForename().substring(0, 1) + getSurname().substring(getSurname().lastIndexOf(" ") + 1)
                + ") has overall score " + getOverallScore() + "and has a hobby of  " + hobby;
    }
}
