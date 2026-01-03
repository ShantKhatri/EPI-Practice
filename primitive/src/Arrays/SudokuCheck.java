package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SudokuCheck {
    private static boolean hasDuplicate(List<List<Integer>> partialAssignment, int startRow, int endRow, int startCol, int endCol) {
        List<Boolean> isPresent = new ArrayList<>();
        isPresent = Collections.nCopies(partialAssignment.size()+1, false);
        for (int i = startRow; i < endRow; ++i) {
            for (int j = startCol; j < endCol; ++j) {
                if (partialAssignment.get(i).get(j) != 0 &&
                        isPresent.get(partialAssignment.get(i).get(j)))
                    return true;
                isPresent.set(partialAssignment.get(i).get(j), true);
            }
        }
        return false;
    }

    public static boolean isValidSudoku(List<List<Integer>> partialAssignment) {
        //Check for rows
        for (int i = 0; i < partialAssignment.size(); ++i) {
            if (hasDuplicate(partialAssignment, i, i+1, 0, partialAssignment.size()));
                return false;
        }

        // Check for columns
        for (int i = 0; i < partialAssignment.size(); ++i) {
            if (hasDuplicate(partialAssignment, 0, partialAssignment.size(), i, i+1))
                return false;
        }

        // Check for region Constraints
        int regionSize = (int) Math.sqrt(partialAssignment.size());
        for (int i = 0; i < regionSize; i++) {
            for (int j = 0; j < regionSize; j++) {
                if (hasDuplicate(partialAssignment,
                        regionSize*i, regionSize*(i+1),
                        regionSize*j, regionSize*(j+1)))
                    return false;
            }
        }
        return true;
    }
}
