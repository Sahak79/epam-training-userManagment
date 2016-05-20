package com.epam.model;

import com.epam.model.converter.UserProfileConverter;
import com.epam.model.converter.UserStatusConverter;
import com.epam.model.lcp.UserProfile;
import com.epam.model.lcp.UserStatus;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Created by Sahak_Babayan on 3/29/2016.
 */
@Entity
@Table(name = "`user`")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
    private Long id;

    @Column(name = "status_id")
    @Convert(converter = UserStatusConverter.class)
    private UserStatus status;

    @Column(name = "type_id")
    @Convert(converter = UserProfileConverter.class)
    private UserProfile profile;

    @NotEmpty(message = "{err.field.first.name.required}")
    @Column(name = "firstname")
    private String firstName;

    @NotEmpty(message = "{err.field.last.name.required}")
    @Column(name = "lastname")
    private String lastName;

	@Email(message = "{err.field.email.invalid}")
    @NotEmpty(message = "{err.field.email.required}")
    @Column(name = "email")
    private String email;

    @NotEmpty(message = "{err.field.password.required}")
    @Column(name = "password")
    private String password;
  
    @ManyToMany(mappedBy = "applicants")
    private List<Job> appliedJobs;
    
//    @OneToMany(mappedBy = "owner")
//    private List<Job> postedJobs;
    
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id", insertable =  false, updatable = false)
	private UserType userType;

	public User(){}

    public User(User user) {
        this.id = user.id;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.email = user.email;
        this.password = user.password;
        this.status = user.status;
        this.profile = user.profile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public UserProfile getProfile() {
        return profile;
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }

//	public List<Job> getPostedJobs() {
//		return postedJobs;
//	}
//
//	public void setPostedJobs(List<Job> postedJobs) {
//		this.postedJobs = postedJobs;
//	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

    
//    public List<Job> getJobs() {
//		return jobs;
//	}
//
//	public void setJobs(List<Job> jobs) {
//		this.jobs = jobs;
//	}
//
//	@Override
//	public String toString() {
//		return "User [id=" + id + ", status=" + status + ", profile=" + profile + ", firstName=" + firstName
//				+ ", lastName=" + lastName + ", email=" + email + ", password=" + password + ", jobs=" + jobs + "]";
//	}

	
}

