public class Rook extends ChessPiece 
{
    private String type = "Rook";

    public Rook(int x, int y, ChessBoard b, int colour)
    {
        super(x, y, b, colour);

    }

    public void pieceClicked()
    {
        if (colour == cb.getTurn()) {
            cb.clearHighlights();
            cb.setActivePiece(this);
       
            for (int i = xLocation + 1; i < 8; i++) {
                if (!highlightSquare(i, yLocation)) {
                    break; 
                }
            }
            
            
            for (int i = xLocation - 1; i >= 0; i--) {
                if (!highlightSquare(i, yLocation)) {
                    break; 
                }
            }
    
            for (int i = yLocation + 1; i < 8; i++) {
                if (!highlightSquare(xLocation, i)) {
                    break; 
                }
            }
    
            for (int i = yLocation - 1; i >= 0; i--) {
                if (!highlightSquare(xLocation, i)) {
                    break; 
                }
            }
        }
    }
   
    public String getType(){return type;}
}