package project;

import java.util.*;

public class App
{
    public static void main( String[] args )
    {
        Collection<DataRow<Integer, String>> countries = new HashSet<>();
        Collection<DataRow<Integer, String>> cities = new HashSet<>();
        JoinOperation<DataRow<Integer, String>, DataRow<Integer, String>, JoinedDataRow> innerJoinOperation = new InnerJoinOperation();
        JoinOperation<DataRow<Integer, String>, DataRow<Integer, String>, JoinedDataRow> leftJoinOperation = new LeftJoinOperation<>();
        JoinOperation<DataRow<Integer, String>, DataRow<Integer, String>, JoinedDataRow> rightJoinOperation = new RightJoinOperation<>();

        countries.add(new DataRow<>(0, "Ukraine"));
        countries.add(new DataRow<>(1, "Germany"));
        countries.add(new DataRow<>(2, "France"));
        countries.add(new DataRow<>(5, "Portugal"));
        countries.add(new DataRow<>(6, "Poland"));
        countries.add(new DataRow<>(9, "South Korea"));
        countries.add(new DataRow<>(10, "Vatican"));

        System.out.println("Countries:");
        System.out.println(countries);
        System.out.println();

        cities.add(new DataRow<>(0, "Kyiv"));
        cities.add(new DataRow<>(1, "Berlin"));
        cities.add(new DataRow<>(3, "Budapesht"));
        cities.add(new DataRow<>(5, "Lissabon"));
        cities.add(new DataRow<>(7, "Madrid"));

        System.out.println("Cities:");
        System.out.println(cities);
        System.out.println();

        Collection<JoinedDataRow> joinedDataRowsInner = innerJoinOperation.join(countries, cities);
        System.out.println("InnerJoin: ");
        joinedDataRowsInner.stream().forEach(System.out::println);
        System.out.println();

        Collection<JoinedDataRow> joinedDataRowsLeft = leftJoinOperation.join(countries, cities);
        System.out.println("LeftJoin: ");
        joinedDataRowsLeft.stream().forEach(System.out::println);
        System.out.println();

        Collection<JoinedDataRow> joinedDataRowsRight = rightJoinOperation.join(countries, cities);
        System.out.println("RightJoin: ");
        joinedDataRowsRight.stream().forEach(System.out::println);
    }
}
