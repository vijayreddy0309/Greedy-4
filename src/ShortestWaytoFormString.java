// TC: O(mn) m: length of source. n: length of target
// SC: O(m) 
import java.util.*;
public class ShortestWaytoFormString {
	public int shortestWay(String source, String target) {
		int sp = 0;
		int tp = 0;
		int count = 1;
		HashSet<Character> set = new HashSet<>();
		for(int i=0;i<source.length();i++) {
		    set.add(source.charAt(i));
		}
		while(tp < target.length()) {
		    if(!set.contains(target.charAt(tp))) return -1;
			if(source.charAt(sp) == target.charAt(tp)) {
				tp++;
			}
			sp++;
			if(sp==source.length() && tp<target.length()) {
				sp=0;
				count++;
			}
		}
		return count;
	}

}


//TC: O(nlogm)
// SC: O(m)

import java.util.*;
public class ShortestWaytoFormString {
	public int shortestWay(String source, String target) {
		Map<Character, List<Integer>> map = new HashMap<>();
		int count = 1;
		int sp = 0;
		int tp = 0;
		for(int i=0;i<source.length();i++) {
		    char sChar = source.charAt(i);
		    if (!map.containsKey(sChar)) {
                map.put(sChar, new ArrayList<>());
		    }
            map.get(sChar).add(i);  
		}
		
		while(tp < target.length()) {
		    char tChar = target.charAt(tp);
		    if(!map.containsKey(tChar)) return -1;
		    if(sp == source.length()) {
		            count++;
		            sp = 0;
		        }
		    if(tChar == source.charAt(sp)) {
		        tp++;
		        sp++;
		        //if(tp == target.length()) return count;
		    } else {
		        int bsIdx = binarySearch(map.get(tChar),sp);
		        if(bsIdx == map.get(tChar).size()) {
		            sp = map.get(tChar).get(0);
		            count++;
		        } else {
		            sp = map.get(tChar).get(bsIdx);
		        }
		        sp++;
		        tp++;
		    }
		    
		    
		}
		return count;
	}

    private int binarySearch(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(list.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
	
	public static void main(String[] args) {
	    String source = "abc";
	    String target = "abcbb";
	    ShortestWaytoFormString sol = new ShortestWaytoFormString();
	    int result = sol.shortestWay(source, target);
	    System.out.println(result);
	}
}

