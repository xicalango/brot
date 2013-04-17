package xx.brot;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class BrotPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	private class MouseZoomListener implements MouseListener, MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			if(zoomRectangle != null) {
				Point topLeft = zoomRectangle.getLocation();
				Point lowerRight = e.getPoint();
				
				if(lowerRight.x < topLeft.x || lowerRight.y < topLeft.y) {
					return;
				}
				
				zoomRectangle.width = lowerRight.x - topLeft.x;
				zoomRectangle.height = lowerRight.y - topLeft.y;
				repaint();
			}
		}

		@Override
		public void mouseMoved(MouseEvent e) {}

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getButton() == MouseEvent.BUTTON3) {
				viewport.changeRect(2, 2, -2, -2);
				repaintSet();
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			if(e.getButton() == 1) {
				zoomRectangle = new Rectangle(e.getPoint());
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if(e.getButton() == 1) {
				zoomToRectangle();
			}
		}
		
	}
	
	private SetFn toDrawSet;
	private Viewport viewport;
	
	private BufferedImage bufferedImage;
	
	private Rectangle zoomRectangle = null;
	
	public BrotPanel(SetFn toDrawSet) {
		this.toDrawSet = toDrawSet;
		
		viewport = new Viewport(2, 2, -2, -2);
		viewport.setAspectRatio(true);
		
		setPreferredSize(new Dimension(640,480));
		
		bufferedImage = new BufferedImage(640, 480, BufferedImage.TYPE_INT_ARGB);
		
		
		setBackground(Color.black);
		
		MouseZoomListener mzl = new MouseZoomListener();
		
		addMouseListener(mzl);
		addMouseMotionListener(mzl);

	}
	
	public void zoomToRectangle() {
		if(zoomRectangle == null) {
			return;
		}
		
		if(zoomRectangle.width == 0 && zoomRectangle.height == 0) {
			zoomRectangle = null;
			return;
		}
		
		Dimension size = getSize();
		Point location = zoomRectangle.getLocation();
		Point location2 = new Point(location);
		location2.x += zoomRectangle.width;
		location2.y += zoomRectangle.height;
		
		
		double x1 = viewport.convertX(location, size);
		double y1 = viewport.convertY(location, size);
		double x2 = viewport.convertX(location2, size);
		double y2 = viewport.convertY(location2, size);
		
		viewport.changeRect(x1, y1, x2, y2);
		
		zoomRectangle = null;
		repaintSet();
	}

	private void repaintSet() {
		
		Dimension size = getSize(); //use buffer size
		Graphics g = bufferedImage.getGraphics();
		
		for( int y = 0; y < size.height; y++ ) {
			for( int x = 0; x < size.width; x++ ) {
				Point p = new Point(x, y);
				
				double xx = viewport.convertX(p, size);
				double yy = viewport.convertY(p, size);
				
				int color = toDrawSet.includes(xx, yy);
				g.setColor( new Color(0, color, 0) );
				
				g.drawRect(x, y, 1, 1);
			}
		}
		
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		((Graphics2D)g).drawImage(bufferedImage, 0, 0, this);
		
		
		if(zoomRectangle != null) {
			g.setColor(Color.white);
			g.drawRect(zoomRectangle.x, zoomRectangle.y, zoomRectangle.width, zoomRectangle.height);
		}
		
	}
	
	
	
}
