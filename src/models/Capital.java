/** This class is resposible for storing collection with capitals.
It reads capitals from a file and stores them with match countries in a HashMap*/
package models;
import operators.*;
import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.lang.*;

public class Capital {
    public TreeMap newmap;
    private String country;
    private String searchedCapital;

    public Capital() {
        this.searchedCapital = "";
        this.country = "";
    }
    public String getCountry() {
        return this.country;
    }
    public String getSearchedCapital () {
        return this.searchedCapital;
    }
    public void setSearchedCapital (String capital) {
        this.searchedCapital = capital;
    }
    public void setCountry(String capital) {
        this.country = capital;
    }

    public TreeMap createMap() {
        File file = new File("./resources/capitals.txt");
        BufferedReader reader = null;
        TreeMap<String, String> newmap = new TreeMap();
        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            while ((text = reader.readLine()) != null) {
                text = text.replace("|", ",");
                String[] list = text.split(" , ");

                newmap.put(list[0], list[1]);
            }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.print(e);
            }
        }
        //print out the list

        return newmap;
    }

    public String getRandomCountry(TreeMap map, Integer level) {
        Random gen = new Random();
        Set<String> set = map.keySet();
        List<String> keyList1 = new ArrayList<>(set);//convert set to list of Countries
        List<String> sublist = keyList1.subList(0, level);
        int random = gen.nextInt(sublist.size());

        return keyList1.get(random);//generate random country
    }
    public String getRandomCapital(String country, TreeMap map) {

        return new Converter().converterToUp((String) map.get(country));
    }   //^get capital of given country and convert toUpperCase
}
