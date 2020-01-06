package DTO;

public class DTOPost {
    boolean success;
    int[] input;

    public DTOPost(boolean success, int[] input) {
        this.success = success;
        this.input = input;
    }

    public DTOPost() {
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int[] getInput() {
        return input;
    }

    public void setInput(int[] input) {
        this.input = input;
    }
}
