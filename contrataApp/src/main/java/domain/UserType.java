package domain;

public class UserType {

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

    }

    public void listUserType(){

    }

}
