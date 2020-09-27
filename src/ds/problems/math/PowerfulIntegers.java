package ds.problems.math;
//https://leetcode.com/problems/powerful-integers/
//970. Powerful Integers

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerfulIntegers {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> p = new HashSet<Integer>();
        for( int i=1; i<bound; i*=x>1?x:bound )
            for( int j=1; i+j<=bound; j*=y>1?y:bound )
                p.add( i+j );
        return new ArrayList<Integer>( p );
    }
}
