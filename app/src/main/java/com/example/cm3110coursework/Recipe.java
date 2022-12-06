package com.example.cm3110coursework;

public class Recipe {



    public Recipe() {

    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "idCategory=" + idCategory +
                ", strCategory='" + strCategory + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int idCategory;
    public String strCategory;
    public String description;
}
