import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class ChessBoard extends JFrame implements ActionListener{
    
    private JPanel boardPanel = new JPanel();
    private ChessSquare[][] board;
    private int turn = 0;

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

                if(y == 1){
                    board[x][y] = new Pawn(x, y, this, 1);
                }
                else if(y == 6){
                    board[x][y] = new Pawn(x,y,this,0);
                }
                else if(y == 0){
                    if(x == 0 || x == 7){
                        board[x][y] = new Rook(x,y,this,1);
                    }

                    else if(x== 1 || x ==6){
                        board[x][y] = new Knight(x,y,this,1);
                    }

                    else if(x == 2 || x == 5){
                        board[x][y] = new Bishop(x,y,this,1);
                    }
                    else if(x == 3){
                        board[x][y] = new Queen(x,y,this,1);
                    }
                    else{
                        board[x][y] = new King(x,y,this,1);
                    }
                }
                else if(y == 7){
                    if(x == 0 || x == 7){
                        board[x][y] = new Rook(x,y,this,0);
                    }

                    else if(x== 1 || x ==6){
                        board[x][y] = new Knight(x,y,this,0);
                    }

                    else if(x == 2 || x == 5){
                        board[x][y] = new Bishop(x,y,this,0);
                    }
                    else if(x == 3){
                        board[x][y] = new Queen(x,y,this,0);
                    }
                    else{
                        board[x][y] = new King(x,y,this,0);
                    }
                }
                else{
                    board[x][y] = new ChessSquare(x, y, this);  
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
    
    
    public void actionPerformed(ActionEvent e){
        
        ChessSquare s = (ChessSquare)e.getSource();
        s.clicked();
    }

    public void changeSides(){
        turn = turn ^ 1;
    }

    public int getTurn(){
        return(turn);
    }
}