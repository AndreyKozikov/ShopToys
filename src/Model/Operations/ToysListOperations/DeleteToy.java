package Model.Operations.ToysListOperations;

import Model.FileIO;
import Model.Interfaces.InputDataHandler;
import Model.Interfaces.MessageHandler;
import Model.Interfaces.Operations;
import Model.ToysList;

public class DeleteToy implements Operations {
    @Override
    public boolean performOperation(Object... args) {
        int id = -1;
        boolean isValidInput = false;
        do {
            try {
                String inputData = ((InputDataHandler) args[1]).inputData("Введите номер игрушки, которую удаляем: ");
                id = Integer.parseInt(inputData);
                isValidInput = true; // Если ввод корректен, выходим из цикла
            } catch (NumberFormatException e) {
                ((MessageHandler) args[2]).handleMessage("Ошибка: Некорректный ввод. Введите число.");
            }
        } while (!isValidInput);
        ((ToysList) args[0]).deleteToy(id);
        FileIO.saveDtToFile(((ToysList) args[0]).preparationSaveToFile(), "toys.txt");
        return false;
    }
}
