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
            case 1:
                return "Понедельник";
            case 2:
                return "Вторник";
            case 3:
                return "Среда";
            case 4:
                return "Четверг";
            case 5:
                return "Пятница";
            case 6:
                return "Суббота";
            case 7:
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
