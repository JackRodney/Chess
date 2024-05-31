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
        if(colour == cb.getTurn()){
            clearHighlights();
            for(int x = -1; x < 2;x++){
                highlightSquare(xLocation + x, yLocation + 1);
                highlightSquare(xLocation + x, yLocation - 1);
            }
            highlightSquare(xLocation - 1, yLocation);
            highlightSquare(xLocation + 1, yLocation);
        }
        
    }
    
    public void move()
    {
       
    }
}
