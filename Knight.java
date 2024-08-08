public class Knight extends ChessPiece 
{
    private String type = "Knight";

    public Knight(int x, int y, ChessBoard b, int colour)
    {
        super(x, y, b, colour);
        // if(colour == 0){
        //     this.setImage("images/White/Knight.png");
        // }else{this.setImage("images/Black/Knight.png");}

    }

    public void pieceClicked()
    {
        
        if (colour == cb.getTurn()) {
            cb.clearHighlights();
            cb.setActivePiece(this);
            highlightSquare(xLocation - 1, yLocation - 2);
            highlightSquare(xLocation - 1, yLocation + 2);
            highlightSquare(xLocation - 2, yLocation + 1);
            highlightSquare(xLocation - 2, yLocation - 1);
            highlightSquare(xLocation + 1, yLocation - 2);
            highlightSquare(xLocation + 1, yLocation + 2); 
            highlightSquare(xLocation + 2, yLocation - 1);
            highlightSquare(xLocation + 2, yLocation + 1);

        }
    }

    public String getType(){return type;}

    
}