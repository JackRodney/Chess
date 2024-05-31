public class King extends ChessPiece 
{
    
    private String type = "King";

    public King(int x, int y, ChessBoard board, int colour)
    {
        super(x,y,board,colour);
        if(colour == 0){
            this.setImage("images/White/King.png");
        }else{this.setImage("images/Black/King.png");}
    }
    
    public void clicked()
    {

    }
    
    public void move()
    {
       
    }
}
