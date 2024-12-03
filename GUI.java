import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.io.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI implements ActionListener
{	
final String viewStatusBar="Status Bar";

final String helpHelpTopic="Help Topic";
final String helpAboutNotepad="About Javapad";

	JFrame window;
	JLabel statusBar;
	JTextArea textArea;
	JScrollPane scrollPane;
	boolean wordWrapOn = false;
	JMenuItem windows, metal, motif,nimbus;
	//Menubar....
	JMenuBar menuBar;
	JMenu menuFile,menuEdit, menuFormat, menuColor, menuView,menuHelp;

	//View
	JMenuItem look1,look2,look3 ;
	//Help
	JMenuItem about;
	
	//File menu....
	JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;

	//Edit menu....
	JMenuItem iUndo, iRedo;
	JMenuItem cut, copy, paste, selectAll,find,editFindNex,	editReplace ;
	
	//Format menu....
	JMenuItem iWrap, iFontArial, iFontSize, iFontCSMS, iFontTNR, iFontImpact, iFontCalibri, iFontCentury, iFontDubai, iFontInk_Free, iFontGadugi;
	JMenuItem iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24, iFontSize28, iFontSize32, iFontSize36, iFontSize40, iFontSize44, iFontSize48, iFontSize52;
	
	
	JMenu menuFont, menuFontSize;
	
	//Color menu
	JMenuItem iColor1, iColor2, iColor3, iColor4, iColor5, iColor6, iColor7, iColor8;
	
	
	Function_File file=new Function_File(this);
	Function_Format format=new Function_Format(this);
	Function_Color color=new Function_Color(this);
	Function_Edit edit=new Function_Edit(this);
	KeyHandler kHandler = new KeyHandler(this);
	FindDialog findReplaceDialog=null; 
	
	UndoManager um=new UndoManager();
	
	public static void main(String[] args)
	{
		new GUI();
	}
	public GUI()
	{	
		createWindow();
		createTextArea();
		createMenuBar();
		createFileMenu();
        createEditMenu();
		createFormatMenu();
		createColorMenu();
		createViewMenu();
		createHelpMenu();

		format.selectedFont = "Arial";
		format.createFont(16);
		format.wordWrap();
		color.changeColor("White");	
		window.setVisible(true);
		//textArea.setForeground(Color.GREEN);
		
	}
	
	
	public void createWindow()
	{
		window = new JFrame("Notepad");
		window.setSize(1100,900);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void createTextArea()
	{

		textArea = new JTextArea();

		textArea.addKeyListener(kHandler);
		
		textArea.getDocument().addUndoableEditListener(
			new UndoableEditListener() {
				public void undoableEditHappened(UndoableEditEvent e) {
					um.addEdit(e.getEdit());
					}
			});

                scrollPane =new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		window.add(scrollPane);	

	
		textArea.setForeground(Color.GREEN);
	
	}
	
public void createMenuBar()
{
	menuBar = new JMenuBar();
	window.setJMenuBar(menuBar);

	menuFile = new JMenu("File");
	menuBar.add(menuFile);
	
	menuEdit = new JMenu("Edit");
	menuBar.add(menuEdit);

	menuFormat = new JMenu("Format");
	menuBar.add(menuFormat);

	menuColor = new JMenu("Color");
	menuBar.add(menuColor);
	
	menuView = new JMenu("View");
	menuBar.add(menuView);
	
	menuHelp = new JMenu("Help");
	menuBar.add(menuHelp);

}

public void createHelpMenu() {
	
				
}
public void createViewMenu() {
	windows= new JMenuItem("windows");
	windows.addActionListener(this);
	windows.setActionCommand("windows");
    menuView.add(windows);
    menuView.addSeparator();
    
    metal = new JMenuItem("metal");
    metal.addActionListener(this);
    metal.setActionCommand("metal");
    menuView.add(metal);
    menuView.addSeparator();
    
    motif = new JMenuItem("motif");
    motif.addActionListener(this);
    motif.setActionCommand("motif");
    menuView.add(motif);
    menuView.addSeparator();

    nimbus = new JMenuItem("nimbus");
    nimbus.addActionListener(this);
    nimbus.setActionCommand("nimbus");
    menuView.add(nimbus);
    menuView.addSeparator();


}
public void createFileMenu()
{
        
	iNew = new JMenuItem("New                Ctrl+N ");
	iNew.addActionListener(this);
	iNew.setActionCommand("New");
	menuFile.add(iNew);
	menuFile.addSeparator();

	
	iOpen = new JMenuItem("Open              Ctrl+O");
	iOpen.addActionListener(this);
	iOpen.setActionCommand("Open");
	menuFile.add(iOpen);

	iSave = new JMenuItem("Save               Ctrl+S");
	iSave.addActionListener(this);
	iSave.setActionCommand("Save");
	menuFile.add(iSave);

	iSaveAs = new JMenuItem("Save As     Ctrl+Shift+S");
	iSaveAs.addActionListener(this);
	iSaveAs.setActionCommand("SaveAs");
	menuFile.add(iSaveAs);
	menuFile.addSeparator();
 	iExit = new JMenuItem("Exit                Ctrl+0");
	iExit.addActionListener(this);
	iExit.setActionCommand("Exit");
	menuFile.add(iExit);	

}

public void createEditMenu()
{
	iUndo = new JMenuItem("Undo       Ctrl+Z");
	iUndo.addActionListener(this);
	iUndo.setActionCommand("Undo");
	menuEdit.add(iUndo);

	iRedo = new JMenuItem("Redo       Ctrl+R");
	iRedo.addActionListener(this);
	iRedo.setActionCommand("Redo");
	menuEdit.add(iRedo);
	menuEdit.addSeparator();

	cut = new JMenuItem("Cut              Ctrl+X");
	cut.addActionListener(this);
	menuEdit.add(cut);
	
	copy = new JMenuItem("Copy            Ctrl+C");
	copy.addActionListener(this);
	menuEdit.add(copy);

	paste = new JMenuItem("Paste          Ctrl+V");
	paste.addActionListener(this);
	menuEdit.add(paste);
	menuEdit.addSeparator();

	selectAll = new JMenuItem("Select All          Ctrl+A");
	selectAll.addActionListener(this);
	menuEdit.add(selectAll);
	
	find = new JMenuItem("Find          Ctrl+F");
	find.addActionListener(this);
	menuEdit.add(find);
	
	
	editFindNex = new JMenuItem("editFindNex F3");
	editFindNex.addActionListener(this);
	menuEdit.add(editFindNex);
	

	editReplace = new JMenuItem("Replace          Ctrl+H");
	editReplace .addActionListener(this);
	menuEdit.add(editReplace);

}

public void createFormatMenu()
{
        
	iWrap = new JMenuItem("Word Wrap: Off");
	iWrap.addActionListener(this);
	iWrap.setActionCommand("Word Wrap");
	menuFormat.add(iWrap);
	menuFormat.addSeparator();
	
	menuFont = new JMenu("Font");
	menuFormat.add(menuFont);

	iFontArial = new JMenuItem("Arial");
	iFontArial.addActionListener(this);
	iFontArial.setActionCommand("Arial");
	menuFont.add(iFontArial);
	
	iFontCSMS = new JMenuItem("Comic Sans MS");
	iFontCSMS.addActionListener(this);
	iFontCSMS.setActionCommand("Comic Sans MS");
	menuFont.add(iFontCSMS);

	iFontTNR = new JMenuItem("Times New Roman");
	iFontTNR.addActionListener(this);
	iFontTNR.setActionCommand("Times New Roman");
	menuFont.add(iFontTNR);

	iFontImpact = new JMenuItem("Impact");
	iFontImpact.addActionListener(this);
	iFontImpact.setActionCommand("Impact");
	menuFont.add(iFontImpact);
	
	iFontCalibri = new JMenuItem("Calibri");
	iFontCalibri.addActionListener(this);
	iFontCalibri.setActionCommand("Calibri");
	menuFont.add(iFontCalibri);

	iFontCentury = new JMenuItem("Century");
	iFontCentury.addActionListener(this);
	iFontCentury.setActionCommand("Century");
	menuFont.add(iFontCentury);
	
	iFontGadugi = new JMenuItem("Gadugi");
	iFontGadugi.addActionListener(this);
	iFontGadugi.setActionCommand("Gadugi");
	menuFont.add(iFontGadugi);
	
	iFontInk_Free = new JMenuItem("Ink Free");
	iFontInk_Free.addActionListener(this);
	iFontInk_Free.setActionCommand("Ink Free");
	menuFont.add(iFontInk_Free);
	
	iFontDubai = new JMenuItem("Dubai");
	iFontDubai.addActionListener(this);
	iFontDubai.setActionCommand("Dubai");
	menuFont.add(iFontDubai);
	
	
	menuFontSize = new JMenu("Font Size");
	menuFormat.add(menuFontSize);

	iFontSize8 = new JMenuItem("8");
	iFontSize8.addActionListener(this);
	iFontSize8.setActionCommand("Size8");
	menuFontSize.add(iFontSize8);

	iFontSize12 = new JMenuItem("12");
	iFontSize12.addActionListener(this);
	iFontSize12.setActionCommand("Size12");
	menuFontSize.add(iFontSize12);

	iFontSize16 = new JMenuItem("16");
	iFontSize16.addActionListener(this);
	iFontSize16.setActionCommand("Size16");
	menuFontSize.add(iFontSize16);

	iFontSize20 = new JMenuItem("20");
	iFontSize20.addActionListener(this);
	iFontSize20.setActionCommand("Size20");
	menuFontSize.add(iFontSize20);

	iFontSize24 = new JMenuItem("24");
	iFontSize24.addActionListener(this);
	iFontSize24.setActionCommand("Size24");
	menuFontSize.add(iFontSize24);
     
	iFontSize28 = new JMenuItem("28");
	iFontSize28.addActionListener(this);
	iFontSize28.setActionCommand("Size28");
	menuFontSize.add(iFontSize28);

	iFontSize32 = new JMenuItem("32");
	iFontSize32.addActionListener(this);
	iFontSize32.setActionCommand("Size32");
	menuFontSize.add(iFontSize32);
	
	iFontSize36 = new JMenuItem("36");
	iFontSize36.addActionListener(this);
	iFontSize36.setActionCommand("Size36");
	menuFontSize.add(iFontSize36);

	iFontSize40 = new JMenuItem("40");
	iFontSize40.addActionListener(this);
	iFontSize40.setActionCommand("Size40");
	menuFontSize.add(iFontSize40);

	iFontSize44 = new JMenuItem("44");
	iFontSize44.addActionListener(this);
	iFontSize44.setActionCommand("Size44");
	menuFontSize.add(iFontSize44);

	iFontSize48 = new JMenuItem("48");
	iFontSize48.addActionListener(this);
	iFontSize48.setActionCommand("Size48");
	menuFontSize.add(iFontSize48);

	iFontSize52 = new JMenuItem("52");
	iFontSize52.addActionListener(this);
	iFontSize52.setActionCommand("Size52");
	menuFontSize.add(iFontSize52);	

}

public void createColorMenu()
 {
        iColor1 = new JMenuItem("White");
        iColor1.addActionListener(this);
        iColor1.setActionCommand("White");
        menuColor.add(iColor1);
        menuColor.addSeparator();

        iColor2 = new JMenuItem("Black");
        iColor2.addActionListener(this);
        iColor2.setActionCommand("Black");
	menuColor.add(iColor2);
	menuColor.addSeparator();

        iColor3 = new JMenuItem("Blue");
        iColor3.addActionListener(this);
        iColor3.setActionCommand("Blue");
	menuColor.add(iColor3);
	menuColor.addSeparator();

	iColor4 = new JMenuItem("Orange");
        iColor4.addActionListener(this);
        iColor4.setActionCommand("Orange");
	menuColor.add(iColor4);
	menuColor.addSeparator();
        
	iColor5 = new JMenuItem("Green");
        iColor5.addActionListener(this);
        iColor5.setActionCommand("Green");
	menuColor.add(iColor5);
	menuColor.addSeparator();
        
	iColor6 = new JMenuItem("Red");
        iColor6.addActionListener(this);
        iColor6.setActionCommand("Red");
        menuColor.add(iColor6);
        menuColor.addSeparator();
        
	iColor7 = new JMenuItem("Yellow");
        iColor7.addActionListener(this);
        iColor7.setActionCommand("Yellow");
	menuColor.add(iColor7);
	menuColor.addSeparator();
        
	iColor8 = new JMenuItem("Pink");
        iColor8.addActionListener(this);
        iColor8.setActionCommand("Pink");
	menuColor.add(iColor8);
        
}

public void actionPerformed(ActionEvent e)
 {
	
	if(e.getSource()==cut)
	textArea.cut();

	if(e.getSource()==copy)
	textArea.copy();

	if(e.getSource()==paste)
	textArea.paste();

	if(e.getSource()==selectAll)
	textArea.selectAll();

	 if(e.getSource()==find)
	{
	if(GUI.this.textArea.getText().length()==0)
		return;	// text box have no text
	if(findReplaceDialog==null)
		findReplaceDialog=new FindDialog(GUI.this.textArea);
	findReplaceDialog.showDialog(GUI.this.window,true);//find
	}
	 	 
	  if(e.getSource()==editFindNex)
	 {
	 if(GUI.this.textArea.getText().length()==0)
	 	return;	// text box have no text

	 if(findReplaceDialog==null)
	 	statusBar.setText("Nothing to search for, use Find option of Edit Menu first !!!!");
	 else
	 	findReplaceDialog.findNextWithSelection();
	 }
	
	  
	  ////////////////////////////////////
	  
	
	  
	  if(e.getSource()==editReplace)
	 {
	 if(GUI.this.textArea.getText().length()==0)
	 	return;	// text box have no text

	 if(findReplaceDialog==null)
	 	findReplaceDialog=new FindDialog(GUI.this.textArea);
	 findReplaceDialog.showDialog(GUI.this.window,false);//replace
	 }
	
	  String LAF;
      if (e.getSource() == windows)
          LAF = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
      else if (e.getSource() == metal)
          LAF = "javax.swing.plaf.metal.MetalLookAndFeel";
      else if (e.getSource() == nimbus)
    	  
          LAF = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
      else
          LAF = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";

      try {
          UIManager.setLookAndFeel(LAF);
          SwingUtilities.updateComponentTreeUI(window);
      } catch (Exception e1) {
          System.out.println("Error setting the LAF..." + e1);
      }
	    
	  
	  ////////////////////////////////////
	//////
  String command = e.getActionCommand();
	
        switch(command) 
	{
	case "New": file.newFile(); break;
	case "Open": file.open(); break;
	case "Save": file.save(); break;
	case "SaveAs": file.saveAs(); break;
	case "Exit": file.exit(); break;

	case "Undo": edit.undo(); break;
	case "Redo": edit.redo(); break;
	
	case "Word Wrap": format.wordWrap(); break;
	case "Arial": format.setFont(command); break;
	case "Comic Sans MS": format.setFont(command); break;
	case "Times New Roman": format.setFont(command); break;
	case "Impact": format.setFont(command); break; 	
	case "Calibri": format.setFont(command); break; 
	case "Century": format.setFont(command); break; 
	case "Gadugi": format.setFont(command); break; 
	case "Ink Free": format.setFont(command); break; 
	case "Dubai": format.setFont(command); break; 

	case "Size8": format.createFont(8); break;
	case "Size12": format.createFont(12); break;
	case "Size16": format.createFont(16); break;
	case "Size20": format.createFont(20); break;
	case "Size24": format.createFont(24); break;
	case "Size28": format.createFont(28); break;
	case "Size32": format.createFont(32); break;
	case "Size36": format.createFont(36); break;
	case "Size40": format.createFont(40); break;
	case "Size44": format.createFont(44); break;
	case "Size48": format.createFont(48); break;
	case "Size52": format.createFont(52); break;
	
	case "White": color.changeColor(command); break;
	case "Black": color.changeColor(command); break;
	case "Blue": color.changeColor(command); break;
	case "Orange": color.changeColor(command); break;
	case "Green": color.changeColor(command); break;
	case "Red": color.changeColor(command); break;
	case "Yellow": color.changeColor(command); break;
	case "Pink": color.changeColor(command); break; 	
	
	}
     }
}
