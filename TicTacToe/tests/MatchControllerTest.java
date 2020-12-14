import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;

import production.ConsoleView;
import production.HumanPlayer;
import production.IInputDevice;
import production.IModel;
import production.IPlayer;
import production.IView;
import production.JComponentTestFrame;
import production.MatchController;
import production.Model;
import production.TicTacToeBoardPanel;

public class MatchControllerTest {

    public static void main(String[] args) {
//        IPlayer player1 = new IPlayer() {
//            
//            @Override
//            public Point getMove(String situation) {
//                return new Point(2, 1);
//            }
//        };
//        IPlayer player2 = new IPlayer() {
//            
//            @Override
//            public Point getMove(String situation) {
//                return new Point(0, 0);
//            }
//        };
        
        IModel m = new Model();
        List<IView> views = new ArrayList<IView>();
        IView v = new ConsoleView(m);
        TicTacToeBoardPanel board = new TicTacToeBoardPanel(m);
        IInputDevice input = board;
        IView v2 = board;
        JComponent compo = board;
        
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new JComponentTestFrame(compo);
			}
		});
        views.add(v2);
        views.add(v);
        //IPlayer player1 = new NetworkPlayer("localhost");
		//IPlayer player2 = new NetworkPlayer("localhost");
        IPlayer player1 = new HumanPlayer(input);
        IPlayer player2 = new HumanPlayer(input);
		MatchController mc = new MatchController(player1, player2, m, views);
        mc.play();
    }

}
