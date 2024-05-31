
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

    public void clicked()
    {
        if(colour == cb.getTurn()){
            highlightSquare(xLocation, yLocation - 1);
            if(yLocation == 6){
                highlightSquare(xLocation, yLocation - 2);
            }
        }
    }
    
    public void move()
    {

    }
}
