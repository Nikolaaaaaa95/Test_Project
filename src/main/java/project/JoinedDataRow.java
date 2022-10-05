package project;

import java.util.Objects;

public class JoinedDataRow <K extends Comparable<K>, V1, V2> {

    private K key;
    private V1 value1;
    private V2 value2;

    public JoinedDataRow() {

    }

    public JoinedDataRow(K key, V1 value1, V2 value2) {
        this.key = key;
        this.value1 = value1;
        this.value2 = value2;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JoinedDataRow<?, ?, ?> that = (JoinedDataRow<?, ?, ?>) o;
        return key.equals(that.key) && Objects.equals(value1, that.value1) && Objects.equals(value2, that.value2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value1, value2);
    }
}
