import java.util.concurrent.TimeUnit;

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

    public boolean checkMate(){
        int[][] kingMoves = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},          {0, 1},
            {1, -1}, {1, 0}, {1, 1}
        };

        cb.setActivePiece(this);

        

        for (int[] move : kingMoves) {
            
            int checkFromX = this.getXPosition() + move[0];
            int checkFromY = this.getYPosition() + move[1];
            int reverseX = this.getXPosition() - move[0];
            int reverseY = this.getYPosition() - move[1];


            if( checkFromX > 7 || checkFromX  < 0 || checkFromY  > 7 || checkFromY  < 0){
                continue;
            }

            if(cb.getSquareAt(checkFromX, checkFromY).getPiece() != null){
                if(cb.getSquareAt(checkFromX, checkFromY).getPiece().getColour() != cb.getTurn()){
                    continue;
                }
            }

            if(cb.getTurn() == 1){
                checkFromX = 7 - checkFromX;
                checkFromY = 7 - checkFromY;
                reverseX = 7 - reverseX;
                reverseY = 7 - reverseY;
            }
         
            System.out.println(checkFromX+ " " + checkFromY);
            if(cb.moveActivePiece(checkFromX,checkFromY)){
                if (!Check()) {
                    return false;
                }
                cb.moveActivePiece(reverseX,reverseY);
            }
            
        }

        return true;
    }

    

    public boolean Check(){
        
        if(checkDiagonals() ||checkStraightLines() ||checkKnights() || checkKings() ||checkPawns()){
            return true;
        }
        return false;
    }

    private boolean checkDiagonals() {
        int[][] directions = {{1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        for (int[] dir : directions) {
            for (int i = 1; xLocation + i * dir[0] < 8 && xLocation + i * dir[0] >= 0 &&
                            yLocation + i * dir[1] < 8 && yLocation + i * dir[1] >= 0; i++) {
                ChessPiece piece = sendConnection(xLocation + i * dir[0], yLocation + i * dir[1]);
                if (piece != null) {
                    if (piece.getColour() == colour) break;
                    if (piece instanceof Bishop) {
                        return true;
                    } else if (piece instanceof Queen) {
                        return true;
                    }
                    break;
                }
            }
        }
        return false;
    }

    private boolean checkStraightLines() {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : directions) {
            for (int i = 1; xLocation + i * dir[0] < 8 && xLocation + i * dir[0] >= 0 &&
                            yLocation + i * dir[1] < 8 && yLocation + i * dir[1] >= 0; i++) {
                ChessPiece piece = sendConnection(xLocation + i * dir[0], yLocation + i * dir[1]);
                if (piece != null) {
                    if (piece.getColour() == colour) break;
                    if (piece instanceof Rook) {
                        return true;
                    } else if (piece instanceof Queen) {
                        return true;
                    }
                    break;
                }
            }
        }
        return false;
    }

    private boolean checkKnights() {
        int[][] knightMoves = {
            {-1, -2}, {-1, 2}, {-2, -1}, {-2, 1},
            {1, -2}, {1, 2}, {2, -1}, {2, 1}
        };

        for (int[] move : knightMoves) {
            ChessPiece piece = sendConnection(xLocation + move[0], yLocation + move[1]);
            if (piece instanceof Knight && piece.getColour() != colour) {
                return true;
            }
        }
        return false;
    }

    private boolean checkKings() {
        int[][] kingMoves = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},          {0, 1},
            {1, -1}, {1, 0}, {1, 1}
        };

        for (int[] move : kingMoves) {
            ChessPiece piece = sendConnection(xLocation + move[0], yLocation + move[1]);
            if (piece instanceof King) {
                return true;
            }
        }
        return false;
    }

    private boolean checkPawns() {
        
        int[][] pawnAttacks = {
            {-1, 1}, {1, 1} , {-1,-1}, {1,-1}
        };
    
        for (int[] attack : pawnAttacks) {
            ChessPiece piece = sendConnection(xLocation + attack[0], yLocation + attack[1]);
            if (piece instanceof Pawn && piece.getColour() != colour && attack[1] == 1 && cb.getTurn() == piece.getColour()) {
                return true;
            }
            if (piece instanceof Pawn && piece.getColour() != colour && attack[1] == -1 && cb.getTurn() != piece.getColour()) {
                return true;
            }
        }
        return false;
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
