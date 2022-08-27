package otrs;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner entrada = new Scanner(System.in);
        int opcion;
        do {
            menue();
            System.out.println("Seleccione opción: ");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese su nit de Usuario");
                    String nit = entrada.nextLine();
                    System.out.println("Ingrese su Problema");
                    String problema = entrada.nextLine();
                    String estado = "Creado";
                    Usuario u = new Usuario(nit, problema, estado);
                    break;
                case 2:

                    System.out.println("Operacoines a realizar");
                    System.out.println("1. Trabajar Ticket");
                    System.out.println("2. Resolver Ticket");
                    System.out.println("3. Escalar Ticket");
                    int opcionCola = entrada.nextInt();
                    switch (opcionCola) {
                        case 1:
                            System.out.println("Seleeciono Trabajar Ticket");
                            System.out.println("Ingrese el numero de ticket que desea trabajar: ");
                            leer();

                            break;
                        case 2:
                            System.out.println("Seleeciono Resolver Ticket");
                            System.out.println("Ingrese el numero de ticket que desea Resolver: ");
                            leer();
                            break;
                        case 3:
                            System.out.println("Seleeciono Escalar Ticket");
                            System.out.println("Ingrese el numero de ticket que desea Escalar: ");
                            leer();
                            ColasUtilizarDisponible();
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Seleccone que desea visualizar");
                    System.out.println("1. Reporte 1.");
                    System.out.println("2. Reporte 2.");
                    System.out.println("3. Reporte 3.");
                    System.out.println("4. Visualizar todos los ticket.");
                    int opcionleer = entrada.nextInt();
                    switch (opcionleer) {
                        case 1:
                            System.out.println("1. Reporte 1 Cola de Ayuda");

                            break;
                        case 2:
                            System.out.println("2. Reporte 2 Sopoorte Tecnico.");
                            break;
                        case 3:
                            System.out.println("3. Reporte 3 Desarrollador.");
                            break;
                        case 4:
                            System.out.println("4. Visualizar todos los ticket.");
                            leer();
                            break;
                    }

                    break;

            }
        } while (opcion != 4);


    }


    public static void leer() {

        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("informacion.json")) {
            Object obj = jsonParser.parse(reader);

            JSONArray informacionList = (JSONArray) obj;
            System.out.println("El archivo contiene lo siguiente: ");
            System.out.println(informacionList);
            for (Object informacionn : informacionList) {
                mostrarInformacion((JSONObject) informacionn);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private static void mostrarInformacion(JSONObject jsonObject) {
        JSONObject informacionn = (JSONObject) jsonObject.get("informacionn");//hasta acá funcionaba bien
        //System.out.println("Información:");
       /*int ticket = (int) informacionn.get("ticket");
       System.out.println("Ticket: "+ticket);

       char nitUsuario = (char) informacionn.get("nitUsuario");
       System.out.println("nit: "+nitUsuario);

       String problema = (String) informacionn.get("problema");
       System.out.println("Problema: "+problema);

       String cola = (String) informacionn.get("cola");
       System.out.println("Cola: "+cola);



        */
    }

    private static void menue() {
        System.out.println(" Menu para Gestionar Ticket:");
        System.out.println(" 1. Crear Ticket. ");
        System.out.println(" 2. Gestionar Ticket. ");
        System.out.println(" 3. Visualizar todos los ticket.");
        System.out.println("4. Salir");
    }



    enum ColasUtilizar{
        MesaAyuda, SoporteTecnico, Desarrollador
    }
    public static void ColasUtilizarDisponible(){



         ColasUtilizar oColas = ColasUtilizar.MesaAyuda;
        switch (oColas){
            case MesaAyuda:
                System.out.println("Se agrego a mesa de Ayuda");
                break;
            case SoporteTecnico:
                System.out.println("Se agrego a Soporte Tecnico");
                break;
            case Desarrollador:
                System.out.println("Se agego a Desarrolador");
                break;


        }
    }


private static void ConversionJason() {
    ObjectMapper mapper = new ObjectMapper();
    try {
        Usuario registros = mapper.readValue(new File("informacion.json"), Usuario.class);
      //  System.out.printf("Ticket:"+registros.get);
        System.out.println("NIT: " + registros.getNit());
        System.out.println("Problema: " + registros.getProblema());
        System.out.println("Cola");
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }

}

}
