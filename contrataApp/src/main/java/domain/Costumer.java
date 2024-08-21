package domain;

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

    //Metodos

    @Override
    public void createUser() {
        super.createUser();
    }

    @Override
    public void listUser() {
        super.listUser();
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
