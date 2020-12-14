package production;

import java.awt.Point;

import bib.fernuni.server_communicator.Communicator;
import bib.fernuni.server_communicator.CommunicatorException;

public class NetworkPlayer implements IPlayer {

	private Communicator com;
	
	
	public NetworkPlayer(String host) {
		com = new Communicator(host, 7890, "UTF-8");
	}

	@Override
	public Point getMove(String situation) throws PlayerException {
		try {
			String response = com.communicate(situation + "\n");
			if (response.startsWith("Error")) {
				throw new PlayerException(response);
			}
			int result = Integer.parseInt(response.trim());
			int row = (result - 1) / 3;
			int column = (result - 1) % 3;
			Point p = new Point(row, column);
			return p;
			
		} catch (CommunicatorException | NumberFormatException e) {
			throw new PlayerException(e);
		}
	}

}
