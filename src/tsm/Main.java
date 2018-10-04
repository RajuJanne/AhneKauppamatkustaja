package tsm;

// Janne Rajuvaara
// NTK17SP 2018

import java.util.*;

public class Main {

    public static void main(String[] args) {

        SortedSet<City> citySet = createCities(getCount());
//        System.out.println("Luotu " + citySet.size() + " kaupunkia.");
//
//        for (City c : citySet) {
//            System.out.println(c.ToString());
//        }

        GreedyTSM gtsm = new GreedyTSM(citySet);
        System.out.println(gtsm.solve());
    }

    private static int getCount() {
        Scanner s = new Scanner(System.in);
        System.out.print("Miten monta kaupunkia luodaan? ");
        return Integer.parseInt(s.nextLine());
    }
    static SortedSet<City> createCities(int count)
    {
        SortedSet<City> citySet = new TreeSet<City>();
        for (int i = 0; i < count; i++) {
            citySet.add(new City(500000,500000,i));
        }
        return citySet;
    }

    static SortedSet<City> createCitiesDistinct(int count)
    {
        SortedSet<City> citySet = new TreeSet<City>();
        int i = 0;
        do {
            // luodaan uusi kaupunki
            City c = new City(1000000, 1000000);

            // tarkistetaan onko listalla jo kaupunkia samoilla koordinaateilla
            boolean cityEquals = false;
            for (City a : citySet) {
                if (c.equalsTo(a)) {
                    cityEquals = true;
                }
            }
            if (!cityEquals)
            {
                // mikäli vastaavaa kaupunkia ei löydetä annetaan luodulle kaupungille
                // iteratiivinen id ja lisätään se listalle
                c.set_id(i);
                citySet.add(c);
                i++;
            }
        } while (i < (count));

        return citySet;
    }
}
