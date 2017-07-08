package ru.stqa.pft.sandbox;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Анастасия Цыбулько on 05.07.2017.
 */
public class Collection {

   public static void main(String[] args) {
                String[] langs = new String[4];
                langs[0] = "Java";
                langs[1] = "C#";
                langs[2] = "Python";
                langs[3] = "PHP";

                List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");

               for(String l : languages) {
                 System.out.println("Язык программирования " + l + "!");
               }

              for(int i = 0; i < languages.size(); i++) {
                 System.out.println(languages.get(i));
             }
             }
 }

