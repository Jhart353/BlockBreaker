package com.jhartz;

import java.awt.Graphics;

public interface PaddleAction {
	
	public void move(Integer xLoc);
	
	public void draw(Graphics g);
}
