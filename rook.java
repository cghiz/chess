import javax.swing.*;
public class rook extends Piece
{
    public rook(boolean color)
    {
        super(color);
        if (color==true)
        {
            image= new ImageIcon("src/wrook.png");
        }
        else
        {
            image= new ImageIcon("src/brook.png");
        }
    }
    public boolean canMove(int startx, int starty, int endx,int endy)
    {
        //rook can go horizontal or vertical 
        if (startx!=endx&&starty!=endy) {
            return false;
        }
        //figure out direction
        int xDirection=0;
        int yDirection=0;
        if (endx>startx) {
            xDirection = 1;
        }
        else if  (endx<startx)
        {
            xDirection = -1;
        }
        else if(endy>starty)
        {
            yDirection = 1;
        }
        else if (endy<starty)
        {
            yDirection = -1;
        }
        int x= startx+xDirection;
        int y= starty+yDirection;
        //check if piece in the way
        while(x!=endx ||y!=endy) {
            if (Chess.position[x][y] != null) {
                return false;
            }
            x += xDirection;
            y += yDirection;
        }
        //empty space
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
