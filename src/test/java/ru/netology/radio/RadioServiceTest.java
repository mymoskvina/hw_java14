package ru.netology.radio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RadioServiceTest {

    // проверяем имя
    @Test
    void ShouldGetAndSet() {
        RadioService radio = new RadioService();
        assertEquals("Super Radio", radio.getName());
    }
    @Test
    void CheckSetName() {
        RadioService radio = new RadioService();
        radio.setName("Super New Radio");
        assertEquals("Super New Radio", radio.getName());
    }
    //преключаем на предыдущю
    @Test
    void GoToPreviousStation() {
        RadioService radio = new RadioService();
        assertEquals(7, radio.getPreviousStation());
    }
    @Test
    void GoToPreviousStationInTest() {
        RadioService radio = new RadioService();
        radio.setPreviousStation(7);
        assertEquals(7, radio.getPreviousStation());
    }
    // переключаем на предыдущую, если на 0 значении
    @Test
    public void GoToPreviousStationIfZero() {
        RadioService radio = new RadioService("Super Radio", 0,5,100, 0, 0,9, 6, 4, true );
        radio.goToPreviousStation();
        assertEquals(9, radio.getCurrentStation());
    }
    // переключаем на предыдущую, если на максимальном значении
    @Test
    public void GoToPreviousStationIfMax() {
        RadioService radio = new RadioService("Super Radio", 9,5,100, 0, 0,9, 0, 8, true );
        radio.goToPreviousStation();
        assertEquals(8, radio.getCurrentStation());
    }
    // переключаем на предыдущую, если на отрицательном значении
    @Test
    public void GoToPreviousStationIfMinusValue() {
        RadioService radio = new RadioService("Super Radio", -3,5,100, 0, 0,9, 0, 8, true );
        radio.goToPreviousStation();
        assertEquals(9, radio.getCurrentStation());
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
    // переключаем на следующую, если в отрицательном значении
    @Test
    public void GoToNextStationIfMinusValue() {
        RadioService radio = new RadioService("Super Radio", -1,5,100, 0, 0,9, 6, 4, true );
        radio.goToNextStation();
        assertEquals(0, radio.getCurrentStation());
    }
    // переключаем на следующую, если в больше максимального значения
    @Test
    public void GoToNextStationIfAboveMaxValue() {
        RadioService radio = new RadioService("Super Radio", 12,5,100, 0, 0,9, 6, 4, true );
        radio.goToNextStation();
        assertEquals(0, radio.getCurrentStation());
    }
    //-----------------------
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
    // набираем на пульте станцию -1
    @Test
    void setCurrentStationBelowZero() {
        RadioService radio = new RadioService();
        radio.setCurrentStation(-1);
        assertEquals(9, radio.getCurrentStation());
    }
    // набираем максимальную станцию на пульте, выше диапазона
    @Test
    void setCurrentStationAbove9() {
        RadioService radio = new RadioService();
        radio.setCurrentStation(10);
        assertEquals(0, radio.getCurrentStation());
    }
    // набираем максимальную станцию на пульте, в диапазоне
    @Test
    void setCurrentStationInTest() {
        RadioService radio = new RadioService();
        radio.setCurrentStation(9);
        assertEquals(9, radio.getCurrentStation());
    }
    //уменьшаем громкость на 1
    @Test
    public void DecreaseVolume() {
        RadioService radio = new RadioService("Super Radio", 0,5,100, 0, 0,9, 6, 4, true );
        radio.decreaseCurrentVolume();
        assertEquals(4, radio.getCurrentVolume());
    }
    //уменьшаем громкость на 1 если стоит 0
    @Test
    public void DecreaseVolumeIfZero() {
        RadioService radio = new RadioService("Super Radio", 0,0,100, 0, 0,9, 6, 4, true );
        radio.decreaseCurrentVolume();
        assertEquals(0, radio.getCurrentVolume());
    }
    //уменьшаем громкость на 1 если стоит 10
    @Test
    public void DecreaseVolumeIfMax() {
        RadioService radio = new RadioService("Super Radio", 0,100,100, 0, 0,9, 6, 4, true );
        radio.decreaseCurrentVolume();
        assertEquals(99, radio.getCurrentVolume());
    }
    //увеличиваем громкость на 1
    @Test
    public void IncreaseVolume() {
        RadioService radio = new RadioService("Super Radio", 0,5,100, 0, 0,9, 6, 4, true );
        radio.increaseCurrentVolume();
        assertEquals(6, radio.getCurrentVolume());
    }
    //увеличиваем громкость на 1 если 0
    @Test
    public void IncreaseVolumeIfZero() {
        RadioService radio = new RadioService("Super Radio", 0,0,100, 0, 0,9, 6, 4, true );
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
    //-----------------------
    @Test
    void CheckGetAndSetNextStation() {
        RadioService radio = new RadioService();
        assertEquals(9, radio.getNextStation());
    }
    @Test
    void CheckGetAndSetNextStationInTest() {
        RadioService radio = new RadioService();
        radio.setNextStation(7);
        assertEquals(7, radio.getNextStation());
    }
    // как отрабатывает следующая станция, когда текущая задана 15
    @Test
    void CheckGetAndSetNextStationIfCurrentOutOfBounce() {
        RadioService radio = new RadioService("Super Radio", 6,5,10, 0, 0,9, 7, 5, true );
        radio.setCurrentStation(15);
        assertEquals(7, radio.getNextStation());
    }
    // как отрабатывает следующая станция, когда текущая задана -2
    @Test
    void CheckGetAndSetNextStationIfCurrentMinusValue() {
        RadioService radio = new RadioService("Super Radio", 6,5,10, 0, 0,9, 7, 5, true );
        radio.setCurrentStation(-2);
        assertEquals(7, radio.getNextStation());
    }
    @Test
    void CheckGetAndSetLastStation() {
        RadioService radio = new RadioService();
        assertEquals(9, radio.getLastStation());
    }
    @Test
    void CheckGetAndSetLastStationInTest() {
        RadioService radio = new RadioService();
        radio.setLastStation(9);
        assertEquals(9, radio.getLastStation());
    }
    @Test
    void CheckGetAndSetFirstStation() {
        RadioService radio = new RadioService();
        assertEquals(0, radio.getFirstStation());
    }
    @Test
    void CheckGetAndSetFirstStationInTest() {
        RadioService radio = new RadioService();
        radio.setFirstStation(0);
        assertEquals(0, radio.getFirstStation());
    }
    @Test
    void CheckGetAndSetCurrentStation() {
        RadioService radio = new RadioService();
        assertEquals(8, radio.getCurrentStation());
    }
    @Test
    void CheckGetAndSetCurrentUndefinedAboveMaxStation() {
        RadioService radio = new RadioService();
        radio.setCurrentStation(15);
        assertEquals(9, radio.getLastStation());
    }
    @Test
    void CheckGetAndSetCurrentUndefinedBelowMinStation() {
        RadioService radio = new RadioService();
        radio.setCurrentStation(-1);
        assertEquals(0, radio.getFirstStation());
    }
    @Test
    void CheckGetAndSetCurrentVolumeWithoutSet() {
        RadioService radio = new RadioService();
        assertEquals(5, radio.getCurrentVolume());
    }
    @Test
    void CheckGetAndSetCurrentVolume() {
        RadioService radio = new RadioService();
        radio.setCurrentVolume(8);
        assertEquals(8, radio.getCurrentVolume());
    }
    @Test
    void CheckGetAndSetCurrentVolumeMax() {
        RadioService radio = new RadioService();
        radio.setCurrentVolume(100);
        assertEquals(100, radio.getCurrentVolume());
    }
    @Test
    void CheckGetAndSetAboveCurrentVolume() {
        RadioService radio = new RadioService();
        radio.setCurrentVolume(101);
        assertEquals(100, radio.getCurrentVolume());
    }
    @Test
    void GetAndSetCurrentVolumeMin() {
        RadioService radio = new RadioService();
        radio.setCurrentVolume(0);
        assertEquals(0, radio.getCurrentVolume());
    }
    @Test
    void CheckGetAndSetMinVolumeWithoutSet() {
        RadioService radio = new RadioService();
        assertEquals(0, radio.getMinVolume());
    }
    @Test
    void CheckGetAndSetBelowMinVolume() {
        RadioService radio = new RadioService();
        radio.setCurrentVolume(-1);
        assertEquals(0, radio.getCurrentVolume());
    }
    @Test
    void CheckGetAndSetMaxVolume() {
        RadioService radio = new RadioService();
        assertEquals(100, radio.getMaxVolume());
    }
   @Test
    void CheckGetAndSetUndefinedUnderMinVolume() {
        RadioService radio = new RadioService();
        radio.setMinVolume(0);
        assertEquals(0, radio.getMinVolume());
    }
    @Test
    void CheckGetAndSetUndefinedUnderMaxVolume() {
        RadioService radio = new RadioService();
        radio.setMaxVolume(100);
        assertEquals(100, radio.getMaxVolume());
    }
    @Test
    void ShouldGetAndSetOn() {
        RadioService radio = new RadioService();
        assertTrue(radio.isOn());
    }
    @Test
    void ShouldGetAndSetOnWhenOff() {
        RadioService radio = new RadioService();
        radio.setOn(false);
        assertEquals(false, radio.isOn());
    }
}