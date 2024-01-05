import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Competitor competitor1 = new Competitor(101, "Joshua", "Vine", "UK", "Expert", 34, new int[]{6, 8, 10, 12, 14});
        Competitor competitor2 = new Competitor(101, "John", "Doe", "UK", "Expert", 35, new int[]{5, 7, 6, 5, 4});
        Competitor competitor3 = new Competitor(101, "kelly", "love", "UK", "Expert", 32, new int[]{5, 5, 5, 6, 7});

        System.out.println(competitor1.getFullDetails());
        System.out.println(competitor1.getShortDetails());
        System.out.println("Overall score for competitor 1: " + competitor1.getOverallScore());

        System.out.println(competitor2.getFullDetails());
        System.out.println(competitor2.getShortDetails());
        System.out.println("Overall score for competitor 2: " + competitor2.getOverallScore());

        System.out.println(competitor3.getFullDetails());
        System.out.println(competitor3.getShortDetails());
        System.out.println("Overall score for competitor 3: " + competitor3.getOverallScore());


        public static void main(String[] args) {
                Manager manager = new Manager();

                // Test reading competitors from CSV
                manager.readCompetitorsFromFiles();

                // Test generating a report
                manager.generateFinalReportToFile();

                // Test filtering competitors (example)
                ArrayList<Competitor> filteredCompetitors = manager.competitorList.filterCompetitors(competitor -> competitor.getAge() >= 18);
                System.out.println("Filtered Competitors (age 18 or above):");
                for (Competitor competitor : filteredCompetitors) {
                    System.out.println(competitor.getFullDetails());
                }

                // Test sorting competitors (example)
                manager.competitorList.sortCompetitors((c1, c2) -> c2.getOverallScore() - c1.getOverallScore()); // Sort by descending overall score
                System.out.println("\nSorted Competitors (by overall score, descending):");
                for (Competitor competitor : manager.competitorList.getCompetitors()) {
                    System.out.println(competitor.getShortDetails()); // Print short details
                }

                // Test GUI (if implemented
        }


    }
}

