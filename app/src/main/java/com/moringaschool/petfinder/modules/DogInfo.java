
package com.moringaschool.petfinder.modules;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class DogInfo {

    @SerializedName("height")
    @Expose
    String height;
    @SerializedName("weight")
    @Expose
     String weight;
    @SerializedName("life")
    @Expose
     String life;
    @SerializedName("breedGroup")
    @Expose
     String breedGroup;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DogInfo() {
    }

    /**
     * 
     * @param weight
     * @param life
     * @param breedGroup
     * @param height
     */
    public DogInfo(String height, String weight, String life, String breedGroup) {
        super();
        this.height = height;
        this.weight = weight;
        this.life = life;
        this.breedGroup = breedGroup;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getLife() {
        return life;
    }

    public void setLife(String life) {
        this.life = life;
    }

    public String getBreedGroup() {
        return breedGroup;
    }

    public void setBreedGroup(String breedGroup) {
        this.breedGroup = breedGroup;
    }

}
