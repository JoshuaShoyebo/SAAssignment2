public class AmateurCompetitor extends Competitor {
    // Additional attributes specific to AmateurCompetitor
    private String hobby;

    public AmateurCompetitor(int competitorNumber, String forename, String Surname, String country, String Gender, int age, int[] scores) {
        super(competitorNumber, forename, Surname, country, "Novice", Gender, age, scores);
    }

    // Implement abstract method with AmateurCompetitor-specific logic
    @Override
    public double getOverallScore() {
        // ExpertCompetitor-specific implementation
        // Calculate overall score based on expertise-specific logic
        return 0; // Replace with actual calculation
    }

    public String getFullDetailss() {
        // Provide specific implementation
        return null;
    }
    public String getShortDetails() {
        // Provide specific implementation
        return null;
    }
}
