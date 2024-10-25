import java.util.Arrays;

public class Storage<T extends Comparable<T>> {
    private final T[] storage;
    private int cap;

    public Storage(int size) {
        storage = (T[]) new Comparable[size];
        cap = 0;
    }

    public void Add(T item) throws StorageExp{
        if(cap == storage.length)
            throw new StorageExp("Хранилище переполнено");

        storage[cap] = item;
        cap++;
    }

    public void Remove() throws StorageExp{
        if (cap == 0)
            throw new StorageExp("Хранилище пусто");

        cap--;
    }

    public void Sort() throws StorageExp{
        if (cap == 0)
            throw new StorageExp("Хранилище пусто");

        boolean duplicates = true;
        for(int i = 0; i < storage.length - 1; i++) {
            if(storage[i] != storage[i+1]){
                duplicates = false;
                break;
            }
        }

        if(duplicates) {
            throw new StorageExp("Массив состоит полностью из одинаковых элементов");
        }
        Arrays.sort(storage);
    }

    public void print() {
        for (int i = 0; i < cap; i++) {
            System.out.println(storage[i]);
        }
    }
}
