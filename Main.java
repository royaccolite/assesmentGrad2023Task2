// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {
        Monster father= new Monster("brown","blue","Invisibility",80,92,70,20,86);
        Monster mother= new Monster("blue","yellow","Flying",70,68,65,40,64);

        ArrayList<Monster> inheritList= new ArrayList<>();
        ArrayList<Monster> childList= new ArrayList<>();

        inheritList.add(father);
        inheritList.add(mother);

//        Monster child= Monster.createRandomClass(father,mother);
//        System.out.println(child.toString());

        HashSet<String> uniqe= new HashSet<>();

        for(int i=0;i<100;i++){
            Monster children= Monster.createRandomClass(father,mother);
            if(!uniqe.contains(children.toString()))
                uniqe.add(children.toString());

        }
        int count=1;
        System.out.println("Parents Properties");
        for (Monster i: inheritList){
            System.out.println(i.toString());
        }
        System.out.println("Children Properties");

        for(String i:uniqe) {
            System.out.println("Child "+count+": "+i);
//            System.out.println("\n");
            count++;
        }

//        System.out.println(uniqe.size());

        try {
            FileWriter myWriter = new FileWriter("output.txt");
            myWriter.write("Parents Properties\n");

            for (Monster i: inheritList){
                myWriter.write(i.toString()+"\n");
            }
            int cnt=1;
            myWriter.write("Children Properties\n");

            for(String i:uniqe) {
                myWriter.write("Child "+cnt+": "+i+"\n");
                cnt++;
            }

            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }
}