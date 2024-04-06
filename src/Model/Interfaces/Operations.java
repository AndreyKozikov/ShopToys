package Model.Interfaces;

/*
 Интерфейс реализщцет паттерн Factory (фабричный метод). Паттерн Factory является порождающим паттерном проектирования,
 который предоставляет способ создания объектов без указания конкретных классов этих объектов.
 */


public interface Operations {
        boolean performOperation(Object... args);

}
