package project;

import java.util.ArrayList;
import java.util.Collection;

public class LeftJoinOperation<D1, D2, R> implements JoinOperation{

    private D1[] left;
    private D2[] right;
    private Collection<R> joined;

    @Override
    public Collection<R> join(Collection leftCollection, Collection rightCollection) {
        left = (D1[]) leftCollection.toArray();
        right = (D2[]) rightCollection.toArray();
        joined = new ArrayList<>();

        for (int i = 0; i < left.length; i++) {
            JoinedDataRow joinedDataRow = new JoinedDataRow();
            DataRow leftData = (DataRow) left[i];
            joinedDataRow.setKey(leftData.getKey());
            joinedDataRow.setValue1(leftData.getValue());
            for (int j = 0; j < right.length; j++) {
                if (left[i].equals(right[j])){
                    DataRow rightData = (DataRow) right[j];
                    joinedDataRow.setValue2(rightData.getValue());
                    break;
                }
                else joinedDataRow.setValue2(null);
            }
            joined.add((R) joinedDataRow);
        }
        return joined;
    }
}
