package domain;

import java.util.Scanner;

public class UserType {

    Scanner sc = new Scanner(System.in);

    private int idType;
    private String typeName;

    //Generar constructor (Se recomienda crear uno vacío y despues uno lleno)

    public UserType(){

    }

    public UserType(int idType, String typeName) {
        this.idType = idType;
        this.typeName = typeName;
    }

    //Generar los Getter and Setter


    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    //Metodos

    public void createUserType(){

        System.out.println("Ingrese el id: ");
        idType = sc.nextInt();

        sc.nextLine();

        System.out.println("Ingrese el nombre del tipo de cliente");
        typeName = sc.nextLine();

    }

    public void listUserType(){

    }

}