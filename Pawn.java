
public class Pawn extends ChessPiece 
{
    private String type = "Pawn";
    
    public Pawn(int x, int y, ChessBoard board, int colour)
    {
        super(x, y, board, colour);
        // if(colour == 0){
        //     this.setImage("images/White/Pawn.png");
        // }else{this.setImage("images/Black/Pawn.png");}

    }

    public void pieceClicked()
    {
        if(colour == cb.getTurn()){
            cb.clearHighlights();
            cb.setActivePiece(this);
            
            if(highlightSquare(xLocation, yLocation - 1)){
                if(yLocation == 6){
                    highlightSquare(xLocation, yLocation - 2);
                }
            }
        }
    }
    
    public String getType(){return type;}

}
