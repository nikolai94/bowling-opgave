import entities.Frame;

public class Calculate {

    private Frame[] frames;
    private int totalScore;
    private int fullPoints = 10;
    private int maxScore = 300;


    public Calculate(Frame[] frames) {
        this.frames = frames;
        this.totalScore = 0;
    }

    public int[] calculateSum(){
        int tmpSum;
        for(int i = 0; i < frames.length; i++){
            tmpSum = 0;

            if(isStrike(frames[i])) tmpSum = calcSumStrike(i);

            else if(isSpare(frames[i])) tmpSum = calcSumSpare(i);

            //else not full points, and therefore no bonus
            else tmpSum = (frames[i].getFirstRoll() + frames[i].getSecondRoll());


            totalScore += tmpSum;
            frames[i].setSum(totalScore);

            if(totalScore == maxScore) return createIntArrForSums(i+1);

        }

        return createIntArrForSums(frames.length);
    }

    private int[] createIntArrForSums(int arrayLength){
        int[] sumArr = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++){
            sumArr[i] = frames[i].getSum();
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

            //Take points from next frame = index+1
            firstRoll = frames[index+1].getFirstRoll();
            //check if this is not a strike.
            if(firstRoll != 10) secondRoll = frames[index+1].getSecondRoll();
            else{
                //check that this index is not the last index
                if(frames.length > (index + 2)) secondRoll = frames[index+2].getFirstRoll();
                else secondRoll = frames[index+1].getSecondRoll();
            }
            sum = frames[index].getFirstRoll();
            sum += (firstRoll + secondRoll);
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
