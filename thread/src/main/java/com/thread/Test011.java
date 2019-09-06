package com.thread;

/**
 * threadLocal表示的是线程的局部变量，
 * 它确保每个线程都是独立的。
 *
 * 确保在同一个线程的任务地方传递
 *
 * 切记，在线程执行结束时，需要将参数值，移除。
 *
 */

class User{
    private String name;
    private int level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public User(String name, int level) {
        this.name = name;
        this.level = level;
    }
}
class UserContext implements AutoCloseable{

    //定义一个静态变量
    private static final ThreadLocal<User> context=new ThreadLocal<>();

    //  初始化赋值
    public UserContext(User user) {
        context.set(user);
    }

    //获取一个user对象
    public static User getCurrentUser(){
        return context.get();
    }
    //移除关联的对象
    @Override
    public void close() throws Exception {
        context.remove();
    }
}

class ThreadProcess extends Thread{
    private User user;

    public ThreadProcess(User user) {
        this.user = user;
    }

    public void run(){
        try {
            try(UserContext ctx=new UserContext(user)){
                new Greeting().hello();
                Levels.checkLevel();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Greeting{
    public void hello(){
        User user= UserContext.getCurrentUser();
        System.out.println("hello : "+user.getName());
    }
}

class Levels{
    public static void checkLevel(){
        User user=UserContext.getCurrentUser();
        if (user.getLevel()<100){
            System.out.println(user.getName()+"is a VIP ");
        }else {
            System.out.println(user.getName()+"is a register ");
        }
    }
}

public class Test011 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1=new ThreadProcess(new User("Tom",111));
        Thread t2=new ThreadProcess(new User("Jerry",111));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("END");
    }
}
