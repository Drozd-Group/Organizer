/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import CalendarNames.Monthes;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Дмитрий Белоус
 */
public class CalendarPanel extends JPanel {

    public CalendarPanel() {
        init();
    }
    private JButton monthBefore = new JButton("<");
    private JButton monthAfter = new JButton(">");
    private int monthNameLength = 50;
    private int vertGap1 = 20;
    private JLabel month = new JLabel();

    private void init() {
        Calendar calendar = Calendar.getInstance();
        month.setText(Monthes.getMonthName(calendar.get(Calendar.MONTH)));
        int l1 = (getWidth() - monthNameLength - 2 * monthAfter.getWidth()) / 2;
        int l2 = getHeight() - vertGap1 - monthBefore.getHeight();
        int l3 = (monthNameLength - month.getWidth()) / 2;
        l1 = (l1 < 0 ? 0 : l1);
        l2 = (l2 < 0 ? 0 : l2);
        l3 = (l3 < 0 ? 0 : l3);
        javax.swing.GroupLayout calendarPanelLayout = new javax.swing.GroupLayout(this);
        setLayout(calendarPanelLayout);
        calendarPanelLayout.setHorizontalGroup(
                calendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(calendarPanelLayout.createSequentialGroup()
                .addContainerGap(l1, Short.MAX_VALUE)
                .addComponent(monthBefore)
                .addGap(l3, l3, l3)
                .addComponent(month)
                .addGap(l3, l3, l3)
                .addComponent(monthAfter)
                .addContainerGap(l1, Short.MAX_VALUE)));
        calendarPanelLayout.setVerticalGroup(
                calendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(calendarPanelLayout.createSequentialGroup()
                .addGap(vertGap1, vertGap1, vertGap1)
                .addGroup(calendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(monthBefore)
                .addComponent(month)
                .addComponent(monthAfter))
                .addContainerGap(l2, Short.MAX_VALUE)));

    }
}
