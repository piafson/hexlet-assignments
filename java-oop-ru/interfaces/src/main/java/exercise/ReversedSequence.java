package exercise;

public class ReversedSequence implements CharSequence {
    private CharSequence input;

    public ReversedSequence(CharSequence input) {
        this.input = input;
    }

    @Override
    public int length() {
        return input.length();
    }

    @Override
    public char charAt(int index) {
        return input.charAt(input.length() - index - 1);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        int inputEnd = input.length() - start;
        int inputBegin = input.length() - end;
        return new ReversedSequence(input.subSequence(inputBegin, inputEnd));
    }

    public String toString()
    {
        return new StringBuilder(this).toString();
    }
}
