//Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
//        Добавить функции 1) Добавление номера
//                         2) Вывод всего


import java.util.*;

public class Task01 {
    public static void main(String[] args) {
        Map<String, List<String>> phoneBook = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1 - Добавление номера ");
            System.out.println("2 - Вывод всего ");
            System.out.println("3 - Выход ");
            System.out.println("Введите пункт меню: ");
            String operation = sc.next();
            List<String> phoneList = new ArrayList<>();

            switch (operation) {
                case "1" -> {
                    System.out.println("Введите имя");
                    String name = sc.next();
                    System.out.println("Введите телефон");
                    String phone = sc.next();
                    if (phoneBook.containsKey(name))
                        phoneList = phoneBook.get(name);
                    phoneList.add(phone);
                    phoneBook.put(name, phoneList);
                }
                case "2" -> {
                    for (Map.Entry<String, List<String>> entry : phoneBook.entrySet())
                        System.out.println(entry);
                }
                case "3" -> {
                    sc.close();
                    return;
                }
                default -> System.out.println("Неверный ввод");
            }
        }
    }
}
