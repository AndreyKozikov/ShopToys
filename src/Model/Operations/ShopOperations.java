package Model.Operations;

/************************************
 *
 * Класс отвечает за управления меню и вызывает соответствующие операции после выбора пользователя над списками игрушек и участников розыгрыша, а также запуск розыгрыша
 *
 ***********************************/

import Model.Interfaces.Operations;

import java.util.HashMap;
import java.util.Map;

public class ShopOperations {

    private final Map<Integer, Operations> operationMap = new HashMap<>();
    private String path;

    public void addOperation(int key, Operations operation){
        operationMap.put(key, operation);
    }
    public Operations getOperation(Integer operation) {
        return operationMap.get(operation);
    }
}
