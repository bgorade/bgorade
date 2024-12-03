import java.awt.Font;

public class Function_Format
{
	GUI gui;
	Font arial, comicSansMS, timesNewRoman, calibri, impact, century, gadugi, ink_free, dubai;
	String selectedFont;

public Function_Format(GUI gui)
{
	this.gui = gui;
}
public void wordWrap()
{
	if(gui.wordWrapOn==false)
	{
		gui.wordWrapOn=true;
		gui.textArea.setLineWrap(true);
		gui.textArea.setWrapStyleWord(true);
		gui.iWrap.setText("Word Wrap: On");
	}
	else if(gui.wordWrapOn==true)
	{
		gui.wordWrapOn=false;
		gui.textArea.setLineWrap(false);
		gui.textArea.setWrapStyleWord(false);
		gui.iWrap.setText("Word Wrap: Off");
			
	}

}

public void createFont(int fontSize)
{
	arial=new Font("Arial", Font.PLAIN, fontSize);
	comicSansMS=new Font("Comic Sans MS", Font.PLAIN, fontSize);
	timesNewRoman=new Font("Times New Roman", Font.PLAIN, fontSize);
	impact=new Font("Impact",Font.PLAIN, fontSize);
	calibri=new Font("Calibri",Font.PLAIN, fontSize);
	century=new Font("Century",Font.PLAIN, fontSize);	
	gadugi=new Font("Gadugi",Font.PLAIN, fontSize);
	ink_free=new Font("Ink Free",Font.PLAIN, fontSize);
	dubai=new Font("Dubai",Font.PLAIN, fontSize);

	setFont(selectedFont);
}

public void setFont(String font)
{
	selectedFont = font;

	switch(selectedFont)
	{
		case "Arial":
			gui.textArea.setFont(arial);
			break;
		case "Comic Sans MS":
			gui.textArea.setFont(comicSansMS);
			break;
		case "Times New Roman":
			gui.textArea.setFont(timesNewRoman);
			break;
		case "Impact":
			gui.textArea.setFont(impact);
			break;
		case "Calibri":
			gui.textArea.setFont(calibri);
			break;		
		case "Century":
			gui.textArea.setFont(century);
			break;
		case "Gadugi":
			gui.textArea.setFont(gadugi);
			break;
		case "Ink Free":
			gui.textArea.setFont(ink_free);
			break;
		case "Dubai":
			gui.textArea.setFont(dubai);
			break;
		
	}		
}


}