package project;

import java.util.*;

public class App
{
    public static void main( String[] args )
    {
        Collection<DataRow<Integer, String>> country = new ArrayList<>();
        Collection<DataRow<Integer, String>> cities = new ArrayList<>();
        JoinOperation<DataRow<Integer, String>, DataRow<Integer, String>, JoinedDataRow> innerJoinOperation = new InnerJoinOperation();
        JoinOperation<DataRow<Integer, String>, DataRow<Integer, String>, JoinedDataRow> leftJoinOperation = new LeftJoinOperation<>();
        JoinOperation<DataRow<Integer, String>, DataRow<Integer, String>, JoinedDataRow> rightJoinOperation = new RightJoinOperation<>();

        country.add(new DataRow<>(0, "Ukraine"));
        country.add(new DataRow<>(1, "Germany"));
        country.add(new DataRow<>(2, "France"));
        country.add(new DataRow<>(5, "Portugal"));
        country.add(new DataRow<>(6, "Poland"));

        System.out.println("Countries:");
        System.out.println(country);
        System.out.println();

        cities.add(new DataRow<>(0, "Kyiv"));
        cities.add(new DataRow<>(1, "Berlin"));
        cities.add(new DataRow<>(3, "Budapesht"));
        cities.add(new DataRow<>(5, "Lissabon"));
        cities.add(new DataRow<>(7, "Madrid"));

        System.out.println("Cities:");
        System.out.println(cities);
        System.out.println();

        Collection<JoinedDataRow> joinedDataRowsInner = innerJoinOperation.join(country, cities);
        System.out.println("InnerJoin: ");
        joinedDataRowsInner.stream().forEach(System.out::println);
        System.out.println();

        Collection<JoinedDataRow> joinedDataRowsLeft = leftJoinOperation.join(country, cities);
        System.out.println("LeftJoin: ");
        joinedDataRowsLeft.stream().forEach(System.out::println);
        System.out.println();

        Collection<JoinedDataRow> joinedDataRowsRight = rightJoinOperation.join(country, cities);
        System.out.println("RightJoin: ");
        joinedDataRowsRight.stream().forEach(System.out::println);
    }
}
