package vue;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class CelluleRenderer extends JLabel implements TableCellRenderer {

    private static final long serialVersionUID = 7614980041275818704L;

    public CelluleRenderer() {
        super();
        setOpaque(true);
        setHorizontalAlignment(JLabel.CENTER);
        this.setFont(new Font("Calibri", Font.ITALIC, 30));
        //this.setForeground(new java.awt.Color(10, 10, 40));
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setToolTipText((String) value);
        setFont(new Font("Calibri", Font.BOLD, 17));
        this.setForeground(new java.awt.Color(100, 10, 40));
        return this;
    }

}
