package Model.Operations.ToysListOperations;

import Model.Interfaces.MessageHandler;
import Model.Interfaces.Operations;

public class ShowToys implements Operations {
    @Override
    public boolean performOperation(Object... args) {
        ((MessageHandler) args[2]).handleMessage(args[0].toString());
        return false;
    }
}
