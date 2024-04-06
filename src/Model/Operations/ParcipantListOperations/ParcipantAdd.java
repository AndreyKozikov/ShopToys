package Model.Operations.ParcipantListOperations;

import Model.FileIO;
import Model.Interfaces.InputDataHandler;
import Model.Interfaces.MessageHandler;
import Model.Interfaces.Operations;
import Model.Parcipant;
import Model.QueueOfParcipant;

public class ParcipantAdd implements Operations {
    @Override
    public boolean performOperation(Object... args) {
        boolean errors = false;
        String[] input = ((InputDataHandler) args[1]).inputData("Введите через пробел фамилия, имя и телефон нового участника розыгрыша: ").split(" ");
        while (input.length != 3) {
            ((MessageHandler) args[2]).handleMessage("Ошибка данных. Повторите ввод.");
            input = ((InputDataHandler) args[1]).inputData("Введите через пробел фамилия, имя и телефон нового участника розыгрыша: ").split(" ");
        }
        ((QueueOfParcipant) args[0]).addParcipant(new Parcipant(input[0], input[1], input[2]));
        ((MessageHandler) args[2]).handleMessage("Участник розыгрыша добавлен");
        FileIO.saveDtToFile(((QueueOfParcipant) args[0]).
                preparationSaveToFile(), "Parcipant.txt");
        return false;
    }
}
