package project;

public class JoinedDataRow <K extends Comparable<K>, V1, V2> {

    private K key;
    private V1 value1;
    private V2 value2;

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue1(V1 value1) {
        this.value1 = value1;
    }

    public void setValue2(V2 value2) {
        this.value2 = value2;
    }

    @Override
    public String toString() {
        return "JoinedDataRow{" +
                key + ", " + value1 +
                ", " + value2 + '}';
    }
}
