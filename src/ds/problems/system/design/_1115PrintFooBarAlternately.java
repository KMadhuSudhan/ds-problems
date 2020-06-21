package ds.problems.system.design;
//https://leetcode.com/problems/print-foobar-alternately/
//1115. Print FooBar Alternately

public class _1115PrintFooBarAlternately {

    private int n;
    private volatile int t;

    public static void main(String[] args) {
        _1115PrintFooBarAlternately printFooBarAlternately = new _1115PrintFooBarAlternately(5);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("foo");
            }
        };

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("bar");
            }
        };
        try {
            printFooBarAlternately.foo(runnable);
            printFooBarAlternately.bar(runnable1);
        } catch (InterruptedException ie) {

        }
    }
    public _1115PrintFooBarAlternately(int n) {
        this.n = n;

    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while(t != 0){
                Thread.yield();
            }

            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            t = 1;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while(t != 1){
                Thread.yield();
            }

            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            t = 0;
        }
    }


}
