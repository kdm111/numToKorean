import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {
    public Label(String title) {
        setText(title);
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(TOP);
        setOpaque(true);
        setPreferredSize(new Dimension(100, 50));
    }

    public void setFontColor(Color color) {
        setForeground(color);
    }
}
