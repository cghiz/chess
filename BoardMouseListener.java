import java.awt.event.*;
public class BoardMouseListener implements MouseListener
{
    private int startx;
    private int starty;
    public void mousePressed(MouseEvent e)
    {
        //where the mouse was pressed
        startx= e.getX()/44;
        starty= e.getY()/44;
    }
    public void mouseReleased(MouseEvent e)
    {
        //where it was released
        int endx= e.getX()/44;
        int endy= e.getY()/44;
        //checking if they are real
        if (startx<0||startx>7||starty<0||starty>7|| endx<0||endx>7||endy<0||endy>7)
        {
            return;
        }
        //doesnt make it a move if same square it starts at 
        if (startx==endx&&starty==endy)
        {
            return;
        }
        //checks if its at starting position
        if (Chess.position[startx][starty]==null)
        {
            return;
        }
        if (Chess.position[startx][starty].color==false)
        {
            return;
        }
        //only able to move white 
        if (Chess.position[startx][starty].canMove(startx,starty,endx,endy))
        {
            //checking if legal
            Chess.position[endx][endy]= Chess.position[startx][starty];
            Chess.position[startx][starty]=null;
            e.getComponent().repaint();
        }
        else
        {
            return;
        }
        //computa do ya thing
        while(true)
        {
            //random selection of piece and placement
            int computerStartX= (int)(Math.random()*8);
            int computerStartY= (int)(Math.random()*8);
            int computerEndX= (int)(Math.random()*8);
            int computerEndY= (int)(Math.random()*8);
            if (Chess.position[computerStartX][computerStartY]==null)
            {
                //trying if no piece at start
                continue;
            }
            if (computerStartX==computerEndX && computerStartY==computerEndY)
            {
                //try again if computer tried same square
                continue;
            }
            if (Chess.position[computerStartX][computerStartY].color== true)
            {
                //try again if white
                continue;
            }
            if (Chess.position[computerEndX][computerEndY]!= null && Chess.position[computerEndX][computerEndY].color==false)
            {
                //try again if theres a black piece in spot
                continue;
            }
            if(!Chess.position[computerStartX][computerStartY].canMove(computerStartX,computerStartY,computerEndX,computerEndY))
            {
                //try again if not valid
                continue;
            }
            //move the piece
            Chess.position[computerEndX][computerEndY]= Chess.position[computerStartX][computerStartY];
            Chess.position[computerStartX][computerStartY]=null;
            //draw the board
            e.getComponent().repaint();
            break;
        }
    }
    public void mouseClicked(MouseEvent e)
    {
    }
    public void mouseEntered(MouseEvent e)
    {
    }
    public void mouseExited(MouseEvent e)
    {
    }
}
