import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener
{

	GUI gui;

	public KeyHandler(GUI gui)
	{
		this.gui =  gui;
	}

	public void keyTyped(KeyEvent e)
	{

		
	}
	public void keyPressed(KeyEvent e)
	{
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S)
		{
			gui.file.save();
		}

		if(e.isShiftDown() && e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S)
		{
		
			gui.file.saveAs();
		}

		if(e.isAltDown() && e.getKeyCode()==KeyEvent.VK_F)
		{

			gui.menuFile.doClick();
		}
		if(e.isAltDown() && e.getKeyCode()==KeyEvent.VK_E)
		{
			gui.menuEdit.doClick();
		}
		if(e.isAltDown() && e.getKeyCode()==KeyEvent.VK_O)
		{
			gui.menuFormat.doClick();
		}
		if(e.isAltDown() && e.getKeyCode()==KeyEvent.VK_C)
		{
			gui.menuColor.doClick();
		}



		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_N)
		{
			gui.file.newFile();
		}

		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_O)
		{
			gui.file.open();
		}
		
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_0)
		{
			gui.file.exit();
		}

		
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_Z)
		{
			gui.edit.undo();
		}

		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_R)
		{
			gui.edit.redo();
		}



	}	

	public void keyReleased(KeyEvent e)
	{
	}

}