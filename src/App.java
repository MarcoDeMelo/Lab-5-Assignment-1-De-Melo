import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File; // Add file, fileReader and ArrayList Imports.
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException; 
import java.util.HashMap;
import java.util.Collections; 
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        ArrayList<String> words = readWords("C:/Users/16476/Desktop/Sc/Semester 4/Java/Lab 5 Assignment 1 De Melo/res/words.txt"); // STEP 4
        
        //Step 14
        ArrayList<String> word2 = readWords2("C:/Users/16476/Desktop/Sc/Semester 4/Java/Lab 5 Assignment 1 De Melo/res/paragraph.txt");
        
        HashMap<String, Integer> wordCounter = buildHashMap(words); //Step 5

        HashMap<String, Integer> wordCounter2 = buildHashMap(word2);

        createHTMLFile(wordCounter);//Step 6 Html

        
        createHTMLFile2(wordCounter);


        createHTMLFile3(wordCounter2);

        createHTMLFile4(wordCounter2);
       
    }

    //Step 4 Read input file
    private static ArrayList<String> readWords(String fileName)
    {
        File file = new File(fileName);
        ArrayList<String> wordList = new ArrayList<>();
        
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line = bufferedReader.readLine();
            while(line != null)
            {
                String[] words = line.split("[ .,]+");
                for(String word: words)
                {
                    if(word.trim().length() > 0)
                    {
                        wordList.add(word.toLowerCase());
                    }


                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            

        } catch (FileNotFoundException e) {

            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return wordList;
    }

    //Step 14 private static ArrayList<String> readWords(String fileName)
    private static ArrayList<String> readWords2(String fileName2)
    {
        File file = new File(fileName2);
        ArrayList<String> wordList = new ArrayList<>();
        
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line = bufferedReader.readLine();
            while(line != null)
            {
                String[] words = line.split("[ .,]+");
                for(String word: words)
                {
                    if(word.trim().length() > 0)
                    {
                        wordList.add(word.toLowerCase());
                    }


                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            

        } catch (FileNotFoundException e) {

            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return wordList;
    }
//Step 5: Counting words Occurences 
    private static HashMap<String, Integer> buildHashMap(ArrayList<String> words)
    {
      HashMap<String, Integer> wordCounter = new HashMap<>();
      for (String word: words)
      {
        Integer count = wordCounter.get(word);
        if(count == null)
        {
            wordCounter.put(word, 1);
        }
        else 
        {
            wordCounter.put(word, count +1);
        }
      }
      return wordCounter;
    }

    
    //Step 6: Create output
    private static void createHTMLFile(HashMap<String, Integer> wordCounter)
    {
        File file = new File("C:/Users/16476/Desktop/Sc/Semester 4/Java/Lab 5 Assignment 1 De Melo/res/words.html");

        try {
            FileWriter fileWriter = new FileWriter(file);
            StringBuilder builder = new StringBuilder();
            builder.append("<h1>Word Count</h1>");

            builder.append("<table>");
            for(String key: wordCounter.keySet())
            {
                final String css = "<style>"
                            + " td, th { border: solid} "
                            + " table, td, th { border=collapse: collapse}"
                            + " table {border: #1E90FF}"
                            + "</style>" ;
            builder.append(css).append("\n");
                builder.append("<tr>");
                builder.append("<td>"+ key + "</td>");
                builder.append("<td>"+ wordCounter.get(key) + "</td>");
                builder.append("</tr>");
            }
            builder.append("</table>");

            fileWriter.append(builder.toString());
            fileWriter.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //Step 10 createHTML is used to get the hasmap into a arraylist so that we can collection.sort it for ascending order.
        private static void createHTMLFile2(HashMap<String, Integer> wordCounter)
        {

            ArrayList<WordFrequency> wordFrequencyList = new ArrayList<>();

        for (String word : wordCounter.keySet()) {
            int frequency = wordCounter.get(word);
            WordFrequency wordFrequency = new WordFrequency(word, frequency);
            wordFrequencyList.add(wordFrequency);
        }
        Collections.sort(wordFrequencyList);
        
       

       
            File file2 = new File("C:/Users/16476/Desktop/Sc/Semester 4/Java/Lab 5 Assignment 1 De Melo/res/sorted.html");
            try {
                
                FileWriter fileWriter = new FileWriter(file2);
                StringBuilder builder = new StringBuilder();
                builder.append("<h1>Word Count</h1>");

        builder.append("<table>");
        final String css = "<style>"
                    + " td, th { border: solid} "
                    + " table, td, th { border-collapse: collapse}"
                    + " table {border: #1E90FF}"
                    + "</style>" ;  
        builder.append(css).append("\n");
        builder.append("<tr><th>Word</th><th>Count</th></tr>");
        for (WordFrequency wordFrequency : wordFrequencyList) {
            builder.append("<tr>");
            builder.append("<td>"+ wordFrequency.getWord() + "</td>");
            builder.append("<td>"+ wordFrequency.getWordCount() + "</td>");
            builder.append("</tr>");
        }
        builder.append("</table>");

        fileWriter.append(builder.toString());
        fileWriter.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
}
    
//Step 16
private static void createHTMLFile3(HashMap<String, Integer> wordCounter2)
        {
            File file = new File("C:/Users/16476/Desktop/Sc/Semester 4/Java/Lab 5 Assignment 1 De Melo/res/paragraph.html");

            try {
                FileWriter fileWriter = new FileWriter(file);
                StringBuilder builder = new StringBuilder();
                builder.append("<h1>Word Count</h1>");
    
                builder.append("<table>");
                for(String key: wordCounter2.keySet())
                {
                    final String css = "<style>"
                                + " td, th { border: solid} "
                                + " table, td, th { border=collapse: collapse}"
                                + " table {border: #1E90FF}"
                                + "</style>" ;
                builder.append(css).append("\n");
                    builder.append("<tr>");
                    builder.append("<td>"+ key + "</td>");
                    builder.append("<td>"+ wordCounter2.get(key) + "</td>");
                    builder.append("</tr>");
                }
                builder.append("</table>");
    
                fileWriter.append(builder.toString());
                fileWriter.close();
    
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
}

private static void createHTMLFile4(HashMap<String, Integer> paragraphFrequencie)
        {

            ArrayList<ParagraphFrequency> paragraphFrequencyList = new ArrayList<>();

        for (String paragraph : paragraphFrequencie.keySet()) {
            int frequency = paragraphFrequencie.get(paragraph);
            ParagraphFrequency paragraphFrequency = new ParagraphFrequency(paragraph, frequency);
            paragraphFrequencyList.add(paragraphFrequency);
        }
        Collections.sort(paragraphFrequencyList);
       
            File file2 = new File("C:/Users/16476/Desktop/Sc/Semester 4/Java/Lab 5 Assignment 1 De Melo/res/sortedParagraphWords.html");
            try {
                
                FileWriter fileWriter = new FileWriter(file2);
                StringBuilder builder = new StringBuilder();
                builder.append("<h1>Word Count</h1>");

        builder.append("<table>");
        final String css = "<style>"
                    + " td, th { border: solid} "
                    + " table, td, th { border-collapse: collapse}"
                    + " table {border: #1E90FF}"
                    + "</style>" ;  
        builder.append(css).append("\n");
        builder.append("<tr><th>Word</th><th>Count</th></tr>");
        for (ParagraphFrequency paragraphFrequency : paragraphFrequencyList) {
            builder.append("<tr>");
            builder.append("<td>"+ paragraphFrequency.getParagraph() + "</td>");
            builder.append("<td>"+ paragraphFrequency.getParagraphCount() + "</td>");
            builder.append("</tr>");
        }
        builder.append("</table>");

        fileWriter.append(builder.toString());
        fileWriter.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
}
// to see it in console.
    /* 
        for (String keyWord: wordCounter.keySet())
        {
            System.out.println(keyWord + ". " + wordCounter.get(keyWord));
        }
        */
    }




