
public class Pawn extends ChessPiece 
{
    private String type = "Pawn";
    
    public Pawn(int x, int y, ChessBoard board, int colour)
    {
        super(x, y, board, colour);
        if(colour == 0){
            this.setImage("images/White/Pawn.png");
        }else{this.setImage("images/Black/Pawn.png");}

    }

    public void move()
    {

    }
}
