package project;

import java.util.ArrayList;
import java.util.Collection;

public class InnerJoinOperation <D1, D2, R> implements JoinOperation {

    private D1[] left;
    private D2[] right;
    private Collection<R> joined;


    @Override
    public Collection<R> join(Collection leftCollection, Collection rightCollection) {
        left = (D1[]) leftCollection.toArray();
        right = (D2[]) rightCollection.toArray();
        joined = new ArrayList<>();

        for (int i = 0; i < left.length; i++)
            for (int j = 0; j < right.length; j++) {
                if (left[i].equals(right[j])) {
                    JoinedDataRow joinedDataRow = new JoinedDataRow();
                    DataRow leftData = (DataRow) left[i];
                    DataRow rightData = (DataRow) right[j];
                    joinedDataRow.setKey(leftData.getKey());
                    joinedDataRow.setValue1(leftData.getValue());
                    joinedDataRow.setValue2(rightData.getValue());
                    joined.add((R) joinedDataRow);
                }
            }
        return joined;
    }
}
