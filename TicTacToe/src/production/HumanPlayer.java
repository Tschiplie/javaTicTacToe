package production;

import java.awt.Point;

public class HumanPlayer implements IPlayer, IMoveListener {

	private Point move;
	private IInputDevice input;

	public HumanPlayer(IInputDevice input) {
		this.input = input;
	}

	@Override
	public void moveOccured(int row, int column) {
		move = new Point(row, column);
	}

	@Override
	public Point getMove(String situation) throws PlayerException {
		move = null;
		input.setMoveListener(this);
		while (move == null) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		return move;
	}

}
