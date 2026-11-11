import java.awt.*;
import java.awt.event.*;

public class PG59ListDemo extends Frame implements ActionListener, ItemListener {

    // Lists
    List listLeft, listRight;

    // Labels
    Label lLeft, lRight, lSelected, lStatus;

    // TextFields
    TextField tfItem, tfSelected;

    // Buttons
    Button btnAdd, btnDelete, btnMoveRight, btnMoveLeft;
    Button btnMoveAll, btnClear, btnExit;
    Button btnSelectAll, btnDeselect;

    public PG59ListDemo() {

        setTitle("AWT List Control - All Functionalities");
        setSize(620, 500);
        setLayout(null);
        setVisible(true);

        // ── Labels ────────────────────────────────────────────────────────
        lLeft = new Label("Available Items:");
        lLeft.setBounds(30, 20, 120, 25);
        add(lLeft);

        lRight = new Label("Selected Items:");
        lRight.setBounds(420, 20, 120, 25);
        add(lRight);

        lSelected = new Label("Item selected:");
        lSelected.setBounds(30, 370, 100, 25);
        add(lSelected);

        lStatus = new Label("Status: Ready");
        lStatus.setBounds(30, 440, 550, 25);
        lStatus.setForeground(Color.blue);
        add(lStatus);

        // ── Left List (multi-select) ───────────────────────────────────────
        listLeft = new List(10, true);
        listLeft.setBounds(30, 50, 180, 200);
        listLeft.add("Ashbi");
        listLeft.add("Jees");
        listLeft.add("Kishore");
        listLeft.add("Rena");
        listLeft.add("Jasin");
        listLeft.add("Diya");
        listLeft.add("Merlin");
        listLeft.add("Ayush");
        add(listLeft);

        // ── Right List (multi-select) ──────────────────────────────────────
        listRight = new List(10, true);
        listRight.setBounds(420, 50, 180, 200);
        add(listRight);

        // ── TextField for adding new item ─────────────────────────────────
        Label lAdd = new Label("New Item:");
        lAdd.setBounds(30, 270, 70, 25);
        add(lAdd);

        tfItem = new TextField();
        tfItem.setBounds(110, 270, 100, 25);
        add(tfItem);

        // ── TextField to show selected item ───────────────────────────────
        tfSelected = new TextField();
        tfSelected.setBounds(140, 370, 430, 25);
        tfSelected.setEditable(false);
        tfSelected.setBackground(Color.lightGray);
        add(tfSelected);

        // ── Middle Buttons (transfer) ──────────────────────────────────────
        btnMoveRight = new Button("  >>  ");
        btnMoveRight.setBounds(240, 80, 70, 30);
        add(btnMoveRight);

        btnMoveLeft = new Button("  <<  ");
        btnMoveLeft.setBounds(240, 120, 70, 30);
        add(btnMoveLeft);

        btnMoveAll = new Button(" >> All");
        btnMoveAll.setBounds(240, 160, 70, 30);
        add(btnMoveAll);

        Button btnMoveAllBack = new Button("<< All ");
        btnMoveAllBack.setBounds(240, 200, 70, 30);
        add(btnMoveAllBack);

        // ── Bottom Buttons ─────────────────────────────────────────────────
        btnAdd = new Button("Add");
        btnAdd.setBounds(30, 310, 70, 30);
        add(btnAdd);

        btnDelete = new Button("Delete");
        btnDelete.setBounds(110, 310, 70, 30);
        add(btnDelete);

        btnSelectAll = new Button("Select All");
        btnSelectAll.setBounds(190, 310, 90, 30);
        add(btnSelectAll);

        btnDeselect = new Button("Deselect");
        btnDeselect.setBounds(290, 310, 80, 30);
        add(btnDeselect);

        btnClear = new Button("Clear All");
        btnClear.setBounds(380, 310, 80, 30);
        add(btnClear);

        btnExit = new Button("Exit");
        btnExit.setBounds(470, 310, 70, 30);
        add(btnExit);

        // ── Action Listeners ──────────────────────────────────────────────
        btnAdd.addActionListener(this);
        btnDelete.addActionListener(this);
        btnMoveRight.addActionListener(this);
        btnMoveLeft.addActionListener(this);
        btnMoveAll.addActionListener(this);
        btnMoveAllBack.addActionListener(this);
        btnSelectAll.addActionListener(this);
        btnDeselect.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        // ── Item Listeners ────────────────────────────────────────────────
        listLeft.addItemListener(this);
        listRight.addItemListener(this);

        // ── Window Close ──────────────────────────────────────────────────
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    // ── Action Performed ──────────────────────────────────────────────────
    public void actionPerformed(ActionEvent e) {

        // Add new item to left list
        if (e.getSource() == btnAdd) {
            String item = tfItem.getText().trim();
            if (!item.isEmpty()) {
                listLeft.add(item);
                tfItem.setText("");
                lStatus.setText("Status: Added \"" + item + "\" to list.");
            } else {
                lStatus.setText("Status: Please enter an item to add.");
            }
        }

        // Delete selected item from left list
        if (e.getSource() == btnDelete) {
            String[] selected = listLeft.getSelectedItems();
            if (selected.length > 0) {
                for (String item : selected) {
                    listLeft.remove(item);
                }
                lStatus.setText("Status: Deleted " + selected.length + " item(s).");
            } else {
                lStatus.setText("Status: Please select item(s) to delete.");
            }
        }

        // Move selected items from left to right
        if (e.getSource() == btnMoveRight) {
            String[] selected = listLeft.getSelectedItems();
            if (selected.length > 0) {
                for (String item : selected) {
                    listRight.add(item);
                    listLeft.remove(item);
                }
                lStatus.setText("Status: Moved " + selected.length + " item(s) to right.");
            } else {
                lStatus.setText("Status: Please select item(s) to move.");
            }
        }

        // Move selected items from right to left
        if (e.getSource() == btnMoveLeft) {
            String[] selected = listRight.getSelectedItems();
            if (selected.length > 0) {
                for (String item : selected) {
                    listLeft.add(item);
                    listRight.remove(item);
                }
                lStatus.setText("Status: Moved " + selected.length + " item(s) to left.");
            } else {
                lStatus.setText("Status: Please select item(s) to move back.");
            }
        }

        // Move all items from left to right
        if (e.getSource() == btnMoveAll) {
            String[] items = listLeft.getItems();
            if (items.length > 0) {
                for (String item : items) {
                    listRight.add(item);
                }
                listLeft.removeAll();
                lStatus.setText("Status: Moved all " + items.length + " item(s) to right.");
            } else {
                lStatus.setText("Status: Left list is already empty.");
            }
        }

        // Move all items from right to left
        if (e.getActionCommand().equals("<< All ")) {
            String[] items = listRight.getItems();
            if (items.length > 0) {
                for (String item : items) {
                    listLeft.add(item);
                }
                listRight.removeAll();
                lStatus.setText("Status: Moved all " + items.length + " item(s) to left.");
            } else {
                lStatus.setText("Status: Right list is already empty.");
            }
        }

        // Select all items in left list
        if (e.getSource() == btnSelectAll) {
            for (int i = 0; i < listLeft.getItemCount(); i++) {
                listLeft.select(i);
            }
            lStatus.setText("Status: All items selected.");
        }

        // Deselect all items in left list
        if (e.getSource() == btnDeselect) {
            for (int i = 0; i < listLeft.getItemCount(); i++) {
                listLeft.deselect(i);
            }
            tfSelected.setText("");
            lStatus.setText("Status: All items deselected.");
        }

        // Clear both lists
        if (e.getSource() == btnClear) {
            listLeft.removeAll();
            listRight.removeAll();
            tfSelected.setText("");
            lStatus.setText("Status: Both lists cleared.");
        }

        // Exit
        if (e.getSource() == btnExit) {
            System.exit(0);
        }
    }

    // ── Item State Changed ─────────────────────────────────────────────────
    public void itemStateChanged(ItemEvent e) {
        String[] leftSelected  = listLeft.getSelectedItems();
        String[] rightSelected = listRight.getSelectedItems();

        StringBuilder sb = new StringBuilder();

        if (leftSelected.length > 0) {
            sb.append("Left: ");
            for (String s : leftSelected) sb.append(s).append("  ");
        }
        if (rightSelected.length > 0) {
            sb.append("Right: ");
            for (String s : rightSelected) sb.append(s).append("  ");
        }

        tfSelected.setText(sb.toString());
        lStatus.setText("Status: " + (leftSelected.length + rightSelected.length)
            + " item(s) selected.");
    }

    // ── main ──────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        new PG59ListDemo();
    }
}
/*

**Sample Output Window:**
```
 ┌──────────────────────────────────────────────────────────┐
 │          AWT List Control - All Functionalities          │
 ├──────────────────────────────────────────────────────────┤
 │  Available Items:              Selected Items:           │
 │  ┌────────────┐                ┌────────────┐            │
 │  │ Alice      │   [  >>  ]     │            │            │
 │  │ Bob        │   [  <<  ]     │            │            │
 │  │ Charlie    │   [ >> All]    │            │            │
 │  │ David      │   [<< All ]    │            │            │
 │  │ Eve        │                │            │            │
 │  │ Frank      │                │            │            │
 │  │ Grace      │                │            │            │
 │  │ Henry      │                │            │            │
 │  └────────────┘                └────────────┘            │
 │  New Item: [          ]                                  │
 │  [Add] [Delete] [Select All] [Deselect] [Clear] [Exit]   │
 │  Item selected: [                                    ]   │
 │  Status: Ready                                           │
 └──────────────────────────────────────────────────────────┘
```

---

**How to Compile and Run:**
```
Step 1: Compile
        javac ListDemo.java

Step 2: Run
        java ListDemo
*/