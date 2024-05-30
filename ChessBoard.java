import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChessBoard extends JFrame implements ActionListener{
    
    private JPanel boardPanel = new JPanel();
    private ChessSquare[][] board;

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
                if((x+1) % 2 == 0 ^ (y+1) % 2 ==0){
                    board[x][y].setBackground(Color.decode("#5A190B"));
                }else{board[x][y].setBackground(Color.decode("#D1B57D"));}
                
                board[x][y].addActionListener(this);
                boardPanel.add(board[x][y]);
            }cd 
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
        
    }
}