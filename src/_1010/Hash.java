package _1010;

public class Hash {
    Slot[] hashTable;

    Hash(Integer size) {
        this.hashTable = new Slot[size];
    }

    class Slot {
        String value;

        Slot(String value) {
            this.value = value;
        }
    }

    int hashFunc(String key) {
        return (int) key.charAt(0) % this.hashTable.length;
    }

    void save(String key, String value) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            this.hashTable[address].value = value;
        } else {
            this.hashTable[address] = new Slot(value);
        }
    }

    String getData(String key) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            return this.hashTable[address].value;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Hash hash = new Hash(2);
        hash.save("천재", "맹이");
        hash.save("돌", "붕이");

        String 돌 = hash.getData("돌");

        System.out.println("돌 = " + 돌);
    }
}
