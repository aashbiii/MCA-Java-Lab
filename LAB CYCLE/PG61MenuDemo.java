import java.awt.*;
import java.awt.event.*;

public class PG61MenuDemo extends Frame implements ActionListener {

    // TextArea to display output
    TextArea ta;

    // Status label
    Label lStatus;

    // ── Menu Bar ──────────────────────────────────────────────────────────
    MenuBar menuBar;

    // ── Menus ─────────────────────────────────────────────────────────────
    Menu menuFile, menuEdit, menuFormat, menuView, menuHelp;

    // ── File Menu Items ───────────────────────────────────────────────────
    MenuItem miNew, miOpen, miSave, miSaveAs, miPrint, miExit;

    // ── Edit Menu Items ───────────────────────────────────────────────────
    MenuItem miCut, miCopy, miPaste, miDelete, miSelectAll, miFind;

    // ── Format Menu Items ─────────────────────────────────────────────────
    MenuItem miBold, miItalic, miUnderline;
    CheckboxMenuItem miWordWrap;
    Menu menuFont, menuFontSize;
    MenuItem miFontArial, miFontCourier, miFontTimesNew;
    MenuItem miSize10, miSize14, miSize18, miSize24;

    // ── View Menu Items ───────────────────────────────────────────────────
    CheckboxMenuItem miToolbar, miStatusBar, miFullScreen;

    // ── Help Menu Items ───────────────────────────────────────────────────
    MenuItem miAbout, miHelp;

