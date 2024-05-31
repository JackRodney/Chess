public abstract class ChessPiece extends ChessSquare{
    
    protected String type;
    protected int colour;

    public ChessPiece(int x, int y, ChessBoard board, int colour)
    {
        super(x,y,board);
        this.colour = colour;

    }

    protected void highlightSquare(int x, int y) {
       
        if (x >= 0 && x < 8 && y >= 0 && y < 8 ) {
            if(cb.getSquareAt(x, y) instanceof ChessPiece){
            }else{cb.getSquareAt(x, y).setImage("images/Select.png");}
            
        }
    }

    protected void clearHighlights(){
        for(int y = 0; y < 8;y++){
            for(int x = 0; x<8; x++){
                if(cb.getSquareAt(x, y) instanceof ChessPiece){
                }else{cb.getSquareAt(x, y).setImage(null);}
            }
        }
    }
    
    public abstract void move();

}




