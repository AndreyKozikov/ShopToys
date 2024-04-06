package Model;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;

public class ConductTheRaffle {
    private static Random random = new Random();
    private static PriorityQueue<Toy> pq = new PriorityQueue<>();
    private static LinkedList<String> result = new LinkedList<>();

    public static StringBuilder runRaffle(ToysList toysLst, QueueOfParcipant parcipants, int countRuffles) {
        StringBuilder resultRaffle = new StringBuilder();
        int totalprob = toysLst.getTotalprob();
        while (countRuffles > 0) {
            Toy toy = getToy(toysLst, totalprob);
            if (toy != null) {
                int randomParcipant = random.nextInt(parcipants.getCount());
                result.add(parcipants.getParcipantById(randomParcipant).toString() + " выиграл игрушку " + toy.getName() + "\n"); //Сделано только для выполнения условия задания по организации общей очереди
                countRuffles--;
            }
        }
        for (String item: result){
            resultRaffle.append(item);
        }
        return resultRaffle;
    }

    private static Toy getToy(ToysList toys, int totalProb) {
        for (Toy toy : toys) {
            pq.add(toy);
        }
        int cumulativeWeight = 0;
        int randomNumber = random.nextInt(totalProb);
        while (!pq.isEmpty()) {
            Toy toy = pq.poll();
            cumulativeWeight += toy.getChance();
            if (randomNumber < cumulativeWeight) {
                return toy;
            }
        }
        return null;
    }
}
