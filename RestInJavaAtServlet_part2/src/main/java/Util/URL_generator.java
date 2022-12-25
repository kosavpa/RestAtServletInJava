package Util;

import java.net.MalformedURLException;
import java.net.URL;

public class URL_generator {
    private static URL url;

    private URL_generator() {
    }

    public static URL deletePerson(){
        try {
            return url = new URL("http://localhost:8081/RestInJavaAtServlets_part1_war_exploded/delete");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static URL newPerson(){
        try {
            return url = new URL("http://localhost:8181/RestInJavaAtServlets_part1_war_exploded/new");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
    public static URL person(String pathVariables){
        try {
            return url = new URL("http://localhost:8081/RestInJavaAtServlets_part1_war_exploded/person?id=" + pathVariables);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static URL persons(){
        try {
            return url = new URL("http://localhost:8081/RestInJavaAtServlets_part1_war_exploded/persons");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static URL updatePerson(){
        try {
            return url = new URL("http://localhost:8081/RestInJavaAtServlets_part1_war_exploded/update");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
