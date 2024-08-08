public class King extends ChessPiece 
{
    private String type = "King";

    public King(int x, int y, ChessBoard board, int colour)
    {
        super(x,y,board,colour);

    }
    
    public void pieceClicked()
    {
        if(colour == cb.getTurn()){
            cb.clearHighlights();
            cb.setActivePiece(this);
            for(int x = -1; x < 2;x++){
                highlightSquare(xLocation + x, yLocation + 1);
                highlightSquare(xLocation + x, yLocation - 1);
            }
            highlightSquare(xLocation - 1, yLocation);
            highlightSquare(xLocation + 1, yLocation);
        }
        
    }

    public String getType(){return type;}

}
