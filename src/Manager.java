import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;

public class Manager {

    CompetitorList competitorList;

    public Manager() {
        competitorList = new CompetitorList();
    }

    public void readCompetitorsFromFiles() {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Joshua\\IdeaProjects\\SA2\\src\\RunCompetitor.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line by comma (or any other delimiter based on the file format)
                String[] data = line.split(",");
                // The data array will now contain all the values from the CSV file for each line
                int competitorNumber = Integer.parseInt(data[0]);
                String forename = data[1];
                String surname = data[2];
                String country = data[5];
                String level = data[4];
                int age = Integer.parseInt(data[3]);
                String[] scoreStrings = Arrays.copyOfRange(data, 6, 10);  // Assuming scores are separated by space
                int[] scores = new int[scoreStrings.length];
                for (int i = 0; i < scoreStrings.length; i++) {
                    scores[i] = Integer.parseInt(scoreStrings[i]);
                }
                // Create a new competitor object and add it to the competitor list
                Competitor competitor = new Competitor(competitorNumber, forename, surname, country, level, age, scores);
                // Add the competitor to the competitor list
                competitorList.addCompetitor(competitor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Use appropriate methods from CompetitorList to add competitors


    public void generateFinalReportToFile() {
        try {
            FileWriter writer = new FileWriter("final_report.txt");

            // Write header
            writer.write("This is Final Competitor Report\n");
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

