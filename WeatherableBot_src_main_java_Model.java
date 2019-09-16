class Model {
    private String name;
    private Double temp;
    private Double humidity;
    private String icon;
    private String main;

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    double getTemp() {
        return temp;
    }

    void setTemp(double temp) {
        this.temp = temp;
    }

    Double getHumidity() {
        return humidity;
    }

    void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    String getIcon() {
        return icon;
    }

    void setIcon(String icon) {
        this.icon = icon;
    }

    String getMain() {
        return main;
    }

    void setMain(String main) {
        this.main = main;
    }
}
