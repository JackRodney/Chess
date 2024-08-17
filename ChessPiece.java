
import java.awt.Color;

public abstract class ChessPiece {
    
    protected int xLocation;
    protected int yLocation;
    protected ChessBoard cb;
    protected String type;
    protected int colour;
    protected int move = 0;


    public ChessPiece(int x, int y, ChessBoard board, int colour)
    {
        this.xLocation = x;
        this.yLocation = y;
        this.cb = board;
        this.colour = colour;

    }

    protected boolean highlightSquare(int x, int y) {
        if (x >= 0 && x < 8 && y >= 0 && y < 8) {
            cb.getSquareAt(x, y).setSelectable(true);
            if (cb.getSquareAt(x, y).getPiece() instanceof ChessPiece) {
                if(cb.getSquareAt(x,y).getPiece().getColour() != this.getColour()){
                    Color colour = cb.getSquareAt(x, y).getBackground();
                    String colourString = String.format("#%02x%02x%02x", colour.getRed(), colour.getGreen(), colour.getBlue()); 
                    if(colourString.equals("#5a190b")){cb.getSquareAt(x,y).setBackground(Color.decode("#8D726B"));}
                    if(colourString.equals("#d1b57d")){cb.getSquareAt(x,y).setBackground(Color.decode("#d2c5aa"));}
                }
                
                return false; 

            } else {
                cb.getSquareAt(x, y).setImage("images/Select.png");
            
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

    protected void incrementMove(){this.move ++;}

    protected void decrementMove(){this.move --;}

    protected abstract void pieceClicked();

}




