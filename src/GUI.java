import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
public class GUI {
    public static void main(String[] args) throws IOException {
        Manager manager = new Manager();
        manager.readCompetitorsFromFiles();
        JFrame frame = new JFrame("Competitor Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 250);
        JPanel panel1 = new JPanel();
        JLabel label1 = new JLabel("Competitor Number:");
        JTextField competitorNumberField = new JTextField(10);
        JButton viewDetailsButton = new JButton("View Details");
        panel1.add(label1);
        panel1.add(competitorNumberField);
        panel1.add(viewDetailsButton);
        JPanel panel2 = new JPanel();
        String[] columnNames = {"Welcome to the Competitor Management System please follow the instructions below:"};
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columnNames);
        JTable table = new JTable();
        table.setModel(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        panel2.add(scrollPane);
        JPanel panel3 = new JPanel();
        JButton editDetailsButton = new JButton("Edit Details");
        JButton removeCompetitorButton = new JButton("Remove Competitor");
        JButton addCompetitorButton = new JButton("Add Competitor");
        panel3.add(editDetailsButton);
        panel3.add(removeCompetitorButton);
        panel3.add(addCompetitorButton);
        frame.add(panel1, "North");
        frame.add(panel2, "Center");
        frame.add(panel3, "South");
        viewDetailsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int number = Integer.parseInt(competitorNumberField.getText());
                Competitor competitor = manager.searchCompetitorByNumber(number);
                if (competitor != null) {
                    String[] columns = {"Field", "Value"};
                    Object[][] data = {
                            {"Competitor Number", competitor.getCompetitorNumber()},
                            {"Forename", competitor.getForename()},
                            {"Surname", competitor.getSurname()},
                            {"Country", competitor.getCountry()},
                            {"Gender", competitor.getGender()},
                            {"Level", competitor.getLevel()},
                            {"Age", competitor.getAge()},
                            {"Minimum Score", competitor.getMinScore()},
                            {"Max Score", competitor.getMaxScore()},
                            {"OverallScore", competitor.getOverallScore()},
                            {"Average Score", competitor.getAverageScore()},
                    };
                    DefaultTableModel model = new DefaultTableModel(data, columns);
                    JTable detailsTable = new JTable(model);
                    JScrollPane scrollPane = new JScrollPane(detailsTable);
                    JPanel detailsPanel = new JPanel();
                    detailsPanel.add(new JLabel("Competitor Details:"));
                    detailsPanel.add(scrollPane);
                    JFrame detailsFrame = new JFrame("Competitor Details");
                    detailsFrame.add(detailsPanel);
                    detailsFrame.pack();
                    detailsFrame.setVisible(true);
                }
            }
        });
        editDetailsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int number = Integer.parseInt(competitorNumberField.getText());
                Competitor competitor = manager.searchCompetitorByNumber(number);
                if (competitor != null) {
                    String forename = competitor.getForename();
                    String surname = competitor.getSurname();
                    String country = competitor.getCountry();
                    String level = competitor.getLevel();
                    String gender = competitor.getGender();
                    int age = competitor.getAge();
                    JTextField forenameField = new JTextField(forename, 10);
                    JTextField surnameField = new JTextField(surname, 10);
                    JTextField countryField = new JTextField(country, 10);
                    JTextField levelField = new JTextField(level, 10);
                    JTextField genderField = new JTextField(gender, 10);
                    JTextField ageField = new JTextField(String.valueOf(age), 10);
                    JPanel editPanel = new JPanel();
                    editPanel.add(new JLabel("Forename:"));
                    editPanel.add(forenameField);
                    editPanel.add(new JLabel("Surname:"));
                    editPanel.add(surnameField);
                    editPanel.add(new JLabel("Countries:"));
                    editPanel.add(countryField);
                    editPanel.add(new JLabel("Level:"));
                    editPanel.add(levelField);
                    editPanel.add(new JLabel("Gender:"));
                    editPanel.add(genderField);
                    editPanel.add(new JLabel("Age:"));
                    editPanel.add(ageField);
                    JFrame editFrame = new JFrame("Edit Competitor Details");
                    editFrame.add(editPanel);
                    editFrame.pack();
                    editFrame.setVisible(true);
                }
            }
        });

        addCompetitorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add code to get competitor details from user input
                int Competitornummber = Integer.parseInt(JOptionPane.showInputDialog("Enter Competitor Number:"));
                String forename = JOptionPane.showInputDialog("Enter forename:");
                String surname = JOptionPane.showInputDialog("Enter surname:");
                String country = JOptionPane.showInputDialog("Enter country:");
                String level = JOptionPane.showInputDialog("Enter Level:");
                String Gender = JOptionPane.showInputDialog("Enter Gender:");
                int age = Integer.parseInt(JOptionPane.showInputDialog("Enter Age:"));
                int[] scores = new int[4];
                for (int i = 0; i < 4; i++) {
                    scores[i] = Integer.parseInt(JOptionPane.showInputDialog("Enter score " + (i + 1) + ":"));
                }
                // Add more fields as needed
                // Create new competitor
                Competitor newCompetitor = new Competitor(Competitornummber,forename, surname, country, level, Gender, age, scores);

                // Add new competitor to manager
                CompetitorList.addCompetitor(newCompetitor);
                // Save competitor details to a text file
                Manager.saveCompetitorDetailsToFile(newCompetitor);
            }
        });
        frame.setVisible(true);
    }



    }
