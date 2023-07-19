public class Persona {
    //Constantes
    private static final char SEXO_DE = 'H';
    public static final int INFRAPESO = -1;
    public static final int PESO_IDEAL = 0;
    public static final int SOBREPESO = 1;
    //Atributos
    private String nombre;
    private int edad;
    private String DNI;
    private char sexo;
    private double peso;
    private double altura;

    public Persona() {

    }

    public Persona(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }

    public Persona(String nombre, int edad, char sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        generaNumeroIdentidad();
        comprobarSexo();
        this.peso = peso;
        this.altura = altura;
    }

    /**
     * esMayorDeEdad():
     * indica si es mayor de edad, devuelve un booleano.
     * Indica si la persona es mayor de edad
     *
     * @return true si es mayor de edad y false es menor de edad
     */
    public boolean esMayorDeEdad(){
        if (this.edad >= 18){
            return true;
        }else {
            return false;
        }
    }

    /*
    comprobarSexo(char sexo):
    comprueba que el sexo introducido es correcto. Si no es correcto, sera H. No sera visible al exterior.
    */
    private void comprobarSexo(){
        if(this.sexo !=  'H' && this.sexo != 'M'){
            this.sexo = SEXO_DE;
        }
    }

    /*
    generaLetraNumeroIdentidad():
    genera un número aleatorio de 8 cifras, genera a partir de este su número su letra correspondiente.
    Este método sera invocado cuando se construya el objeto. Puedes dividir el método para que te sea más fácil. No será visible al exterior.
     */
    private char generaLetraNumeroIdentidad(int res){
        char letras[]={'T', 'R', 'W', 'A', 'G', 'M', 'Y',
                'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z',
                'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        return letras[res];
    }
    private void generaNumeroIdentidad(){
        final int divisor = 23;
        //Generamos un número de 8 digitos
        //Math.floor() en Java se utiliza para encontrar el valor entero más grande que es menor o igual al argumento y es igual al entero matemático de un valor double.
        //Math.random() es un método de la clase Math que se utiliza en Java para generar números aleatorios.
        int numDNI = ((int) Math.floor(Math.random() * (100000000 - 10000000) + 10000000));
        int res = numDNI - (numDNI / divisor * divisor);
        //Calculamos la letra del DNI
        char letraDNI = generaLetraNumeroIdentidad(res);
        //Pasamos el DNI a String
        DNI = Integer.toString(numDNI) + letraDNI;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    /*
    calcularIMC():
    calculara si la persona esta en su peso ideal (peso en kg/(altura^2  en m)),
    si esta fórmula devuelve un valor menor que 20, la función devuelve un -1, si devuelve un número entre 20 y 25 (incluidos),
    significa que esta por debajo de su peso ideal la función devuelve un 0
    y si devuelve un valor mayor que 25 significa que tiene sobrepeso, la función devuelve un 1. Te recomiendo que uses constantes para devolver estos valores.
     */
    /**
     * Calcula el indice de masa corporal
     *
     * @return codigo numerico
     * <ul><li>-1: la persona esta por debajo de su peso ideal</li>
     * <li>0: la persona esta en su peso ideal</li>
     * <li>1: la persona esta por encima de su peso ideal</li></ul>
     */
    public int calcularIMC(){
        //La función Math.pow() es un método estático de Math que retorna la base elevada al exponente
        //Calculamos el peso de la persona
        double pesoActual = peso/(Math.pow(altura,2));
        //Segun el peso, devuelve un codigo
        if(pesoActual >= 20 && pesoActual <= 25){
            return PESO_IDEAL;
        } else if (pesoActual < 20) {
            return INFRAPESO;
        }else {
            return SOBREPESO;
        }
    }

    /**
     * Devuelve informacion del objeto
     *
     * @return cadena con toda la informacion
     */
    @Override
    public String toString() {
        String sexo;
        if (this.sexo == 'H') {
            sexo = "hombre";
        } else {
            sexo = "mujer";
        }
        return "Informacion de la persona:\n"
                + "Nombre: " + nombre + "\n"
                + "Sexo: " + sexo + "\n"
                + "Edad: " + edad + " años\n"
                + "DNI: " + DNI + "\n"
                + "Peso: " + peso + " kg\n"
                + "Altura: " + altura + " metros\n";
    }
}
