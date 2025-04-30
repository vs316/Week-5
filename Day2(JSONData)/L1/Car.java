package javaJSONHandling;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Car {
    public String make;
    public String model;
    public int year;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public static void main(String[] args) throws Exception {
        Car car = new Car("Toyota", "Camry", 2020);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(car);

        System.out.println(jsonString);

    }
}
