import javax.swing.*;
import java.io.*;
import java.util.*;

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



    public void removeCompetitor(int competitorNumber) {

        for (Competitor competitor : CompetitorList.getCompetitors()) {
            if (competitor.getCompetitorNumber() == competitorNumber) {
                CompetitorList.getCompetitors().remove(competitor);
                break;
            }
        }

    }

    public void printCompetitorWithHighestScore() {

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

                Competitor competitor = new Competitor(competitorNumber, forename, surname, country, level, Gender, age, scores) {
                    @Override
                    public String getFullDetailss() {
                        return null;
                    }

                    @Override
                    public String getShortDetailss() {
                        return null;
                    }
                };

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

            writer.write("\nFrequency Report - Scores awarded:\n");
            Map<Integer, Integer> scoreFrequency = new HashMap<>();
            for (Competitor c : competitorList.getCompetitors()) {
                for (int score : c.getScores()) {
                    scoreFrequency.put(score, scoreFrequency.getOrDefault(score, 0) + 1);
                }

            }
            for (Map.Entry<Integer, Integer> entry : scoreFrequency.entrySet()) {
                writer.write("Score " + entry.getKey() + " awarded " + entry.getValue() + " time(s)\n");
            }
            writer.write("\n");
            if (CompetitorList.getCompetitors().isEmpty()) {
                writer.write("No competitors available.");
                return;
            }

            Competitor highestScoreCompetitor = CompetitorList.getCompetitors().stream()
                    .max(Comparator.comparingDouble(Competitor::getOverallScore))
                    .orElse(null );

            writer.write("Competitor with the highest score:");
            writer.write(highestScoreCompetitor.getFullDetails());

            writer.write("\n");
            writer.write("Total Overall Score for all Competitors is : " + competitorList.getSumOfOverallScores());
            writer.write("\n");
            writer.write("Total Minimum Score for all Competitors is : " + competitorList.getMinimumOverallScore());
            writer.write("\n");
            writer.write("Total Maximum Score for all Competitors is : " + competitorList.getMaximumOverallScore());
            writer.write("\n");
            writer.write("Total Average Score for all Competitors is : " + competitorList.getAverageOverallScore());



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






