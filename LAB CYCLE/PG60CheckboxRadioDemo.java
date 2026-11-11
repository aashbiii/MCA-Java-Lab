import java.awt.*;
import java.awt.event.*;

public class PG60CheckboxRadioDemo extends Frame implements ItemListener, ActionListener {

    // ── Checkboxes ────────────────────────────────────────────────────────
    Checkbox chkJava, chkPython, chkCpp, chkHTML, chkSQL;

    // ── Radio Buttons (CheckboxGroup) ─────────────────────────────────────
    CheckboxGroup genderGroup, courseGroup;
    Checkbox rbMale, rbFemale, rbOther;
    Checkbox rbUG, rbPG, rbPhD;

    // ── Labels ────────────────────────────────────────────────────────────
    Label lSkills, lGender, lCourse, lResult;

    // ── TextFields ────────────────────────────────────────────────────────
    TextField tfSkills, tfGender, tfCourse, tfResult;

    // ── Buttons ───────────────────────────────────────────────────────────
    Button btnSubmit, btnClear, btnExit;

    public PG60CheckboxRadioDemo() {

        setTitle("Checkbox and Radio Button Demo");
        setSize(520, 550);
        setLayout(null);
        setVisible(true);

        // ── Section 1: Checkboxes ─────────────────────────────────────────
        Label lTitle1 = new Label("Select Skills (Checkbox - Multiple Selection):");
        lTitle1.setBounds(30, 20, 350, 25);
        lTitle1.setForeground(Color.blue);
        add(lTitle1);

        chkJava = new Checkbox("Java");
        chkJava.setBounds(30, 55, 80, 25);
        add(chkJava);

        chkPython = new Checkbox("Python");
        chkPython.setBounds(120, 55, 80, 25);
        add(chkPython);

        chkCpp = new Checkbox("C++");
        chkCpp.setBounds(210, 55, 80, 25);
        add(chkCpp);

        chkHTML = new Checkbox("HTML");
        chkHTML.setBounds(300, 55, 80, 25);
        add(chkHTML);

        chkSQL = new Checkbox("SQL");
        chkSQL.setBounds(390, 55, 80, 25);
        add(chkSQL);

        lSkills = new Label("Selected Skills:");
        lSkills.setBounds(30, 95, 110, 25);
        add(lSkills);

        tfSkills = new TextField();
        tfSkills.setBounds(150, 95, 330, 25);
        tfSkills.setEditable(false);
        tfSkills.setBackground(Color.lightGray);
        add(tfSkills);

        // ── Divider ───────────────────────────────────────────────────────
        Label lLine1 = new Label("--------------------------------------------------");
        lLine1.setBounds(30, 130, 450, 20);
        add(lLine1);

        // ── Section 2: Radio Buttons — Gender ─────────────────────────────
        Label lTitle2 = new Label("Select Gender (Radio Button - Single Selection):");
        lTitle2.setBounds(30, 155, 350, 25);
        lTitle2.setForeground(Color.blue);
        add(lTitle2);

        genderGroup = new CheckboxGroup();

        rbMale = new Checkbox("Male", genderGroup, false);
        rbMale.setBounds(30, 190, 80, 25);
        add(rbMale);

        rbFemale = new Checkbox("Female", genderGroup, false);
        rbFemale.setBounds(120, 190, 80, 25);
        add(rbFemale);

        rbOther = new Checkbox("Other", genderGroup, false);
        rbOther.setBounds(210, 190, 80, 25);
        add(rbOther);

        lGender = new Label("Selected Gender:");
        lGender.setBounds(30, 225, 110, 25);
        add(lGender);

        tfGender = new TextField();
        tfGender.setBounds(150, 225, 330, 25);
        tfGender.setEditable(false);
        tfGender.setBackground(Color.lightGray);
        add(tfGender);

        // ── Divider ───────────────────────────────────────────────────────
        Label lLine2 = new Label("--------------------------------------------------");
        lLine2.setBounds(30, 260, 450, 20);
        add(lLine2);

        // ── Section 3: Radio Buttons — Course ─────────────────────────────
        Label lTitle3 = new Label("Select Course (Radio Button - Single Selection):");
        lTitle3.setBounds(30, 285, 350, 25);
        lTitle3.setForeground(Color.blue);
        add(lTitle3);

        courseGroup = new CheckboxGroup();

        rbUG = new Checkbox("Under Graduate", courseGroup, false);
        rbUG.setBounds(30, 320, 130, 25);
        add(rbUG);

        rbPG = new Checkbox("Post Graduate", courseGroup, false);
        rbPG.setBounds(170, 320, 120, 25);
        add(rbPG);

        rbPhD = new Checkbox("PhD", courseGroup, false);
        rbPhD.setBounds(300, 320, 80, 25);
        add(rbPhD);

        lCourse = new Label("Selected Course:");
        lCourse.setBounds(30, 355, 110, 25);
        add(lCourse);

        tfCourse = new TextField();
        tfCourse.setBounds(150, 355, 330, 25);
        tfCourse.setEditable(false);
        tfCourse.setBackground(Color.lightGray);
        add(tfCourse);

        // ── Divider ───────────────────────────────────────────────────────
        Label lLine3 = new Label("--------------------------------------------------");
        lLine3.setBounds(30, 390, 450, 20);
        add(lLine3);

        // ── Result Field ──────────────────────────────────────────────────
        lResult = new Label("Full Summary:");
        lResult.setBounds(30, 415, 110, 25);
        add(lResult);

        tfResult = new TextField();
        tfResult.setBounds(150, 415, 330, 25);
        tfResult.setEditable(false);
        tfResult.setBackground(Color.lightGray);
        add(tfResult);

        // ── Buttons ───────────────────────────────────────────────────────
        btnSubmit = new Button("Submit");
        btnSubmit.setBounds(80, 460, 90, 30);
        add(btnSubmit);

        btnClear = new Button("Clear");
        btnClear.setBounds(200, 460, 90, 30);
        add(btnClear);

        btnExit = new Button("Exit");
        btnExit.setBounds(320, 460, 90, 30);
        add(btnExit);

        // ── Item Listeners ────────────────────────────────────────────────
        chkJava.addItemListener(this);
        chkPython.addItemListener(this);
        chkCpp.addItemListener(this);
        chkHTML.addItemListener(this);
        chkSQL.addItemListener(this);

        rbMale.addItemListener(this);
        rbFemale.addItemListener(this);
        rbOther.addItemListener(this);

        rbUG.addItemListener(this);
        rbPG.addItemListener(this);
        rbPhD.addItemListener(this);

        // ── Action Listeners ──────────────────────────────────────────────
        btnSubmit.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        // ── Window Close ──────────────────────────────────────────────────
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    // ── Item State Changed ────────────────────────────────────────────────
    public void itemStateChanged(ItemEvent e) {

        // Update skills text field
        StringBuilder skills = new StringBuilder();
        if (chkJava.getState())   skills.append("Java  ");
        if (chkPython.getState()) skills.append("Python  ");
        if (chkCpp.getState())    skills.append("C++  ");
        if (chkHTML.getState())   skills.append("HTML  ");
        if (chkSQL.getState())    skills.append("SQL  ");
        tfSkills.setText(skills.toString().trim());

        // Update gender text field
        Checkbox selectedGender = genderGroup.getSelectedCheckbox();
        tfGender.setText(selectedGender != null ? selectedGender.getLabel() : "");

        // Update course text field
        Checkbox selectedCourse = courseGroup.getSelectedCheckbox();
        tfCourse.setText(selectedCourse != null ? selectedCourse.getLabel() : "");
    }

    // ── Action Performed ──────────────────────────────────────────────────
    public void actionPerformed(ActionEvent e) {

        // Submit — show full summary
        if (e.getSource() == btnSubmit) {
            String skills = tfSkills.getText();
            String gender = tfGender.getText();
            String course = tfCourse.getText();

            if (skills.isEmpty() || gender.isEmpty() || course.isEmpty()) {
                tfResult.setText("Please fill all selections!");
                tfResult.setForeground(Color.red);
            } else {
                tfResult.setText("Skills: " + skills +
                                 " | Gender: " + gender +
                                 " | Course: " + course);
                tfResult.setForeground(Color.darkGray);
            }
        }

        // Clear — reset everything
        if (e.getSource() == btnClear) {
            chkJava.setState(false);
            chkPython.setState(false);
            chkCpp.setState(false);
            chkHTML.setState(false);
            chkSQL.setState(false);

            genderGroup.setSelectedCheckbox(null);
            courseGroup.setSelectedCheckbox(null);

            tfSkills.setText("");
            tfGender.setText("");
            tfCourse.setText("");
            tfResult.setText("");
        }

        // Exit
        if (e.getSource() == btnExit) {
            System.exit(0);
        }
    }

    // ── main ──────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        new PG60CheckboxRadioDemo();
    }
}
/*

**Sample Output Window:**
```
 ┌──────────────────────────────────────────────────┐
 │         Checkbox and Radio Button Demo           │
 ├──────────────────────────────────────────────────┤
 │ Select Skills (Checkbox - Multiple Selection):   │
 │  ☑ Java  ☑ Python  ☐ C++  ☑ HTML  ☐ SQL        │
 │  Selected Skills: [ Java  Python  HTML         ] │
 │ ------------------------------------------------ │
 │ Select Gender (Radio Button - Single Selection): │
 │  ○ Male   ● Female   ○ Other                    │
 │  Selected Gender: [ Female                     ] │
 │ ------------------------------------------------ │
 │ Select Course (Radio Button - Single Selection): │
 │  ○ Under Graduate  ● Post Graduate  ○ PhD       │
 │  Selected Course: [ Post Graduate              ] │
 │ ------------------------------------------------ │
 │  Full Summary: [Skills: Java Python HTML |      ]│
 │                [Gender: Female | Course: PG    ] │
 │                                                  │
 │      [ Submit ]   [ Clear ]   [ Exit ]           │
 └──────────────────────────────────────────────────┘
```

---

**How to Compile and Run:**
```
Step 1: Compile
        javac CheckboxRadioDemo.java

Step 2: Run
        java CheckboxRadioDemo
*/