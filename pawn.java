import javax.swing.*;
public class pawn extends Piece
{
    public pawn(boolean color)
    {
        super(color);
        if (color == true)
        {
            image = new ImageIcon("src/wpawn.png");
        } else
        {
            image = new ImageIcon("src/bpawn.png");
        }
    }

    public boolean canMove(int startx, int starty, int endx, int endy)
    {
        if (color == true) {
            //moves forward
            if (endx == startx && endy == starty - 1) {
                //only by one
                if (Chess.position[endx][endy] == null) {
                    return true;
                }
            }
            //IF FIRST MOVE CAN GO 2 FOR EACH PAWN
            if (starty == 6 && endx == startx && endy == starty - 2) {
                if (Chess.position[startx][starty - 1] == null && Chess.position[endx][endy] == null) {
                    return true;
                }
            }
            //capture diagonally
            if (Math.abs(endx - startx) == 1 && endy == starty - 1) {
                if (Chess.position[endx][endy] != null && Chess.position[endx][endy].color != color) {
                    return true;
                }
            }
        }
        else
        {
            //black pawn gets its own
            if (endx == startx && endy == starty + 1) {
                if (Chess.position[endx][endy] == null) {
                    return true;
                }
            }
            //black pawn FIRST MOVE of pawn can also go 2
            if (starty == 1 && endx == startx && endy == starty + 2) {
                if (Chess.position[startx][starty + 1] == null && Chess.position[endx][endy] == null) {
                    return true;
                }
            }
            //captures diagnally also 
            if (Math.abs(endx - startx) == 1 && endy == starty + 1)
            {
                if (Chess.position[endx][endy] != null && Chess.position[endx][endy].color != color)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
