package gui;

import javax.swing.*;
import java.awt.event.*;

public class LanguageChooser extends JDialog {
    private JFrame parent;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox<String> ComboBoxLanguageChooser;
    private AVAILABLE_LOCALES selectedLocale = null;

    public LanguageChooser(JFrame parent) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setSize(300, 150);

        this.parent = parent;

        for (AVAILABLE_LOCALES availableLocales : AVAILABLE_LOCALES.getAll()) {
            ComboBoxLanguageChooser.addItem(availableLocales.getDisplayName() + " / " + availableLocales.getLocale());
        }


        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

    }

    private void onOK() {
        int index = ComboBoxLanguageChooser.getSelectedIndex();
        if (index >= 0) {
            selectedLocale = AVAILABLE_LOCALES.getAll().get(index);
        }
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public AVAILABLE_LOCALES showDialog() {
        pack();
        setVisible(true); // blockiert hier bis dispose()
        return selectedLocale;
    }

    public static void main(String[] args) {
        //LanguageChooser dialog = new LanguageChooser();
        //dialog.pack();
        //dialog.setVisible(true);
        //System.exit(0);
    }
}
