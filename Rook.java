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
        if(colour == cb.getTurn()){
            clearHighlights();
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