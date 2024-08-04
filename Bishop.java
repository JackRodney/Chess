public class Bishop extends ChessPiece 
{
    private String type = "Bishop";

    public Bishop(int x, int y, ChessBoard b, int colour)
    {
        super(x, y, b, colour);
        if(colour == 0){
            this.setImage("images/White/Bishop.png");
        }else{this.setImage("images/Black/Bishop.png");}

    }

    
    public void clicked() {
        if (colour == cb.getTurn()) {
            clearHighlights();
    
            
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
    
    
    public void move()
    {

    }


    
}
