package ru.netology.radio;

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

    public RadioService(String name, int currentStation, int currentVolume, int maxVolume, int minVolume, int firstStation, int lastStation, int nextStation, int previousStation, boolean on) {
        this.name = name;
        this.currentStation = currentStation;
        this.currentVolume = currentVolume;
        this.maxVolume = maxVolume;
        this.minVolume = minVolume;
        this.firstStation = firstStation;
        this.lastStation = lastStation;
        this.nextStation = nextStation;
        this.previousStation = previousStation;
        this.on = on;
    }

    public RadioService() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int currentStation) {
        if (this.currentStation > lastStation) {
            this.currentStation = firstStation;
        }
        if (this.currentStation < firstStation) {
            this.currentStation = lastStation;
        }
        this.currentStation = currentStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    //установка текущей громкости
    public void setCurrentVolume(int currentVolume) {
        if (this.currentVolume > maxVolume) {
            this.currentVolume = maxVolume;
        }
        if (this.currentVolume < minVolume) {
            this.currentVolume = minVolume;
        }
        this.currentVolume = currentVolume;
    }

    public int getMaxVolume() {
        return maxVolume;
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

    public void setMaxVolume(int maxVolume) {
        this.maxVolume = maxVolume;
    }

    public int getMinVolume() {
        return minVolume;
    }

    public void setMinVolume(int minVolume) {
        this.minVolume = minVolume;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
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

    public int getFirstStation() {
        return firstStation;
    }

    public void setFirstStation(int firstStation) {
        this.firstStation = firstStation;
    }

    public int getLastStation() {
        return lastStation;
    }

    public void setLastStation(int lastStation) {
        this.lastStation = lastStation;
    }

    public int getNextStation() {
        return nextStation;
    }

    public void setNextStation(int nextStation) {
        this.nextStation = nextStation;
    }

    public int getPreviousStation() {
        return previousStation;
    }

    public void setPreviousStation(int previousStation) {
        this.previousStation = previousStation;
    }
}