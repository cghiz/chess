import java.awt.event.*;
public class BoardMouseListener implements MouseListener
{
    private int startx;
    private int starty;
    public void mousePressed(MouseEvent e)
    {
        startx= e.getX()/44;
        starty= e.getY()/44;
    }
    public void mouseReleased(MouseEvent e)
    {
        int endx= e.getX()/44;
        int endy= e.getY()/44;

        if (startx<0||startx>7||starty<0||starty>7|| endx<0||endx>7||endy<0||endy>7)
        {
            return;
        }
        if (startx==endx&&starty==endy)
        {
            return;
        }
        if (Chess.position[startx][starty]==null)
        {
            return;
        }
        if (Chess.position[startx][starty].color==false)
        {
            return;
        }
        if (Chess.position[startx][starty].canMove(startx,starty,endx,endy))
        {
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
            int computerStartX= (int)(Math.random()*8);
            int computerStartY= (int)(Math.random()*8);
            int computerEndX= (int)(Math.random()*8);
            int computerEndY= (int)(Math.random()*8);
            if (Chess.position[computerStartX][computerStartY]==null)
            {
                continue;
            }
            if (computerStartX==computerEndX && computerStartY==computerEndY)
            {
                continue;
            }
            if (Chess.position[computerStartX][computerStartY].color== true)
            {
                continue;
            }
            if (Chess.position[computerEndX][computerEndY]!= null && Chess.position[computerEndX][computerEndY].color==false)
            {
                continue;
            }
            if(!Chess.position[computerStartX][computerStartY].canMove(computerStartX,computerStartY,computerEndX,computerEndY))
            {
                continue;
            }
            Chess.position[computerEndX][computerEndY]= Chess.position[computerStartX][computerStartY];
            Chess.position[computerStartX][computerStartY]=null;
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
