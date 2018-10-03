package tsm;

import java.util.Random;

public class City {
    // id annetaan vasta equals tarkistuksen jälkeen, joten tätä ei alusteta konstruktorissa
    // id:n arvo tullaan  saamaan kaupunkeja generoivan loopin indeksistä.
    private int _id;
    private int _x;
    private int _y;
    private int _max_X;
    private int _max_Y;

    // oletuskoordinaatisto 0-50
    public City()
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

    // luodaan satunnaiset pisteet x- ja y-akseleille
    private void generate_Coordinates() {
        Random r = new Random();
        _x = r.ints(0,(_max_X + 1)).findFirst().getAsInt();
        _y = r.ints(0,(_max_Y + 1)).findFirst().getAsInt();
    }

    public int get_x() {
        return _x;
    }

    public int get_y() {
        return _y;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }


    // tarkistin onko oliolla sama lokaatio, eli onko kyseessä sama olio.
    public boolean equals(City another)
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

}
