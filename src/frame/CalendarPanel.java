/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import CalendarNames.Monthes;
import java.awt.Color;
import java.util.Calendar;
import javax.swing.GroupLayout;
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
    private JButton monthBeforeButton = new JButton("<");
    private JButton monthAfterButton = new JButton(">");
    private int[] verticalGaps = new int[]{11, 11, 20, 8, 6, 11};
    private int[] horizontalGaps = new int[]{11, 6, 150};
    private JLabel monthLabel = new JLabel();
    private JPanel[] panels = new JPanel[49];
    private Color[] colors = new Color[]{Color.GRAY, Color.DARK_GRAY, Color.CYAN, Color.BLUE};

    private void init() {
        setBackground(colors[0]);
        monthAfterButton.setBackground(colors[3]);
        monthBeforeButton.setBackground(colors[3]);
        for (int i = 0; i < 49; ++i) {
            panels[i] = new JPanel();
            panels[i].setBackground(i < 7 ? colors[1] : colors[2]);
            GroupLayout jPanelLayout = new GroupLayout(panels[i]);
            panels[i].setLayout(jPanelLayout);
            jPanelLayout.setHorizontalGroup(
                    jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGap(0, 0, Short.MAX_VALUE));
            jPanelLayout.setVerticalGroup(
                    jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGap(0, verticalGaps[2], Short.MAX_VALUE));
        }
        Calendar calendar = Calendar.getInstance();
        monthLabel.setText(Monthes.getMonthName(calendar.get(Calendar.MONTH)));
        int l3 = (horizontalGaps[2] - monthLabel.getWidth()) / 2;
        l3 = (l3 < 0 ? 0 : l3);
        javax.swing.GroupLayout calendarPanelLayout = new javax.swing.GroupLayout(this);
        setLayout(calendarPanelLayout);
        GroupLayout.SequentialGroup seqGroup = calendarPanelLayout.createSequentialGroup();
        int jmax = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH) + 1;
        for (int i = 0; i < 7; ++i) {
            GroupLayout.ParallelGroup parGroup = calendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING);
            for (int j = 0; j < jmax; ++j) {
                parGroup.addComponent(panels[j * 7 + i], javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
            }
            seqGroup.addGroup(parGroup);
            if (i != 6) {
                seqGroup.addGap(horizontalGaps[1], horizontalGaps[1], horizontalGaps[1]);
            }
        }
        seqGroup.addGap(horizontalGaps[0], horizontalGaps[0], horizontalGaps[0]);
        calendarPanelLayout.setHorizontalGroup(
                calendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(calendarPanelLayout.createSequentialGroup()
                .addGap(horizontalGaps[0], horizontalGaps[0], horizontalGaps[0])
                .addGroup(calendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(calendarPanelLayout.createSequentialGroup()
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
                .addComponent(monthBeforeButton)
                .addGap(l3, l3, l3)
                .addComponent(monthLabel)
                .addGap(l3, l3, l3)
                .addComponent(monthAfterButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
                .addContainerGap())
                .addGroup(seqGroup))));

        seqGroup = calendarPanelLayout.createSequentialGroup().addContainerGap()
                .addGap(verticalGaps[0], verticalGaps[0], verticalGaps[0])
                .addGroup(calendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(monthBeforeButton)
                .addComponent(monthAfterButton)
                .addComponent(monthLabel))
                .addGap(verticalGaps[1], verticalGaps[1], verticalGaps[1]);
        GroupLayout.ParallelGroup parGroup = calendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
        for (int i = 0; i < 7; ++i) {
            parGroup.addComponent(panels[i], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);
        }
        seqGroup.addGroup(parGroup)
                .addGap(verticalGaps[3], verticalGaps[3], verticalGaps[3]);
        for (int j = 1; j < jmax; ++j) {
            parGroup = calendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
            for (int i = 0; i < 7; ++i) {
                parGroup.addComponent(panels[j * 7 + i], javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
            }

            seqGroup.addGroup(parGroup);
            if (j != jmax - 1) {
                seqGroup.addGap(verticalGaps[4], verticalGaps[4], verticalGaps[4]);
            }
        }
        seqGroup.addGap(verticalGaps[5], verticalGaps[5], verticalGaps[5]);
        calendarPanelLayout.setVerticalGroup(
                calendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(seqGroup));

    }
}
