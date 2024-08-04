public class Rook extends ChessPiece 
{
    private String type = "Rook";

    public Rook(int x, int y, ChessBoard b, int colour)
    {
        super(x, y, b, colour);
        if(colour == 0){
            this.setImage("images/White/Rook.png");
        }else{this.setImage("images/Black/Rook.png");}

    }

    public void clicked()
    {
        if (colour == cb.getTurn()) {
            clearHighlights();
    
       
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
    
    public void move()
    {

    }
    
}