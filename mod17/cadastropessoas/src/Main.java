import database.MockFakeDatabase;
import domain.Car;
import domain.SUV;
import domain.Sedan;
import repository.GenericRepositoryImpl;
import repository.IGenericRepository;

import java.util.List;

/**
 * @author thiago silva
 */
public class Main {
    public static void main(String[] args) {
        IGenericRepository<Car> repository = new GenericRepositoryImpl<>();

        Sedan sedan1 = new Sedan(1L, "SEDAN", "BLUE", 2023, 200_000L, 4, true);
        Sedan sedan2 = new Sedan(2L, "SEDAN", "BLACK", 2023, 200_000L, 4, true);
        Sedan sedan3 = new Sedan(3L, "SEDAN", "BLACK", 2023, 200_000L, 4, true);
        Sedan sedan4 = new Sedan(4L, "SEDAN", "BLUE", 2023, 200_000L, 4, true);
        Sedan sedan5 = new Sedan(5L, "SEDAN", "GREEN", 2023, 200_000L, 4, true);
        Sedan sedan6 = new Sedan(6L, "SEDAN", "GREEN", 2023, 200_000L, 4, true);
        Sedan sedan7 = new Sedan(7L, "SEDAN", "RED", 2023, 200_000L, 4, true);
        Sedan sedan8 = new Sedan(8L, "SEDAN", "RED", 2023, 200_000L, 4, true);
        Sedan sedan9 = new Sedan(9L, "SEDAN", "BLUE", 2023, 200_000L, 4, true);

        SUV suv1 = new SUV(10L, "SUV", "BLUE", 2023, 120_000L, true, 150);
        SUV suv2 = new SUV(11L, "SUV", "BLACK", 2023, 200_000L, true, 250);
        SUV suv3 = new SUV(12L, "SUV", "BLACK", 2023, 200_000L, false, 250);
        SUV suv4 = new SUV(13L, "SUV", "BLUE", 2023, 300_000L, true, 200);
        SUV suv5 = new SUV(14L, "SUV", "GREEN", 2023, 200_000L, false, 250);
        SUV suv6 = new SUV(15L, "SUV", "GREEN", 2023, 200_000L, true, 180);
        SUV suv7 = new SUV(16L, "SUV", "BLUE", 2023, 533_000L, false, 250);
        SUV suv8 = new SUV(17L, "SUV", "RED", 2023, 200_000L, true, 500);


        // Save all sedans
        repository.save(sedan1);
        repository.save(sedan2);
        repository.save(sedan3);
        repository.save(sedan4);
        repository.save(sedan5);
        repository.save(sedan6);
        repository.save(sedan7);
        repository.save(sedan8);


        // Save all SUVs
        repository.save(suv1);
        repository.save(suv2);
        repository.save(suv3);
        repository.save(suv4);
        repository.save(suv5);
        repository.save(suv6);
        repository.save(suv7);
        repository.save(suv8);

        printAllCars();

    }

    private static void printAllCars(){
        List<Car> allCars = MockFakeDatabase.getInstance().getData();
        for (Car car : allCars)
            System.out.println(car);
    }

    /**
     * Criar uma annotation chamada Tabela
     * A tabela vai receber um valor que será o nome da tabela
     */
}