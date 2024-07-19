package telran.util.test;

import java.util.Comparator;

public class EvenOddComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer arg0, Integer arg1) {
        int res = 1;
        if (arg0 % 2 == 0 && arg1 % 2 == 0) {
            res =  arg0 - arg1; 
        } else if (arg0 % 2 != 0 && arg1 % 2 != 0) {
            res =  arg1 - arg0;  
        } else if (arg1 % 2 == 0) {
            res = 1;
        } else {
            res = -1;
        }
        return res;
    }

}
