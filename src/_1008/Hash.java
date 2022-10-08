package _1008;

public class Hash {
    public Slot[] hashTable;

    public Hash(Integer size) {
        this.hashTable = new Slot[size];
    }

    class Slot {
        String value;

        Slot(String value) {
            this.value = value;
        }
    }

    public int hashFunc(String key) {
        return (int) (key.charAt(0)) % this.hashTable.length;
    }

    public boolean save(String key, String value) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            this.hashTable[address].value = value;
        } else {
            this.hashTable[address] = new Slot(value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if(this.hashTable[address] != null) {
            return this.hashTable[address].value;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Hash hash = new Hash(20);
        hash.save("1", "스폰지밥");
        hash.save("2", "뚱이");
        hash.save("3", "다람이");
        hash.save("4", "집게사장");

        String data = hash.getData("3");
        System.out.println(data);
    }
}
