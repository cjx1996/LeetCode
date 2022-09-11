package Interviews;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Demo
 * @Description
 * @Author cjx
 * @Date 2022/9/6 19:35
 * @Version 1.0
 */
interface Subject{
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver(Message message);
}
interface Observer{
    void update(Message message);
}
class Message{
    private int fire=0;
    public int getFire(){
        return fire;
    }

    public void setFire(int fire) {
        this.fire = fire;
    }

    public Message(int fire) {
        this.fire = fire;
    }
}
class ConcreteSubject implements Subject{
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(Message message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    private List<Observer> observers=new ArrayList<>();
}
class ConcreteObserverOne implements Observer{

    @Override
    public void update(Message message) {
        if(message.getFire()==1){
            System.out.println("1楼灭火");
        }
    }
}
class ConcreteObserverTwo implements Observer{

    @Override
    public void update(Message message) {
        if(message.getFire()==2){
            System.out.println("2楼灭火");
        }
    }
}
class ConcreteObserverThree implements Observer{

    @Override
    public void update(Message message) {
        if(message.getFire()==3){
            System.out.println("3楼灭火");
        }
    }
}
public class Demo {
    public static void main(String[] args) {
        ConcreteSubject subject=new ConcreteSubject();
        subject.registerObserver(new ConcreteObserverOne());
        subject.registerObserver(new ConcreteObserverTwo());
        subject.registerObserver(new ConcreteObserverThree());
        int fire=0;
        Scanner in=new Scanner(System.in);
        while(true){
            fire=in.nextInt();
            if(fire!=0){
                subject.notifyObserver(new Message(fire));
            }
        }
    }
}
