package Model.Interfaces;

/*
Интерфейс отвечает за формирование меню и используется для CallBack вызовов в модели MVP и позволяет
организовать взаимодействие между Model и View через Presenter
 */

import Model.Operations.ShopOperations;

public interface MenuPrinter {
    String menu(String path, ShopOperations operationsMenu);
}
