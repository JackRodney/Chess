
public class Pawn extends ChessPiece 
{
    private String type = "Pawn";
    
    public Pawn(int x, int y, ChessBoard board, int colour)
    {
        super(x, y, board, colour);

    }

    public void pieceClicked()
    {
        if(colour == cb.getTurn()){

            cb.clearHighlights();
            cb.setActivePiece(this);
            
           

            if(!(cb.getSquareAt(xLocation, yLocation - 1).getPiece() instanceof ChessPiece)){
                if(highlightSquare(xLocation, yLocation - 1)){
                    if(yLocation == 6){
                        if(!(cb.getSquareAt(xLocation, yLocation - 2).getPiece() instanceof ChessPiece)){
                            highlightSquare(xLocation, yLocation - 2);
                        }
                    }
                }
            }

            if(cb.getSquareAt(xLocation - 1, yLocation - 1).getPiece() != null){
                highlightSquare(xLocation - 1, yLocation -1);
                
            }

            if(cb.getSquareAt(xLocation + 1, yLocation - 1).getPiece() != null){
                highlightSquare(xLocation + 1, yLocation -1);
                
            }
            

        }
    }
    
    public String getType(){return type;}

}
