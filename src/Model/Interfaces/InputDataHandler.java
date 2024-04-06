package Model.Interfaces;

/*
Интерфейс отвечает за ввод данных пользователей и используется для CallBack вызовов в модели MVP и позволяет
организовать взаимодействие между Model и View через Presenter
 */

public interface InputDataHandler {
    String inputData(String message);

}
