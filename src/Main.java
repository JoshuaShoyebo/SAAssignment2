
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Competitor competitor1 = new Competitor(101, "John", "Doe", "USA", "Novice", "Male", 25, new int[]{4, 5, 3, 4, 5});
        Competitor competitor2 = new Competitor(102, "Jane", "Smith", "UK", "Expert","Female", 32, new int[]{5, 5, 5, 5, 5});

//System.out.println(competitor1.getFullDetails());
        //System.out.println(competitor1.getShortDetails());
        //System.out.println("Overall score for competitor 1: " + //competitor1.getOverallScore());

        //System.out.println(competitor2.getFullDetails());
        //System.out.println(competitor2.getShortDetails());
        //System.out.println("Overall score for competitor 2: " + //competitor2.getOverallScore());


        Manager manager = new Manager();
        Competitor competitor;

        // Test reading competitors from CSV
        manager.readCompetitorsFromFiles();

        // Test generating a report
        manager.generateFinalReportToFile();

        Scanner scanner = new Scanner(System.in);

        do{
            System.out.print("Enter competitor number: ");
            int competitorNumber = scanner.nextInt();
            competitor = manager.searchCompetitorByNumber(competitorNumber);

            if (competitor != null) {
                System.out.println(competitor.getShortDetails());
            } else {
                System.out.println("Competitor not found.");

            }
        }while (competitor == null);
    }
}

  