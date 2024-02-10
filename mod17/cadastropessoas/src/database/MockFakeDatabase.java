package database;

import domain.Car;

import java.util.ArrayList;
import java.util.List;

public class MockFakeDatabase {

    private static MockFakeDatabase mockFakeDatabase;

    private static final List<Car> data = new ArrayList<>();

    private MockFakeDatabase() {
    }

    public static MockFakeDatabase getInstance(){
        if (mockFakeDatabase == null){
            mockFakeDatabase = new MockFakeDatabase();
        }

        return mockFakeDatabase;
    }

    public List<Car> getData() {
        return data;
    }
}
