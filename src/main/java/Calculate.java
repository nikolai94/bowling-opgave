import entities.Frame;

public class Calculate {

    private Frame[] frames;
    private int totalScore;
    private int fullPoints = 10;


    public Calculate(Frame[] frames) {
        this.frames = frames;
        this.totalScore = 0;
    }
    
    public int[] calculateSum(){

        for(int i = 0; i < frames.length; i++){
            int tmpSum = 0;

            if(isStrike(frames[i])) tmpSum = calcSumStrike(i);

            else if(isSpare(frames[i])) tmpSum = calcSumSpare(i);

            //else not full points, and therefore no bonus
            else tmpSum = (frames[i].getFirstRoll() + frames[i].getSecondRoll());


            totalScore += tmpSum;
            frames[i].setSum(totalScore);
        }

        return createIntArrForSums();
    }

    private int[] createIntArrForSums(){
        int countFrameArr = frames.length;
        int[] sumArr = new int[countFrameArr];
        int count = 0;

        for(Frame f : frames){
            sumArr[count] = f.getSum();
            count++;
        }
        return sumArr;
    }

    //returns sum
    private int calcSumStrike(int index){

        //check that in not last row in array
        if(frames.length != (index+1)){
            int sum;
            int firstRoll = 0;
            int secondRoll = 0;

            firstRoll = frames[index+1].getFirstRoll();
            //check if this is a strike
            if(firstRoll != 10) secondRoll = frames[index+1].getSecondRoll();
            else{
                //check that this index is not the last index
                if(frames.length > (index + 2)) secondRoll = frames[index+2].getFirstRoll();
            }
            sum = frames[index].getFirstRoll();
            sum += (firstRoll + secondRoll);
            //System.out.println("Index: "+ index + " ::: Sum"+ sum);
            return sum;
        }

        //if last row in array no bonus
        return (frames[index].getFirstRoll() + frames[index].getSecondRoll());
    }

    private int calcSumSpare(int index){
        //check that in not last row in array
        if(frames.length != (index+1)){
            int sum;
            sum = (frames[index].getFirstRoll() + frames[index].getSecondRoll());
            sum += frames[index+1].getFirstRoll();
            return sum;
        }

        //if last row in array no bonus
        return (frames[index].getFirstRoll() + frames[index].getSecondRoll());
    }

    //Returns true if strike
    private boolean isStrike(Frame frame){
        if(frame.getFirstRoll() == fullPoints) return true;

        return false;
    }

    // returns true if spare
    private boolean isSpare(Frame frame){
        if(frame.getFirstRoll() == fullPoints) return false;
        else if((frame.getFirstRoll() + frame.getSecondRoll()) == fullPoints ) return true;

        return false;
    }



}
