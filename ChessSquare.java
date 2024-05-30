
import java.awt.Dimension;

import javax.swing.*;

public class ChessSquare extends JButton
{
    protected ChessBoard cb;
    protected int xLocation;
    protected int yLocation;
     
    public ChessSquare(int x, int y, ChessBoard b)
    {

        this.cb = b;
        this.xLocation = x;
        this.yLocation = y;
        //this.setEnabled(false);
        this.setBorderPainted(false);
        this.setPreferredSize(new Dimension(100,100));

        
    }

    public void setImage(String image)
    {
        this.setIcon(new ImageIcon(image));
    }



}
