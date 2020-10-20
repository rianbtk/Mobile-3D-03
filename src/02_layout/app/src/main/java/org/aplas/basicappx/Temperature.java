package org.aplas.basicappx;

public class Temperature {
    Temperature() {
        this.celcius = 0;
    }
    private double celcius;
    private double fahrenheit;
    private double kelvins;


    public void setCelcius(double celcius) {
        this.celcius = celcius;
    }

    public void setFahrenheit(double celcius) {
        this.celcius = (celcius-32)/9*5;
    }

    public void setKelvins(double celcius) {
        this.celcius = celcius-273.15;
    }

    public double getCelcius() {
        return celcius;
    }

    public double getFahrenheit() {
        return celcius*9/5 + 32;
    }

    public double getKelvins() {
        return celcius + 273.15;
    }

    public double convert (String oriUnit, String convUnit, double value) {
        if (oriUnit.equals("°C")) {
            setCelcius(value);
        } else if (oriUnit.equals("°F")) {
            setFahrenheit(value);
        } else {
            setKelvins(value);
        }
        if (convUnit.equals("°C")) {
            return getCelcius();
        } else if (convUnit.equals("°F")) {
            return  getFahrenheit();
        } else {
            return getKelvins();
        }
    }
}
