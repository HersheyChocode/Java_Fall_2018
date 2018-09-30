package w4day1;
import apcs.Window;
public class Pong {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int width = 500;//Creates width var for the screen
		int height = 375;//Creates height var for screen
		Window.size(width, height);
		int paddleOneX = 5;//right paddle x
		int paddleOneY = height/2;//right paddle y
		int paddleTwoX = 495;// left paddle x
		int paddleTwoY = height/2;//left paddle y
		int x = width/2;//x
		int y = height/2;//y
		int dx = 10;//direction for x circle
		int dy = 10;//direction of y circle
		int rad = 20;//radius for circle
		int paddleWidth = 10;//Width of paddle
		int paddleHeight = 60;//Height of paddle
		int scoreOne = 0;//initial score of player one
		int scoreTwo = 0;//initial score of player two
		while(scoreOne<10 && scoreTwo<10) { //Forever until we say to stop
			Window.frame();//frame
			Window.out.background("light green");//Background
			Window.out.color("light blue");//Paint color change
			Window.out.rectangle(width/2, height/2, width/40, height);//Middle sector
			Window.out.color("black");//Color change
			Window.out.print("Player One: " + scoreOne, width/4, 20);//Prints score
			Window.out.print("Player Two: " + scoreTwo, width*3/4, 20);//Prints score
			Window.out.rectangle(paddleOneX, paddleOneY, paddleWidth, paddleHeight);//Paddle one, left
			Window.out.rectangle(paddleTwoX, paddleTwoY, paddleWidth, paddleHeight);//Paddle two, right
			Window.out.color("light pink");//paint color = pink
			Window.out.circle(x, y, rad);//creates circle
			if (x<=rad) {//if x <= left edge
				dx = -dx; //oppose the direction
				scoreTwo += 1; //Adds a point for player two
			}
			if (x>=width-rad) {//if x >= right edge
				dx = -dx; //oppose the direction
				scoreOne += 1; //Adds a point for player one
			}
			if (y+rad>=height||y<=rad) {//if y = top edge or bottom edge
				dy = -dy;//oppose the direction
			}
			if (x-paddleWidth-rad<=paddleOneX&&y<=paddleOneY+paddleHeight&&y>=paddleOneY-paddleHeight) {//If the x and y are touching paddle one
				dx = -dx; //oppose the direction
			}
			
			if (x+paddleWidth+rad>=paddleTwoX&&y<=paddleTwoY+paddleHeight&&y>=paddleTwoY-paddleHeight) {//If the x and y are touching paddle two
				dx = -dx; //oppose the direction
			}
			if (Window.key.pressed("up")&&paddleOneY-paddleHeight/2> 0) {//If up is pressed
				paddleOneY -= 10; //Paddle moves up
			} else if (Window.key.pressed("down")&&paddleOneY+paddleHeight/2<height) { //else if down is pressed
				paddleOneY += 10; //Paddle moves down
			}
			if (Window.key.pressed("w")&&paddleTwoY-paddleHeight/2> 0) {//If 'W' is pressed
				paddleTwoY -= 10; //Paddle moves up
			} else if (Window.key.pressed("s")&&paddleTwoY+paddleHeight/2<height) { //Else if 'S' is pressed
				paddleTwoY += 10; //Paddle moves down
			}
			x = x+dx; //X of circle moves
			y = y + dy; //Y of circle moves
		}
	} 
}
