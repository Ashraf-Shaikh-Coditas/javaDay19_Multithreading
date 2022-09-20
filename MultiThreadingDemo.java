package Week5.Day19;

public class MultiThreadingDemo extends Thread {

    public void run() {
        for(int i =0 ; i< 3 ; i++) {
            System.out.println(Thread.currentThread());

        }
    }

    public static void main(String[] args) throws InterruptedException {

        MultiThreadingDemo demo = new MultiThreadingDemo();
        MultiThreadingDemo demo1 = new MultiThreadingDemo();
        MultiThreadingDemo demo2 = new MultiThreadingDemo();


        demo.setName("Ashraf");
        demo.start();
        demo.join();
        demo1.setDaemon(true);

        demo1.setName("Aman");
        demo1.start();
//        demo1.run();

        demo2.setName("Praveer");
        demo2.start();
//        demo2.run();

        System.out.println(demo.getState());
        System.out.println(demo1.getState());
        System.out.println(demo2.getState());





    }
}
