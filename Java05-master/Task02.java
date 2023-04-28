//
//Пусть дан список сотрудников:
//Иван Иванов
//Светлана Петрова
//Кристина Белова
//Анна Мусина
//Анна Крутова
//Иван Юрин
//Петр Лыков
//Павел Чернов
//Петр Чернышов
//Мария Федорова
//Марина Светлова
//Мария Савина
//Мария Рыкова
//Марина Лугова
//Анна Владимирова
//Иван Мечников
//Петр Петин
//Иван Ежов
//
//        Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
//        Отсортировать по убыванию популярности Имени.


import java.io.FileReader;
import java.util.*;


public class Task02 {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("people.txt");
        Scanner scan = new Scanner(fr);
        Map<String, Integer> people = new HashMap<>();
        ArrayList<String> str = new ArrayList<>();
        while (scan.hasNextLine())
            str.add(scan.nextLine());
        System.out.println(str);

        for (String s : str) {
            int count = 1;
            String[] temp = s.split(" ");
            if (people.containsKey(temp[0]))
                count = people.get(temp[0]) + 1;
            people.put(temp[0], count);
        }
        System.out.println(people);

        ArrayList<Integer> list = new ArrayList<>();
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : people.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list);
        Collections.reverse(list);

        for (int num : list) {
            for (Map.Entry<String, Integer> entry : people.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedMap.put(entry.getKey(), num);
                }
            }
        }
        System.out.println(sortedMap);
    }
}