import Interfaces.GetRequests;
import Interfaces.IMyLogger;
import Interfaces.PostRequests;
import entities.Frame;
import entities.Game;
import rest.GetList;
import rest.PostList;

import java.util.Arrays;

public class Facade {
    private String url;
    private GetRequests getList;
    private PostRequests postList;
    private IMyLogger myLogger;

    public Facade(GetRequests getList, PostRequests postList, String url, IMyLogger myLogger) {
        this.getList = getList;
        this.postList = postList;
        this.url = url;
        this.myLogger = myLogger;
    }

    public Facade(IMyLogger myLogger) {
        this.myLogger = myLogger;
        this.getList = new GetList(this.myLogger);
        this.postList = new PostList(this.myLogger);
        //for testing
        //this.url = "http://192.168.33.22/skat?get";
        this.url = "http://13.74.31.101/api/points";
    }

    public void calcBowlingScore(){
        //Get request
        Game game = getGame();
        System.out.println("Game: " + game.toString());

        //calc score
        int[] resultScore = calcScore(game.getFrames());
        System.out.println("Check this sum: " + Arrays.toString(resultScore));
        myLogger.writeToLogFile("Check this sum: " + Arrays.toString(resultScore));

        //Post request - check calc score
        boolean result = postResult(game.getToken(), resultScore);
        System.out.println("From api - Success: " + result);

    }

    private Game getGame(){
        return getList.GetBowlingPointsList(url);
    }

    private int[] calcScore(Frame[] frames ){
        Calculate calculate = new Calculate(frames);
        return calculate.calculateSum();
    }

    private boolean postResult(String token, int[] result){
        //TODO change url:
        // Test url http://192.168.33.22/skat/index.php?post
        return postList.validateBowlingSum(token, result, url);
    }

}
