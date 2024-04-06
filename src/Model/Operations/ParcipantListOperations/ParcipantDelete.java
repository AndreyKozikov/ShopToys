package Model.Operations.ParcipantListOperations;

import Model.FileIO;
import Model.Interfaces.InputDataHandler;
import Model.Interfaces.MessageHandler;
import Model.Interfaces.Operations;
import Model.QueueOfParcipant;

public class ParcipantDelete implements Operations {
    @Override
    public boolean performOperation(Object... args) {
        int input = -1;
        boolean isValidInput = false;
        do {
            try {
                String inputData = ((InputDataHandler) args[1]).inputData("Введите через пробел номер удаляемого участника розыгрыша: ");
                input = Integer.parseInt(inputData);
                isValidInput = true; // Если ввод корректен, выходим из цикла
            } catch (NumberFormatException e) {
                ((MessageHandler) args[2]).handleMessage("Ошибка: Некорректный ввод. Введите число.");
            }
        } while (!isValidInput);

        ((QueueOfParcipant) args[0]).deleteParcipian(input-1);
        ((MessageHandler) args[2]).handleMessage("Участник розыгрыша удален");
        FileIO.saveDtToFile(((QueueOfParcipant) args[0]).preparationSaveToFile(), "Parcipant.txt");
        return false;
    }
}
