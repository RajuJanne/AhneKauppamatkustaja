package tsm;

// Janne Rajuvaara
// NTK17SP 2018

import java.util.Comparator;
import java.util.Random;

public class City implements Comparable<City>, Comparator<City> {
    // id annetaan vasta equals tarkistuksen jälkeen, joten tätä ei alusteta konstruktorissa
    // id:n arvo tullaan  saamaan kaupunkeja generoivan loopin indeksistä.
    private int _id;
    private int _x;
    private int _y;
    private int _max_X;
    private int _max_Y;

    // oletuskoordinaatisto 0-50
    City()
    {
        _max_X = 50;
        _max_Y = 50;
        generate_Coordinates();
    }
    // mikäli luonnin yhteydessä annetaan erikseen maksimikoko koordinaatistolle, niin pompataan tänne
    public City(int x, int y)
    {
        _max_X = x;
        _max_Y = y;
        generate_Coordinates();
    }
    
    public City(int x, int y, int id)
    {
        _max_X = x;
        _max_Y = y;
        _id = id;
        generate_Coordinates();
    }

    // luodaan satunnaiset pisteet x- ja y-akseleille
    private void generate_Coordinates() {
        Random r = new Random();
        _x = r.ints(0,(_max_X + 1)).findFirst().getAsInt();
        _y = r.ints(0,(_max_Y + 1)).findFirst().getAsInt();
    }

    int get_x() {
        return _x;
    }

    public int get_y() {
        return _y;
    }

    int get_id() {
        return _id;
    }

    void set_id(int _id) {
        this._id = _id;
    }


    // tarkistin onko oliolla sama lokaatio, eli onko kyseessä sama olio.

    boolean equalsTo(City another)
    {
        if (this.get_y() == another.get_y() || this.get_x() == another.get_x())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public int compareTo(City another)
    {
        if (this.get_id() == another.get_id())
        {
            return 0;
        }
        else if (this.get_id() < another.get_id())
        {
            return -1;
        }
        else
        {
            return 1;

        }
    }

    @Override
    public int compare(City o1, City o2) {
        if (o1.get_id() < o2.get_id())
        {
            return -1;
        } else if (o1.get_id() == o2.get_id())
        {
            return 0;
        } else {
            return 1;
        }
    }

    String ToString() {
        return "Id: " + get_id() + ", koodinaatit: " + get_x() + ", " + get_y();
    }
}
