package production;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

public class TicTacToeBoardPanel extends JPanel implements IView, IInputDevice{
	private IModel model;
	private double scale;
	private IMoveListener iml;
	
	public TicTacToeBoardPanel(IModel model) {
		this.model = model;
		setBackground(Color.YELLOW);
		setPreferredSize(new Dimension(450, 450));
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int column = (int) (e.getX() / scale / 100);
				int row = (int) (e.getY() / scale / 100);
				if (column < 3 && row < 3 && column >= 0 && row >= 0 && iml != null) {
					iml.moveOccured(row, column);
				}
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		configureGraphicsForUsageOfUserCoordinateSystem(g2);
		drawGrid(g2);
		drawFieldStates(g2);
	}

	private void drawFieldStates(Graphics2D g2) {
		for (int column = 0; column < 3; column++) {
			for (int row = 0; row < 3; row++) {
				EFieldState state = model.getFieldState(row, column);
				switch (state) {
				case CIRCLE:
					g2.drawOval(100 * column, 100 * row, 100, 100);
					break;
				case CROSS:
					g2.drawLine(column * 100, row * 100, column * 100 + 100, row * 100 + 100);
					g2.drawLine(column * 100 + 100, row * 100, column * 100, row * 100 + 100);
					break;
				default:
					break;
				}
			}
		}
	}

	private void drawGrid(Graphics2D g2) {
		g2.drawLine(0, 100, 300, 100);
		g2.drawLine(0, 200, 300, 200);
		g2.drawLine(100, 0, 100, 300);
		g2.drawLine(200, 0, 200, 300);
		g2.drawRect(0, 0, 300, 300);
	}

	private void configureGraphicsForUsageOfUserCoordinateSystem(Graphics2D g2) {
		double xscale = getWidth() / 300.0;
		double yscale = getHeight() / 300.0;
		scale = Math.min(xscale, yscale);
		AffineTransform at = AffineTransform.getScaleInstance(scale, scale);
		g2.transform(at);
	}

	@Override
	public void refresh() {
		repaint();
	}

	@Override
	public void setMoveListener(IMoveListener iml) {
		this.iml = iml;
	}
}
