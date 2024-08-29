
public class Pawn extends ChessPiece 
{
    private String type = "Pawn";
    private ChessPiece enPassentL = null;
    private ChessPiece enPassentR = null;
    private boolean isEnpassent = false;
    
    
    public Pawn(int x, int y, ChessBoard board, int colour)
    {
        super(x, y, board, colour);
        
    }

    public void pieceClicked()
    {
        if(colour == cb.getTurn()){

            cb.clearHighlights();
            cb.setActivePiece(this);
            
           

            if(!(cb.getSquareAt(xLocation, yLocation - 1).getPiece() instanceof ChessPiece)){
                if(highlightSquare(xLocation, yLocation - 1)){
                    if(yLocation == 6){
                        if(!(cb.getSquareAt(xLocation, yLocation - 2).getPiece() instanceof ChessPiece)){
                            highlightSquare(xLocation, yLocation - 2);
                        }
                    }
                }
            }

            if(xLocation > 0){
                enPassentL = cb.getSquareAt(xLocation - 1, yLocation).getPiece();

                if(cb.getSquareAt(xLocation - 1, yLocation - 1).getPiece() != null){
                    highlightSquare(xLocation - 1, yLocation -1);
                    
                }
            }
            
            if(xLocation < 7){
                enPassentR = cb.getSquareAt(xLocation + 1, yLocation).getPiece();

                if(cb.getSquareAt(xLocation + 1, yLocation - 1).getPiece() != null){
                    highlightSquare(xLocation + 1, yLocation -1);
                    
                    
                    
                }
            }

            if(enPassentL instanceof Pawn && enPassentL.getMove() == 1 && enPassentL == cb.getLastPieceMoved()){
                highlightSquare(xLocation - 1, yLocation -1);
                isEnpassent = true;
            }
            else if(enPassentR instanceof Pawn && enPassentR.getMove() == 1 && enPassentR == cb.getLastPieceMoved()){
                highlightSquare(xLocation + 1, yLocation -1);
                isEnpassent = true;
            }
            else{isEnpassent = false;}

            

        }
    }
    
    public String getType(){return type;}

    public boolean getIsEnpassent(){return isEnpassent;}

}
