import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import java.io.*;
import java.util.ArrayList;



// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("Json");
        serializedSimple();
        deserializedSimple();
    }

    static void serializedSimple() {
        Todo losdias = new Todo("Walk the dog", false, 0,3,"dog");
        Todo lasemanas = new Todo("Pay the Bills",true, 1,1, "bills");
        ArrayList<Todo>todoList = new ArrayList<>();
        todoList.add(losdias);
        todoList.add(lasemanas);
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("data.json")){
            gson.toJson(todoList,writer);
            System.out.println(todoList);
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }

    static void deserializedSimple(){
        try (FileReader reader = new FileReader("data.json")){
            JsonParser parser = new JsonParser();
            JsonElement jsonElement = parser.parse(reader);
            Gson gson = new Gson();
            Type type = new TypeToken<ArrayList<Todo>>(){}.getType();
            ArrayList<Todo>losdias = gson.fromJson(jsonElement, type);
            System.out.println(losdias);
            String value = losdias.get(0).getName();
            System.out.println(value);
            losdias.get(0).setName(("Walk the Fish"));
            System.out.println(losdias);
           // System.out.println(losdias.remove(0));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class Simple{
    private String name;
    private String email;
    private int age;
    private boolean isDevolper;

    public Simple(String name, String email, int age, boolean isDevolper) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.isDevolper = isDevolper;
    }

    @Override
    public String toString() {
        return "Simple{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", isDevolper=" + isDevolper +
                '}';
    }
}

class Todo {
    private String name;
    private boolean isDone;
    private int id;
    private int priority;
    private String title;

    public Todo(String name, boolean isDone, int id, int priority, String title) {
        this.name = name;
        this.isDone = isDone;
        this.id = id;
        this.priority = priority;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        this.name = name;
        return false;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "name='" + name + '\'' +
                ", isDone=" + isDone +
                ", id=" + id +
                ", priority=" + priority +
                ", title='" + title + '\'' +
                '}';
    }
}