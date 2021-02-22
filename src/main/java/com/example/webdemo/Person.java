package com.example.webdemo;

public class Person {
    private PersonListener personListener;

    public void Eat(){
        personListener.doEat(new Event(this));
    }
    public void sleep(){
        personListener.doSleep(new Event(this));
    }
    public void registerLister (PersonListener personListener){
        this.personListener = personListener;
    }
}
