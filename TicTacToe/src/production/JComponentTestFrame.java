package production;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class JComponentTestFrame extends JFrame {

	public JComponentTestFrame(JComponent jC)  {
		this.add(jC);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	
	


}
