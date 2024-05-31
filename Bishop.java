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

    }
    
    public void move()
    {

    }


    
}
