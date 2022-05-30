
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Panel extends JPanel implements ActionListener {

	final int WIDTH = 700;
	final int HEIGHT = 700;
	Image enemy;
	Timer timer;
	int xVelocity = 1;
	int yVelocity = 1;
	int x = 0;
	int y = 0;
	
	int randEnemy;
	
	Panel(){
		
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(Color.black);
		enemy = new ImageIcon("img/dvd0.png").getImage();
		timer = new Timer(10, this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		
		super.paint(g);
		
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawImage(enemy, x, y, null);
	}
	
	public void getRandomEnemy() {
		
	    int n = (int) (Math.random() * 8);
	    while (n == randEnemy || n > 8) {
	    	n = (int) (Math.random() * 8);
	        n += 1;
	    }
	    
	    randEnemy = n;
		enemy = new ImageIcon("img/dvd" + randEnemy + ".png").getImage();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(x >= WIDTH - enemy.getWidth(null) || x < 0) {
			xVelocity = xVelocity * -1;
			getRandomEnemy();
		}
		x = x + xVelocity;
		
		if(y >= HEIGHT - enemy.getHeight(null) || y < 0) {
			yVelocity = yVelocity * -1;
			getRandomEnemy();
		}
		y = y + yVelocity;
		
		repaint();
	}	
}