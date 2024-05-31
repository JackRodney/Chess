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
            for (int i = -Math.min(xLocation, yLocation); i < Math.min(8 - xLocation, 8 - yLocation); i++) {
                highlightSquare(xLocation + i, yLocation + i);
            }

            for (int i = -Math.min(xLocation, 8 - yLocation - 1); i < Math.min(8 - xLocation, yLocation + 1); i++) {
                highlightSquare(xLocation + i, yLocation - i);
            }

            for (int x = 0; x < 8; x++) {
                highlightSquare(x, yLocation);
            }
    
            for (int y = 0; y < 8; y++) {
                highlightSquare(xLocation, y);
            }
        }
    }
    
    public void move()
    {

    }
    
}
