package semesterprojekt.model;

public class Cat {
    private int catid;

    private String name;

    private double weight;

    private String breed;

    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Cat() {
    }

    public Cat(int catid, String name, double weight, String breed, String gender) {
        this.catid = catid;
        this.name = name;
        this.weight = weight;
        this.breed = breed;
        this.gender = gender;
    }

    public int getCatid() {
        return catid;
    }

    public void setCatid(int catid) {
        this.catid = catid;
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

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "catid=" + catid +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", breed='" + breed + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}