    public PG61MenuDemo() {

        setTitle("AWT Menu Demo");
        setSize(600, 500);
        setLayout(null);

        // ── TextArea ──────────────────────────────────────────────────────
        ta = new TextArea("Welcome to AWT Menu Demo!\n" +
                          "Use the menu bar above to try all menu options.\n");
        ta.setBounds(10, 10, 570, 400);
        ta.setFont(new Font("Arial", Font.PLAIN, 14));
        add(ta);

        // ── Status Label ──────────────────────────────────────────────────
        lStatus = new Label("Status: Ready");
        lStatus.setBounds(10, 420, 570, 25);
        lStatus.setForeground(Color.blue);
        add(lStatus);

        // ── Menu Bar ──────────────────────────────────────────────────────
        menuBar = new MenuBar();

        // ── File Menu ─────────────────────────────────────────────────────
        menuFile = new Menu("File");

        miNew    = new MenuItem("New",        new MenuShortcut('N'));
        miOpen   = new MenuItem("Open",       new MenuShortcut('O'));
        miSave   = new MenuItem("Save",       new MenuShortcut('S'));
        miSaveAs = new MenuItem("Save As");
        miPrint  = new MenuItem("Print",      new MenuShortcut('P'));
        miExit   = new MenuItem("Exit");

        menuFile.add(miNew);
        menuFile.add(miOpen);
        menuFile.add(miSave);
        menuFile.add(miSaveAs);
        menuFile.addSeparator();
        menuFile.add(miPrint);
        menuFile.addSeparator();
        menuFile.add(miExit);

        // ── Edit Menu ─────────────────────────────────────────────────────
        menuEdit = new Menu("Edit");

        miCut       = new MenuItem("Cut",        new MenuShortcut('X'));
        miCopy      = new MenuItem("Copy",       new MenuShortcut('C'));
        miPaste     = new MenuItem("Paste",      new MenuShortcut('V'));
        miDelete    = new MenuItem("Delete");
        miSelectAll = new MenuItem("Select All", new MenuShortcut('A'));
        miFind      = new MenuItem("Find",       new MenuShortcut('F'));

        menuEdit.add(miCut);
        menuEdit.add(miCopy);
        menuEdit.add(miPaste);
        menuEdit.add(miDelete);
        menuEdit.addSeparator();
        menuEdit.add(miSelectAll);
        menuEdit.addSeparator();
        menuEdit.add(miFind);

        // ── Format Menu ───────────────────────────────────────────────────
        menuFormat = new Menu("Format");

        miBold       = new MenuItem("Bold");
        miItalic     = new MenuItem("Italic");
        miUnderline  = new MenuItem("Underline");
        miWordWrap   = new CheckboxMenuItem("Word Wrap", true);

        // Font submenu
        menuFont = new Menu("Font");
        miFontArial     = new MenuItem("Arial");
        miFontCourier   = new MenuItem("Courier");
        miFontTimesNew  = new MenuItem("Times New Roman");
        menuFont.add(miFontArial);
        menuFont.add(miFontCourier);
        menuFont.add(miFontTimesNew);

        // Font size submenu
        menuFontSize = new Menu("Font Size");
        miSize10 = new MenuItem("10");
        miSize14 = new MenuItem("14");
        miSize18 = new MenuItem("18");
        miSize24 = new MenuItem("24");
        menuFontSize.add(miSize10);
        menuFontSize.add(miSize14);
        menuFontSize.add(miSize18);
        menuFontSize.add(miSize24);

        menuFormat.add(miBold);
        menuFormat.add(miItalic);
        menuFormat.add(miUnderline);
        menuFormat.addSeparator();
        menuFormat.add(miWordWrap);
        menuFormat.addSeparator();
        menuFormat.add(menuFont);
        menuFormat.add(menuFontSize);

        // ── View Menu ─────────────────────────────────────────────────────
        menuView = new Menu("View");

        miToolbar   = new CheckboxMenuItem("Toolbar",    true);
        miStatusBar = new CheckboxMenuItem("Status Bar", true);
        miFullScreen = new CheckboxMenuItem("Full Screen", false);

        menuView.add(miToolbar);
        menuView.add(miStatusBar);
        menuView.addSeparator();
        menuView.add(miFullScreen);

        // ── Help Menu ─────────────────────────────────────────────────────
        menuHelp = new Menu("Help");

        miHelp  = new MenuItem("Help Topics");
        miAbout = new MenuItem("About");

        menuHelp.add(miHelp);
        menuHelp.addSeparator();
        menuHelp.add(miAbout);

        // ── Add menus to menu bar ─────────────────────────────────────────
        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.add(menuFormat);
        menuBar.add(menuView);
        menuBar.setHelpMenu(menuHelp);

        // ── Set menu bar to frame ─────────────────────────────────────────
        setMenuBar(menuBar);

        // ── Action Listeners — File ───────────────────────────────────────
        miNew.addActionListener(this);
        miOpen.addActionListener(this);
        miSave.addActionListener(this);
        miSaveAs.addActionListener(this);
        miPrint.addActionListener(this);
        miExit.addActionListener(this);

        // ── Action Listeners — Edit ───────────────────────────────────────
        miCut.addActionListener(this);
        miCopy.addActionListener(this);
        miPaste.addActionListener(this);
        miDelete.addActionListener(this);
        miSelectAll.addActionListener(this);
        miFind.addActionListener(this);

        // ── Action Listeners — Format ─────────────────────────────────────
        miBold.addActionListener(this);
        miItalic.addActionListener(this);
        miUnderline.addActionListener(this);
        miWordWrap.addActionListener(this);
        miFontArial.addActionListener(this);
        miFontCourier.addActionListener(this);
        miFontTimesNew.addActionListener(this);
        miSize10.addActionListener(this);
        miSize14.addActionListener(this);
        miSize18.addActionListener(this);
        miSize24.addActionListener(this);

        // ── Action Listeners — View ───────────────────────────────────────
        miToolbar.addActionListener(this);
        miStatusBar.addActionListener(this);
        miFullScreen.addActionListener(this);

        // ── Action Listeners — Help ───────────────────────────────────────
        miHelp.addActionListener(this);
        miAbout.addActionListener(this);

        // ── Window Close ──────────────────────────────────────────────────
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    // ── Action Performed ──────────────────────────────────────────────────
    public void actionPerformed(ActionEvent e) {

        String cmd = e.getActionCommand();

        switch (cmd) {

            // File menu
            case "New":
                ta.setText("");
                lStatus.setText("Status: New file created.");
                break;

            case "Open":
                ta.append(">> Open file dialog would appear here.\n");
                lStatus.setText("Status: Open selected.");
                break;

            case "Save":
                ta.append(">> File saved.\n");
                lStatus.setText("Status: File saved.");
                break;

            case "Save As":
                ta.append(">> Save As dialog would appear here.\n");
                lStatus.setText("Status: Save As selected.");
                break;

            case "Print":
                ta.append(">> Print dialog would appear here.\n");
                lStatus.setText("Status: Print selected.");
                break;

            case "Exit":
                System.exit(0);
                break;

            // Edit menu
            case "Cut":
                ta.append(">> Cut selected text.\n");
                lStatus.setText("Status: Cut.");
                break;

            case "Copy":
                ta.append(">> Copied selected text.\n");
                lStatus.setText("Status: Copy.");
                break;

            case "Paste":
                ta.append(">> Pasted text.\n");
                lStatus.setText("Status: Paste.");
                break;

            case "Delete":
                ta.append(">> Deleted selected text.\n");
                lStatus.setText("Status: Delete.");
                break;

            case "Select All":
                ta.selectAll();
                lStatus.setText("Status: All text selected.");
                break;

            case "Find":
                ta.append(">> Find dialog would appear here.\n");
                lStatus.setText("Status: Find selected.");
                break;

            // Format menu
            case "Bold":
                ta.setFont(new Font(ta.getFont().getName(), Font.BOLD,
                    ta.getFont().getSize()));
                lStatus.setText("Status: Bold applied.");
                break;

            case "Italic":
                ta.setFont(new Font(ta.getFont().getName(), Font.ITALIC,
                    ta.getFont().getSize()));
                lStatus.setText("Status: Italic applied.");
                break;

            case "Underline":
                ta.append(">> Underline applied.\n");
                lStatus.setText("Status: Underline selected.");
                break;

            case "Word Wrap":
                lStatus.setText("Status: Word Wrap = " + miWordWrap.getState());
                break;

            // Font submenu
            case "Arial":
                ta.setFont(new Font("Arial", ta.getFont().getStyle(),
                    ta.getFont().getSize()));
                lStatus.setText("Status: Font changed to Arial.");
                break;

            case "Courier":
                ta.setFont(new Font("Courier", ta.getFont().getStyle(),
                    ta.getFont().getSize()));
                lStatus.setText("Status: Font changed to Courier.");
                break;

            case "Times New Roman":
                ta.setFont(new Font("Times New Roman", ta.getFont().getStyle(),
                    ta.getFont().getSize()));
                lStatus.setText("Status: Font changed to Times New Roman.");
                break;

            // Font size submenu
            case "10":
                ta.setFont(new Font(ta.getFont().getName(),
                    ta.getFont().getStyle(), 10));
                lStatus.setText("Status: Font size set to 10.");
                break;

            case "14":
                ta.setFont(new Font(ta.getFont().getName(),
                    ta.getFont().getStyle(), 14));
                lStatus.setText("Status: Font size set to 14.");
                break;

            case "18":
                ta.setFont(new Font(ta.getFont().getName(),
                    ta.getFont().getStyle(), 18));
                lStatus.setText("Status: Font size set to 18.");
                break;

            case "24":
                ta.setFont(new Font(ta.getFont().getName(),
                    ta.getFont().getStyle(), 24));
                lStatus.setText("Status: Font size set to 24.");
                break;

            // View menu
            case "Toolbar":
                lStatus.setText("Status: Toolbar = " + miToolbar.getState());
                break;

            case "Status Bar":
                lStatus.setText("Status: Status Bar = " + miStatusBar.getState());
                break;

            case "Full Screen":
                lStatus.setText("Status: Full Screen = " + miFullScreen.getState());
                break;

            // Help menu
            case "Help Topics":
                ta.append(">> Help Topics:\n" +
                           "   1. Use File menu to create/open/save files.\n" +
                           "   2. Use Edit menu to cut/copy/paste text.\n" +
                           "   3. Use Format menu to change font/style.\n" +
                           "   4. Use View menu to toggle toolbar/statusbar.\n");
                lStatus.setText("Status: Help Topics opened.");
                break;

            case "About":
                ta.append(">> About:\n" +
                           "   AWT Menu Demo\n" +
                           "   Version 1.0\n" +
                           "   Demonstrates all AWT Menu functionalities.\n");
                lStatus.setText("Status: About opened.");
                break;
        }
    }

    // ── main ──────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        new PG61MenuDemo();
    }
}
/*
**Sample Output Window:**
```
 ┌──────────────────────────────────────────────────────┐
 │  File   Edit   Format   View   Help                  │
 ├──────────────────────────────────────────────────────┤
 │                                                      │
 │  Welcome to AWT Menu Demo!                           │
 │  Use the menu bar above to try all menu options.     │
 │                                                      │
 │                                                      │
 │                                                      │
 │                                                      │
 │  Status: Ready                                       │
 └──────────────────────────────────────────────────────┘
```

---

**How to Compile and Run:**
```
Step 1: Compile
        javac MenuDemo.java

Step 2: Run
        java MenuDemo
*/