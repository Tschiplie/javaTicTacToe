import production.EFieldState;
import production.IModel;
import production.IMoveListener;
import production.JComponentTestFrame;
import production.Model;
import production.TicTacToeBoardPanel;

public class ComponentTest {


	public static void main(String[] args) {
		IModel m = new Model();
		m.setFieldState(1, 2, EFieldState.CROSS);
		m.setFieldState(2, 1, EFieldState.CIRCLE);
		System.out.println(m);
		TicTacToeBoardPanel c = new TicTacToeBoardPanel(m);
		IMoveListener iml = new IMoveListener() {
	
			@Override
			public void moveOccured(int row, int column) {
				System.out.println(row + " " + column);
			}
		};
		c.setMoveListener(iml);
		
		new JComponentTestFrame(c);
		

	}

}
