package lab2.part4;

abstract class Circuit {
    public abstract double getResistance();
    public abstract double getPotentialDiff();
    public abstract void applyPotentialDiff(double V);

    public double getPower() {
        return getPotentialDiff() * getPotentialDiff() / getResistance();
        // power = V^2/R
    }

    public double getCurrent() {
        return getPotentialDiff() / getResistance();
        // I = V / R
    }
}

class Resistor extends Circuit {
    private double resistance;
    private double potentialDifference;

    public Resistor(double resistance) {
        this.resistance = resistance;
        this.potentialDifference = 0.0;
    }

    @Override
    public double getResistance() {
        return resistance;
    }

    @Override
    public double getPotentialDiff() {
        return potentialDifference;
    }

    @Override
    public void applyPotentialDiff(double V) {
        this.potentialDifference = V;
    }
}

class Series extends Circuit {
    private Circuit circuit1;
    private Circuit circuit2;

    public Series(Circuit circuit1, Circuit circuit2) {
        this.circuit1 = circuit1;
        this.circuit2 = circuit2;
    }

    @Override
    public double getResistance() {
        return circuit1.getResistance() + circuit2.getResistance();
    }

    @Override
    public double getPotentialDiff() {
        return circuit1.getPotentialDiff() + circuit2.getPotentialDiff();
    }

    @Override
    public void applyPotentialDiff(double V) {
        double totalResistance = getResistance();
        double current = V / totalResistance;

        circuit1.applyPotentialDiff(current * circuit1.getResistance());
        circuit2.applyPotentialDiff(current * circuit2.getResistance());
    }
}

class Parallel extends Circuit {
    private Circuit circuit1;
    private Circuit circuit2;

    public Parallel(Circuit circuit1, Circuit circuit2) {
        this.circuit1 = circuit1;
        this.circuit2 = circuit2;
    }

    @Override
    public double getResistance() {
        double r1 = circuit1.getResistance();
        double r2 = circuit1.getResistance();
        return (1 / (1/r1) + (1/r2));
    }

    @Override
    public double getPotentialDiff() {
        return circuit1.getPotentialDiff();  // Потенциал одинаков для параллельных цепей
    }

    @Override
    public void applyPotentialDiff(double V) {
        circuit1.applyPotentialDiff(V);
        circuit2.applyPotentialDiff(V);
    }
}

public class CircuitTest {
    public static void main(String[] args) {
        Circuit a = new Resistor(3.0);
        Circuit b = new Resistor(3.0);
        Circuit c = new Resistor(6.0);
        Circuit d = new Resistor(3.0);
        Circuit e = new Resistor(2.0);

        Circuit f = new Series(a, b);
        Circuit g = new Parallel(c, d);
        Circuit h = new Series(g, e); // 4
        // 1/6 + 1/3 = 1/1/2 = 2
        Circuit circuit = new Parallel(h, f);
        // 1/4 + 1/6 = 
        double R = circuit.getResistance();
        System.out.println("Equivalent Resistance of the circuit: " + R + " Ohms");

        circuit.applyPotentialDiff(12);
        System.out.println("Total Current in the circuit: " + circuit.getCurrent() + " Amps");
        System.out.println("Total Power dissipated in the circuit: " + circuit.getPower() + " Watts");
    }
}
