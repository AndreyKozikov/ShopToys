package Model.Operations.ParcipantListOperations;

import Model.Interfaces.MessageHandler;
import Model.Interfaces.Operations;
import Model.QueueOfParcipant;

public class ParcipantList implements Operations {
    @Override
    public boolean performOperation(Object... args) {
        ((MessageHandler) args[2]).handleMessage(((QueueOfParcipant) args[0]).toString());
        return false;
    }
}
