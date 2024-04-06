package Model.Menu;

import Model.Interfaces.Operations;

public class Menu {
    private int id;
    private Operations operation;
    private String name;

    public Menu(int id, Operations operation, String name) {
        this.id = id;
        this.operation = operation;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Operations getOperation() {
        return  this.operation;
    }

    public String getName() {
        return name;
    }
}
