package Model;

import Model.Interfaces.Operations;
import Model.Menu.Menu;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class FileIO {
    private static ArrayList<Integer> id = new ArrayList<>();
    private static ArrayList<String> name = new ArrayList<>();
    private static ArrayList<Integer> chance = new ArrayList<>();

    private static int getId(int i) { //Ввести проверку нахождения индекса в диапазоне
        return id.get(i);
    }

    private static String getName(int i) { //Ввести проверку нахождения индекса в диапазоне
        return name.get((i));
    }

    private static int getChance(int i) { //Ввести проверку нахождения индекса в диапазоне
        return chance.get(i);
    }


    public static ToysList readDtFileToys(String path) throws RuntimeException {
        String str;
        String[] tmp = null;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((str = br.readLine()) != null) {
                tmp = str.split(" ");
                if (tmp.length < 3) {
                    throw new RuntimeException("Ошибка формата файла" + path);
                }
                try {
                    id.add(Integer.parseInt(tmp[0]));
                    chance.add(Integer.parseInt(tmp[1]));
                    name.add(tmp[2]);
                } catch (NumberFormatException e){
                    throw new RuntimeException("Ошибка формата файла" + path);
                }
            }
            ToysList toysList = new ToysList();
            for (int i = 0; i < id.size(); i++) {
                toysList.setToysList(new Toy(getId(i), getName(i), getChance(i)));
            }
            return toysList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static QueueOfParcipant readDtFileParcipant(String path) throws RuntimeException {
        QueueOfParcipant qp = new QueueOfParcipant();
        String str;
        String[] tmp = null;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((str = br.readLine()) != null) {
                tmp = str.split(" ");
                if (tmp.length < 3) {
                    throw new RuntimeException("Ошибка формата файла" + path);
                }
                qp.addParcipant(new Parcipant(tmp[0], tmp[1], tmp[2]));
            }
            return qp;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveDtToFile(StringBuilder data, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(data.toString());
            System.out.println("Данные успешно записаны в файл: " + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка при записи данных в файл: " + e.getMessage());
        }
    }

    public static ArrayList<Menu> readMenuFromFile(String path) throws RuntimeException { //Сделать путь к файлу аргументом метода
        ArrayList<Menu> menu = new ArrayList<>();
        String str;
        String[] tmp = null;
        int id;
        Operations operation;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((str = br.readLine()) != null) {
                tmp = str.split(";"); // Ввести проверку на количество аргументов
                if (tmp.length <3) {
                    throw new RuntimeException("Ошибка формата файла" + path);
                }
                id = Integer.parseInt(tmp[0]);
                operation = getOperation(tmp[1]);
                menu.add(new Menu(id, operation, tmp[2]));
            }
            return menu;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Operations getOperation(String operation) { //Метод реализует Reflection и позволяет получить класс по его имени
        try {
            // Получаем класс операции по имени из строки operation
            Class<?> operationClass = Class.forName(operation);

            // Создаем экземпляр операции
            Operations operationInstance = (Operations) operationClass.getDeclaredConstructor().newInstance();

            return operationInstance;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

}



