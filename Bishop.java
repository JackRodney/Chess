public class Bishop extends ChessPiece 
{
    private String type = "Bishop";

    public Bishop(int x, int y, ChessBoard b, int colour)
    {
        super(x, y, b, colour);

    }

    
    public void pieceClicked() {
        
        
        if (colour == cb.getTurn()) {
            cb.clearHighlights();
            cb.setActivePiece(this);
    
            
            for (int i = 1; xLocation + i < 8 && yLocation + i < 8; i++) {
                if (!highlightSquare(xLocation + i, yLocation + i)) {
                    break; 
                }
            }
    
            for (int i = 1; xLocation - i >= 0 && yLocation - i >= 0; i++) {
                if (!highlightSquare(xLocation - i, yLocation - i)) {
                    break; 
                }
            }
    
            
            for (int i = 1; xLocation + i < 8 && yLocation - i >= 0; i++) {
                if (!highlightSquare(xLocation + i, yLocation - i)) {
                    break; 
                }
            }
    
            for (int i = 1; xLocation - i >= 0 && yLocation + i < 8; i++) {
                if (!highlightSquare(xLocation - i, yLocation + i)) {
                    break; 
                }
            }
        }
    }

    public String getType(){return type;}
    
}
