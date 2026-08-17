import javax.swing.*;
import java.awt.*;
public abstract class Piece
{
    protected ImageIcon image;
    protected boolean color;
    public Piece(boolean color)
    {
        this.color=color;
    }
    public void drawPiece(int x, int y, Graphics g)
    {
        g.drawImage(image.getImage(),x,y,35,35,null);
    }
    public abstract boolean canMove(int startx, int starty, int endx, int endy);
}
