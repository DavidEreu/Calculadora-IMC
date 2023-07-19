import javax.swing.*;

public class PersonaMain {
    public static void main(String[] args) {

        //Introducimos los datos
        String nombre = JOptionPane.showInputDialog("Introduce el nombre");

        String texto = JOptionPane.showInputDialog("Introduce la edad");
        int edad = Integer.parseInt(texto);

        texto = JOptionPane.showInputDialog("Introduce el sexo");
        char sexo = texto.charAt(0);

        texto = JOptionPane.showInputDialog("Introduce el peso");
        double peso = Double.parseDouble(texto);

        texto = JOptionPane.showInputDialog("Introduce la altura");
        double altura = Double.parseDouble(texto);

        //Creamos objetos con cada constructor
        Persona persona1 = new Persona();
        Persona persona2 = new Persona(nombre, edad, sexo);
        Persona persona3 = new Persona(nombre, edad, sexo, peso, altura);

        //Los datos que no esten completos los insertamos con los metodos set
        persona1.setNombre("Laura");

        persona1.setEdad(30);
        persona1.setSexo('M');
        persona1.setPeso(60);
        persona1.setAltura(1.60);

        persona2.setPeso(90.5);
        persona2.setAltura(1.80);

        //Usamos metodos para realizar la misma accion para cada objeto
        System.out.println("Persona1");
        muestraMensajePeso(persona1);
        muestraMayorDeEdad(persona1);
        System.out.println(persona1.toString());

        System.out.println("Persona2");
        muestraMensajePeso(persona2);
        muestraMayorDeEdad(persona2);
        System.out.println(persona2.toString());

        System.out.println("Persona3");
        muestraMensajePeso(persona3);
        muestraMayorDeEdad(persona3);
        System.out.println(persona3.toString());
    }

    public static void muestraMensajePeso(Persona p) {
        int IMC = p.calcularIMC();
        switch (IMC) {
            case Persona.PESO_IDEAL:
                System.out.println("La persona esta en su peso ideal");
                break;
            case Persona.INFRAPESO:
                System.out.println("La persona esta por debajo de su peso ideal");
                break;
            case Persona.SOBREPESO:
                System.out.println("La persona esta por encima de su peso ideal");
                break;
        }
    }

    public static void muestraMayorDeEdad(Persona p) {

        if (p.esMayorDeEdad()) {
            System.out.println("La persona es mayor de edad");
        } else {
            System.out.println("La persona no es mayor de edad");
        }
    }
}
