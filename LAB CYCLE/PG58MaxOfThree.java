import java.awt.*;
import java.awt.event.*;

public class PG58MaxOfThree extends Frame implements ActionListener {

    Label l1, l2, l3, lResult;
    TextField tf1, tf2, tf3, tfResult;
    Button btnFind, btnClear, btnExit;

    public PG58MaxOfThree() {

        setTitle("Maximum of Three Numbers");
        setSize(400, 300);
        setLayout(new FlowLayout());
        setVisible(true);

        // Labels and TextFields
        l1 = new Label("Enter Number 1 :");
        tf1 = new TextField(15);

        l2 = new Label("Enter Number 2 :");
        tf2 = new TextField(15);

        l3 = new Label("Enter Number 3 :");
        tf3 = new TextField(15);

        lResult = new Label("Maximum       :");
        tfResult = new TextField(15);
        tfResult.setEditable(false);
        tfResult.setBackground(Color.lightGray);

        // Buttons
        btnFind  = new Button("Find Maximum");
        btnClear = new Button("Clear");
        btnExit  = new Button("Exit");

        // Add components
        add(l1);      add(tf1);
        add(l2);      add(tf2);
        add(l3);      add(tf3);
        add(lResult); add(tfResult);
        add(btnFind); add(btnClear); add(btnExit);

        // Action Listeners
        btnFind.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        // Window Close
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnFind) {
            try {
                int n1 = Integer.parseInt(tf1.getText());
                int n2 = Integer.parseInt(tf2.getText());
                int n3 = Integer.parseInt(tf3.getText());

                int max = n1;
                if (n2 > max) max = n2;
                if (n3 > max) max = n3;

                tfResult.setText(String.valueOf(max));

            } catch (NumberFormatException ex) {
                tfResult.setText("Invalid input!");
            }
        }

        if (e.getSource() == btnClear) {
            tf1.setText("");
            tf2.setText("");
            tf3.setText("");
            tfResult.setText("");
            tf1.requestFocus();
        }

        if (e.getSource() == btnExit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new PG58MaxOfThree();
    }
}