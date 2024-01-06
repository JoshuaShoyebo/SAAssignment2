import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Manager {

    CompetitorList competitorList;

    public Manager() {
        competitorList = new CompetitorList();
    }

    public void readCompetitorsFromFiles() {
            try {
                // Assuming a single CSV file for now
                File file = new File("C:\\Users\\Joshua\\IdeaProjects\\SA2\\src\\RunCompetitor.csv");
                Scanner scanner = new Scanner(file);

                // Skip the header row (if present)
                if (scanner.hasNextLine()) {
                    scanner.nextLine(); // Consume the header row
                }

                // Read each competitor line
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] data = line.split(",");

                    // Parse data and create Competitor object (adapt as needed)
                    int competitorNumber = Integer.parseInt(data[0]);
                    String forename = data[1];
                    String surname = data[2];
                    String country = data[5];
                    String level = data[4];
                    int age = Integer.parseInt(data[3]);
                    int[] scores = Arrays.stream(data[6].split(" ")).mapToInt(Integer::parseInt).toArray();

                    Competitor competitor = new Competitor(competitorNumber, forename, surname, country, level, age, scores);
                    competitorList.addCompetitor(competitor);
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error: File not found.");
                e.printStackTrace();
            }
        }

        // Use appropriate methods from CompetitorList to add competitors
    

    public void generateFinalReportToFile() {
            try {
                FileWriter writer = new FileWriter("final_report.txt");

                // Write header
                writer.write("Final Competitor Report\n");
                writer.write("-----------------------\n");

                // Write competitor details (adjust formatting as needed)
                for (Competitor competitor : competitorList.getCompetitors()) {
                    writer.write(competitor.getFullDetails() + "\n");
                }

                writer.close();
                System.out.println("Final report generated successfully.");
            } catch (IOException e) {
                System.out.println("Error: Failed to generate report.");
                e.printStackTrace();
            }
        }

    

    public Competitor searchCompetitorByNumber(int competitorNumber) {
        // Delegate search to CompetitorList
        return competitorList.searchCompetitorByNumber(competitorNumber);
    }

   


    }

