package ru.stqa.pft.sandbox;

/**
 * Created by Анастасия Цыбулько on 26.05.2017.
 */
public class Woman {

    double tits;
    double high;
    boolean ugly;
    String name;

    public void kiss (Woman w) {
        System.out.println("Чмок! " + this.name + " поцеловала " + w.name);
    }
}
