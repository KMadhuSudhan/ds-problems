package ds.problems.test;

public class PrintNumbersAndChars {

    class CharsAndnumbers implements Runnable {
        Printer printer;
        private boolean isNumber;
        @Override
        public void run() {
            int num = 0;
            char character = 'a';
          while(num<=20) {
              if(isNumber) {
                  printer.printNumber(num);
                  num++;
              } else {
                  printer.printNumber(character);
                  character++;
              }
          }
        }
    }
    class Printer {
        private volatile  boolean isNumber;
        synchronized  void printNumber(int number) {
            while(!isNumber) {
                try {
                    wait();
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.print(Thread.currentThread().getName() + ":" + number);
            isNumber = false;
            notify();
        }

        synchronized  void printChars(Character character) {
            while(isNumber) {
                try {
                    wait();
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.print(Thread.currentThread().getName() + ":" + character);
            isNumber = true;
            notify();
        }
    }
    public static void main(String[] args) {
    }

}
