import javax.swing.*;
public class knight extends Piece
{
    public knight(boolean color)
    {
        super(color);
        if (color==true)
        {
            image= new ImageIcon("src/wknight.png");
        }
        else
        {
            image= new ImageIcon("src/bknight.png");
        }
    }
    public boolean canMove(int startx, int starty,int endx,int endy)
    {
        int xDifference = Math.abs(endx-startx);
        int yDifference = Math.abs(endy-starty);
        if ((xDifference==2&&yDifference==1)||(xDifference==1&&yDifference==2))
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
