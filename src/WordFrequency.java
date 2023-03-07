public class WordFrequency implements Comparable<WordFrequency>{
    Integer wordCount;
    String word;

    public WordFrequency(String word, Integer wordCount)
    {
        this.word = word;
        this.wordCount = wordCount;
    }

    @Override
    public String toString()
    {
        return "WordFrequency [Word = " + word + " Word frequency = " + wordCount + " ] ";
    }
    @Override
    public int compareTo(WordFrequency otherWordCount)
    {
        int comparedWordCount = 0;
        if(this.wordCount > otherWordCount.wordCount)
        {
            comparedWordCount = 1;
        }

        if(this.wordCount < otherWordCount.wordCount)
        {
            comparedWordCount = -1;
        }

        if(this.wordCount == otherWordCount.wordCount)
        {
            comparedWordCount = 0;
        }
        return comparedWordCount;
        
    }
}