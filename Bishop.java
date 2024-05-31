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
        }

    }
    
    public void move()
    {

    }


    
}
