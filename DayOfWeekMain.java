package Lesson2;

enum DayOfWeek {
    MONDAY("Понедельника"), TUESDAY("Вторника"), WEDNESDAY("Среды"), THURSDAY("Четверга"), FRIDAY("Пятницы");

    private String rus;

    DayOfWeek(String rus) {
        this.rus = rus;
    }

    public String getRus() {
        return rus;
    }
}

public class DayOfWeekMain {

    public static void main(final String[] args) {
        DayOfWeek dayWork = DayOfWeek.TUESDAY;

        System.out.println("Cо дня недели (включительно): " + dayWork.getRus());
        System.out.println("осталось работать " + getWorkingHours(dayWork) + " час(ов)а");
    }

    public static int getWorkingHours(Enum DayOfWeek){
        int indexDay = 0;
        int hoursWork = 0;
        indexDay = DayOfWeek.ordinal();
        for (int i = 0; i < (5 - indexDay); i++) {
            hoursWork = hoursWork + 8;
        }
        return hoursWork;
    }
}
