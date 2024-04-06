package Model.Interfaces;

/*
Интерфейс отвечает за вывод сообщений и используется для CallBack вызовов в модели MVP и позволяет
организовать взаимодействие между Model и View через Presenter
 */

public interface MessageHandler {
    void handleMessage(String message);
}
