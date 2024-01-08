import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Manager {

    CompetitorList competitorList;

    public Manager() {



        competitorList = new CompetitorList();
    }

    public void openGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    GUI gui = new GUI();
                    gui.main(null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void readCompetitorsFromFiles() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/RunCompetitor.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line by comma (or any other delimiter based on the file format)
                String[] data = line.split(",");
                // The data array will now contain all the values from the CSV file for each line
                int competitorNumber = Integer.parseInt(data[0]);
                String forename = data[1];
                String surname = data[2];
                String country = data[6];
                String level = data[4];
                String Gender = data[5];
                int age = Integer.parseInt(data[3]);
                String[] scoreStrings = Arrays.copyOfRange(data, 7, 11);  // Assuming scores are separated by space
                int[] scores = new int[scoreStrings.length];
                for (int i = 0; i < scoreStrings.length; i++) {
                    scores[i] = Integer.parseInt(scoreStrings[i]);
                }
                // Create a new competitor object and add it to the competitor list
                Competitor competitor = new Competitor(competitorNumber, forename, surname, country, level, Gender, age, scores);
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
            writer.write("| Competitor Number  | Forename        | Surname        | Country  | Gender | Level | Age        | Average Score | Max Score | Min Score | Overall Score |\n");
            writer.write("|--------------------|-----------------|----------------|----------|--------|-------|----------|---------------|---------| --------------|\n");

            // Write competitor details (adjust formatting as needed)
            for (Competitor competitor : competitorList.getCompetitors()) {
                writer.write(competitor.getFullDetailsTable() + "\n");
            }


            writer.close();
            System.out.println("Final report generated successfully.");
        } catch (IOException e) {
            System.out.println("Error: Failed to generate report.");
            e.printStackTrace();
        }
    }

    static void saveCompetitorDetailsToFile(Competitor competitor) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("competitor_details.txt", true))) {
            writer.write("Forename: " + competitor.getForename() + "\n");
            writer.write("Surname: " + competitor.getSurname() + "\n");
            writer.write("Country: " + competitor.getCountry() + "\n");
            writer.write("Gender: " + competitor.getGender() + "\n");
            writer.write("Level: " + competitor.getLevel() + "\n");
            writer.write("Age: " + competitor.getAge() + "\n");
            // Add more details as needed
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Competitor searchCompetitorByNumber(int competitorNumber) {
        // Delegate search to CompetitorList
        return competitorList.searchCompetitorByNumber(competitorNumber);
    }
        public static void main(String[] args) {
            Manager manager = new Manager();
            manager.openGUI();

        }


    }






