/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gamezone.model;

/**
 *
 * @author Jose Rodriguez
 */
public class VideoGame extends Product{
    private String platform;
    private String genre;
    private String ageRating;

    public VideoGame(String platform, String genre, String ageRating, String id, String title, double price, int availableQuantity) {
        super(id, title, price, availableQuantity);
        this.platform = platform;
        this.genre = genre;
        this.ageRating = ageRating;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    @Override
    public String getDescription() {
        return "VideoGame{" + "platform=" + platform + ", genre=" + genre + ", ageRating=" + ageRating + '}';
    }
    
    @Override
    public String getProductType(){
        return "Videogame";
    }
}
