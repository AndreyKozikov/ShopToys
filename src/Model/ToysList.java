package Model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Consumer;

public class ToysList implements Iterable<Toy> {
    private LinkedList<Toy> toysList;
    private int count = 0;
    private int totalprob = 0;

    public ToysList() {
        this.toysList = new LinkedList<>();
    }

    public int getCount() {
        return count;
    }

    public boolean deleteToy(int idToDel) {
        int id = 0;
        for (Toy toy : this.toysList) {
            if (idToDel == toy.getId()) {
                this.toysList.remove(id);
                return true;
            }
            id++;
        }
        return false;
    }

    public boolean changeChanceForToy(int id, int chance) {
        for (Toy toy : this.toysList) {
            if (id == toy.getId()) {
                toy.setChance(chance);
                return true;
            }
        }
        return false;
    }

    public void setToysList(Toy toy) {
        this.toysList.add(toy);
        this.count++;
        this.totalprob += toy.getChance();

    }

    public int getTotalprob() {
        return totalprob;
    }

    public StringBuilder preparationSaveToFile() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Toy toy : toysList) {
            stringBuilder.append(toy.preparationSaveToFile());
        }
        return stringBuilder;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список игрушек:\n");
        for (Toy toy : toysList) {
            stringBuilder.append(toy.toString());
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<Toy> iterator() {
        return toysList.iterator();
    }

    @Override
    public void forEach(Consumer<? super Toy> action) {
        for (Toy toy : toysList) {
            action.accept(toy);
        }
    }
}
