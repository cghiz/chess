import javax.swing.*;
public class bishop extends Piece {
    public bishop(boolean color) {
        super(color);
        if (color == true) {
            image = new ImageIcon("src/wbishop.png");
        } else {
            image = new ImageIcon("src/bbishop.png");
        }
    }

    public boolean canMove(int startx, int starty, int endx, int endy)
    {
        int xDifference = Math.abs(endx - startx);
        int yDifference = Math.abs(endy - starty);
        //moves diagonally
        if (xDifference!=yDifference)
        {
            return false;
        }
        //directions
        int xDirection=1;
        int yDirection=1;
        if (endx<startx)
        {
            xDirection=-1;
        }
        if (endy<starty)
        {
            yDirection=-1;
        }
        int x= startx+xDirection;
        int y= starty+yDirection;
        //look for blocks
        while(x!= endx|| y!= endy)
        {
            if (Chess.position[x][y]!=null)
            {
                return false;
            }
            x +=xDirection;
            y+= yDirection;
        }
        //empty
        if (Chess.position[endx][endy]== null)
        {
            return true;
        }
        //capture
        if (Chess.position[endx][endy].color != color)
        {
            return true;
        }
        return false;
    }
}
