/**
 * Created by Дмитрий Гринец on 27.02.2016.
 */
public class Horse
{
    private String name;
    private double speed;
    private double distance;

    public Horse(String name, double speed, double distance)
    {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName()
    {
        return name;
    }

    public double getSpeed()
    {
        return speed;
    }

    public double getDistance()
    {
        return distance;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }

    public void move(){
        distance += Math.random()*getSpeed();
    }

    public void print(){
        for(int i = 0; i < Math.round(getDistance()); i++)
        {
            System.out.print(".");
        }
        System.out.println(getName());
    }
}