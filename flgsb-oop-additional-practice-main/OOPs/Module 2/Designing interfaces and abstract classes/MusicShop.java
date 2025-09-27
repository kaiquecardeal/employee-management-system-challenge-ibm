// Step 1: Create an abstract class Instrument
// This should include:
// - private String name
// - protected int year (year of manufacture)
// - constructor that initializes both fields
// - abstract method play() that returns a String
// - concrete method getInstrumentDetails() that returns information about the instrument
abstract class Instrument {
    private String name; // Nome do instrumento
    protected int year; // Ano de fabricação

    // Construtor para inicializar os campos
    public Instrument(String name, int year) {
        this.name = name;
        this.year = year;
    }

    // Método abstrato que deve ser implementado pelas subclasses
    public abstract String play();

    // Método concreto que retorna detalhes do instrumento
    public String getInstrumentDetails() {
        return "Instrumento: " + name + ", Anos: " + year;
    }

}

// Step 2: Create an interface Tunable
// This should include:
// - abstract method tune() that returns a String
// - abstract method adjustPitch(boolean up) that returns a String (up means increase pitch)
interface Tunable {
    String tune();

    String adjustPitch(boolean up);
}

// Step 3: Create an interface Maintainable
// This should include:
// - abstract method clean() that returns a String
// - abstract method inspect() that returns a String
interface Maintainable {
    String clean();

    String inspect();
}

// Step 4: Create a concrete class StringedInstrument that extends Instrument
// This should include:
// - private int numberOfStrings
// - constructor that initializes name, year, and numberOfStrings
// - implementation of the abstract play() method
// - override getInstrumentDetails() to include number of strings
class StringedInstrument extends Instrument {
    private int numberOfStrings; // Número de cordas

    // Construtor para inicializar os campos
    public StringedInstrument(String name, int year, int numberOfStrings) {
        super(name, year); // Chama o construtor da classe pai
        this.numberOfStrings = numberOfStrings;
    }

    // Implementação do método abstrato play()
    @Override
    public String play() {
        return "Tocando um instrumento de cordas com " + numberOfStrings + " cordas.";
    }

    // Sobrescrita do método getInstrumentDetails() para incluir o número de cordas
    @Override
    public String getInstrumentDetails() {
        return super.getInstrumentDetails() + ", Número de cordas: " + numberOfStrings;
    }
}

// Step 5: Create a concrete class Guitar that extends StringedInstrument 
// and implements Tunable and Maintainable
// This should include:
// - private String guitarType (acoustic, electric, etc.)
// - constructor that initializes all fields
// - implementation of all required interface methods
class Guitar extends StringedInstrument implements Tunable, Maintainable {
    private String guitarType; // Tipo de guitarra (acústica, elétrica, etc.)

    // Construtor para inicializar os campos
    public Guitar(String name, int year, int numberOfStrings, String guitarType) {
        super(name, year, numberOfStrings); // Chama o construtor da classe pai
        this.guitarType = guitarType;
    }

    // Implementação do método tune() da interface Tunable
    @Override
    public String tune() {
        return "Afinando uma guitarra " + guitarType + ".";
    }

    // Implementação do método adjustPitch(boolean up) da interface Tunable
    @Override
    public String adjustPitch(boolean up) {
        return up ? "Ajustando o tom da guitarra " + guitarType + " para cima." : "Ajustando o tom da guitarra " + guitarType + " para baixo.";
    }

    // Implementação do método clean() da interface Maintainable
    @Override
    public String clean() {
        return "Limpando a guitarra " + guitarType + ".";
    }

    // Implementação do método inspect() da interface Maintainable
    @Override
    public String inspect() {
        return "Inspecionando a guitarra " + guitarType + " para manutenção.";
    }

    // Sobrescrita do método getInstrumentDetails() para incluir o tipo de guitarra
    @Override
    public String getInstrumentDetails() {
        return super.getInstrumentDetails() + ", Tipo de guitarra: " + guitarType;
    }

}


// Step 6: Create a concrete class Piano that extends Instrument
// and implements Tunable and Maintainable
// This should include:
// - private boolean isGrand
// - constructor that initializes all fields
// - implementation of the abstract play() method
// - implementation of all required interface methods
class Piano extends Instrument implements Tunable, Maintainable {
    private boolean isGrand; // Indica se o piano é de cauda

    // Construtor para inicializar os campos
    public Piano(String name, int year, boolean isGrand) {
        super(name, year); // Chama o construtor da classe pai
        this.isGrand = isGrand;
    }

    // Implementação do método abstrato play()
    @Override
    public String play() {
        return "Tocando um piano de cauda " + (isGrand ? "de cauda" : "vertical" + ".");
    }

    // Implementação do método tune() da interface Tunable
    @Override
    public String tune() {
        return "Afinando o piano " + (isGrand ? "de cauda" : "vertical") + ".";
    }

    // Implementação do método adjustPitch(boolean up) da interface Tunable
    @Override
    public String adjustPitch(boolean up) {
        return up ? "Ajustando o tom do piano " + (isGrand ? "de cauda" : "vertical") + " para cima." : "Ajustando o tom do piano " + (isGrand ? "de cauda" : "vertical") + " para baixo.";
    }

    // Implementação do método clean() da interface Maintainable
    @Override
    public String clean() {
        return "Limpando o piano " + (isGrand ? "de cauda" : "vertical") + ".";
    }

    // Implementação do método inspect() da interface Maintainable
    @Override
    public String inspect() {
        return "Inspecionando o piano " + (isGrand ? "de cauda" : "vertical") + " para manutenção.";
    }

    // Sobrescrita do método getInstrumentDetails() para incluir se é grand ou upright
    @Override
    public String getInstrumentDetails() {
        return super.getInstrumentDetails() + ", Tipo de piano: " + (isGrand ? "de cauda" : "vertical");

    }
}


// Step 7: Create a public class MusicShop to test the classes
// This should include:
// - main method that:
//   1. Creates an array of Instrument objects including Guitar and Piano instances
//   2. Iterates through the array calling play() for each instrument
//   3. Demonstrates polymorphism by testing if each instrument is Tunable or Maintainable
//      and if so, calls the appropriate methods
public class MusicShop {
    public static void main(String[] args) {
        Instrument[] instruments = {
                new Guitar("Fender Stratocaster", 2020, 6, "Elétrica"),
                new Guitar("Gibson Acoustic", 2018, 6, "Acústica"),
                new Piano("Yamaha Grand", 2015, true),
                new Piano("Kawai Upright", 2019, false)
        };

        // Iterando através do array e chamando play() para cada instrumento
        for (Instrument instrument : instruments) {
            System.out.println(instrument.play());
            System.out.println(instrument.getInstrumentDetails());

            // Verificando se o instrumento é Tunable e chamando os métodos apropriados
            if (instrument instanceof Tunable) {
                Tunable tunableInstrument = (Tunable) instrument;
                System.out.println(tunableInstrument.tune());
                System.out.println(tunableInstrument.adjustPitch(true));
                System.out.println(tunableInstrument.adjustPitch(false));
            }

            // Verificando se o instrumento é Maintainable e chamando os métodos apropriados
            if (instrument instanceof Maintainable) {
                Maintainable maintainableInstrument = (Maintainable) instrument;
                System.out.println(maintainableInstrument.clean());
                System.out.println(maintainableInstrument.inspect());
            }
            System.out.println(); // Linha em branco para melhor legibilidade
        }
    }
}













































