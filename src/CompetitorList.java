import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

public class CompetitorList {

    private static ArrayList<Competitor> competitors;

    public CompetitorList() {
        competitors = new ArrayList<>();
    }
    public ArrayList<Competitor> getCompetitors() {
        return competitors; // Returns a reference to the internal list
    }
    public static void addCompetitor(Competitor competitor) {
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
    // In the CompetitorList class:
    public void sortCompetitors(Comparator<Competitor> comparator, boolean b) {
        competitors.sort(comparator); //  Java's built-in sorting
    }

    // In the CompetitorList class:
    public ArrayList<Competitor> filterCompetitors(Predicate<Competitor> predicate) {
        ArrayList<Competitor> filteredCompetitors = new ArrayList<>();
        for (Competitor competitor : competitors) {
            if (predicate.test(competitor)) {
                filteredCompetitors.add(competitor);
            }
        }
        return filteredCompetitors;
    }


    // - removeCompetitor()
}

