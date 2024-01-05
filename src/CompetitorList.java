import java.util.ArrayList;

public class CompetitorList {

    private ArrayList<Competitor> competitors;

    public CompetitorList() {
        competitors = new ArrayList<>();
    }
    public ArrayList<Competitor> getCompetitors() {
        return competitors; // Returns a reference to the internal list
    }
    public void addCompetitor(Competitor competitor) {
        competitors.add(competitor);
    }

    public Competitor searchCompetitorByNumber(int competitorNumber) {
        for (Competitor competitor : competitors) {
            if (competitor.getCompetitorNumber() == competitorNumber) {
                return competitor;
            }
        }
        return null;
    }

    // Implement other methods as needed, such as:
    // - generateReport()
    // - sortCompetitors()
    // - filterCompetitors()
    // - removeCompetitor()
}

