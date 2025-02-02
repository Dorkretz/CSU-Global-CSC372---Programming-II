package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

    public class UserInterface extends JFrame {
        private JTextArea textArea;
        private Color randomGreenHue;

        // Window settings
        public UserInterface() {
            setTitle("Java UI");
            setSize(1000, 1000);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            // Adds text area inside pane
            textArea = new JTextArea();
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setOpaque(false);
            scrollPane.getViewport().setOpaque(false);
            textArea.setOpaque(false);

            // Sets pane layout
            getContentPane().setLayout(new BorderLayout());
            getContentPane().add(scrollPane, BorderLayout.CENTER);

            // Creates menu
            JMenuBar menuBar = new JMenuBar();
            JMenu menu = new JMenu("Options");
            menuBar.add(menu);
            setJMenuBar(menuBar);

            // Add menu items with actions
            addMenuItem(menu, "Show Date/Time", e -> textArea.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\n"));
            addMenuItem(menu, "Save to File", e -> saveToFile());
            addMenuItem(menu, "Change Background", e -> changeBackground());
            addMenuItem(menu, "Exit", e -> System.exit(0));
        }

        /**
         * Method to create a menu item
         */
        private void addMenuItem(JMenu menu, String title, ActionListener action) {
            JMenuItem item = new JMenuItem(title);
            item.addActionListener(action);
            menu.add(item);
        }

        /**
         * Saves the content to a text file named "log.txt"
         */
        private void saveToFile() {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true))) {
                writer.write(textArea.getText() + "\n");
                JOptionPane.showMessageDialog(this, "Saved to log.txt");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving to file", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        /**
         * Changes the background color to a random green hue when clicked
         */
        private void changeBackground() {
            Color newGreenHue = getRandomGreenColor();
            getContentPane().setBackground(newGreenHue);
            repaint();
        }

        /**
         * Generates a new random green hue by keeping the previous green component
         * Returns a color with a random shade of green
         */
        private Color getRandomGreenColor() {
            Random rand = new Random();
            return new Color(rand.nextInt(56), 200 + rand.nextInt(56), rand.nextInt(56));
        }

        /**
         * Main method to launch application
         */
        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> new UserInterface().setVisible(true));
        }
    }