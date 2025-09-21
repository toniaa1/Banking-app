package Pong;
import java.awt.*;
import java.awt.event.*;

public class Paddle extends Rectangle{

	int id;
	int yVelocity;
	int speed = 10;
	
	Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT){//, int id)
		super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
	}
	
	public void keyPressed(KeyEvent e) {

			if(e.getKeyCode()==KeyEvent.VK_UP) {
				setYDirection(-speed);
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				setYDirection(speed);
			}
	}
	public void keyReleased(KeyEvent e) {

			if(e.getKeyCode()==KeyEvent.VK_UP) {
				setYDirection(0);
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				setYDirection(0);
			}

	}
	public void setYDirection(int yDirection) {
		yVelocity = yDirection;
	}
	public void move() {
		y= y + yVelocity;
	}
	public void draw(Graphics g) {
		if(id==1)
			g.setColor(Color.blue);
		else
			g.setColor(Color.red);
		g.fillRect(x, y, width, height);
	}
}