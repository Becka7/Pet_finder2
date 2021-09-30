
package com.moringaschool.petfinder.modules;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.moringaschool.petfinder.modules.DogInfo;

import org.parceler.Parcel;

@Parcel
public class PetSearchResponse {

    @SerializedName("breedName")
    @Expose
    String breedName;
    @SerializedName("image")
    @Expose
     String image;
    @SerializedName("description")
    @Expose
    String description;
    @SerializedName("dogInfo")
    @Expose
     DogInfo dogInfo;
    @SerializedName("id")
    @Expose
     String id;

    /**
     * No args constructor for use in serialization
     * 
     */
    public PetSearchResponse() {
    }

    /**
     * 
     * @param image
     * @param breedName
     * @param description
     * @param id
     * @param dogInfo
     */
    public PetSearchResponse(String breedName, String image, String description, DogInfo dogInfo, String id) {
        super();
        this.breedName = breedName;
        this.image = image;
        this.description = description;
        this.dogInfo = dogInfo;
        this.id = id;
    }

    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DogInfo getDogInfo() {
        return dogInfo;
    }

    public void setDogInfo(DogInfo dogInfo) {
        this.dogInfo = dogInfo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
