

import javax.swing.*;
import java.awt.*;
import panel.*;

public class MoveCircleMain {

	public static void main(String[] args) 
	{
		
		
			JFrame theGUI = new JFrame();
			//theGUI.setTitle(“GUI Program”);
			
			theGUI.setSize(600, 600);
			theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			//ColorPanel panel = new ColorPanel(Color.black, theGUI);
			ColorPanel panel = new ColorPanel (Color.black, 500, 200);
			Container pane = theGUI.getContentPane();
			pane.add(panel);
			
			theGUI.setVisible(true);

	}

}
