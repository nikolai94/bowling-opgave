import entities.Frame;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import test.TestDTO;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CalculateTest {

    private Frame[] frames;
    private int[] expectedResult;
    private Calculate calculate;


    public CalculateTest(TestDTO testDTO){
        this.frames = testDTO.getFrames();
        this.expectedResult = testDTO.getExpectedResult();

        calculate = new Calculate(this.frames);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {testCase1()},
                {testCase2()},
                {testCase3()},
                {testCase4()},
                {testCase5()} });
        //return Arrays.asList(new Object[][]{{testCase5()}  });
    }

    @Test
    public void testCalculationOnMockData(){
        Assert.assertArrayEquals(expectedResult, calculate.calculateSum());
    }

    private static TestDTO testCase1(){
        Frame[] frames = new Frame[10];
        frames[0] = new Frame(1, 6);
        frames[1] = new Frame(1, 7);
        frames[2] = new Frame(10, 0); //Strike
        frames[3] = new Frame(9, 1); //Spare
        frames[4] = new Frame(1, 5);
        frames[5] = new Frame(3, 5);
        frames[6] = new Frame(5, 4);
        frames[7] = new Frame(3, 6);
        frames[8] = new Frame(7, 0);
        frames[9] = new Frame(3, 1);

        int result[] = new int[]{7, 15, 35, 46, 52, 60, 69, 78, 85, 89};

        TestDTO testDTO = new TestDTO(frames, result);
        return testDTO;
    }

    //Both Strike and Spare
    private static TestDTO testCase2(){
        Frame[] frames = new Frame[10];
        frames[0] = new Frame(4, 4);
        frames[1] = new Frame(10, 0); //Strike
        frames[2] = new Frame(4, 2);
        frames[3] = new Frame(1, 6);
        frames[4] = new Frame(10, 0); //Strike
        frames[5] = new Frame(4, 5);
        frames[6] = new Frame(1, 9); //Spare
        frames[7] = new Frame(8, 0);
        frames[8] = new Frame(1, 3);
        frames[9] = new Frame(5, 2);

        int result[] = new int[]{8, 24, 30, 37, 56, 65, 83, 91, 95, 102};

        TestDTO testDTO = new TestDTO(frames, result);
        return testDTO;
    }

    //Several Spares and no Strikes
    private static TestDTO testCase3(){
        Frame[] frames = new Frame[8];
        frames[0] = new Frame(2, 8); //Spare
        frames[1] = new Frame(2, 0);
        frames[2] = new Frame(4, 6); //Spare
        frames[3] = new Frame(2, 2);
        frames[4] = new Frame(1, 5);
        frames[5] = new Frame(9, 1); //Spare
        frames[6] = new Frame(8, 2); //Spare
        frames[7] = new Frame(7, 3); //Spare

        int result[] = new int[]{12, 14, 26, 30, 36, 54, 71, 81};

        TestDTO testDTO = new TestDTO(frames, result);
        return testDTO;
    }

    //Both Strike and Spare
    private static TestDTO testCase4(){
        Frame[] frames = new Frame[8];
        frames[0] = new Frame(3, 1);
        frames[1] = new Frame(5, 5); //Spare
        frames[2] = new Frame(2, 7);
        frames[3] = new Frame(4, 4);
        frames[4] = new Frame(1, 8);
        frames[5] = new Frame(10, 0); //Strike
        frames[6] = new Frame(9, 1); //Spare
        frames[7] = new Frame(3, 6);

        int result[] = new int[]{4,16,25,33,42,62,75,84};

        TestDTO testDTO = new TestDTO(frames, result);
        return testDTO;
    }

    //Only Strikes - test for max points 300
    private static TestDTO testCase5(){
        Frame[] frames = new Frame[11];
        frames[0] = new Frame(10, 0);
        frames[1] = new Frame(10, 0);
        frames[2] = new Frame(10, 0);
        frames[3] = new Frame(10, 0);
        frames[4] = new Frame(10, 0);
        frames[5] = new Frame(10, 0);
        frames[6] = new Frame(10, 0);
        frames[7] = new Frame(10, 0);
        frames[8] = new Frame(10, 0);
        frames[9] = new Frame(10, 0);
        frames[10] = new Frame(10, 10);

        int result[] = new int[]{30, 60, 90, 120, 150, 180, 210, 240, 270, 300};

        TestDTO testDTO = new TestDTO(frames, result);
        return testDTO;
    }



}