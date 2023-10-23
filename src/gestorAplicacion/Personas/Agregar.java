case 3: 
  int opcionEmp;
  int opcionEmp1;
  do {
  System.out.println("-------------------------------------------------------");
  System.out.println("¿Que deseas hacer?");
  System.out.println("1. Consultar lista de Empleados");
  System.out.println("2. Consultar lista de Aspirantes a Empleado");
  System.out.println("3. Agregar ficha de Aspirante a Empleado");
  System.out.println("4. Contratar Empleado");
  System.out.println("5. Despedir Empleado");
  System.out.println("6. Volver al menú de funcionalidades");
  System.out.print("Escribe el número de la opción que necesitas: ");
  opcionEmp= (int) readLong();
  switch(opcionEmp) {

  case 1:System.out.println("-------------------------------------------------------"); 
    System.out.println("Lista de Empleados: ")
    if (restaurante.getEmpleados().size()==0){
      System.out.println("No hay empleados");
    } else {
      mostrarEmpleados(restaurante.getEmpleados());
    }
    System.out.println("Escribe el nùmero del empleado para ver mas detalles")
    num= (int) readLong();
    indice=num-1
    System.out.println("-------------------------------------------------------");
    if (indice>=0 && indice<restaurante.getEmpleados().size()) {
      System.out.print(restaurante.getEmpleados().get(indice).detallesEmpleado());
    } else
    {
      System.out.println("El nùmero ingresado no es vàlido, por favor ingresa un nùmero que corresponda a un empleado");
    }
    System.out.println("-------------------------------------------------------");
    break;

  case 2:System.out.println("-------------------------------------------------------"); 
    System.out.println("Lista de Aspirantes a Empleados: ")
    if (restaurante.getAspEmpleados().size()==0){
      System.out.println("No hay aspirantes a empleados");
    } else {
      mostrarEmpleados(restaurante.getAspEmpleados());
    }
    System.out.println("Escribe el nùmero del aspirante para ver mas detalles")
    num= (int) readLong();
    indice=num-1
    System.out.println("-------------------------------------------------------");
    if (indice>=0 && indice<restaurante.getAspEmpleados().size()) {
      System.out.print(restaurante.getAspEmpleados().get(indice).detallesEmpleado());
    } else
    {
      System.out.println("El nùmero ingresado no es vàlido, por favor ingresa un nùmero que corresponda a un empleado");
    }
    System.out.println("-------------------------------------------------------");
    break;

  case 3: do {
     System.out.println("-------------------------------------------------------");
     System.out.println("¿Que ficha deseas agregar?");
     System.out.println("1. Agregar ficha de Cocinero");
     System.out.println("2. Agregar ficha de Mesero"); 
     System.out.println("3. Agregar ficha de Domiciliario");
     System.out.print("Escribe el número de la opción que necesitas: ");
     opcionEmp1= (int) readLong();
     switch(opcionEmp1) {
       case 1:System.out.println("-------------------------------------------------------");  
       System.out.println("Ingresa el nombre");
       String nombre= readln();
       System.out.println("Ingresa la cedula");
       Long cedula= readLong();
       System.out.println("Ingresa el turno");
       String tipoturno= readln().toUpperCase();
         if (tipoturno=="SEMANA"){
           Turno turno = turno1
         } else if (tipoturno=="SABADO") {
           Turno turno = turno2
         } else if (tipoturno=="DOMINGO") {
           Turno turno = turno3
         }
       Empleado empleado = new Cocinero(nombre, cedula, "Cocinero", restaurante, turno);
        restaurante.getAspEmpleados().add(empleado);
       case 2:System.out.println("-------------------------------------------------------");  
        System.out.println("Ingresa el nombre");
        String nombre= readln();
        System.out.println("Ingresa la cedula");
        Long cedula= readLong();
        System.out.println("Ingresa el turno");
        String tipoturno= readln().toUpperCase();
          if (tipoturno=="SEMANA"){
            Turno turno = turno1
          } else if (tipoturno=="SABADO") {
            Turno turno = turno2
          } else if (tipoturno=="DOMINGO") {
            Turno turno = turno3
          }
        Empleado empleado = new Mesero(nombre, cedula, "Mesero", restaurante, turno);
         restaurante.getAspEmpleados().add(empleado);
       case 3:System.out.println("-------------------------------------------------------");  
          System.out.println("Ingresa el nombre");
          String nombre= readln();
          System.out.println("Ingresa la cedula");
          Long cedula= readLong();
          System.out.println("Ingresa el turno");
          String tipoturno= readln().toUpperCase();
            if (tipoturno=="SEMANA"){
              Turno turno = turno1
            } else if (tipoturno=="SABADO") {
              Turno turno = turno2
            } else if (tipoturno=="DOMINGO") {
              Turno turno = turno3
            }
          Empleado empleado = new Domiciliario(nombre, cedula, "Domiciliario", restaurante, turno);
           restaurante.getAspEmpleados().add(empleado);
       case 4:
         break;
  }while(opcionEmp2!=4);break;

  case 4:System.out.println("-------------------------------------------------------"); 
    System.out.println("Lista de Aspirantes a Empleados: ")
    if (restaurante.getAspEmpleados().size()==0){
      System.out.println("No hay aspirantes a empleados");
    } else {
      mostrarEmpleados(restaurante.getAspEmpleados());
    }
    System.out.println("Escribe el nùmero del aspirante que deseas contratar")
    num= (int) readLong();
    indice=num-1
    System.out.println("-------------------------------------------------------");
    if (indice>=0 && indice<restaurante.getAspEmpleados().size()) {
      restaurante.contratarEmpleado(restaurante.getAspEmpleados().get(indice));
      restaurante.getAspEmpleados().remove(indice);
    } else
    {
      System.out.println("El nùmero ingresado no es vàlido, por favor ingresa un nùmero que corresponda a un empleado");
    }
    System.out.println("-------------------------------------------------------");
    break;

  case 5:System.out.println("-------------------------------------------------------");
    System.out.println("Lista de Empleados: ")
      if (restaurante.getEmpleados().size()==0){
        System.out.println("No hay empleados");
      } else {
        mostrarEmpleados(restaurante.getEmpleados());
      }
      System.out.println("Escribe el nùmero del empleado que desea despedir")
      num= (int) readLong();
      indice=num-1
      System.out.println("-------------------------------------------------------");
      if (indice>=0 && indice<restaurante.getEmpleados().size()) {
        restaurante.getEmpleados().remove(indice);
      } else
      {
        System.out.println("El nùmero ingresado no es vàlido, por favor ingresa un nùmero que corresponda a un empleado");
      }
      System.out.println("-------------------------------------------------------");
      break;

  case 6:
    break;
  }
}while(opcionEmp!=6);break;


//Metodo para mostrar algunos datos de los empleados
public static void mostrarEmpleados(ArrayList<Empleados> Empleado) {
  short cont=1;
  for (Empleado e:Empleado) {
    System.out.println(cont+". Nombre:"+e.getNombre()+"- Puesto"+e.getPuesto()+"- Turno: "+e.getTurno().getTipo();
    cont++;
  }
}

//Metodo para mostrar detalles de los empleados
public static void detallesEmpleado(){
  return 
    "\n   Nombre: " + this.getNombre()+
    "\n   Cedula: " + this.getCedula()+
    "\n   Puesto: " + this.getPuesto()+
    "\n   Turno: " + this.getTurno().getTipo()+
    "\n   Salario: " + this.getTurno().getSalario();
    "\n"+" "+this.Puntuacion()
}


//Metodo para mostrar la puntuacion del Empleado
public String puntuacion(){
  return "La puntacion del Empleado es: "+ this.getPuntuacion();
}

//Metodo para mostrar la descripcion del trabajo del Empleado
public String trabajo(){
  return "Empleado del restaurante"
}

package gestorAplicacion.Personas;

import java.io.Serializable;

public class Cocinero extends Empleado implements Serializable{
  private static final long serialVersionUID = 1L;

  public Cocinero() { }
  public Cocinero(String nombre, Long cedula, String puesto, Restaurante restaurante, Turno turno){
      super(nombre, cedula, puesto, restaurante, turno);
   // Inicializa la lista de turnos
      this.turnos = new ArrayList<>();
   // Añade el turno a la lista
      this.turnos.add(turno); 
      this.setFechaContratacion(new Date()); 
  }

  //Metodo para mostrar la puntuacion del Empleado
  public String puntuacion(){
    return "La puntacion del Cocinero es: "+ this.getPuntuacion();
  }

  //Metodo para mostrar la descripcion del trabajo del Empleado
  public String trabajo(){
    return "Cocinero, es quien cocina y prepara alimentos en el restaurante."
  }
}

package gestorAplicacion.Personas;

import java.io.Serializable;

public class Domiciliario extends Empleado implements Serializable{
  private static final long serialVersionUID = 1L;

  public Domiciliario() { }
  public Domiciliario(String nombre, Long cedula, String puesto, Restaurante restaurante, Turno turno){
      super(nombre, cedula, puesto, restaurante, turno);
   // Inicializa la lista de turnos
      this.turnos = new ArrayList<>();
   // Añade el turno a la lista
      this.turnos.add(turno); 
      this.setFechaContratacion(new Date()); 
  }

  //Metodo para mostrar la puntuacion del Empleado
  public String puntuacion(){
    return "La puntacion del Domiciliario es: "+ this.getPuntuacion();
  }

  //Metodo para mostrar la descripcion del trabajo del Empleado
  public String trabajo(){
    return "Domiciliario, es la persona encargada de entregar los pedidos a domicilio."
  }
}


package gestorAplicacion.Personas;

import java.io.Serializable;

public class Mesero extends Empleado implements Serializable{
  private static final long serialVersionUID = 1L;

  public Mesero() { }
  public Mesero(String nombre, Long cedula, String puesto, Restaurante restaurante, Turno turno){
      super(nombre, cedula, puesto, restaurante, turno);
   // Inicializa la lista de turnos
      this.turnos = new ArrayList<>();
   // Añade el turno a la lista
      this.turnos.add(turno); 
      this.setFechaContratacion(new Date()); 
  }

  //Metodo para mostrar la puntuacion del Empleado
  public String puntuacion(){
    return "La puntacion del Mesero es: "+ this.getPuntuacion();
  }

  //Metodo para mostrar la descripcion del trabajo del Empleado
  public String trabajo(){
    return "Mesero, es quien se encarga de atender y servir a la clientela."
  }
}
