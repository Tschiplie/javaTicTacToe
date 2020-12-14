import java.awt.Point;

import bib.fernuni.server_communicator.Communicator;
import bib.fernuni.server_communicator.CommunicatorException;

public class CommunicatorTest {

	public static void main(String[] args) throws CommunicatorException {
		Communicator com = new Communicator("localhost", 7890, "UTF-8");
		
		String response = com.communicate("xxxooo___\n");
		System.out.println(response);
		int result = Integer.parseInt(response.trim());
		System.out.println(result);
		int row = (result - 1) / 3;
		System.out.println(row);
		int column = (result - 1) % 3;
		System.out.println(column);
		Point p = new Point(row, column);
		System.out.println(p);
	}

}
