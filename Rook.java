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

    }
    
    public void move()
    {

    }
    
}