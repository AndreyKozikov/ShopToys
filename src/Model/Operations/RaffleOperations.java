package Model.Operations;
/************************************
 *
 * Класс отвечает за управления розыгрышем призов
 *
 ***********************************/
import Model.*;
import Model.Interfaces.InputDataHandler;
import Model.Interfaces.MessageHandler;
import Model.Interfaces.Operations;

public class RaffleOperations implements Operations {//performOperation(out, in, menu)
    @Override
    public boolean performOperation(Object... args) {
        ToysList toyList = new ToysList();
        QueueOfParcipant parcipants = new QueueOfParcipant();
        toyList = FileIO.readDtFileToys("toys.txt");
        parcipants = FileIO.readDtFileParcipant("Parcipant.txt");
        boolean validInput = false;
        int countRaffles = 10;
        do {
            try {
                String input = ((InputDataHandler) args[1]).inputData("Введите количество розыгрышей: ");
                countRaffles = Integer.parseInt(input);
                validInput = true; // Если ввод корректен, выходим из цикла
            } catch (NumberFormatException e) {
                ((MessageHandler) args[0]).handleMessage("Ошибка: Некорректный ввод. Введите число.");
            }
        } while (!validInput);

        StringBuilder result = ConductTheRaffle.runRaffle(toyList, parcipants, countRaffles);
        ((MessageHandler) args[0]).handleMessage("Список победителей розыгрыша:\n" + result);
        FileIO.saveDtToFile(result, "result.txt");
        return false;
    }

}
