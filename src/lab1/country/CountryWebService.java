package lab1.country;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC) //определение типа SOAP-связывания
public interface CountryWebService { //интерфейс определяет методы, которые будет представлять SOAP-вебсервис
    @WebMethod //аннотация для того, чтобы Publisher понимал этот метод как SOAP
        //метод возвращает объект Country по его Id
    Country getCountryById(int id);

    @WebMethod
        //метод удаляет объект Country по его Id
    boolean removeCountryById(int id);

    @WebMethod
        //метод обновляет объект Country, заменяя его данные
    boolean updateCountry(Country country);

    @WebMethod
        //возвращает массив всех объектов класса Country
    Country[] getAllCountries();
}
