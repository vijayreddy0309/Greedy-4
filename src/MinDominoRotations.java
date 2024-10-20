// TC: O(n)
// SC: O(1) //at most we can have only 6 numbers on domino
class MinDominoRotations {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int n = tops.length;
        int target = 0;
        int topCount = 0;
        int bottomCount = 0;
        for(int i=0;i<n;i++) {
            frequencyMap.put(tops[i],frequencyMap.getOrDefault(tops[i],0)+1);
            if(frequencyMap.get(tops[i]) >= n) {
                target = tops[i];
                break;
            }
        }
        for(int i=0;i<n;i++) {
            frequencyMap.put(bottoms[i],frequencyMap.getOrDefault(bottoms[i],0)+1);
            if(frequencyMap.get(bottoms[i]) >= n) {
                target = bottoms[i];
                break;
            }
        }

        for(int i=0;i<n;i++) {
            if(tops[i]!= target && bottoms[i] != target) return -1;
            if(tops[i] == target && bottoms[i] != target) topCount++;
            if(tops[i] != target && bottoms[i] == target) bottomCount++;
        }
        return Math.min(topCount,bottomCount);
    }
}

//Solution without finding the target
// TC: O(n)
// SC: O(1)
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int result = minRotations(tops,bottoms,tops[0]);
        if(result == -1) {
            return minRotations(tops,bottoms,bottoms[0]);
        }
        return result;
    }

    private int minRotations(int[] tops, int[] bottoms,int target) {
        int n = tops.length;
        int topCount = 0;
        int bottomCount = 0;
        for(int i=0;i<n;i++) {
            if(tops[i]!= target && bottoms[i] != target) return -1;
            if(tops[i] == target && bottoms[i] != target) topCount++;
            if(tops[i] != target && bottoms[i] == target) bottomCount++;
        }
        return Math.min(topCount,bottomCount);
    }
}