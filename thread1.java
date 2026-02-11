class thread1 extends Thread {
    private final String paragraph;
    private final String word;
    public thread1(String paragraph, String word) {
        this.paragraph = paragraph;
        this.word = word;
    }
    public void run() {
        int count = countWord(paragraph, word);
        if (count == 0) {
            System.out.println("The word \"" + word + "\" does not exist in the text.");
        } else {
            System.out.println("The word \"" + word + "\" appears " + count + " times.");
        }
    }
    private int countWord(String paragraph, String word) {
        int count = 0;
        int index = 0;
        while ((index = paragraph.indexOf(word, index)) != -1) {
            count++;
            index += word.length();
        }
        return count;
    }
}
