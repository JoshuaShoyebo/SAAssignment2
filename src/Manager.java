import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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


    // Inside your Manager class
    public void removeCompetitor(int competitorNumber) {

        for (Competitor competitor : CompetitorList.getCompetitors()) {
            if (competitor.getCompetitorNumber() == competitorNumber) {
                CompetitorList.getCompetitors().remove(competitor);
                break;
            }
        }
        // Update code to save the updated list of competitors to the file if needed
    }

    public void printCompetitorWithHighestScore() {
        if (CompetitorList.getCompetitors().isEmpty()) {
            System.out.println("No competitors available.");
            return;
        }

        // Find the competitor with the highest score using a Comparator
        Competitor highestScoreCompetitor = CompetitorList.getCompetitors().stream()
                .max(Comparator.comparingDouble(Competitor::getOverallScore))
                .orElse(null);

        System.out.println("Competitor with the highest score:");
        System.out.println(highestScoreCompetitor.getFullDetails());
    }

    public void readCompetitorsFromFiles() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/RunCompetitor.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                int competitorNumber = Integer.parseInt(data[0]);
                String forename = data[1];
                String surname = data[2];
                String country = data[6];
                String level = data[4];
                String Gender = data[5];
                int age = Integer.parseInt(data[3]);
                String[] scoreStrings = Arrays.copyOfRange(data, 7, 11);
                int[] scores = new int[scoreStrings.length];
                for (int i = 0; i < scoreStrings.length; i++) {
                    scores[i] = Integer.parseInt(scoreStrings[i]);
                }

                Competitor competitor = new Competitor(competitorNumber, forename, surname, country, level, Gender, age, scores);

                competitorList.addCompetitor(competitor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public void generateFinalReportToFile() {
        try {
            FileWriter writer = new FileWriter("final_report.txt");

            // Write header
            writer.write("This is Final Competitor Report\n");
            writer.write("| Competitor Number  | Forename        | Surname        | Country  | Gender | Level | Age        | Average Score | Max Score | Min Score | Overall Score |\n");
            writer.write("|--------------------|-----------------|----------------|----------|--------|-------|----------|---------------|---------| --------------|\n");


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

    static void saveCompetitorDetailsToFile(Competitor competitor) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("competitor_details.txt", true))) {
            writer.write("Forename: " + competitor.getForename() + "\n");
            writer.write("Surname: " + competitor.getSurname() + "\n");
            writer.write("Country: " + competitor.getCountry() + "\n");
            writer.write("Gender: " + competitor.getGender() + "\n");
            writer.write("Level: " + competitor.getLevel() + "\n");
            writer.write("Age: " + competitor.getAge() + "\n");

            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Competitor searchCompetitorByNumber(int competitorNumber) {

        return competitorList.searchCompetitorByNumber(competitorNumber);
    }
        public static void main(String[] args) {
            Manager manager = new Manager();
            manager.openGUI();

        }


    public ArrayList<Competitor> getCompetitors() {
        return null;
    }
}






