package edu.uoc.pac4.alien;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public abstract class EtherealAlien extends Alien {
    private double transparencyLevel;

    protected EtherealAlien(String name, double transparencyLevel) throws AlienException {
        super(name);
        setTransparencyLevel(transparencyLevel);
    }

    public double getTransparencyLevel() {
        return transparencyLevel;
    }

    public void setTransparencyLevel(double transparencyLevel) {
        if (transparencyLevel < 0.0) {
            this.transparencyLevel = 0.0;
        } else if (transparencyLevel > 1.0) {
            this.transparencyLevel = 1.0;
        } else {
            this.transparencyLevel = transparencyLevel;
        }
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        df.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.US));

        return "{ \"alienDetails\": " + super.toString() +
                ", \"transparencyLevel\": " + df.format(transparencyLevel) + " }";
    }
}