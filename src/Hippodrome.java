import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
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
        Horse johny = new Horse("Johny", 3.3, 0);
        Horse marko = new Horse("Marko", 2.7, 0);
        Horse diablo = new Horse("Diablo", 3.5, 0);
        game.getHorses().add(johny);
        game.getHorses().add(marko);
        game.getHorses().add(diablo);

        Horse bet = game.makeBet();
        game.run();
        game.printWinner();
        if(bet.getName().equals(game.getWinner().getName()))
            System.out.println(String.format("Congratulations! Your win is %.2f$", bet.getBet()*6/bet.getSpeed()));
        else
            System.out.println("You lost. Better luck next time!");
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

    public Horse makeBet()throws Exception
    {
        Horse ret = null;
        int bet = 0;
        try(BufferedReader r = new BufferedReader(new InputStreamReader(System.in)))
        {
            System.out.println("Take a sit and make a bet!\n" +
                    "How much would you like to bet?(Just write a number, no currency signs or other text)");
            boolean trueInitBet = true;
            while(trueInitBet)
            {
                try
                {
                    bet = Integer.parseInt(r.readLine());
                    trueInitBet = false;
                }
                catch(RuntimeException e)
                {
                    System.out.println("Wrong input, please, try again.");
                }
            }
            System.out.println("On which horse would you like to bet? There are:");
            for(Horse h : game.getHorses())
            {
                System.out.println(h.getName());
            }
            boolean trueInitHorse = true;
            while(trueInitHorse)
            {
                String horseName = r.readLine();
                for(Horse h : game.getHorses())
                {
                    if(horseName.equalsIgnoreCase(h.getName())) {
                        ret = h;
                        trueInitHorse = false;
                        break;
                    }
                }
                if(ret==null)
                    System.out.println("You entered wrong name, please, try again");
            }
            ret.setBet(bet);
        }
        return ret;
    }
}
