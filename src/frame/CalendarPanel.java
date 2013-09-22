/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import CalendarNames.Days;
import CalendarNames.Monthes;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import static java.util.Calendar.*;
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
    public final int DEFAULT_FONT_SIZE = 12;
    private JButton monthBeforeButton = new JButton("<");
    private JButton monthAfterButton = new JButton(">");
    private int[] verticalGaps = new int[]{11, 11, 20, 8, 6, 11};
    private int[] horizontalGaps = new int[]{11, 6, 50};
    private JLabel monthLabel = new JLabel();
    private JPanel[] panels = new JPanel[49];
    private JLabel[] labels = new JLabel[49];
    private int weeksNumber = -1;
    private Color[] colors = new Color[]{Color.GRAY, Color.DARK_GRAY, Color.CYAN, Color.BLUE, Color.GREEN, new Color(150, 255, 255)};
    Calendar calendar = Calendar.getInstance();

    private void init() {
        initComponents();
        placeComponents();
    }

    private void initComponents() {
        verticalGaps[2] = Math.max(verticalGaps[2], DEFAULT_FONT_SIZE);
        setBackground(colors[0]);
        monthAfterButton.setBackground(colors[3]);
        monthBeforeButton.setBackground(colors[3]);
        monthAfterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                monthAfterButtonActionPerformed(e);
            }
        });
        monthBeforeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                monthBeforeButtonActionPerformed(e);
            }
        });
        for (int i = 0; i < 49; ++i) {
            labels[i] = new JLabel();
            panels[i] = new JPanel();
            GroupLayout jPanelLayout = new GroupLayout(panels[i]);
            panels[i].setLayout(jPanelLayout);
            jPanelLayout.setHorizontalGroup(
                    jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
                    .addComponent(labels[i])
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE)));
            jPanelLayout.setVerticalGroup(
                    jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                    .addGap((verticalGaps[2] - DEFAULT_FONT_SIZE) / 2)
                    .addComponent(labels[i])
                    .addGap((verticalGaps[2] - DEFAULT_FONT_SIZE) / 2)));
        }
    }

    private void placeComponents() {
        javax.swing.GroupLayout calendarPanelLayout = new javax.swing.GroupLayout(this);
        setLayout(calendarPanelLayout);
        GroupLayout.SequentialGroup seqGroup = calendarPanelLayout.createSequentialGroup();
        int jmax = calendar.getActualMaximum(WEEK_OF_MONTH) + 1;
        if (weeksNumber == -1) {
            weeksNumber = jmax;
        }
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
                .addGap(horizontalGaps[2], horizontalGaps[2], horizontalGaps[2])
                .addComponent(monthLabel)
                .addGap(horizontalGaps[2], horizontalGaps[2], horizontalGaps[2])
                .addComponent(monthAfterButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
                .addGap(horizontalGaps[0], horizontalGaps[0], horizontalGaps[0]))
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
        updateContent();
    }

    private void updateContent() {
        for (int i = weeksNumber; i < calendar.getActualMaximum(WEEK_OF_MONTH) + 1; ++i) {
            for (int j = 0; j < 7; ++j) {
                panels[i * 7 + j].setVisible(true);
            }
        }
        for (int i = calendar.getActualMaximum(WEEK_OF_MONTH) + 1; i < weeksNumber; ++i) {
            for (int j = 0; j < 7; ++j) {
                panels[i * 7 + j].setVisible(false);
            }
        }
        weeksNumber = calendar.getActualMaximum(WEEK_OF_MONTH) + 1;
        monthLabel.setText(Monthes.getMonthName(calendar.get(MONTH)) + " " + calendar.get(YEAR));
        for (int i = 0; i < 7; ++i) {
            labels[i].setText(i < 7 ? Days.getDayOfWeekShortName(i + calendar.getFirstDayOfWeek() - 1) : "");
            panels[i].setBackground(colors[1]);
        }
        Calendar temp = Calendar.getInstance();
        int dayOfWeek = (calendar.get(DAY_OF_WEEK) - calendar.get(DAY_OF_MONTH) + 34) % 7;
        int month = calendar.get(MONTH);
        int day = 1;
        int j = 7;
        if (dayOfWeek != 0) {
            calendar.set(MONTH, (month + 11) % 12);
            day = calendar.getActualMaximum(DAY_OF_MONTH) - dayOfWeek + 1;
            for (; day <= calendar.getActualMaximum(DAY_OF_MONTH); day++, j++) {
                labels[j].setText("" + day);
                if (calendar.get(YEAR) - (month == 0 ? 1 : 0) == temp.get(YEAR) && calendar.get(MONTH) == temp.get(MONTH) && day == temp.get(DAY_OF_MONTH)) {
                    panels[j].setBackground(colors[4]);
                } else {
                    panels[j].setBackground(colors[5]);
                }
            }
            calendar.set(MONTH, month);
            day = 1;
        }
        for (; day <= calendar.getActualMaximum(DAY_OF_MONTH); day++, j++) {
            labels[j].setText("" + day);
            if (calendar.get(YEAR) == temp.get(YEAR) && month == temp.get(MONTH) && day == temp.get(DAY_OF_MONTH)) {
                panels[j].setBackground(colors[4]);
            } else {
                panels[j].setBackground(colors[2]);
            }
        }
        dayOfWeek = (calendar.get(DAY_OF_WEEK) + calendar.getActualMaximum(DAY_OF_MONTH) - calendar.get(DAY_OF_MONTH) - 1) % 7;
        if (dayOfWeek != 0) {
            calendar.set(MONTH, (month + 1) % 12);
            day = 1;
            for (; day <= 7 - dayOfWeek; day++, j++) {
                labels[j].setText("" + day);

                if (calendar.get(YEAR) + (month == 11 ? 1 : 0) == temp.get(YEAR) && calendar.get(MONTH) == temp.get(MONTH) && day == temp.get(DAY_OF_MONTH)) {
                    panels[j].setBackground(colors[4]);
                } else {
                    panels[j].setBackground(colors[5]);
                }
            }
            calendar.set(MONTH, month);
        }
    }

    private void monthBeforeButtonActionPerformed(ActionEvent e) {
        calendar.set(MONTH, (calendar.get(MONTH) + 11) % 12);
        if (calendar.get(MONTH) == 11) {
            calendar.set(YEAR, calendar.get(YEAR) - 1);
        }
        updateContent();
        placeComponents();
    }

    private void monthAfterButtonActionPerformed(ActionEvent e) {
        calendar.set(MONTH, (calendar.get(MONTH) + 1) % 12);
        if (calendar.get(MONTH) == 0) {
            calendar.set(YEAR, calendar.get(YEAR) + 1);
        }
        updateContent();
        placeComponents();
    }
}
