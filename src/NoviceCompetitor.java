public class NoviceCompetitor extends Competitor {

    private String hobby;

    public NoviceCompetitor(int competitorNumber, String forename, String Surname, String country, String Gender, int age, int[] scores) {
        super(competitorNumber, forename, Surname, country, "Novice", Gender, age, scores);
    }


    @Override
    public double getOverallScore() {

        return 0;
    }

    public String getFullDetailss() {

        return null;
    }
    public String getShortDetails() {

        return null;
    }
}
