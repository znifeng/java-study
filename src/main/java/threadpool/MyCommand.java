package threadpool;

public class MyCommand implements  Runnable{
    private String name;
    public MyCommand(){super();}
    public MyCommand(String name){
        super();
        this.name = name;
    }
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " with mycommand name " + name + " is running.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
