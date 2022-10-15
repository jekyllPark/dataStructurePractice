package _1015;

public class Hash {
    Slot[] hashTable;

    Hash(Integer size) {
        this.hashTable = new Slot[size];
    }

    class Slot{
        String value;
        public Slot(String value){
            this.value = value;
        }
    }

    public Integer hashFunc(String key) {
        return (int) key.charAt(0) % this.hashTable.length;
    }

    public void save(String key, String value) {
        Integer address = this.hashFunc(key);
        if(this.hashTable[address] != null) {
            this.hashTable[address].value = value;
        } else {
            this.hashTable[address] = new Slot(value);
        }
    }
    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            return this.hashTable[address].value;
        } else {
            return null;
        }
    }
}
