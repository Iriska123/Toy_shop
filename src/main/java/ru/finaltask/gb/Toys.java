package ru.finaltask.gb;

public class Toys {
    private int id;
    private String name;
    private double weight;

    public Toys(int id, String name, double weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("id = %d, name = %s, weight = %f", getId(), getName(), getWeight());
    }
}
