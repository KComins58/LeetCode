public class Solution {
    public List<Integer> largestDivisibleSubset(int[] iNums) {
        if (iNums == null || iNums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(iNums);

        int n = iNums.length;
        int[] aNums = new int[n];
        Arrays.fill(aNums, 1);

        int iMSize = 1;
        int iMIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (iNums[i] % iNums[j] == 0 && aNums[i] < aNums[j] + 1) {
                    aNums[i] = aNums[j] + 1;
                    if (aNums[i] > iMSize) {
                        iMSize = aNums[i];
                        iMIndex = i;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        int iCSize = iMSize;
        int iCVal = iNums[iMIndex];

        for (int i = iMIndex; i >= 0; i--) {
            if (iCVal % iNums[i] == 0 && aNums[i] == iCSize) {
                result.add(iNums[i]);
                iCVal = iNums[i];
                iCSize--;
            }
        }

        Collections.reverse(result); 
        return result;
    }
}
