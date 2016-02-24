package com.jhartz;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.script.ScriptException;


public class Field extends Frame implements Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Image ballImage, paddleImage;
	Image memoryImage;
	
	Thread thread;
	
	MainBall ball;
	
	MainPaddle paddle;
	
	int sleepTime = 50;
	
	Dimension screenSize;
	
	Graphics memoryGraphics;

	Field() {
		setTitle("Block Breaker");
		
		int taskBarSize = 60;
		screenSize = new Dimension(1200, 750);
		setSize(screenSize.width, screenSize.height - taskBarSize);
		setResizable(false);
		setVisible(true);	
		
		try {
			ballImage = ImageIO.read(new File("Images/Ball.png"));
			paddleImage = ImageIO.read(new File("Images/Paddle.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		
		memoryImage = createImage(getSize().width, getSize().height); 
		memoryGraphics = memoryImage.getGraphics(); 

		thread = new Thread(this);
		thread.start();
		
	}
	
	public static void main(String [] args){
		Field field = new Field();
	}
	
	public void update(Graphics g) {
		memoryGraphics.fillRect(0, 0, screenSize.width, screenSize.height);
		ball.drawBall(memoryGraphics);
		paddle.drawPaddle(memoryGraphics);
		g.drawImage(memoryImage, 0, 0, this);
	}

	@Override
	public void run() {
		int left = 0;
		int top = 0 + 20;
		int right = getWidth();
		int bottom = getHeight();
		
		Rectangle bounds = new Rectangle(left, top, right, bottom);
		ball = new MainBall(ballImage, bounds, this);
		paddle = new MainPaddle(paddleImage, bounds, this);
		
		while (true) {
			try {
				ball.move();
			} catch (BallBelowBoundsException e1) {
				System.exit(0);
			}
			paddle.move();
			checkCollision();
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
		}
	}
	
	public void checkCollision() {
		if (ball.location.x > paddle.location.x && ball.location.x + ball.size < paddle.location.x + paddle.paddleWidth){
			if (ball.location.y + ball.size > paddle.location.y) {
				ball.changeYVel();
			}
		}
	}
}
