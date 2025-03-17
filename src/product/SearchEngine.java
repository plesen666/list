package product;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.Searchable;

import java.util.ArrayList;
import java.util.Collections;

public class SearchEngine {
    private ArrayList<Searchable> searchable = new ArrayList<>();


    public ArrayList<Searchable> getSearchable() {
        return searchable;
    }

    public ArrayList<Searchable> search(String searchBar) {
        ArrayList<Searchable> searchArray = new ArrayList<>();

        for (Searchable element : searchable) {
            if ((element.getSearchTemp().toLowerCase().trim().contains(searchBar.toLowerCase().trim()))) {
                searchArray.add(element);





            }
        }
        return searchArray;
    }

    public Searchable getSearchTerm(String search) throws BestResultNotFound {
        int indexStart = 0;
        int indexStop;
        int numberRepetitions = 0;
        int maximumNumberRepetitions = 0;
        Searchable maximumMatches = null;
        for (Searchable element : searchable) {
            if ((element.getSearchTemp().toLowerCase().trim().contains(search.toLowerCase().trim()))) {
                indexStop = element.getSearchTemp().toLowerCase().trim().indexOf(search.toLowerCase().trim(), indexStart);
                while (indexStop != -1) {
                    numberRepetitions++;
                    indexStart = indexStop + search.length();
                    indexStop = element.getSearchTemp().toLowerCase().trim().indexOf(search.toLowerCase().trim(), indexStart);
                }
                if (numberRepetitions >= maximumNumberRepetitions) {
                    maximumNumberRepetitions = numberRepetitions;
                    maximumMatches = element;
                }
                indexStart = 0;
                numberRepetitions = 0;
            }
        }
        if (maximumMatches == null) {
            throw new BestResultNotFound(" ОБЪЕКТЫ ТИПА SEARCHABLE НЕ СОДЕРЖАТ СТРОКИ " + search.toUpperCase());
        }
        return maximumMatches;
    }

    public void add(Searchable[] newObject) {
        Collections.addAll(searchable, newObject);
    }
    public void clearSearchEngine(){
        searchable.clear();







    }
}