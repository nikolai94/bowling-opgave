import Interfaces.IMyLogger;
import entities.Frame;
import mylogger.MyLogger;

public class Main {
    public static void main(String[] args) {


        IMyLogger log = new MyLogger();

        Facade facade = new Facade(log);
        facade.calcBowlingScore();


        /*Frame[] frames = new Frame[10];
        frames[0] = new Frame(10, 0);
        frames[1] = new Frame(10, 0);
        frames[2] = new Frame(10, 0);
        frames[3] = new Frame(10, 0);
        frames[4] = new Frame(10, 0);
        frames[5] = new Frame(10, 0);
        frames[6] = new Frame(10, 0);
        frames[7] = new Frame(10, 0);
        frames[8] = new Frame(10, 0);
        frames[9] = new Frame(10, 0);*/

        Frame[] frames = new Frame[10];
        frames[0] = new Frame(1, 6);
        frames[1] = new Frame(1, 7);
        frames[2] = new Frame(10, 0);
        frames[3] = new Frame(9, 1);
        frames[4] = new Frame(1, 5);
        frames[5] = new Frame(3, 5);
        frames[6] = new Frame(5, 4);
        frames[7] = new Frame(3, 6);
        frames[8] = new Frame(7, 0);
        frames[9] = new Frame(3, 1);

        /*Calculate calculate = new Calculate(frames);
        int[] arr = calculate.calculateSum();
        Gson gson = new Gson();
        String jsonStr = gson.toJson(arr);
        System.out.println(jsonStr);*/





    }
}
