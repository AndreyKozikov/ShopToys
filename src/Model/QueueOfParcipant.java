package Model;

import java.util.LinkedList;

public class QueueOfParcipant {

    private LinkedList<Parcipant> qp;

    public QueueOfParcipant() {
        this.qp = new LinkedList<>();
    }

    public void addParcipant(Parcipant parcipant){
        qp.add(parcipant);
    }

    public int getCount(){
        return qp.size();
    }

    public LinkedList<Parcipant> getQp() {
        return qp;
    }

    public void deleteParcipian(int index){
        qp.remove(index);
    }

    public Parcipant getParcipantById (int index){
        return qp.remove(index);
    }
    public Parcipant getParcipant(){
        return qp.pop();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int id = 1;
        for (Parcipant parcipant : qp) {
            stringBuilder.append(id).append(". ").append(parcipant.toString()).append("\n");
            id++;
        }
        return stringBuilder.toString();
    }

    public StringBuilder preparationSaveToFile() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Parcipant parcipant : qp) {
            stringBuilder.append(parcipant.preparationSaveToFile());
        }
        return stringBuilder;
    }
}
