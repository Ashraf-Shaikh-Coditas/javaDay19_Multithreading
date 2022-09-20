package Week5.Day19;

public class PrintOdd implements Runnable{
    void printOdd(int bound) throws InterruptedException {
        boolean flag = false;
        int i = 0 ;
        while(i<=bound) {
            if(!flag) {
                flag = true;
                i++;

            } else {
                System.out.println(i);
                flag = false;
                i++;
            }
        }

    }

    public static void main(String[] args) {

        PrintOdd printOdd = new PrintOdd();
        Thread t1 = new Thread(printOdd);
        t1.start();
    }

    @Override
    public void run() {
        PrintOdd p = new PrintOdd();
        try {
            p.printOdd(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

/*

1
3
5
7
9
11
13
15
17
19


* */