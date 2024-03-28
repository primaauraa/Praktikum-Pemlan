package Tugas.Praktikum.Pemlan;

public class Hero {
    private String name;
    private double hp;
    private double attack;
    private double defense;

    public Hero() {
    }

    public Hero(String name, double hp, double attack, double defense) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
    }
 
    public String namaPemain() {
        return name;
    }
    public void setNamaPemain(String name) {
        this.name = name;
    }
    public double healthPoin() {
        return hp;
    }
    public void setHealthPoin(double hp) {
        this.hp = hp;
    }
    public double serang() {
        return attack;
    }
    public void setSerang(double attack) {
        this.attack = attack;
    }
    public double bertahan() {
        return defense;
    }
    public void setBertahan(double defense) {
        this.defense = defense;
    }
}

    

