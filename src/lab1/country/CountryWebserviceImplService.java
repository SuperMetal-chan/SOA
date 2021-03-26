package lab1.country;

import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
/*
определение мапинга веб-сервиса, именно здесь и присутствует пакет, о котором упоминалось раньше.
*/
@WebService(endpointInterface = "lab1.country.CountryWebService")
public class CountryWebserviceImplService implements CountryWebService {

    //определение размера контейнера
    private static final int CONTAINER_SIZE = 10;
    //генератор случайных чисел
    private static final Random RANDOM = new Random();

    //создание пустой внутренней структуры данных
    private static Map<Integer, Country> container = new HashMap<>();

    //инициализация структуры данных заполненными объектами
    static {
        for (int i = 0; i < CONTAINER_SIZE; i++) {
            int randomId = generateRandomNumber();
            int randomPopulation = RANDOM.nextInt(80000000);
            float randomArea = generateRandomFloat();
            container.put(randomId, new Country("Ukraine " + i,  randomPopulation, randomId, randomArea));
        }
    }
    // метод для генерации случайных числе по указанному диапазону
    private static int generateRandomNumber() {
        return RANDOM.nextInt(CONTAINER_SIZE * CONTAINER_SIZE - CONTAINER_SIZE + 1) + CONTAINER_SIZE;
    }
    private static float generateRandomFloat() {
        return RANDOM.nextFloat();
    }
    // возвращает объект по его идентификатору
    @Override
    public Country getCountryById(int id) {
        return container.get(id);
    }
    //возвращает список всех объектов
    @Override
    public Country[] getAllCountries() {
        return container.values().toArray(new Country[container.values().size()]);
    }
    //удаляет объект по его идентификатор, возвращает true, если объект был удален и false - если нет
    @Override
    public boolean removeCountryById(int id) {
        boolean CountryExists = container.containsKey(id);
        container.remove(id);
        return CountryExists || container.containsKey(id);
    }
    //обновление данных объекта в данном случае название id не обновляется, т.к. служит ключом
    @Override
    public boolean updateCountry(Country country) {
        Country countryToUpdate = container.get(country.getId());
        if (countryToUpdate == null) {
            return false;
        } else {
            countryToUpdate.setName(country.getName());
            country.setId(country.getId());
            return true;
        }
    }
}
