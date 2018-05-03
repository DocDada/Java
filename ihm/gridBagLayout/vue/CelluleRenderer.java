package vue;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class CelluleRenderer extends JLabel implements TableCellRenderer {

    private static final long serialVersionUID = 7614980041275818704L;

    public CelluleRenderer() {
        super();
        setOpaque(true);
        setHorizontalAlignment(JLabel.CENTER);
        this.setForeground(new java.awt.Color(180, 100, 100));
        
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setToolTipText((String) value);
        return this;
    }

}
