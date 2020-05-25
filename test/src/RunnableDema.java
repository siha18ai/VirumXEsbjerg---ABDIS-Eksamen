class RunnableDema implements Runnable {
    private Thread t;
    private String threadName;

    RunnableDema (String threadName){
        this.threadName = threadName;
        System.out.println("Creating " + threadName);
    }

    public void run(){
        System.out.println("Running" + threadName);
            for(int i = 4; i > 0; i--){
                System.out.println("Thread" + threadName + ", " + i);
            }
        System.out.println("Thread " + threadName + " exiting");
    }
    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
        System.out.println("OGås mig");
    }
}
class TestThread{
    public static void main(String args[]){
        RunnableDema R1 = new RunnableDema("Thread-1");
        R1.start();

        RunnableDema R2 = new RunnableDema("Thread-2");
        R2.start();
    }
}