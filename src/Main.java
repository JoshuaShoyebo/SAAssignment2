public class Main {
    public static void main(String[] args) {
    Competitor competitor1 = new Competitor(101, "John Doe", "USA", "Novice", 25, new int[]{4, 5, 3, 4, 5});
    Competitor competitor2 = new Competitor(102, "Jane Smith", "UK", "Expert", 32, new int[]{5, 5, 5, 5, 5});
    Competitor competitor3 = new Competitor(103, "Jane Doe", "USA", "Expert", 35, new int[]{5, 5, 5, 5, 5});

        System.out.println(competitor1.getFullDetails());
        System.out.println(competitor1.getShortDetails());
        System.out.println("Overall score for competitor 1: " + competitor1.getOverallScore());

        System.out.println(competitor2.getFullDetails());
        System.out.println(competitor2.getShortDetails());
        System.out.println("Overall score for competitor 2: " + competitor2.getOverallScore());

        System.out.println(competitor3.getFullDetails());
        System.out.println(competitor3.getShortDetails());
        System.out.println("Overall score for competitor 3: " + competitor3.getOverallScore());

    }
}
