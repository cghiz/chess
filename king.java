import javax.swing.*;
public class king extends Piece
{
    public king(boolean color)
    {
        super(color);
        if (color==true)
        {
            image= new ImageIcon("src/wking.png");
        }
        else
        {
            image= new ImageIcon("src/bking.png");
        }
    }
    public boolean canMove(int startx,int starty,int endx, int endy)
    {
        int xDifference=Math.abs(endx-startx);
        int yDifference=Math.abs(endy-starty);
        if (xDifference<=1 &&yDifference<=1)
        {
            if (Chess.position[endx][endy]==null)
            {
                return true;
            }
            if (Chess.position[endx][endy].color!=color)
            {
                return true;
            }
        }
        return false;
    }
}
