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
        frame.setSize(650, 250);
        JPanel panel1 = new JPanel();
        JLabel label1 = new JLabel("Competitor Number:");
        JTextField competitorNumberField = new JTextField(5);
        JButton viewDetailsButton = new JButton("View Details");
        panel1.add(label1);
        panel1.add(competitorNumberField);
        panel1.add(viewDetailsButton);
        JPanel panel2 = new JPanel();
        String[] columnNames = {"CN:","Forename", "Surname", "Country", "Gender", "Level", "Age","Min", "Max","Overall","Avg"};
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
        JButton viewCompetitorButton = new JButton("View All Competitors");
        JButton viewNovCompetitorButton = new JButton("View Novices");
        JButton viewAmCompetitorButton = new JButton("View Amateurs");
        JButton viewExCompetitorButton = new JButton("View Experts");

        panel3.add(editDetailsButton);
        panel3.add(removeCompetitorButton);
        panel3.add(addCompetitorButton);
        panel3.add(viewCompetitorButton);
        panel3.add(viewNovCompetitorButton);
        panel3.add(viewAmCompetitorButton);
        panel3.add(viewExCompetitorButton);

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
                JButton saveButton = new JButton("Save");
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
                    JTextField score1Field = new JTextField(String.valueOf(competitor.getScores()[0]), 5);
                    JTextField score2Field = new JTextField(String.valueOf(competitor.getScores()[1]), 5);
                    JTextField score3Field = new JTextField(String.valueOf(competitor.getScores()[2]), 5);
                    JTextField score4Field = new JTextField(String.valueOf(competitor.getScores()[3]), 5);
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
                    editPanel.add(new JLabel("Score 1:"));
                    editPanel.add(score1Field);
                    editPanel.add(new JLabel("Score 2:"));
                    editPanel.add(score2Field);
                    editPanel.add(new JLabel("Score 3:"));
                    editPanel.add(score3Field);
                    editPanel.add(new JLabel("Score 4:"));
                    editPanel.add(score4Field);
                    editPanel.add(saveButton);
                    JFrame editFrame = new JFrame("Edit Competitor Details");
                    editFrame.add(editPanel);
                    editFrame.pack();
                    editFrame.setVisible(true);
                    saveButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            // Update the competitor's scores
                            int[] updatedScores = {
                                    Integer.parseInt(score1Field.getText()),
                                    Integer.parseInt(score2Field.getText()),
                                    Integer.parseInt(score3Field.getText()),
                                    Integer.parseInt(score4Field.getText())
                            };

                            competitor.setScores(updatedScores);



                            editFrame.dispose();

                        }
                    });
                }
            }
        });

        viewNovCompetitorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                tableModel.setRowCount(0);


                ArrayList<Competitor> competitors = CompetitorList.getCompetitors();


                for (Competitor competitor : competitors) {

                    if ("Novice".equals(competitor.getLevel())) {
                        Object[] rowData = {
                                competitor.getCompetitorNumber(),
                                competitor.getForename(),
                                competitor.getSurname(),
                                competitor.getCountry(),
                                competitor.getGender(),
                                competitor.getLevel(),
                                competitor.getAge(),
                                competitor.getMinScore(),
                                competitor.getMaxScore(),
                                competitor.getOverallScore(),
                                competitor.getAverageScore()
                        };
                        tableModel.addRow(rowData);
                    }
                }

                for (int i = 0; i < table.getColumnCount(); i++) {
                    table.getColumnModel().getColumn(i).setPreferredWidth(150);
                }
            }
        });

        viewAmCompetitorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                tableModel.setRowCount(0);

                ArrayList<Competitor> competitors = CompetitorList.getCompetitors();

                for (Competitor competitor : competitors) {

                    if ("Amateur".equals(competitor.getLevel())) {
                        Object[] rowData = {
                                competitor.getCompetitorNumber(),
                                competitor.getForename(),
                                competitor.getSurname(),
                                competitor.getCountry(),
                                competitor.getGender(),
                                competitor.getLevel(),
                                competitor.getAge(),
                                competitor.getMinScore(),
                                competitor.getMaxScore(),
                                competitor.getOverallScore(),
                                competitor.getAverageScore()
                        };
                        tableModel.addRow(rowData);
                    }
                }

                for (int i = 0; i < table.getColumnCount(); i++) {
                    table.getColumnModel().getColumn(i).setPreferredWidth(150);
                }
            }
        });
        viewExCompetitorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                tableModel.setRowCount(0);


                ArrayList<Competitor> competitors = CompetitorList.getCompetitors();


                for (Competitor competitor : competitors) {

                    if ("Expert".equals(competitor.getLevel())) {
                        Object[] rowData = {
                                competitor.getCompetitorNumber(),
                                competitor.getForename(),
                                competitor.getSurname(),
                                competitor.getCountry(),
                                competitor.getGender(),
                                competitor.getLevel(),
                                competitor.getAge(),
                                competitor.getMinScore(),
                                competitor.getMaxScore(),
                                competitor.getOverallScore(),
                                competitor.getAverageScore()
                        };
                        tableModel.addRow(rowData);
                    }
                }

                for (int i = 0; i < table.getColumnCount(); i++) {
                    table.getColumnModel().getColumn(i).setPreferredWidth(150);
                }
            }
        });
        removeCompetitorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int selectedRowIndex = table.getSelectedRow();


                if (selectedRowIndex != -1) {

                    int competitorNumber = (int) table.getValueAt(selectedRowIndex, 0);

                    manager.removeCompetitor(competitorNumber);

                    // Remove the selected row from the DefaultTableModel
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.removeRow(selectedRowIndex);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a row to remove.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
                }
            }
        });


        viewCompetitorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clear existing data in the table
                tableModel.setRowCount(0);


                ArrayList<Competitor> competitors = CompetitorList.getCompetitors();


                for (Competitor competitor : competitors) {
                    Object[] rowData = {
                            competitor.getCompetitorNumber(),
                            competitor.getForename(),
                            competitor.getSurname(),
                            competitor.getCountry(),
                            competitor.getGender(),
                            competitor.getLevel(),
                            competitor.getAge(),
                            competitor.getMinScore(),
                            competitor.getMaxScore(),
                            competitor.getOverallScore(),
                            competitor.getAverageScore()
                    };
                    tableModel.addRow(rowData);
                }
                for (int i = 0; i < table.getColumnCount(); i++) {
                    table.getColumnModel().getColumn(i).setPreferredWidth(150);
                }
            }
        });

        addCompetitorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

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

                Competitor newCompetitor = new Competitor(Competitornummber, forename, surname, country, level, Gender, age, scores) {
                    @Override
                    public String getFullDetailss() {
                        return null;
                    }

                    @Override
                    public String getShortDetailss() {
                        return null;
                    }
                };


                CompetitorList.addCompetitor(newCompetitor);

                Manager.saveCompetitorDetailsToFile(newCompetitor);
            }
        });
        frame.setVisible(true);
    }



    }

