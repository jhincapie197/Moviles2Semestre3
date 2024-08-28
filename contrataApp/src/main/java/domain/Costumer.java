package domain;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Costumer extends User{

    private String costumerType;

    //Generar constructor

    public Costumer(){
        super(); //Se coloca super para que llame al constructor de la clase padre
    }

    public Costumer(int idUser, String userName, String lastName, String email, String phone, String address, String city, String state, String country, UserType userType, String password, String costumerType) {
        super(idUser, userName, lastName, email, phone, address, city, state, country, userType, password);
        this.costumerType = costumerType;
    }

    //Getter and Setter

    public String getCostumerType() {
        return costumerType;
    }

    public void setCostumerType(String costumerType) {
        this.costumerType = costumerType;
    }


    List<List<Object>> users = new ArrayList<>();


    //Metodos

    @Override
    public void createUser() {

        ArrayList<Object> user = new ArrayList<Object>(); //Para guardar como una lista

        super.createUser();
        System.out.println("Ingrese el tipo de costumer: ");
        costumerType = sc.nextLine();

        user.add(idUser);
        user.add(userName);
        user.add(email);
        user.add(userType.getTypeName());
        user.add(costumerType);
        user.add(users);


    }

    @Override
    public void listUser() {
        super.listUser();
        for (Object user: users){
            System.out.println(user);
        }
    }

    @Override
    public void updateUSer() {
        super.updateUSer();
    }

    @Override
    public void deleteUser() {
        super.deleteUser();
    }
}
