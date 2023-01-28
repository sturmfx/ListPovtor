package com.company;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main
{

    public static void main(String[] args) throws IOException
    {
        String file ="D:\\AnnaAlievaTest\\ListPovtor\\src\\example_text.txt";
        Otchet(readFile(file));

    }

    public static String readFile(String filePath) throws IOException
    {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(filePath)));
        return data;
    }

    public static List<String> getWords(String text)
    {
        String filtered_text = text;
        String filter = ".,!?\n";
        for(char c : filter.toCharArray())
        {
            filtered_text = filtered_text.replace(String.valueOf(c), "");
        }
        filtered_text = filtered_text.toLowerCase();
        List<String> words = Arrays.asList(filtered_text.split(" "));
        return words;
    }

    public static void Otchet(String text)
    {
        int number_of_chars = text.length();
        List<String> words = getWords(text);
        int number_of_words = words.size();

        ArrayList<String> unique_list = new ArrayList<>();
        ArrayList<Integer> frequency_list = new ArrayList<>();
        for(String word : words)
        {
            if(unique_list.contains(word))
            {

            }
            else
            {
                unique_list.add(word);
            }
        }

        for(String unique_word : unique_list)
        {
            int count = 0;
            count = (int) words.stream().filter(word -> unique_word.equals(word)).count();
            frequency_list.add(count);
        }


        System.out.println("Text has " + number_of_words + " words and " + number_of_chars + " characters.");
        System.out.println("Text has " + unique_list.size() + " unique words.");

        for(int i = 0; i < unique_list.size(); i++)
        {
            System.out.println(unique_list.get(i) + " - " + frequency_list.get(i));
        }
    }
}
