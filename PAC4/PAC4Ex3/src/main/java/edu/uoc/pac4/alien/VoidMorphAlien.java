package edu.uoc.pac4.alien;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class VoidMorphAlien extends EtherealAlien implements ShapeShifter {
    private static final double TRANSPARENCY_LEVEL = 0.90;
    private double morphingAbility;

    public VoidMorphAlien(String name, double morphingAbility) throws AlienException {
        super(name, TRANSPARENCY_LEVEL);
        setMorphingAbility(morphingAbility);
    }

    public double getMorphingAbility() {
        return morphingAbility;
    }

    public void setMorphingAbility(double morphingAbility) throws AlienException {
        if (morphingAbility < 0.0 || morphingAbility > 1.0) {
            throw new AlienException(AlienException.INVALID_MORPHING_ABILITY);
        }
        this.morphingAbility = morphingAbility;
    }

    @Override
    public void changeName() {
        shapeShift();
        try {
            setName(getName() + " (VoidMorph)");
        } catch (AlienException e) {
        }
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        df.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.US));

        return "{ \"type\": \"VoidMorphAlien\", \"etherealAlienDetails\": " +
                super.toString() + ", \"morphingAbility\": " + df.format(morphingAbility) + " }";
    }
}