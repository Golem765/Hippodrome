import java.util.ArrayList;

/**
 * Created by Дмитрий Гринец on 27.02.2016.
 *
 * This project is made by me, following guides of Javarush.ru, level 21 Big task 01
 */
public class Hippodrome
{
    public static ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;
    public static void main(String[] args)throws Exception
    {
        Hippodrome hip = new Hippodrome();
        game = hip;
        Horse johny = new Horse("Johny", 3, 0);
        Horse marko = new Horse("Marko", 3, 0);
        Horse diablo = new Horse("Diablo", 3, 0);
        game.getHorses().add(johny);
        game.getHorses().add(marko);
        game.getHorses().add(diablo);

        game.run();
        game.printWinner();
    }

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void run()throws InterruptedException{
        for(int i = 1; i <= 100; i++)
        {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void print(){
        for(Horse h : getHorses())
        {
            h.print();
            System.out.println();
        }
    }

    public void move(){
        for(Horse h : getHorses())
        {
            h.move();
        }
    }

    public Horse getWinner()
    {
        Horse max = new Horse("max", 0, 0);
        for(Horse h : getHorses())
        {
            if(h.getDistance() >= max.getDistance())
                max = h;
        }
        return max;
    }

    public void printWinner()
    {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
