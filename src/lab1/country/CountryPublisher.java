package lab1.country;

import javax.xml.ws.Endpoint;
public class CountryPublisher {
    //точка входа в JVM, выполнение любой Java программы начинается с main-метода
    public static void main(String[] args) {
        /*запуск "вещания", Endpoint принимает 2 параметра - адрес сервиса и его реализацию.
         * localhost - адрес машины, localhost - будет доступен только на локальном компьютере
         * 8081 - номер порта, надо чтобы порт не был занят, занятые порты можно проверить с помощью программы TCP View
         * /ws/person - мапинг на SOAP сервис
         */
        Endpoint.publish("http://localhost:8081/ws/country", new CountryWebserviceImpl());
    }
}
