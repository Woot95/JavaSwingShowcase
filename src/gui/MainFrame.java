package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    //region private class variables
    private JButton           ButtonStartRadioButtonTest;
    private JButton           button2;
    private JButton           button3;
    private JButton           button4;
    private JMenu             menuFile;
    private JMenuItem         menuItemChangeLanguage;
    private AVAILABLE_LOCALES currentSelectedLanguage;
    //endregion

    //region constructors
    public MainFrame() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setVisible(true);

        this.currentSelectedLanguage = AVAILABLE_LOCALES.DE;

        this.setJMenuBar(createMenuBar());

        this.updateAfterLanguageChange(this.currentSelectedLanguage);

        ButtonStartRadioButtonTest.addActionListener(createRadioButtonTestActionListener());
    }
    //endregion

    //region event handler
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
                AVAILABLE_LOCALES selected_local = languageChooser.showDialog();
                if (selected_local != null) {
                    MainFrame.this.setCurrentSelectedLanguage(selected_local);
                }
            }
        };
    }
    //endregion

    //region getter
    public AVAILABLE_LOCALES getCurrentSelectedLanguage() {
        return currentSelectedLanguage;
    }
    //endregion

    //region setter
    public void setCurrentSelectedLanguage(AVAILABLE_LOCALES currentSelectedLanguage) {
        this.currentSelectedLanguage = currentSelectedLanguage;
        updateAfterLanguageChange(this.currentSelectedLanguage);
    }
    //endregion

    //region public methods
    //endregion

    //region private methods

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

    private void updateAfterLanguageChange(AVAILABLE_LOCALES selectedLanguage) {
        i18nHandler.setLocale(this.currentSelectedLanguage);
        this.updateTexts();
        this.updateMnemonics(selectedLanguage);
    }


    private void updateTexts() {
        this.setTitle(i18nHandler.get("mainframe.title"));
        this.menuFile.setText(i18nHandler.get("mainframe.menu.File"));
        this.menuItemChangeLanguage.setText(i18nHandler.get("mainframe.menu.File.changeLanguage"));
    }

    private void updateMnemonics(AVAILABLE_LOCALES selectedLocal) {
        switch (selectedLocal) {
            case DE:
                this.menuItemChangeLanguage.setMnemonic('S');
                break;
            case EN:
                this.menuItemChangeLanguage.setMnemonic('L');
                break;
        }
    }
    //endregion

}
