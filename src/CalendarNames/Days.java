/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CalendarNames;

/**
 *
 * @author Дмитрий Белоус
 */
public class Days {

    public static String getDayOfWeekName(int number) {
        switch (number) {
            case 0:
                return "Понедельник";
            case 1:
                return "Вторник";
            case 2:
                return "Среда";
            case 3:
                return "Четверг";
            case 4:
                return "Пятница";
            case 5:
                return "Суббота";
            case 6:
                return "Воскресенье";
            default:
                return "Не опредлёне";
        }
    }

    public static String getDayOfWeekShortName(int number) {
        switch (number) {
            case 1:
                return "Пн";
            case 2:
                return "Вт";
            case 3:
                return "Ср";
            case 4:
                return "Чт";
            case 5:
                return "Пт";
            case 6:
                return "Сб";
            case 7:
                return "Вс";
            default:
                return "Не";
        }
    }
}
