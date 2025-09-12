package testdome;

import java.util.LinkedList;
import java.util.List;

public class TrainComposition {
    List<Integer> trains = new LinkedList<>();
    public void attachWagonFromLeft(int wagonId) {
        trains.add(0, wagonId);
    }

    public void attachWagonFromRight(int wagonId) {
        trains.add(wagonId);
    }

    public int detachWagonFromLeft() {
        return trains.remove(0);
    }

    public int detachWagonFromRight() {
        return trains.remove(trains.size()-1);
    }

    public static void main(String[] args) {
        TrainComposition train = new TrainComposition();
        train.attachWagonFromLeft(7);
        train.attachWagonFromLeft(13);
        System.out.println(train.detachWagonFromRight()); // 7
        System.out.println(train.detachWagonFromLeft()); // 13
    }
}