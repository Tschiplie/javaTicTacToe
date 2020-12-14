package production;

import java.awt.Point;
import java.util.List;

public class MatchController {
    private IPlayer player1;
    private IPlayer player2;
    private IModel model;
    private List<IView> views;
    
    public MatchController(IPlayer player1, IPlayer player2, IModel model, List<IView> views) {
        this.player1 = player1;
        this.player2 = player2;
        this.model = model;
        this.views = views;
    }

    public void play() {
        for (int i = 0; i < 9; i++) {
            boolean even = i % 2 == 0;
            IPlayer currentPlayer = even ? player1 : player2;
            try {
				Point move = currentPlayer.getMove(model.toServerString());
				EFieldState currentFieldState = even ? EFieldState.CROSS : EFieldState.CIRCLE;
				model.setFieldState((int)move.getX(), (int) move.getY(), currentFieldState);
				for (IView view : views) {
					view.refresh();				
				}
			} catch (PlayerException e) {
				e.printStackTrace();
				System.exit(0);
			}
        }
    }
}
