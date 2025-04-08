package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JButton ButtonStartRadioButtonTest;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    private JMenu menuFile;
    private JMenuItem menuItemChangeLanguage;

    public MainFrame() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setVisible(true);

        //init menu bar
        this.setJMenuBar(createMenuBar());

        this.updateTexts();

        ButtonStartRadioButtonTest.addActionListener(createRadioButtonTestActionListener());
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        menuFile = new JMenu(i18nHandler.get("mainframe.menu.File"));
        menuItemChangeLanguage = new JMenuItem(i18nHandler.get("mainframe.menu.File.changeLanguage"));
        menuItemChangeLanguage.addActionListener(this.getChangeLanguageAction());

        menuFile.add(menuItemChangeLanguage);
        menuBar.add(menuFile);

        return menuBar;
    }

    private ActionListener createRadioButtonTestActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
    }

    private ActionListener getChangeLanguageAction() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LanguageChooser languageChooser = new LanguageChooser();
                AVAILABLE_LOCALES selected_local = languageChooser.showDialog();
                i18nHandler.setLocale(selected_local.getLocale());
                updateTexts();
            }
        };
    }

    private void updateTexts() {
        this.setTitle(i18nHandler.get("mainframe.title"));
        this.menuFile.setText(i18nHandler.get("mainframe.menu.File"));
        this.menuItemChangeLanguage.setText(i18nHandler.get("mainframe.menu.File.changeLanguage"));
    }
}
