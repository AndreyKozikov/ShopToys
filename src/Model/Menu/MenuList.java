package Model.Menu;

import Model.Interfaces.Operations;

import java.util.ArrayList;
import java.util.Iterator;


public class MenuList implements Iterable<Menu>{
    
    private ArrayList<Menu> menu;

    public MenuList(String path) {
        this.menu = new ArrayList<>();
    }

    public void createMenuList(int id, Operations operation, String name){
        this.menu.add(new Menu(id, operation, name));
    }

    @Override
    public Iterator<Menu> iterator() {
        return menu.iterator();
    }

}
