public class Knight extends ChessPiece 
{
    private String type = "Knight";

    public Knight(int x, int y, ChessBoard b, int colour)
    {
        super(x, y, b, colour);
        if(colour == 0){
            this.setImage("images/White/Knight.png");
        }else{this.setImage("images/Black/Knight.png");}

    }

    public void move(){

    }
    
}