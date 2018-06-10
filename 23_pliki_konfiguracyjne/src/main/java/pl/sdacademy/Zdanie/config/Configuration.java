package pl.sdacademy.Zdanie.config;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Configuration { // klasa configuration służy do reprezentacji pliku konfiguracji w formacie yaml za
    // pomocą obiektu javy
    String version; //nazwy pól powinny być takie same jak nazwy użyte w naszym pliku yaml
    Date released; //nasza biblioteka nie radzi sobie z nowym api daty, dlatego używamy starej klasy Date z pakietu java.util
    String author;
    Map<String, String> users; //mapy odzwierciedlone są przez przypisania w yamlu z użyciem ":", np. prezes : tomek itd.
    List<String> tradeList; //listy w yamlu definiowane są przez rozpoczęcie elementu od myślnika, np - element1

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    } //nasza biblioteka nie wymaga istnienia konstruktora ustawiającego wszystkie pola, w zamian oczekuje, że każde pole będzie posiadało swój setter

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    } //nasza biblioteka nie wymaga istnienia konstruktora ustawiającego wszystkie pola, w zamian oczekuje, że każde pole będzie posiadało swój setter


    public Date getReleased() {
        return released;
    }

    public void setReleased(Date released) {
        this.released = released;
    }

    public Map<String, String> getUsers() {
        return users;
    }

    public void setUsers(Map<String, String> users) {
        this.users = users;
    }

    public List<String> getTradeList() {
        return tradeList;
    }

    public void setTradeList(List<String> fileExtensions) {
        this.tradeList = fileExtensions;
    }

    @Override
    public String toString() {
        return "Configuration {" +
                "version = '" + version + '\'' +
                ", released = " + released +
                ", Author = " + author +
                ", users = " + users +
                ", tradeList = " + tradeList +
                '}';
    }
}
