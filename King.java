public class King extends ChessPiece 
{
    private String type = "King";

    public King(int x, int y, ChessBoard board, int colour)
    {
        super(x,y,board,colour);

    }
    
    public void pieceClicked()
    {
        if(colour == cb.getTurn()){
            cb.clearHighlights();
            cb.setActivePiece(this);
            for(int x = -1; x < 2;x++){
                highlightSquare(xLocation + x, yLocation + 1);
                highlightSquare(xLocation + x, yLocation - 1);
            }
            highlightSquare(xLocation - 1, yLocation);
            highlightSquare(xLocation + 1, yLocation);

            if(move == 0){
                highlightSquare(xLocation -2, yLocation);
                highlightSquare(xLocation + 2, yLocation);
            }
        }
        
    }

    public void ConnectionCheck(){
        
        for (int i = 1; xLocation + i < 8 && yLocation + i < 8; i++) {
            
            if(sendConnection(xLocation, yLocation - i) != null){
                if(sendConnection(xLocation, yLocation - i).getColour() == colour){
                    break;
                }
                if(sendConnection(xLocation, yLocation - i)instanceof Bishop){
                    System.out.println("Check");
                }
                if(sendConnection(xLocation, yLocation - i)instanceof Queen){
                    System.out.println("Check");
                }
            } 
        }

        for (int i = 1; xLocation - i >= 0 && yLocation - i >= 0; i++) {
            
            if(sendConnection(xLocation - i, yLocation - i) != null){  
                if(sendConnection(xLocation -i, yLocation - i).getColour() == colour){
                    break;
                }
                if(sendConnection(xLocation - i, yLocation - i)instanceof Bishop){
                    System.out.println("Check");
                }
                if(sendConnection(xLocation - i, yLocation - i)instanceof Queen){
                    System.out.println("Check");
                }
            }
        }

        for (int i = 1; xLocation + i < 8 && yLocation - i >= 0; i++) {
                
            if(sendConnection(xLocation + i, yLocation - i) != null){ 
                if(sendConnection(xLocation +i, yLocation - i).getColour() == colour){
                    break;
                }
                if(sendConnection(xLocation + i, yLocation - i)instanceof Bishop){
                    System.out.println("Check");
                }
                if(sendConnection(xLocation + i, yLocation - i)instanceof Queen){
                    System.out.println("Check");
                }
            }
        }

        for (int i = 1; xLocation - i >= 0 && yLocation + i < 8; i++) {
            
            if(sendConnection(xLocation - i, yLocation + i) != null){
                if(sendConnection(xLocation -i, yLocation + i).getColour() == colour){
                    break;
                }
                if(sendConnection(xLocation - i, yLocation + i)instanceof Bishop){
                    System.out.println("Check");
                }
                if(sendConnection(xLocation - i, yLocation + i)instanceof Queen){
                    System.out.println("Check");
                }
            }

        }
        
        for (int i = xLocation + 1; i < 8; i++) {
            if(sendConnection(i, yLocation) != null){
                if(sendConnection(i, yLocation).getColour() == colour){
                    break;
                }
                if(sendConnection(i, yLocation)instanceof Rook){
                    System.out.println("Check");
                }
                if(sendConnection(i, yLocation)instanceof Queen){
                    System.out.println("Check");
                }
            }

        }
        
       
        for (int i = xLocation - 1; i >= 0; i--) {
            if(sendConnection(i, yLocation) != null){
                if(sendConnection(i, yLocation).getColour() == colour){
                    break;
                }
                if(sendConnection(i, yLocation)instanceof Rook){
                    System.out.println("Check");
                }
                if(sendConnection(i, yLocation)instanceof Queen){
                    System.out.println("Check");
                }
            }

        }

    
        for (int i = yLocation + 1; i < 8; i++) {
            if(sendConnection(xLocation, i) != null){
                if(sendConnection(xLocation, i).getColour() == colour){
                    break;
                }
                if(sendConnection(xLocation, i)instanceof Rook){
                    System.out.println("Check");
                }
                if(sendConnection(xLocation, i)instanceof Queen){
                    System.out.println("Check");
                }
            }
        }

        
        for (int i = yLocation - 1; i >= 0; i--) {
            if(sendConnection(xLocation, i) != null){
                if(sendConnection(xLocation, i).getColour() == colour){
                    break;
                }
                if(sendConnection(xLocation, i)instanceof Rook){
                    System.out.println("Check");
                }
                if(sendConnection(xLocation, i)instanceof Queen){
                    System.out.println("Check");
                }
            }
        }
    }

    protected ChessPiece sendConnection(int x, int y) {
        if (x >= 0 && x < 8 && y >= 0 && y < 8) {
            if (cb.getSquareAt(x, y).getPiece() instanceof ChessPiece) {
                return cb.getSquareAt(x,y).getPiece();   

            } 
        }
        return null;   
    }

    public String getType(){return type;}

}
