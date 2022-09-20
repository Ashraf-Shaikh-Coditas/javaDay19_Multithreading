package Week5.Day19;

//3)WRITE A PROGRAM OF 3THREAD OBJECTS USING Runnable INTERFACE
//TRY TO ACCESS ALL THE METHODS OF Thread CLASS.
public class QuestionThree implements Runnable {

    @Override
    public void run() {
        for(int i =0 ; i< 3 ; i++) {
            System.out.println(Thread.currentThread());

        }
    }

    public static void main(String[] args) throws InterruptedException {
        QuestionThree m1 = new QuestionThree();
        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m1);
        Thread t3 = new Thread(m1);

        t1.setName("A");
        t2.setName("B");
        t3.setName("C");

//        t1.start();
        t1.run();
        t1.join();
        t2.start();
//        t2.run();
        t3.start();




        System.out.println(t1.getState());
        System.out.println(t2.getState());
        System.out.println(t3.getState());

        System.out.println(t1.getName());
        System.out.println(t2.getName());
        System.out.println(t3.getName());

        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        System.out.println(t3.getPriority());

        System.out.println(t1.isDaemon());
        System.out.println(t2.isDaemon());
        System.out.println(t3.isDaemon());

        t1.setPriority(10);
        System.out.println(t1.getPriority());

    }


}
