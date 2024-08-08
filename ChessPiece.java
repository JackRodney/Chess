public abstract class ChessPiece {
    
    protected int xLocation;
    protected int yLocation;
    protected ChessBoard cb;
    protected String type;
    protected int colour;


    public ChessPiece(int x, int y, ChessBoard board, int colour)
    {
        this.xLocation = x;
        this.yLocation = y;
        this.cb = board;
        this.colour = colour;

    }

    protected boolean highlightSquare(int x, int y) {
        if (x >= 0 && x < 8 && y >= 0 && y < 8) {
            if (cb.getSquareAt(x, y).getPiece() instanceof ChessPiece) {
                return false; 
            } else {
                cb.getSquareAt(x, y).setImage("images/Select.png");
                cb.getSquareAt(x, y).setSelectable(true);
                return true;
            }
        }
        return false; 
    }


    protected void setPosition(int x, int y){
        this.xLocation = x;
        this.yLocation = y;
    }

    protected int getXPosition(){return xLocation;}

    protected int getYPosition(){return yLocation;}

    protected String getType(){return type;}

    protected int getColour(){return colour;}

    protected abstract void pieceClicked();

}




