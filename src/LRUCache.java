import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUCache {

    private int capacity;
    private List<Integer> data;
    private Map<Integer, Integer> dataPositionMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        data = new LinkedList<>();
        dataPositionMap = new HashMap<>();
    }

    public int get(int key) {
        if (hasItem(key)) {
            updateValue(key, getItem(key));
            return getItem(key);
        }
        return -1;
    }

    public void set(int key, int value) {
        if (hasItem(key)) {
            updateValue(key, value);
        } else {
            if (this.capacity == data.size()) {
                removeLastItem();
            }
            incrementAll();
            this.data.add(0, value);
            this.dataPositionMap.put(key, 0);
        }

    }

    private void incrementAll() {
        for (Map.Entry<Integer, Integer> dataPosition : new HashMap<>(dataPositionMap).entrySet()) {
            this.dataPositionMap.put(dataPosition.getKey(), dataPosition.getValue() + 1);
        }
    }

    private void updateValue(int key, int value) {
        int index = getItemIndex(key);
        for (Map.Entry<Integer, Integer> dataPosition : new HashMap<>(dataPositionMap).entrySet()) {
            if (dataPosition.getValue() < index) {
                this.dataPositionMap.put(dataPosition.getKey(), dataPosition.getValue() + 1);
            }
        }
        this.data.remove(index);
        this.data.add(0, value);
        this.dataPositionMap.put(key, 0);
    }

    private int getItemIndex(int key) {
        return this.dataPositionMap.get(key);
    }

    private boolean hasItem(int key) {
        return this.dataPositionMap.containsKey(key);
    }

    private int getItem(int key) {
        return this.data.get(this.dataPositionMap.get(key));
    }

    private void removeLastItem() {
        for (Map.Entry<Integer, Integer> dataPosition : new HashMap<>(dataPositionMap).entrySet()) {
            if (dataPosition.getValue() == lastItemIndex()) {
                dataPositionMap.remove(dataPosition.getKey());
            }
        }
        this.data.remove(lastItemIndex());
    }

    private Integer lastItem() {
        return this.data.get(lastItemIndex());
    }


    private int lastItemIndex() {
        return this.data.size() - 1;

    }
}