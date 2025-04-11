package gui;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LanguageChooser extends JDialog {
    //region private variables
    private JFrame            parent;
    private JPanel            contentPane;
    private JButton           buttonOK;
    private JButton           buttonCancel;
    private JComboBox<String> ComboBoxLanguageChooser;
    private AVAILABLE_LOCALES selectedLocale = null;
    //endregion

    //region constructors
    public LanguageChooser(JFrame parent) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setSize(300, 150);

        this.setParent(parent);

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
    //endregion

    //region getter
    @Override
    public JFrame getParent() {
        return parent;
    }
    //endregion

    //region setter
    public void setParent(JFrame parent) {
        this.parent = parent;
    }
    //endregion

    //region event handler
    private void onOK() {
        int index = ComboBoxLanguageChooser.getSelectedIndex();
        if (index >= 0) {
            selectedLocale = AVAILABLE_LOCALES.getAll().get(index);
        }
        dispose();
    }

    private void onCancel() {
        dispose();
    }
    //endregion

    //region public methods
    public AVAILABLE_LOCALES showDialog() {
        pack();
        setVisible(true);
        return selectedLocale;
    }
    //endregion

}
