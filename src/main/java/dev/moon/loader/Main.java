package dev.moon.loader;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public final class Main {
    private static final Color BG = new Color(9, 13, 29);
    private static final Color BLUE = new Color(40, 110, 255);
    private static final Color PANEL = new Color(18, 27, 51);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::showWindow);
    }

    private static void showWindow() {
        JFrame frame = new JFrame("MOON3MK LOADER");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 390);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JPanel root = new JPanel();
        root.setBackground(BG);
        root.setBorder(new EmptyBorder(25, 30, 25, 30));
        root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));

        JLabel logo = new JLabel("☾ MOON3MK");
        logo.setFont(new Font("Arial", Font.BOLD, 32));
        logo.setForeground(Color.WHITE);
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("CLIENT LOADER  •  VERSION 1.0.0");
        subtitle.setForeground(new Color(150, 180, 230));
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField license = new JTextField();
        license.setMaximumSize(new Dimension(420, 42));
        license.setFont(new Font("Arial", Font.PLAIN, 15));
        license.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(BLUE),
                "ACTIVATION CODE"));

        JTextField folder = new JTextField();
        folder.setEditable(false);
        folder.setMaximumSize(new Dimension(420, 42));
        folder.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(BLUE),
                "MINECRAFT FOLDER"));

        JButton browse = new JButton("SELECT GAME FOLDER");
        JButton activate = new JButton("ACTIVATE");
        JButton play = new JButton("INSTALL & PLAY");

        style(browse);
        style(activate);
        style(play);

        JLabel status = new JLabel("Waiting for activation");
        status.setForeground(new Color(180, 195, 225));
        status.setAlignmentX(Component.CENTER_ALIGNMENT);

        browse.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            if (chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                folder.setText(chooser.getSelectedFile().getAbsolutePath());
            }
        });

        activate.addActionListener(e ->
                status.setText("Online license server configuration required"));

        play.addActionListener(e ->
                status.setText("Activation and installation are not configured yet"));

        root.add(logo);
        root.add(Box.createVerticalStrut(5));
        root.add(subtitle);
        root.add(Box.createVerticalStrut(25));
        root.add(license);
        root.add(Box.createVerticalStrut(12));
        root.add(folder);
        root.add(Box.createVerticalStrut(8));
        root.add(browse);
        root.add(Box.createVerticalStrut(12));
        root.add(activate);
        root.add(Box.createVerticalStrut(8));
        root.add(play);
        root.add(Box.createVerticalStrut(18));
        root.add(status);

        frame.setContentPane(root);
        frame.setVisible(true);
    }

    private static void style(JButton button) {
        button.setMaximumSize(new Dimension(420, 38));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setBackground(BLUE);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 13));
    }
}
