import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        TaskService tasks = new TaskService();
//        System.out.println(tasks);
//        System.out.println();

        /*OnceTask onceTask = new OnceTask("first", "once task", 1, 1,
                LocalDateTime.of(2011, 11, 11, 11, 0));
        System.out.println("onceTask = " + onceTask);

        DailyTask dailyTask = new DailyTask("second", "daily task", 2, 2,
                LocalDateTime.of(2012, 12, 12, 12, 12));
        System.out.println("dailyTask = " + dailyTask);

        WeeklyTask weeklyTask = new WeeklyTask("third", "weekly task", 1, 3,
                LocalDateTime.of(2013, 3, 13, 13, 13));
        System.out.println("weeklyTask = " + weeklyTask);

        MonthlyTask monthlyTask = new MonthlyTask("forth", "monthly task", 2, 4,
                LocalDateTime.of(2014, 4, 14, 14, 14));
        System.out.println("monthlyTask = " + monthlyTask);

        YearlyTask yearlyTask = new YearlyTask("fifth", "yearly task", 1, 5,
                LocalDateTime.of(2015, 5, 15, 15, 15));
        System.out.println("yearlyTask = " + yearlyTask);*/
        /*tasks.addTask(onceTask);
        tasks.addTask(dailyTask);
        tasks.addTask(weeklyTask);
        tasks.addTask(monthlyTask);
        tasks.addTask(yearlyTask);
        System.out.println();
        System.out.println(tasks);
        System.out.println();
        TaskService.printData(tasks);
        System.out.println();
        tasks.removeTask(3);
        TaskService.printData(tasks);
        tasks.addTask(new DailyTask("added task","daily task",1,2,
                LocalDateTime.now()));
        System.out.println();
        TaskService.printData(tasks);*/

        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner, tasks);
                            break;
                        case 2:
                            System.out.print("Введите номер задачи: ");
                            tasks.removeTask(scanner.nextInt());
                            System.out.println("List All Tasks:");
                            TaskService.printData(tasks);
                            System.out.println();
                            break;
                        case 3:
                            System.out.print("Введите дату в формате yyyy-MM-dd: ");
                            LocalDate userDate = getUserDate(scanner.next());
                            List<Task> tasksListOnDate = tasks.getTasksListOnDate(userDate);
//                            System.out.println("tasksListOnDate = " + tasksListOnDate);
                            printData(tasksListOnDate);

                            // todo: обрабатываем пункт меню 3
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
        TaskService.printData(tasks);
    }

    private static void inputTask(Scanner scanner, TaskService tasks) {
        System.out.print("Введите название задачи: ");
        String name = scanner.next();
        scanner.nextLine();
        System.out.print("Введите описание задачи: ");
        String description = scanner.nextLine();
        System.out.print("Введите дату и время задачи в формате 'yyyy-MM-ddTHH:mm:ss': ");
        String dateTime = scanner.nextLine();
        System.out.print("Введите тип задачи (1-рабочая, 2-личная): ");
        int type = scanner.nextInt();
        if (type != 1 && type != 2) {
            throw new RuntimeException("Некорректное значение типа задачи: введите 1 или 2");
        }
        String newType = type == 1 ? Type.WORK.getTaskType() : Type.PERSONAL.getTaskType();

        LocalDateTime localDateTime = LocalDateTime.parse(dateTime);

        System.out.print("Введите повторяемость задачи 1-однократная, 2-ежедневная, 3-еженедельняа, 4-ежемесячная, 5-ежегодная: ");
        Integer rep = scanner.nextInt();

        switch (rep) {
            case 1:
                tasks.addTask(new OnceTask(name, description, newType, rep, localDateTime));
                break;
            case 2:
                tasks.addTask(new DailyTask(name, description, newType, rep, localDateTime));
                break;
            case 3:
                tasks.addTask(new WeeklyTask(name, description, newType, rep, localDateTime));
                break;
            case 4:
                tasks.addTask(new MonthlyTask(name, description, newType, rep, localDateTime));
                break;
            case 5:
                tasks.addTask(new YearlyTask(name, description, newType, rep, localDateTime));
                break;
            default:
                throw new RuntimeException("Введите корректное число от 1 до 5:");
        }
        System.out.println("List All Tasks:");
        TaskService.printData(tasks);
        System.out.println();
//        Task task = new Task(name, description, type, rep) {
//                @Override
//                public boolean isAvailable(Task task, LocalDateTime query) {
//                    return false;
//                }
        }

    public static LocalDate getUserDate(String text) {
        LocalDate date = LocalDate.parse(text);
        return date;
    }

    public static void printData(List<Task> tasks) {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

//        public static LocalDateTime inputTaskDateTime()
//        System.out.println();

//        System.out.println();
//        TaskService.addTask(task);
//        System.out.println(service);


    private static void printMenu() {
        System.out.println("1. Добавить задачу\n2. Удалить задачу\n" +
                "3. Получить задачу на указанный день\n" +
                "0. Выход");
    }
}
