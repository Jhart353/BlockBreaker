package com.jhartz;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

public class Block implements BlockAction {
	// The frame to draw the block to.
	Component field;
	
	// The outside bounds of the frame.
	Rectangle bounds;
	
	// The image related to the block.
	Image image;
	
	// Top left location of the block
	Point location;
	
	Block(Image image, Rectangle bounds, Component field) {
		
	}
	
	@Override
	public void draw(Graphics g) {

		
	}
}
