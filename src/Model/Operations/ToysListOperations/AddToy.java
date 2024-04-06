package Model.Operations.ToysListOperations;

import Model.FileIO;
import Model.Interfaces.InputDataHandler;
import Model.Interfaces.MessageHandler;
import Model.Interfaces.Operations;
import Model.Toy;
import Model.ToysList;

public class AddToy implements Operations {
    @Override
    public boolean performOperation(Object... args) {
        String toyString;
        String[] tmp = null;
        int id = -1;
        int chance = 0;
        boolean isValidInput = false;
        do {
            toyString = ((InputDataHandler) args[1]).inputData("Введите через пробел номер и шанс выпадения (целые числа) и название игрушки: ");
            tmp = toyString.split(" ");

            try {
                id = Integer.parseInt(tmp[0]);
                chance = Integer.parseInt(tmp[1]);
                isValidInput = true; // Если ввод корректен, выходим из цикла
            } catch (NumberFormatException e) {
                ((MessageHandler) args[2]).handleMessage("Ошибка: Некорректный ввод.");
            }
            if (tmp.length != 3 && isValidInput) {
                ((MessageHandler) args[2]).handleMessage("Ошибка: Некорректный ввод.");
                isValidInput = false;
            }
        } while (!isValidInput);
        String name = tmp[2];
        ((ToysList) args[0]).setToysList(new Toy(id, name, chance));
        FileIO.saveDtToFile(((ToysList) args[0]).preparationSaveToFile(), "toys.txt");
        return false;
    }
}
