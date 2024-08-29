
import java.awt.Dimension;
import javax.swing.*;

public  class ChessSquare extends JButton
{
    private ChessBoard cb;
    private int xLocation;
    private int yLocation;
    private ChessPiece piece;
    private boolean selectable;


   
    public ChessSquare(int x, int y, ChessBoard b)
    {

        this.cb = b;
        this.xLocation = x;
        this.yLocation = y;
        //this.setEnabled(false);
        this.setBorderPainted(false);
        this.setPreferredSize(new Dimension(100,100));

        
    }

    public void setPiece(ChessPiece piece) {
        this.piece = piece;
        if (piece != null) {
            String pieceImagePath = "images/" + (piece.getColour() == 0 ? "White/" : "Black/") + piece.getType() + ".png";
            this.setImage(pieceImagePath);
        } else {
            this.setImage(null); 
        }
        this.repaint(); 
    }

    
    public void clicked(){
        if(piece instanceof ChessPiece){
            piece.pieceClicked();
        }

        System.out.println(" Square " + xLocation + " " + yLocation);

        
        if(selectable){
            
            cb.moveActivePiece(xLocation, yLocation);
            if(piece instanceof Pawn && ((Pawn) piece).getIsEnpassent()){
                int direction = (cb.getTurn() == 0) ? 1 : -1;
                int y = yLocation + direction;
                int Y = (cb.getTurn() == 0) ? y : 7-y;
                int X = (cb.getTurn() == 0) ? xLocation : 7 -xLocation;
                System.out.println("X: "+xLocation+"Y: "+(yLocation + direction));
                cb.getSquareAt(X, Y).setPiece(null);

            }

            cb.changeSides();
            cb.clearHighlights();
            
        }

    }

    public void setImage(String image){this.setIcon(new ImageIcon(image));}

    public ChessPiece getPiece(){return this.piece;}



    public void setSelectable(boolean bool){this.selectable = bool;}


}
