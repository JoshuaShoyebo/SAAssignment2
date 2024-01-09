import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

public class CompetitorList {

    private static ArrayList<Competitor> competitors;

    public CompetitorList() {
        competitors = new ArrayList<>();
    }
    public static ArrayList<Competitor> getCompetitors() {
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


    public static double getSumOfOverallScores() {
        double sum = 0;
        for (Competitor competitor : competitors) {
            sum += competitor.getOverallScore();
        }
        return sum;
    }

    public static double getMinimumOverallScore() {
        if (competitors.isEmpty()) {
            return 0;
        }

        double minScore = competitors.get(0).getOverallScore();
        for (Competitor competitor : competitors) {
            minScore = Math.min(minScore, competitor.getOverallScore());
        }
        return minScore;
    }

    // Method to get the maximum overall score for all competitors
    public static double getMaximumOverallScore() {
        if (competitors.isEmpty()) {
            return 0;
        }

        double maxScore = competitors.get(0).getOverallScore();
        for (Competitor competitor : competitors) {
            maxScore = Math.max(maxScore, competitor.getOverallScore());
        }
        return maxScore;
    }

    // Method to get the average overall score for all competitors
    public static double getAverageOverallScore() {
        if (competitors.isEmpty()) {
            return 0;
        }

        double sum = 0;
        for (Competitor competitor : competitors) {
            sum += competitor.getOverallScore();
        }
        return sum / competitors.size();
    }

    public void sortCompetitors(Comparator<Competitor> comparator, boolean b) {
        competitors.sort(comparator); //  Java's built-in sorting
    }


    public ArrayList<Competitor> filterCompetitors(Predicate<Competitor> predicate) {
        ArrayList<Competitor> filteredCompetitors = new ArrayList<>();
        for (Competitor competitor : competitors) {
            if (predicate.test(competitor)) {
                filteredCompetitors.add(competitor);
            }
        }
        return filteredCompetitors;
    }



}

