package ru.netology.radio;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Data


public class RadioService {
    private String name = "Super Radio";
    private int currentStation = 8;
    private int currentVolume = 5;
    private int maxVolume = 100;
    private int minVolume = 0;
    private int firstStation = 0;
    private int lastStation = 9;
    private int nextStation = 9;
    private int previousStation = 7;
    private boolean on = true;

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int currentStation) {
        if (currentStation > lastStation) {
            this.currentStation = firstStation;
            return;
        }
        if (currentStation < firstStation) {
            this.currentStation = lastStation;
            return;
        }
        this.currentStation = currentStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    //установка текущей громкости
    public void setCurrentVolume(int currentVolume) {
        if (currentVolume > maxVolume) {
            this.currentVolume = maxVolume;
            return;
        }
        if (currentVolume < minVolume) {
            this.currentVolume = minVolume;
            return;
        }
        this.currentVolume = currentVolume;
    }


    public void increaseCurrentVolume() {
        if (currentVolume < maxVolume) {
            this.currentVolume++;
        }
    }

    public void decreaseCurrentVolume () {
        if (currentVolume > minVolume) {
            this.currentVolume--;
        }
    }

    public int getMinVolume() {
        return minVolume;
    }

    public void setMinVolume(int minVolume) {
        this.minVolume = minVolume;
    }

    public void goToNextStation() {
        if (currentStation < lastStation) {
            this.currentStation++;
        }
        else {
            this.currentStation = firstStation;
        }
    }

    public void goToPreviousStation () {
        if (currentStation > firstStation) {
            this.currentStation--;
        }
        else {
            this.currentStation = lastStation;
        }
    }
}