package project;

import java.util.ArrayList;
import java.util.Collection;

public class RightJoinOperation<D1, D2, R> implements JoinOperation{

    private D1[] left;
    private D2[] right;
    private Collection<R> joined;

    @Override
    public Collection join(Collection leftCollection, Collection rightCollection) {
        left = (D1[]) leftCollection.toArray();
        right = (D2[]) rightCollection.toArray();
        joined = new ArrayList<>();

        for (int i = 0; i < right.length; i++) {
            JoinedDataRow joinedDataRow = new JoinedDataRow();
            DataRow rightData = (DataRow) right[i];
            joinedDataRow.setKey(rightData.getKey());
            joinedDataRow.setValue2(rightData.getValue());
            for (int j = 0; j < left.length; j++) {
                if (right[i].equals(left[j])) {
                    DataRow leftData = (DataRow) left[j];
                    joinedDataRow.setValue1(leftData.getValue());
                    break;
                } else joinedDataRow.setValue1(null);
            }
            joined.add((R) joinedDataRow);
        }
        return joined;
    }
}

