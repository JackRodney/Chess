public abstract class ChessPiece extends ChessSquare{
    
    protected String type;
    protected int colour;

    public ChessPiece(int x, int y, ChessBoard board, int colour)
    {
        super(x,y,board);
        this.colour = colour;

    }

    public abstract void move();

}




