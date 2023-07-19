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

        Persona persona1 = new Persona(nombre, edad, sexo, peso, altura);

        JOptionPane.showMessageDialog(null,nombre);
        muestraMensajePeso(persona1);
        muestraMayorDeEdad(persona1);
        JOptionPane.showMessageDialog(null,persona1.toString());
    }

    public static void muestraMensajePeso(Persona p) {
        int IMC = p.calcularIMC();
        switch (IMC) {
            case Persona.PESO_IDEAL:
                JOptionPane.showMessageDialog(null,"La persona esta en su peso ideal");
                break;
            case Persona.INFRAPESO:
                JOptionPane.showMessageDialog(null,"La persona esta por debajo de su peso ideal");
                break;
            case Persona.SOBREPESO:
                JOptionPane.showMessageDialog(null,"La persona esta por encima de su peso ideal");
                break;
        }
    }

    public static void muestraMayorDeEdad(Persona p) {

        if (p.esMayorDeEdad()) {
            JOptionPane.showMessageDialog(null,"La persona es mayor de edad");
        } else {
            JOptionPane.showMessageDialog(null,"La persona no es mayor de edad");
        }
    }
}
