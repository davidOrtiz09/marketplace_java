package model;

public class Id<T> {

    public Id(Long id){
        this.id = id;
    }

    public Long id;

    public String toString() {
            return id.toString();
        }
}
