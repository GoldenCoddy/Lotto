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
    private JButton Auswertung;
    private JButton ziehen;
    private JLabel Label1;
    private JButton buttonCancel;
    private sortmaschine_exe sortmatschine = new sortmaschine_exe();
    private otto maoam = new otto(6,49, 1, false);
    private WerteDatAuself OutWorther = new WerteDatAuself(false);
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

        checkmynumbers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getfromspinners();
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
        Label1.addComponentListener(new ComponentAdapter() {
        });
    }

    private void onOK() {
        /* 38 40 37 39 66 65 */
        if ((int) spinner1.getValue() == 38 && (int) spinner2.getValue() == 40 && (int) spinner3.getValue() == 37 && (int) spinner4.getValue() == 39 && (int) spinner5.getValue() == 66 && (int) spinner6.getValue() == 65) {
           System.out.println("=============================================");
           System.out.println("|| You hacky Hax0r activated the hack mode ||");
           System.out.println("|| Cyber, Cyber, Cyber, Cyber, Cyber, CYBER||");
           System.out.println("=============================================");
           OutWorther = new WerteDatAuself(true);
        } else {
            dispose();
        }
    }

    private void onQuickTipp() {
        getippt = maoam.wuerfel();
        printtospinners();
        onZiehung();
        System.out.println("Getippt nach der Ziehung:");
        onCheck();
        System.out.println("Getippt nach dem Check:");
        }
        onVergLeiche();
        System.out.println("Getippt nach dem Vergleich:");
        for (int i = 0; i<6; i++) {
            System.out.println(getippt[i]);
        }
        printtospinners();
    }

    private void onVergLeiche() {
        richtige = OutWorther.richtige(getippt, gezogen);
        if (richtige == 1) {
            Label1.setText("Sie haben 1 richtigen.");
        } else {
            Label1.setText("Sie haben " + String.valueOf(richtige) + " richtige.");
        }
    }

    private void printtospinners() {
        spinner1.setValue(getippt[0]);
        spinner2.setValue(getippt[1]);
        spinner3.setValue(getippt[2]);
        spinner4.setValue(getippt[3]);
        spinner5.setValue(getippt[4]);
        spinner6.setValue(getippt[5]);
    }
    private void getfromspinners() {
        getippt[0] = (int) spinner1.getValue();
        getippt[1] = (int) spinner2.getValue();
        getippt[2] = (int) spinner3.getValue();
        getippt[3] = (int) spinner4.getValue();
        getippt[4] = (int) spinner5.getValue();
        getippt[5] = (int) spinner6.getValue();
    }

    private void onCheck() {
        getippt = sortmatschine.sortmyfoo(getippt);
        boolean sucessful = false;
        while (!sucessful) {
            getippt = sortmatschine.sortmyfoo(getippt);
            sucessful = true;
            for (int i = 0; i < getippt.length - 1; i++) {
                if (getippt[i] == getippt[i + 1]) {
                    sucessful = false;
                    getippt[i + 1]++;
                }
            }
        }
        printtospinners();
    }

    private void onZiehung() {
        maoam = new otto(6,49,1,false);
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


    public static void main(String[] args) {
        Banane dialog = new Banane();
        dialog.pack();
        System.out.println("Starting Lotto by CryptKiddie and GoldenCoddy");
        System.out.println("This program is pretty shitty and OpenSource.");
        System.out.println("Fork or contribute under https://github.com/GoldenCoddy/Lotto/");
        dialog.setVisible(true);
        System.exit(0);
    }
}
