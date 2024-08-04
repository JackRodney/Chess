public class Queen extends ChessPiece 
{
    private String type = "Queen";

    public Queen(int x, int y, ChessBoard b, int colour)
    {
        super(x, y, b, colour);
        if(colour == 0){
            this.setImage("images/White/Queen.png");
        }else{this.setImage("images/Black/Queen.png");}

    }

    
    public void clicked()
    {
        if(colour == cb.getTurn()){
       
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
