import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        Competitor competitor1 = new Competitor(101, "Joshua", "Vine", "UK", "Expert", 34, new int[]{6, 8, 10, 12});
        Competitor competitor2 = new Competitor(102, "John", "Doe", "UK", "Expert", 35, new int[]{5, 7, 6, 6});
        Competitor competitor3 = new Competitor(103, "Jane", "Doe", "UK", "Expert", 36, new int[]{4, 5, 6, 7});


        System.out.println(competitor1.getFullDetails());
        System.out.println(competitor1.getShortDetails());
        System.out.println("Overall score for competitor 2: " + competitor1.getOverallScore());

        System.out.println(competitor2.getFullDetails());
        System.out.println(competitor2.getShortDetails());
        System.out.println("Overall score for competitor 2: " + competitor2.getOverallScore());




                Manager manager = new Manager();

                // Test reading competitors from CSV
                manager.readCompetitorsFromFiles();

                // Test generating a report
                manager.generateFinalReportToFile();

                // Test filtering competitors (example)

                }

                // Test GUI (if implemented
        }





