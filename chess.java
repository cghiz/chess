import javax.swing.*;
public class Chess
{
    public static Piece[][] position= new Piece[8][8];
    public static void main(String[] args)
    {
        //white pieces
        position[0][7]= new rook(true);
        position[1][7]= new knight(true);
        position[2][7]= new bishop(true);
        position[3][7]= new queen(true);
        position[4][7]= new king(true);
        position[5][7]= new bishop(true);
        position[6][7]= new knight(true);
        position[7][7]= new rook(true);
        //white pawns
        position[0][6]= new pawn(true);
        position[1][6]= new pawn(true);
        position[2][6]= new pawn(true);
        position[3][6]= new pawn(true);
        position[4][6]= new pawn(true);
        position[5][6]= new pawn(true);
        position[6][6]= new pawn(true);
        position[7][6]= new pawn(true);
        //black pieces 
        position[0][0]= new rook(false);
        position[1][0]= new knight(false);
        position[2][0]= new bishop(false);
        position[3][0]= new queen(false);
        position[4][0]= new king(false);
        position[5][0]= new bishop(false);
        position[6][0]= new knight(false);
        position[7][0]= new rook(false);
        //black pawns
        position[0][1]= new pawn(false);
        position[1][1]= new pawn(false);
        position[2][1]= new pawn(false);
        position[3][1]= new pawn(false);
        position[4][1]= new pawn(false);
        position[5][1]= new pawn(false);
        position[6][1]= new pawn(false);
        position[7][1]= new pawn(false);
        //chess board
        JFrame frame= new JFrame();
        frame.setSize(352,352);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BoardComponent board= new BoardComponent();
        frame.add(board);
        frame.setVisible(true);
    }
}
