import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChessBoard extends JFrame implements ActionListener{
    
    private JPanel boardPanel = new JPanel();
    private ChessSquare[][] board;
    private int turn = 0;
    private ChessPiece activePiece;
    private ChessPiece lastMovedPiece = null;
    private boolean check;

    public ChessBoard(){
        super();
        this.board = new ChessSquare[8][8];
        setTitle("Chess");
        setSize(800,800);
        setContentPane(boardPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        boardPanel.setLayout(new GridLayout(8,8));


        for(int y = 0; y<8;y++){
            for(int x = 0; x<8; x++){

                board[x][y] = new ChessSquare(x, y, this);
                
                if(y == 1){
                    board[x][y].setPiece(new Pawn(x,y,this,1));
                }
                else if(y == 6){
                    board[x][y].setPiece(new Pawn(x,y,this,0));
                }
                else if(y == 0){
                    if(x == 0 || x == 7){
                        board[x][y].setPiece(new Rook(x,y,this,1));
                    }

                    else if(x== 1 || x ==6){
                        board[x][y].setPiece(new Knight(x,y,this,1));
                    }

                    else if(x == 2 || x == 5){
                        board[x][y].setPiece(new Bishop(x,y,this,1));
                    }
                    else if(x == 3){
                        board[x][y].setPiece(new Queen(x,y,this,1));
                    }
                    else{
                        board[x][y].setPiece(new King(x,y,this,1));                    }
                }
                else if(y == 7){
                    if(x == 0 || x == 7){
                        board[x][y].setPiece(new Rook(x,y,this,0));
                    }

                    else if(x== 1 || x ==6){
                        board[x][y].setPiece(new Knight(x,y,this,0));
                    }

                    else if(x == 2 || x == 5){
                        board[x][y].setPiece(new Bishop(x,y,this,0));
                    }
                    else if(x == 3){
                        board[x][y].setPiece(new Queen(x,y,this,0));                    }
                    else{
                        board[x][y].setPiece(new King(x,y,this,0));                    }
                }

                if((x+1) % 2 == 0 ^ (y+1) % 2 ==0){
                        board[x][y].setBackground(Color.decode("#5A190B"));
                }else{board[x][y].setBackground(Color.decode("#D1B57D"));}
                
                board[x][y].addActionListener(this);
                boardPanel.add(board[x][y]);
            }
        }

        setVisible(true);
    }

    public ChessSquare getSquareAt(int x, int y)
	{
		if (x < 0 || x >= 8 || y < 0 || y >= 8)
			return null;

		return board[x][y];
	}

    public boolean moveActivePiece(int x, int y) {

        int currentX = activePiece.getXPosition();
        int currentY = activePiece.getYPosition();
    
        int adjustedX = (turn == 1) ? 7 - x : x;
        int adjustedY = (turn == 1) ? 7 - y : y;
        
        ChessPiece targetPiece = board[adjustedX][adjustedY].getPiece(); 
    
        activePiece.setPosition(adjustedX, adjustedY);
        board[adjustedX][adjustedY].setPiece(activePiece);
        board[currentX][currentY].setPiece(null);
        activePiece.incrementMove();
        check = false;


        if (activePiece instanceof Pawn && activePiece.getYPosition() == 0) {
            board[adjustedX][adjustedY].setPiece(new Queen(adjustedX, adjustedY, this, activePiece.getColour()));
        }
    
        King myKing = findKing(activePiece.getColour());
        if (myKing.Check()) {

            activePiece.setPosition(currentX, currentY);
            board[currentX][currentY].setPiece(activePiece);
            board[adjustedX][adjustedY].setPiece(targetPiece);
            activePiece.decrementMove();
    
            check = true;
            System.out.println("Move is illegal: King would be in check");
            return false;
        }

        King opponentKing = findKing(activePiece.getColour() ^ 1);
                
        if (opponentKing.Check()) {
            System.out.println("Check!");
    
            if (opponentKing.checkMate()) {
                System.out.println("CHECKMATE");

            }
        }
        
        lastMovedPiece = activePiece;
 
        return true;
    }
    
    public void moveKing(King king, int x, int y){
        int currentX = king.getXPosition();
        int currentY = king.getYPosition();

        int adjustedX = (turn == 1) ? 7 - x : x;
        int adjustedY = (turn == 1) ? 7 - y : y;
        
        activePiece.setPosition(adjustedX, adjustedY);
        board[adjustedX][adjustedY].setPiece(activePiece);
        board[currentX][currentY].setPiece(null);
        activePiece.incrementMove();
        check = false;


    }

    private King findKing(int colour){
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                ChessPiece piece = board[x][y].getPiece();
                if (piece instanceof King && piece.getColour() == colour) {
                    return (King) piece;
                }
            }
        }
        return null;
    }

    protected void clearHighlights(){
        for(int y = 0; y < 8;y++){
            for(int x = 0; x<8; x++){
                this.getSquareAt(x, y).setSelectable(false);


                if(this.getSquareAt(x, y).getPiece() instanceof ChessPiece){
                }else{this.getSquareAt(x, y).setImage(null);}

                Color colour = this.getSquareAt(x, y).getBackground();
                String colourString = String.format("#%02x%02x%02x", colour.getRed(), colour.getGreen(), colour.getBlue()); 
                if(colourString.equals("#8d726b")){this.getSquareAt(x,y).setBackground(Color.decode("#5a190b"));}
                if(colourString.equals("#d2c5aa")){this.getSquareAt(x,y).setBackground(Color.decode("#d1b57d"));}
            }
        }
    }
    
    public void actionPerformed(ActionEvent e){
        
        ChessSquare s = (ChessSquare)e.getSource();
        s.clicked();
    }

    public void changeSides(){
        
        if(!check){

            ChessSquare[][] flippedBoard = new ChessSquare[8][8];

            for (int y = 0; y < 8; y++) {
                for (int x = 0; x < 8; x++) {
                    int newX = 7 - x;
                    int newY = 7 - y;
        
                    flippedBoard[newX][newY] = board[x][y];
        
                    ChessPiece piece = flippedBoard[newX][newY].getPiece();
                    if (piece != null) {

                        piece.setPosition(newX, newY);
                    }
                }
            }
        
            board = flippedBoard;
        
            boardPanel.removeAll();
            for (int y = 0; y < 8; y++) {
                for (int x = 0; x < 8; x++) {
                    boardPanel.add(board[x][y]);
                }
            }
        
            turn = turn ^ 1;
            boardPanel.revalidate();
            boardPanel.repaint();
        }
    }

    public int getTurn(){return(turn);}

    public ChessPiece getLastPieceMoved(){return lastMovedPiece;}

    public void setActivePiece(ChessPiece c){this.activePiece = c;}

    public ChessPiece getActivePiece(){return activePiece;}

    public void setBoard(int x, int y, ChessPiece p){board[x][y].setPiece(p);}
    public static void main(String args[])
    {
        new ChessBoard();
        
    }
}