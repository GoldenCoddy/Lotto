import javax.swing.*;
import java.awt.event.*;


public class Banane extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JSpinner spinner3;
    private JSpinner spinner4;
    private JSpinner spinner5;
    private JSpinner spinner6;
    private JButton checkmynumbers;
    private JButton quicktippButton;
    private JTextPane textPane1;
    private boolean hasahackinghaxorhackedme = false;
    private JButton Auswertung;
    private JButton ziehen;
    private JLabel Label1;
    private JButton buttonCancel;
    private sortmaschine_exe sortmatschine = new sortmaschine_exe();
    private otto maoam = new otto(6,49, 1, false);
    private WerteDatAuself OutWorther = new WerteDatAuself(hasahackinghaxorhackedme);
    private int[]  getippt = new int[6];
    private int[]  gezogen = new int[6];
    private int richtige;


    public Banane() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        /*buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });*/

        /* call onCancel() when cross is clicked
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
        */
        checkmynumbers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCheck();
            }
        });
        ziehen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onZiehung();
            }
        });
        Auswertung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onVergLeiche();
            }
        });
        quicktippButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onQuickTipp();
            }
        });
    }

    private void onOK() {

    }

    private void onQuickTipp() {
        onCheck();
        onZiehung();
        onVergLeiche();
    }

    private void onVergLeiche() {
        richtige = OutWorther.richtige(getippt, gezogen);
        System.out.println(richtige);
        if (richtige == 1) {
            Label1.setText("Sie haben 1 richtigen.");
        } else {
            Label1.setText("Sie haben " + String.valueOf(richtige) + " richtige.");
        }
    }

    private void onCheck() {
        //spinner1.getValue();
        //getippt[1] = spinner1.getValue();
        getippt[0] = (int) spinner1.getValue();
        getippt[1] = (int) spinner2.getValue();
        getippt[2] = (int) spinner3.getValue();
        getippt[3] = (int) spinner4.getValue();
        getippt[4] = (int) spinner5.getValue();
        getippt[5] = (int) spinner6.getValue();
        //sortmatschine = new sortmaschine_exe();
        getippt = sortmatschine.sortmyfoo(getippt);
        //hier
        //boolean dublicate = false;
        boolean sucessful = false;
        while (!sucessful) {
            getippt = sortmatschine.sortmyfoo(getippt);
            sucessful = true;
            for (int i = 0; i < getippt.length - 1; i++) {
                if (getippt[i] == getippt[i + 1]) {
                    //dublicate = true;
                    sucessful = false;
                    getippt[i + 1]++;
                }
            }
        }
        //hier
        spinner1.setValue(getippt[0]);
        spinner2.setValue(getippt[1]);
        spinner3.setValue(getippt[2]);
        spinner4.setValue(getippt[3]);
        spinner5.setValue(getippt[4]);
        spinner6.setValue(getippt[5]);
    }

    private void onZiehung() {
        gezogen = maoam.wuerfel();
        gezogen = sortmatschine.sortmyfoo(gezogen);
        String tempa = "";
        for (int I = 0; I < 6; I++) {
            tempa = tempa + String.valueOf(gezogen[I]);
            if (I<5) {
                tempa = tempa + "; ";
            }
        }
        textPane1.setText(tempa);
    }



   /* private void onCancel() {
        // add your code here if necessary
        dispose();
    }*/

    public static void main(String[] args) {
        Banane dialog = new Banane();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
