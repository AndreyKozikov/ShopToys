package Model.Operations.ToysListOperations;

import Model.FileIO;
import Model.Interfaces.InputDataHandler;
import Model.Interfaces.MessageHandler;
import Model.Interfaces.Operations;
import Model.ToysList;

public class SetChance implements Operations {
    @Override
    public boolean performOperation(Object... args) {
        int id = -1;
        int chance = 0;
        boolean isValidInput = false;
        do {
            try {
                id = Integer.parseInt(((InputDataHandler) args[1]).inputData("Введите номер игрушки, для которой меняем шанс выпадения: "));
                chance = Integer.parseInt(((InputDataHandler) args[1]).inputData("Введите новое значение шанса выпадения: "));
                isValidInput = true; // Если ввод корректен, выходим из цикла
            } catch (NumberFormatException e) {
                ((MessageHandler) args[2]).handleMessage("Ошибка: Некорректный ввод. Введите число.");
            }
        } while (!isValidInput);

        boolean success = ((ToysList) args[0]).changeChanceForToy(id, chance);
        if (success){
            FileIO.saveDtToFile(((ToysList) args[0]).preparationSaveToFile(), "toys.txt");
        }
        return false;
    }
}
