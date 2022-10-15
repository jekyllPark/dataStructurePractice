package _1015;

public class LinearProbing2 {
    public Slot[] hashTable;

    public LinearProbing2(Integer size) {
        this.hashTable = new Slot[size];
    }

    class Slot {
        String key;
        String value;
        public Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public int hashFunc(String key) {
        return (int) (key.charAt(0)) % this.hashTable.length;
    }

    public boolean save(String key, String value) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            if(this.hashTable[address].key == key) {
                this.hashTable[address].value = value;
                return true;
            } else {
                Integer curAddress = address + 1;
                while (this.hashTable[curAddress] != null) {
                    if (this.hashTable[curAddress].key == key) {
                        this.hashTable[curAddress].value = value;
                        return true;
                    } else {
                        curAddress++;
                        if (curAddress >= this.hashTable.length) {
                            return false;
                        }
                    }
                }
                this.hashTable[curAddress] = new Slot(key, value);
                return true;
            }
        } else {
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            if (this.hashTable[address].key == key) {
                return this.hashTable[address].value;
            } else {
                Integer currAddress = address;
                while(this.hashTable[currAddress] != null) {
                    if(this.hashTable[currAddress].key == key) {
                        return this.hashTable[currAddress].value;
                    } else {
                       currAddress++;
                        if (currAddress >= this.hashTable.length) {
                            return null;
                        }
                    }
                }
                return null;
            }
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        LinearProbing2 linearProbing2 = new LinearProbing2(3);
        linearProbing2.save("1", "naruto");
        linearProbing2.save("2", "sasuke");
        linearProbing2.save("2", "hinata");

        System.out.println(linearProbing2.getData("1"));
        System.out.println(linearProbing2.getData("2"));
        System.out.println(linearProbing2.getData("3"));
    }
}
