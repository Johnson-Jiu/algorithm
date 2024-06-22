package lambda;

public class Employee {
    private Integer age;
    private Integer money;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Employee(Integer age, Integer money) {
        this.age = age;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", money=" + money +
                '}';
    }
}
