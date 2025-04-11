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

    private AVAILABLE_LOCALES currentSelectedLanguage;

    public MainFrame() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setVisible(true);

        //init menu bar
        this.setJMenuBar(createMenuBar());

        this.currentSelectedLanguage = AVAILABLE_LOCALES.DE;

        this.updateAfterLanguageChange(this.currentSelectedLanguage);

        ButtonStartRadioButtonTest.addActionListener(createRadioButtonTestActionListener());
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
                LanguageChooser languageChooser = new LanguageChooser(MainFrame.this);
                AVAILABLE_LOCALES selected_local =languageChooser.showDialog();
                if (selected_local != null){
                    MainFrame.this.setCurrentSelectedLanguage(selected_local);
                }
            }
        };
    }


    public void setCurrentSelectedLanguage(AVAILABLE_LOCALES currentSelectedLanguage) {
        this.currentSelectedLanguage = currentSelectedLanguage;
        updateAfterLanguageChange(this.currentSelectedLanguage);
    }

    public AVAILABLE_LOCALES getCurrentSelectedLanguage() {
        return currentSelectedLanguage;
    }

    private void updateAfterLanguageChange(AVAILABLE_LOCALES selectedLanguage){
        i18nHandler.setLocale(this.currentSelectedLanguage);
        this.updateTexts();
        this.updateMnemonics(selectedLanguage);
    }


    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        menuFile = new JMenu(i18nHandler.get("mainframe.menu.File"));

        menuItemChangeLanguage = new JMenuItem(i18nHandler.get("mainframe.menu.File.changeLanguage"));
        menuItemChangeLanguage.addActionListener(this.getChangeLanguageAction());
        menuItemChangeLanguage.setMnemonic('S');

        menuFile.add(menuItemChangeLanguage);
        menuBar.add(menuFile);

        return menuBar;
    }

    private void updateTexts() {
        this.setTitle(i18nHandler.get("mainframe.title"));
        this.menuFile.setText(i18nHandler.get("mainframe.menu.File"));
        this.menuItemChangeLanguage.setText(i18nHandler.get("mainframe.menu.File.changeLanguage"));
    }

    private void updateMnemonics(AVAILABLE_LOCALES selectedLocal) {
        switch (selectedLocal){
            case DE:
                this.menuItemChangeLanguage.setMnemonic('S');
                break;
            case EN:
                this.menuItemChangeLanguage.setMnemonic('L');
                break;
        }

    }
}
