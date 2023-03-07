public class ParagraphFrequency implements Comparable<ParagraphFrequency>{
    Integer paragraphCount;
    String paragraph;

    //Constructer 
    public ParagraphFrequency(String paragraph, Integer paragraphCount)
    {
        this.paragraph = paragraph;
        this.paragraphCount = paragraphCount;
    }

    public String getParagraph()
    {
        return paragraph;
    }
    
    public Integer getParagraphCount()
    {
        return paragraphCount;
    }

    @Override
    public String toString()
    {
        return "paragraphFrequency [paragraph = " + paragraph + " paragraph frequency = " + paragraphCount + " ] ";
    }

    @Override
    public int compareTo(ParagraphFrequency otherParagraphCount)
    {
        int comparedParagraphCount = 0;
        if(this.paragraphCount > otherParagraphCount.paragraphCount)
        {
            comparedParagraphCount = 1;
        }

        if(this.paragraphCount < otherParagraphCount.paragraphCount)
        {
            comparedParagraphCount = -1;
        }

        if(this.paragraphCount == otherParagraphCount.paragraphCount)
        {
            comparedParagraphCount = 0;
        }
        return comparedParagraphCount;
        
    }
}