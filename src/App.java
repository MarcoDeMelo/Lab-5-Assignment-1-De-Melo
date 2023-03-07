import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File; // Add file, fileReader and ArrayList Imports.
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException; 
import java.util.HashMap;
import java.util.Collection;
import java.util.Collections; 
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        ArrayList<String> words = readWords("C:/Users/16476/Desktop/Sc/Semester 4/Java/Lab 5 Assignment 1 De Melo/res/words.txt"); // STEP 4
        HashMap<String, Integer> wordCounter = buildHashMap(words); //Step 5
        createHTMLFile(wordCounter);//Step 6 Html

        HashMap<String, Integer> wordFrequencies = buildHashMap(words);

        ArrayList<WordFrequency> wordFrequencyList = new ArrayList<>();

        for (String word : wordFrequencies.keySet()) {
            int frequency = wordFrequencies.get(word);
            WordFrequency wordFrequency = new WordFrequency(word, frequency);
            wordFrequencyList.add(wordFrequency);
        }

        Collections.sort(wordFrequencyList);
        for (WordFrequency wordFrequency : wordFrequencyList) {
            System.out.println(wordFrequency.getWord() + " : " + wordFrequency.getWordCount());
        }
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
// to see it in console.
    /* 
        for (String keyWord: wordCounter.keySet())
        {
            System.out.println(keyWord + ". " + wordCounter.get(keyWord));
        }
        */
    }

}


