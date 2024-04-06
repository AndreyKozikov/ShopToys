package Model;

public class Toy implements Comparable<Toy> {
    private int id;
    private String name;
    private int chance;

    public Toy(int id, String name, int chance) {
        this.id = id;
        this.name = name;
        this.chance = chance;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getChance() {
        return this.chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public String preparationSaveToFile() {
        return id + " " + chance + " " + name + "\n";
    }
    @Override
    public String toString() {
        return "Игрушка номер: " + id +
                ", название: '" + name + '\'' +
                ", шанс выпадения: " + chance +
                " \n";
    }

    @Override
    public int compareTo(Toy o) {
        return  Double.compare(o.chance, this.chance);
    }
}
