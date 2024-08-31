package abhik26.healthcare_management.entity;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import abhik26.healthcare_management.entity.enums.UserAuthority;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    @Email(message = "Invalid email.")
    @NotBlank(message = "Email can not be blank.")
    private String email;

    @Column(name = "password", nullable = false)
    @NotBlank(message = "Password can not be blank.")
    private String password;

    @Column(name = "first_name", nullable = false)
    @NotBlank(message = "First name can not be blank.")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotBlank(message = "Last name can not be blank.")
    private String lastName;

    @Column(name = "contact_number", nullable = false)
    @Pattern(regexp = "[1-9][0-9]{9}", message = "Invalid contact number, it needs to have 10 digits and cannot not start with 0.")
    @NotBlank(message = "Contact number cannot be blank.")
    private String contactNumber;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id", nullable = false, unique = true)
    @NotNull(message = "Address cannot be null.")
    @Valid
    private Address address;

    @Column(name = "date_of_birth", nullable = false)
    @NotNull(message = "Date of birth cannot be null")
    private Date dateOfBirth;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @NotEmpty(message = "Authorities cannot be empty.")
    @Valid
    private Set<UserAuthority> authorities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Set<UserAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<UserAuthority> roles) {
        this.authorities = roles;
    }

    @PrePersist
    @PreUpdate
    private void pre() {
        this.email = this.email != null ? this.email.toLowerCase() : null;

        if (this.firstName != null) {
            List<String> nameWords = Arrays.asList(this.firstName.trim().split("\\s+"));

            this.firstName = nameWords.stream().map((word) -> {
                return word = word.substring(0, 1).toUpperCase()
                        .concat(word.substring(1).toLowerCase());
            }).collect(Collectors.joining(" "));
        }

        if (this.lastName != null) {
            List<String> nameWords = Arrays.asList(this.lastName.trim().split("\\s+"));

            this.lastName = nameWords.stream().map(word -> {
                return word = word.substring(0, 1).toUpperCase()
                        .concat(word.substring(1).toLowerCase());
            }).collect(Collectors.joining(" "));
        }
    }
}
