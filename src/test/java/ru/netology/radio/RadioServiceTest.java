import org.junit.jupiter.api.Test;
import ru.netology.constructor.RadioService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RadioServiceTest {

    // проверяем имя
    @Test
    void ShouldGetAndSet() {
        RadioService radio = new RadioService("Super Radio", 0,5,10, 0, 0,9, 6, 4, true );
        assertEquals("Super Radio", radio.getName());
    }
    //преключаем на предыдущю
    @Test
    public void GoToPreviousStation() {
        RadioService radio = new RadioService();
        radio.goToPreviousStation();
        assertEquals(7, radio.getCurrentStation());
    }
    // переключаем на предыдущую, если на 0 значении
    @Test
    public void GoToPreviousStationIfZero() {
        RadioService radio = new RadioService("Super Radio", 0,5,10, 0, 0,9, 6, 4, true );
        radio.goToPreviousStation();
        assertEquals(9, radio.getCurrentStation());
    }
    // переключаем на предыдущую, если на максимальном значении
    @Test
    public void GoToPreviousStationIfMax() {
        RadioService radio = new RadioService("Super Radio", 9,5,10, 0, 0,9, 6, 4, true );
        radio.goToPreviousStation();
        assertEquals(8, radio.getCurrentStation());
    }
    // переключаем на следующую
    @Test
    public void GoToNextStation() {
        RadioService radio = new RadioService("Super Radio", 5,5,10, 0, 0,9, 6, 4, true );
        radio.goToNextStation();
        assertEquals(6, radio.getCurrentStation());
    }
    // переключаем на следующую, если на 0 значении
    @Test
    public void GoToNextStationIfSelectedZeroStation() {
        RadioService radio = new RadioService("Super Radio", 0,5,10, 0, 0,9, 6, 4, true );
        radio.goToNextStation();
        assertEquals(1, radio.getCurrentStation());
    }
    // переключаем на следующую, если на максимальном значении
    @Test
    public void GoToNextStationIfMax() {
        RadioService radio = new RadioService("Super Radio", 9,5,100, 0, 0,9, 6, 4, true );
        radio.goToNextStation();
        assertEquals(0, radio.getCurrentStation());
    }
    // набираем станцию на пульте
    @Test
    void setCurrentStation() {
        RadioService radio = new RadioService("Super Radio", 3,5,10, 0, 0,9, 6, 4, true );
        assertEquals(3, radio.getCurrentStation());
    }
    //набираем 0 станцию на пульте
    @Test
    void setCurrentStationZero() {
        RadioService radio = new RadioService("Super Radio", 0,5,10, 0, 0,9, 6, 4, true );
        assertEquals(0, radio.getCurrentStation());
    }
    // набираем максимальную станцию на пульте
    @Test
    void setCurrentStationMax() {
        RadioService radio = new RadioService("Super Radio", 9,5,10, 0, 0,9, 6, 4, true );
        assertEquals(9, radio.getCurrentStation());
    }

    //уменьшаем громкость на 1
    @Test
    public void DecreaseVolume() {
        RadioService radio = new RadioService("Super Radio", 0,5,10, 0, 0,9, 6, 4, true );
        radio.decreaseCurrentVolume();
        assertEquals(4, radio.getCurrentVolume());
    }
    //уменьшаем громкость на 1 если стоит 0
    @Test
    public void DecreaseVolumeIfZero() {
        RadioService radio = new RadioService("Super Radio", 0,0,10, 0, 0,9, 6, 4, true );
        radio.decreaseCurrentVolume();
        assertEquals(0, radio.getCurrentVolume());
    }
    //уменьшаем громкость на 1 если стоит 10
    @Test
    public void DecreaseVolumeIfMax() {
        RadioService radio = new RadioService("Super Radio", 0,100,10, 0, 0,9, 6, 4, true );
        radio.decreaseCurrentVolume();
        assertEquals(99, radio.getCurrentVolume());
    }
    //увеличиваем громкость на 1
    @Test
    public void IncreaseVolume() {
        RadioService radio = new RadioService("Super Radio", 0,5,10, 0, 0,9, 6, 4, true );
        radio.increaseCurrentVolume();
        assertEquals(6, radio.getCurrentVolume());
    }
    //увеличиваем громкость на 1 если 0
    @Test
    public void IncreaseVolumeIfZero() {
        RadioService radio = new RadioService("Super Radio", 0,0,10, 0, 0,9, 6, 4, true );
        radio.increaseCurrentVolume();
        assertEquals(1, radio.getCurrentVolume());
    }
    //увеличиваем громкость на 1 если максимальная громкость
    @Test
    public void IncreaseVolumeIfMax() {
        RadioService radio = new RadioService("Super Radio", 0,100,100, 0, 0,9, 6, 4, true );
        radio.increaseCurrentVolume();
        assertEquals(100, radio.getCurrentVolume());
    }
    @Test
    void CheckGetAndSetCurrentUnderMinStation() {
        RadioService radio = new RadioService("Super Radio", 0,5,10, 0, 0,9, 6, 4, true );
        int currentStation = -1;
        assertEquals(0, radio.getCurrentStation());
    }
    @Test
    void CheckGetAndSetCurrentBelowMinStation() {
        RadioService radio = new RadioService("Super Radio", 2,5,10, 0, 0,9, 6, 4, true );
        assertEquals(2, radio.getCurrentStation());
    }
    @Test
    void CheckGetAndSetPreviousStation() {
        RadioService radio = new RadioService("Super Radio", 9,5,10, 0, 0,9, 6, 8, true );
        assertEquals(8, radio.getPreviousStation());
    }
    @Test
    void CheckGetAndSetNextStation() {
        RadioService radio = new RadioService("Super Radio", 6,5,10, 0, 0,9, 7, 5, true );
        assertEquals(7, radio.getNextStation());
    }
    @Test
    void CheckGetAndSetLastStation() {
        RadioService radio = new RadioService("Super Radio", 0,5,10, 0, 0,9, 6, 4, true );
        assertEquals(9, radio.getLastStation());
    }
    @Test
    void CheckGetAndSetFirstStation() {
        RadioService radio = new RadioService("Super Radio", 0,5,10, 0, 1,9, 6, 4, true );
        assertEquals(1, radio.getFirstStation());
    }
    @Test
    void CheckGetAndSetCurrentVolume() {
        RadioService radio = new RadioService("Super Radio", 0,8,10, 0, 0,9, 6, 4, true );
        assertEquals(8, radio.getCurrentVolume());
    }
    @Test
    void CheckGetAndSetBelowCurrentVolume() {
        RadioService radio = new RadioService("Super Radio", 0,15,10, 0, 0,9, 6, 4, true );
        assertEquals(15, radio.getCurrentVolume());
    }
    @Test
    void CheckGetAndSetUndefinedUnderCurrentVolume() {
        RadioService radio = new RadioService("Super Radio", 0,0,10, 0, 0,9, 6, 4, true );
        int currentVolume = -1;
        assertEquals(0, radio.getCurrentVolume());
    }
    @Test
    void CheckGetAndSetMaxVolume() {
        RadioService radio = new RadioService("Super Radio", 0,5,10, 0, 0,9, 6, 4, true );
        assertEquals(10, radio.getMaxVolume());
    }
    @Test
    void CheckGetAndSetUndefinedMaxVolume() {
        RadioService radio = new RadioService("Super Radio", 0,5,5, 0, 0,9, 6, 4, true );
        assertEquals(5, radio.getMaxVolume());
    }

    @Test
    void CheckGetAndSetMinVolume() {
        RadioService radio = new RadioService("Super Radio", 0,5,10, 0, 0,9, 6, 4, true );
        assertEquals(0, radio.getMinVolume());
    }
    @Test
    void CheckGetAndSetUndefinedMinVolume() {
        RadioService radio = new RadioService("Super Radio", 0,5,10, 0, 0,9, 6, 4, true );
        assertEquals(0, radio.getMinVolume());
    }
    @Test
    void CheckGetAndSetUndefinedUnderMinVolume() {
        RadioService radio = new RadioService();
        assertEquals(0, radio.getMinVolume());
    }
    @Test
    void ShouldGetAndSetOn() {
        RadioService radio = new RadioService();
        assertTrue(radio.isOn());
    }
    @Test
    void CheckGetAndSetCurrentStation() {
        RadioService radio = new RadioService();
        assertEquals(8, radio.getCurrentStation());
    }
    @Test
    void CheckGetAndSetCurrentUndefinedBelowMaxStation() {
        RadioService radio = new RadioService();
        int currentStation = 15;
        assertEquals(8, radio.getCurrentStation());
    }
    @Test
    void CheckGetAndSetCurrentUndefinedBelowMinStation() {
        RadioService radio = new RadioService();
        int currentStation = -1;
        assertEquals(8, radio.getCurrentStation());
    }
}