import javax.swing.*;
import java.awt.*;
public class BoardComponent extends JComponent
{
    public BoardComponent()
    {
        addMouseListener(new BoardMouseListener());
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for (int x=0;x<8;x++)
        {
            for (int y=0;y<8;y++)
            {
                if((x%2==0 && y%2==0)||(x%2!=0 && y%2!=0))
                {
                    g.setColor(new Color(177,113,24));
                }
                else
                {
                    g.setColor(new Color(233,174,95));
                }
                g.fillRect(x*44,y*44,44,44);
                if (Chess.position[x][y]!=null)
                {
                    Chess.position[x][y].drawPiece(x*44+12,y*44+12,g);
                }
            }
        }
    }
}
