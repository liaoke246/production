package com;

public class User {
    private  String id;
    private  String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    User(){

    }

    User(String name,String id){
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

class person extends User{

    public String id;
    public  String name;

    public person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public person() {
    }

    @Override
    public String toString() {
        return "person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


}