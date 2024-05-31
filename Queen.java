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

    }
    
    public void move()
    {

    }
    
}
