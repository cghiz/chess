import javax.swing.*;
public class queen extends Piece
{
    public queen(boolean color)
    {
        super(color);
        if (color==true)
        {
            image= new ImageIcon("src/wqueen.png");
        }
        else
        {
            image= new ImageIcon("src/bqueen.png");
        }
    }
    public boolean canMove(int startx, int starty, int endx, int endy)
    {
        int xDifference = Math.abs(endx-startx);
        int yDifference = Math.abs(endy-starty);
        //horizontal,vertical, or diagonal
        if (startx!=endx && starty!=endy && xDifference!=yDifference) {
            return false;
        }
        //direction
        int xDirection=0;
        int yDirection=0;
        if (endx>startx) {
            xDirection = 1;
        }
        else if  (endx<startx)
        {
            xDirection = -1;
        }
        if(endy>starty)
        {
            yDirection = 1;
        }
        else if (endy<starty)
        {
            yDirection = -1;
        }
        int x= startx+xDirection;
        int y= starty+yDirection;
        //no pieces in the way
        while(x!=endx ||y!=endy) {
            if (Chess.position[x][y] != null) {
                return false;
            }
            x += xDirection;
            y += yDirection;
        }
        //empty spaces
        if (Chess.position[endx][endy]==null)
        {
            return true;
        }
        //capture
        if (Chess.position[endx][endy].color!= color)
        {
            return true;
        }
        return false;
    }
}
