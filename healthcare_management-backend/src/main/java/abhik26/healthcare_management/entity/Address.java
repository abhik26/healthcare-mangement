package abhik26.healthcare_management.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Address street cannot be blank.")
    private String street;

    @NotBlank(message = "Address city cannot be blank.")
    private String city;

    @NotBlank(message = "Address province cannot be blank.")
    private String province;

    @NotBlank(message = "Address country cannot be blank.")
    private String country;

    @NotBlank(message = "Address zip code cannot be blank.")
    @Pattern(regexp = "[1-9][0-9]{5}", message = "Address zip code can only contain 6 digits and cannot start with 0")
    private String zipCode;

    public String getStreet() {
        return street;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
