import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

 class DateManipulation {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        // Ввод и сохранение первой даты
        System.out.print("Введите первую дату в формате dd.MM.yyyy: ");
        String firstDateString = scanner.nextLine();
        Date firstDate = dateFormat.parse(firstDateString);

        // Увеличение даты на 45 дней
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(firstDate);
        calendar.add(Calendar.DAY_OF_MONTH, 45);
        Date increasedDate = calendar.getTime();
        System.out.println("Дата после увеличения на 45 дней: " + dateFormat.format(increasedDate));

        // Сдвиг даты на начало года
        calendar.setTime(firstDate);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date shiftedDate = calendar.getTime();
        System.out.println("Дата после сдвига на начало года: " + dateFormat.format(shiftedDate));

        // Увеличение даты на 10 рабочих дней
        calendar.setTime(firstDate);
        int addedDays = 0;
        while (addedDays < 10) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                addedDays++;
            }
        }
        Date increasedWorkingDaysDate = calendar.getTime();
        System.out.println("Дата после увеличения на 10 рабочих дней: " + dateFormat.format(increasedWorkingDaysDate));

        // Ввод и сохранение второй даты
        System.out.print("Введите вторую дату в формате dd.MM.yyyy: ");
        String secondDateString = scanner.nextLine();
        Date secondDate = dateFormat.parse(secondDateString);

        // Подсчет рабочих дней между датами
        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
        long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        long workingDaysBetweenDates = 0;
        calendar.setTime(firstDate);
        for (int i = 0; i < diffInDays; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                workingDaysBetweenDates++;
            }
        }
        System.out.println("Количество рабочих дней между введенными датами: " + workingDaysBetweenDates);
    }
}