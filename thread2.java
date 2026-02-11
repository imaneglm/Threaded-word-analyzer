class thread2 extends Thread {
    private final String paragraph;
    private final String word;
    public thread2(String paragraph, String word) {
        this.paragraph = paragraph;
        this.word = word;
    }
    public void run() {
        String[] lines = paragraph.split("\n");
        StringBuilder linesWithWord = new StringBuilder();
        boolean wordFound = false;
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].contains(word)) {
                wordFound = true;
                linesWithWord.append("Line ").append(i + 1).append(": ").append(lines[i]).append("\n");
            }
        }
        if (!wordFound) {
            System.out.println("The word \"" + word + "\" does not exist in the text.");
        } else {
            System.out.println("The word \"" + word + "\" appears in the following lines:");
            System.out.println(linesWithWord);
        }
    }
}
