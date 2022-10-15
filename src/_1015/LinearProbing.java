package _1015;

public class LinearProbing {
    public Slot[] hashTable;
    public LinearProbing(Integer size) {
        this.hashTable = new Slot[size];
    }
    class Slot{
        String key;
        String value;
        Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public int hashFunc(String key) {
        return (int) (key.charAt(0)) % this.hashTable.length;
    }

    public boolean save(String key, String value) {
        Integer address = this.hashFunc(key);
        if(this.hashTable[address] != null) {
            if (this.hashTable[address].key == key) {
                this.hashTable[address].value = value;
                return true;
            } else {
                Integer currAddress = address + 1;
                while(this.hashTable[currAddress] != null) {
                    if (this.hashTable[currAddress].key == key) {
                        this.hashTable[currAddress].value = value;
                        return true;
                    } else {
                        currAddress++;
                        if (currAddress >= this.hashTable.length) {
                            return false;
                        }
                    }
                }
                this.hashTable[currAddress] = new Slot(key, value);
                return true;
            }
        } else {
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if(this.hashTable[address] != null) {
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
        LinearProbing linearProbing = new LinearProbing(4);
        linearProbing.save("1", "돌맹이");
        linearProbing.save("2", "돌붕이");
        linearProbing.save("3", "뚱이");
        linearProbing.save("4", "다람이");

        linearProbing.save("3", "스폰지밥");
        linearProbing.save("5", "집게사장");

        String data1 = linearProbing.getData("1");
        String data2 = linearProbing.getData("2");
        String data3 = linearProbing.getData("3");
        String data4 = linearProbing.getData("4");
        String data5 = linearProbing.getData("5");
        System.out.println("data1 = " + data1);
        System.out.println("data1 = " + data2);
        System.out.println("data1 = " + data3);
        System.out.println("data1 = " + data4);
        System.out.println("data1 = " + data5);
    }
}
