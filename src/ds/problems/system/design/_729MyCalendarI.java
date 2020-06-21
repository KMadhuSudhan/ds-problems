package ds.problems.system.design;

//https://leetcode.com/problems/my-calendar-i/
//729. My Calendar I

import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

public class _729MyCalendarI {

    public static void main(String[] args) {
        _729MyCalendarI myCalendarI = new _729MyCalendarI();
        myCalendarI.book(10, 20); // returns true
        myCalendarI.book(15, 25); // returns false
        myCalendarI.book(20, 30); // returns true
        myCalendarI.book(40, 50);
        myCalendarI.book(20, 25);
        myCalendarI.book(10, 15);
        myCalendarI.book(30, 40);
    }

    TreeMap<Integer, Integer> map;
    public _729MyCalendarI() {
        map = new TreeMap<>();
    }

//    TreeSet<int[]> t;
//    public _729MyCalendarI() {
//        t = new TreeSet<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0]-o2[0];
//            }
//        });
//    }

//    public boolean book(int start, int end) {
//        int[] n = new int[]{start,end};
//        if(t.isEmpty()) {
//            t.add(n);
//            return true;
//        }
//        int[] f = t.floor(n);
//        int[] c = t.ceiling(n);
//        if((f==null || !isOverlap(f,n)) && (c==null || !isOverlap(n,c))) {
//            t.add(n);
//            return true;
//        }
//        return false;
//    }

    private boolean isOverlap(int[] s,int[] b) {
        return s[0]==b[0] || s[1]-1 >= b[0];
    }

    public boolean book(int start, int end) {
        Integer lowerKey = map.floorKey(start);
        Integer higherKey = map.ceilingKey(start);

        if(lowerKey!= null && map.get(lowerKey)> start){
            return false;
        }
        if(higherKey!=null && end > higherKey){
            return false;
        }

        map.put(start, end);

        return true;
    }

    /* tree solutioin class MyCalendar {
       treenode root;
          boolean flag;
        public MyCalendar() {
            root=null;
            flag=false;
        }

        public boolean book(int start, int end) {
            flag=false;
             root=add(root,start,end);
            return flag;
        }

        private treenode add(treenode root,int s, int e){
            if(root==null){
                flag=true;
                  return new treenode(s,e);
            }

            if(e<=root.start){
                root.left=add(root.left,s,e);

            }else if(root.end<=s){
                root.right=add(root.right,s,e);
            }

        return root;

        }

        class treenode{
            int start=0;
            int end=0;
            treenode left=null;
            treenode right=null;
            public treenode(int s,int e){
                start=s;
                end=e;
            }
        }
    } */
}
