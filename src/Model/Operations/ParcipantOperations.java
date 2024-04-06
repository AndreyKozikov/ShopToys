package Model.Operations;

/************************************
 *
 * Класс отвечает за управление меню и операции со списком участников розыгрыша и вызывает соответствующие операции после ввода пользователя
 *
 ***********************************/

import Model.FileIO;
import Model.Interfaces.InputDataHandler;
import Model.Interfaces.MenuPrinter;
import Model.Interfaces.MessageHandler;
import Model.Interfaces.Operations;
import Model.QueueOfParcipant;

public class ParcipantOperations implements Operations { //performOperation(out, in, menu)
    @Override
    public boolean performOperation(Object... args) {
        boolean exit = false;
        QueueOfParcipant parcipantList;
        parcipantList =  FileIO.readDtFileParcipant("Parcipant.txt");
        while (!exit) {
            ShopOperations operationsMenu = new ShopOperations();
            int selection = 0;
            String result = ((MenuPrinter) args[2]).menu("parcipantmenu.txt", operationsMenu);
            if (args[0] instanceof MessageHandler) {
                ((MessageHandler) args[0]).handleMessage("Операции с участниками розыгрыша.\n" + result);
            }
            if (args[1] instanceof InputDataHandler) {
                selection = Integer.parseInt(((InputDataHandler) args[1]).inputData("Введите число: "));
            }
            Operations doOperation = operationsMenu.getOperation(selection);
            InputDataHandler inputData = (InputDataHandler) args[1];
            MessageHandler outputData = (MessageHandler) args[0];
            exit = doOperation.performOperation(parcipantList, inputData, outputData);
        }
        return false;
    }
}
