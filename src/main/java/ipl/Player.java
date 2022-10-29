package ipl;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Player {


    @JsonProperty("name")
    private String name;

    @JsonProperty("country")
    private String country;

    @JsonProperty("price-in-crores")
    private String price_in_crores;

    @JsonProperty("role")
    private String role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPrice_in_crores() {
        return price_in_crores;
    }

    public void setPrice_in_crores(String price_in_crores) {
        this.price_in_crores = price_in_crores;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
