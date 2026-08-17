import javax.swing.*;
import java.awt.*;
public abstract class Piece
{
    //image and color storage
    protected ImageIcon image;
    protected boolean color;
    public Piece(boolean color)
    {
        this.color=color;
    }
    //draws the pieces needed
    public void drawPiece(int x, int y, Graphics g)
    {
        g.drawImage(image.getImage(),x,y,35,35,null);
    }
    //let the pieces do their thing
    public abstract boolean canMove(int startx, int starty, int endx, int endy);
}
