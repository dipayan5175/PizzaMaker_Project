package gui;

import java.awt.Graphics;

public interface Drawable
{
    public void draw(Graphics g, int width, int height);
    public void mouseClicked(int x, int y);
    public void keyPressed(char key);
}