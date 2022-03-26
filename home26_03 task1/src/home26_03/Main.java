package home26_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    /**
     * Задание 1
     * Пользователь вводит с клавиатуры набор чисел. Полученные числа необходимо сохранить в список. После
     * чего нужно показать меню, в котором предложить пользователю набор пунктов:
     * 1. Добавить элемент в список;
     * 2. Удалить элемент из списка;
     * 3. Показать содержимое списка;
     * 4. Проверить есть ли значение в списке;
     * 5. Заменить значение в списке.
     * В зависимости от выбора пользователя выполняется
     * действие, после чего меню отображается снова.
     * Для решения задачи используйте подходящий класс
     * из Java Collections Framework.
     */
    private static int InputNumber() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String temp = reader.readLine();
        Integer num = null;
        try {
            num = Integer.parseInt(temp);
        } catch (NumberFormatException ex) {
            System.out.println("Введено не число");
        }
        return num;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Сколько будет введено чисел?");
        int n = InputNumber();
        List<Integer> numberS = new ArrayList<>(n);
        while (n != 0) {
            n--;
            System.out.println("Введите число");
            int n1 = InputNumber();
            numberS.add(n1);
        }
        System.out.println(numberS);
        System.out.println("1. Продолжить");
        System.out.println("0. Выход");
        int x = InputNumber();
        while (x != 6) {
            System.out.println("0.Выход;\n1.Добавить элемент в список;\n2.Удалить элемент из списка;\n3.Показать содержимое списка;\n4.Проверить есть ли значение в списке;\n5.Заменить значение в списке");
            x = InputNumber();
            if (x == 1) {
                int number = InputNumber();
                numberS.add(number);
            } else if (x == 2){
                System.out.println("Какое число удалить?");
                int y = InputNumber();
                try {
                    int index = numberS.indexOf(y);
                    numberS.remove(index);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(y + " невозможно удалить, так как данного числа нет в списке");
                }
                System.out.println(numberS);
                //or
//            Iterator<Integer> iterator = numberS.iterator();
//            while (iterator.hasNext()){
//                int s = iterator.next();
//                if(s == y) {
//                    iterator.remove();
//                }
//            } System.out.println(numberS);
            } else if (x == 3) {
                System.out.println(numberS);
            } else if (x == 4) {
                System.out.println("Какое значение проверить?");
                int q = InputNumber();
                if (numberS.contains(q)) {
                    System.out.println(q + " есть в списке");
                } else {
                    System.out.println(q + " нет в списке");
                }

            } else if (x == 5) {
                System.out.println("Какое число заменить?");
                int z = InputNumber();
                int index1 = numberS.indexOf(z);
                System.out.println("Введите замену: ");
                int Z = InputNumber();
                numberS.set(index1, Z);
                System.out.println("Заменено:\n" + numberS);
            }
        }

    }
}
