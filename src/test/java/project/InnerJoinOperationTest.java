package project;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

public class InnerJoinOperationTest {

    Collection<DataRow<Integer, String>> countries;
    Collection<DataRow<Integer, String>> cities;
    Collection<JoinedDataRow> joinedDataRowsInner;

    @Test
    public void join() {
        InnerJoinOperation<DataRow<Integer, String>, DataRow<Integer, String>, JoinedDataRow> innerJoinOperation = new InnerJoinOperation();

        assertArrayEquals(innerJoinOperation.join(countries, cities).toArray(), joinedDataRowsInner.toArray());
    }

    @Before
    public void createArray() {
        countries = new ArrayList<>();
        countries.add(new DataRow<>(0, "Ukraine"));
        countries.add(new DataRow<>(1, "Germany"));
        countries.add(new DataRow<>(2, "France"));
        countries.add(new DataRow<>(5, "Portugal"));
        countries.add(new DataRow<>(6, "Poland"));
        countries.add(new DataRow<>(9, "South Korea"));
        countries.add(new DataRow<>(10, "Vatican"));

        cities = new ArrayList<>();
        cities.add(new DataRow<>(0, "Kyiv"));
        cities.add(new DataRow<>(1, "Berlin"));
        cities.add(new DataRow<>(3, "Budapesht"));
        cities.add(new DataRow<>(5, "Lissabon"));
        cities.add(new DataRow<>(7, "Madrid"));

        joinedDataRowsInner = new ArrayList<>();
        joinedDataRowsInner.add(new JoinedDataRow<>(0, "Ukraine", "Kyiv"));
        joinedDataRowsInner.add(new JoinedDataRow<>(1, "Germany", "Berlin"));
        joinedDataRowsInner.add(new JoinedDataRow<>(5, "Portugal", "Lissabon"));
    }
}