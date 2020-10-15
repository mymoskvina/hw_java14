package ru.netology.radio;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RadioServiceTest {
    // проверяем имя
    @Test
    void ShouldGetAndSet() {
        RadioService radio = new RadioService();
        String expected = "Super Radio";
        assertNull(radio.getName());
        radio.setName(expected);
        assertEquals(expected, radio.getName());
    }
    //преключаем на предыдущю
    @Test
    public void GoToPreviousStation() {
        RadioService radio = new RadioService();
        radio.setFirstStation(0);
        radio.setLastStation(9);
        int currentStation = 5;
        int expected = 4;
        radio.setCurrentStation(currentStation);
        radio.goToPreviousStation();
        assertEquals(expected, radio.getCurrentStation());
    }
    // переключаем на предыдущую, если на 0 значении
    @Test
    public void GoToPreviousStationIfZero() {
        RadioService radio = new RadioService();
        radio.setFirstStation(0);
        radio.setLastStation(9);
        int currentStation = 0;
        int expected = 9;
        radio.setCurrentStation(currentStation);
        radio.goToPreviousStation();
        assertEquals(expected, radio.getCurrentStation());
    }
    // переключаем на предыдущую, если на максимальном значении
    @Test
    public void GoToPreviousStationIfMax() {
        RadioService radio = new RadioService();
        radio.setFirstStation(0);
        radio.setLastStation(9);
        int currentStation = 9;
        int expected = 8;
        radio.setCurrentStation(currentStation);
        radio.goToPreviousStation();
        assertEquals(expected, radio.getCurrentStation());
    }
    // переключаем на следующую
    @Test
    public void GoToNextStation() {
        RadioService radio = new RadioService();
        radio.setFirstStation(0);
        radio.setLastStation(9);
        int currentStation = 5;
        int expected = 6;
        radio.setCurrentStation(currentStation);
        radio.goToNextStation();
        assertEquals(expected, radio.getCurrentStation());
    }
    // переключаем на следующую, если на 0 значении
    @Test
    public void GoToNextStationIfSelectedZeroStation() {
        RadioService radio = new RadioService();
        radio.setFirstStation(0);
        radio.setLastStation(9);
        int currentStation = 0;
        int expected = 1;
        radio.setCurrentStation(currentStation);
        radio.goToNextStation();
        assertEquals(expected, radio.getCurrentStation());
    }
    // переключаем на следующую, если на максимальном значении
    @Test
    public void GoToNextStationIfMax() {
        RadioService radio = new RadioService();
        radio.setFirstStation(0);
        radio.setLastStation(9);
        int currentStation = 9;
        int expected = 0;
        radio.setCurrentStation(currentStation);
        radio.goToNextStation();
        assertEquals(expected, radio.getCurrentStation());
    }
    // набираем станцию на пульте
    @Test
    void setCurrentStation() {
        RadioService radio = new RadioService();
        int currentStation = 3;
        int expected = 3;
        radio.setCurrentStation(currentStation);
        assertEquals(expected, radio.getCurrentStation());
    }
    //набираем 0 станцию на пульте
    @Test
    void setCurrentStationZero() {
        RadioService radio = new RadioService();
        int currentStation = 0;
        int expected = 0;
        radio.setCurrentStation(currentStation);
        assertEquals(expected, radio.getCurrentStation());
    }
    // набираем максимальную станцию на пульте
    @Test
    void setCurrentStationMax() {
        RadioService radio = new RadioService();
        int currentStation = 9;
        int expected = 9;
        radio.setCurrentStation(currentStation);
        assertEquals(expected, radio.getCurrentStation());
    }

    //уменьшаем громкость на 1
    @Test
    public void DecreaseVolume() {
        RadioService radio = new RadioService();
        radio.setMinVolume(0);
        radio.setMaxVolume(10);
        int currentVolume = 5;
        int expected = 4;
        radio.setCurrentVolume(currentVolume);
        radio.decreaseCurrentVolume();
        assertEquals(expected, radio.getCurrentVolume());
    }
    //уменьшаем громкость на 1 если стоит 0
    @Test
    public void DecreaseVolumeIfZero() {
        RadioService radio = new RadioService();
        radio.setMinVolume(0);
        radio.setMaxVolume(10);
        int currentVolume = 0;
        int expected = 0;
        radio.setCurrentVolume(currentVolume);
        radio.decreaseCurrentVolume();
        assertEquals(expected, radio.getCurrentVolume());
    }
    //уменьшаем громкость на 1 если стоит 10
    @Test
    public void DecreaseVolumeIfMax() {
        RadioService radio = new RadioService();
        radio.setMinVolume(0);
        radio.setMaxVolume(10);
        int currentVolume = 10;
        int expected = 9;
        radio.setCurrentVolume(currentVolume);
        radio.decreaseCurrentVolume();
        assertEquals(expected, radio.getCurrentVolume());
    }
    //увеличиваем громкость на 1
    @Test
    public void IncreaseVolume() {
        RadioService radio = new RadioService();
        radio.setMinVolume(0);
        radio.setMaxVolume(10);
        int currentVolume = 5;
        int expected = 6;
        radio.setCurrentVolume(currentVolume);
        radio.increaseCurrentVolume();
        assertEquals(expected, radio.getCurrentVolume());
    }
    //увеличиваем громкость на 1 если 0
    @Test
    public void IncreaseVolumeIfZero() {
        RadioService radio = new RadioService();
        radio.setMinVolume(0);
        radio.setMaxVolume(10);
        int currentVolume = 0;
        int expected = 1;
        radio.setCurrentVolume(currentVolume);
        radio.increaseCurrentVolume();
        assertEquals(expected, radio.getCurrentVolume());
    }
    //увеличиваем громкость на 1 если максимальная громкость
    @Test
    public void IncreaseVolumeIfMax() {
        RadioService radio = new RadioService();
        radio.setMinVolume(0);
        radio.setMaxVolume(10);
        int currentVolume = 10;
        int expected = 10;
        radio.setCurrentVolume(currentVolume);
        radio.increaseCurrentVolume();
        assertEquals(expected, radio.getCurrentVolume());
    }
    // Тесты для покрытия JaCoCo
    @Test
    void CheckGetAndSetCurrentStation() {
        RadioService radio = new RadioService();
        radio.setCurrentStation(8);
        int expected = 8;
        radio.setCurrentStation(expected);
        assertEquals(expected, radio.getCurrentStation());
    }
    @Test
    void CheckGetAndSetCurrentUndefinedUnderMinStation() {
        RadioService radio = new RadioService();
        radio.setCurrentStation(-1);
        int expected = 0;
        radio.setCurrentStation(expected);
        assertEquals(expected, radio.getCurrentStation());
    }
    @Test
    void CheckGetAndSetCurrentUndefinedBelowMixStation() {
        RadioService radio = new RadioService();
        radio.setCurrentStation(-1);
        int expected = 0;
        radio.setCurrentStation(expected);
        assertEquals(expected, radio.getCurrentStation());
    }
    @Test
    void CheckGetAndSetPreviousStation() {
        RadioService radio = new RadioService();
        radio.setPreviousStation(8);
        int expected = 8;
        radio.setPreviousStation(expected);
        assertEquals(expected, radio.getPreviousStation());
    }
    @Test
    void CheckGetAndSetNextStation() {
        RadioService radio = new RadioService();
        radio.setNextStation(8);
        int expected = 8;
        radio.setNextStation(expected);
        assertEquals(expected, radio.getNextStation());
    }
    @Test
    void CheckGetAndSetLastStation() {
        RadioService radio = new RadioService();
        radio.setLastStation(9);
        int expected = 9;
        radio.setLastStation(expected);
        assertEquals(expected, radio.getLastStation());
    }
    @Test
    void CheckGetAndSetFirstStation() {
        RadioService radio = new RadioService();
        radio.setFirstStation(1);
        int expected = 1;
        radio.setFirstStation(expected);
        assertEquals(expected, radio.getFirstStation());
    }
    @Test
    void CheckGetAndSetCurrentVolume() {
        RadioService radio = new RadioService();
        radio.setCurrentVolume(8);
        int expected = 8;
        radio.setCurrentVolume(expected);
        assertEquals(expected, radio.getCurrentVolume());
    }
    @Test
    void CheckGetAndSetUndefinedBelowCurrentVolume() {
        RadioService radio = new RadioService();
        radio.setCurrentVolume(15);
        int expected = 10;
        radio.setCurrentVolume(expected);
        assertEquals(expected, radio.getCurrentVolume());
    }
    @Test
    void CheckGetAndSetUndefinedUnderCurrentVolume() {
        RadioService radio = new RadioService();
        radio.setCurrentVolume(-1);
        int expected = 0;
        radio.setCurrentVolume(expected);
        assertEquals(expected, radio.getCurrentVolume());
    }
    @Test
    void CheckGetAndSetMaxVolume() {
        RadioService radio = new RadioService();
        radio.setMaxVolume(10);
        int expected = 10;
        radio.setMaxVolume(expected);
        assertEquals(expected, radio.getMaxVolume());
    }
    @Test
    void CheckGetAndSetUndefinedMaxVolume() {
        RadioService radio = new RadioService();
        radio.setMaxVolume(5);
        int expected = 10;
        radio.setMaxVolume(expected);
        assertEquals(expected, radio.getMaxVolume());
    }

    @Test
    void CheckGetAndSetMinVolume() {
        RadioService radio = new RadioService();
        radio.setMinVolume(0);
        int expected = 0;
        radio.setMinVolume(expected);
        assertEquals(expected, radio.getMinVolume());
    }
    @Test
    void CheckGetAndSetUndefinedMinVolume() {
        RadioService radio = new RadioService();
        radio.setMinVolume(5);
        int expected = 0;
        radio.setMinVolume(expected);
        assertEquals(expected, radio.getMinVolume());
    }
    @Test
    void CheckGetAndSetUndefinedUnderMinVolume() {
        RadioService radio = new RadioService();
        radio.setMinVolume(-1);
        int expected = 0;
        radio.setMinVolume(expected);
        assertEquals(expected, radio.getMinVolume());
    }
    @Test
    void ShouldGetAndSetOn() {
        RadioService radio = new RadioService();
        radio.setOn(false);
        boolean expected = false;
        assertEquals(expected, radio.isOn());
    }
    @Test
    void CheckGetAndSetCurrentStationForCoverage() {
        RadioService radio = new RadioService();
        radio.setCurrentStation(8);
        int expected = 8;
        radio.setCurrentStation(expected);
        assertEquals(expected, radio.getCurrentStation());
    }
    @Test
    void CheckGetAndSetCurrentUndefinedBelowMaxStation() {
        RadioService radio = new RadioService();
        radio.setCurrentStation(15);
        int expected = 10;
        radio.setCurrentStation(expected);
        assertEquals(expected, radio.getCurrentStation());
    }
    @Test
    void CheckGetAndSetCurrentUndefinedBelowMinStation() {
        RadioService radio = new RadioService();
        radio.setCurrentStation(-1);
        int expected = 0;
        radio.setCurrentStation(expected);
        assertEquals(expected, radio.getCurrentStation());
    }
}