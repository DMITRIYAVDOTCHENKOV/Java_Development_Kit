package seminar4.hw;

public class Employee {
    private int id;
    private String phoneNumber;
    private String name;
    private int experience;

    public Employee(int id, String phoneNumber, String name, int experience) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.experience = experience;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
    @Override
    public String toString() {
        return "Имя: " + name + "\nНомер телефона: " + phoneNumber + "\nСтаж: " + experience;
    }

    /**
     * Записываем данные в файл
     * @return
     */
    public String toFileString() {
        return id + "," + phoneNumber + "," + name + "," + experience;
    }
}

