package cbsd.lab11.entity;






import org.hibernate.annotations.Cascade;


import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by narongrit on 2/28/14.
 */
@Entity
public class Movie {

    /*id:String
    - title:String
    - amount:int
    - numberOfDisc:int
    - releaseDate:Date
    - unitPrice:double
    - type:MediaType
    - genre:Genre
    - status:Status
    - quantity:int
    */

    @Id
    @GeneratedValue
  
    Long id;
    @NotEmpty(message = "Please Enter Name")
    String name;
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    int duration;
	@NotEmpty(message = "Please Enter release date")

    String releaseDate;
	
	String Genres;
	
	String director;
	
	String antor;
	String synopsis;
	
	//String showtime;
	
///	String endtime;
	@Cascade({CascadeType.ALL})
    @OneToMany(fetch = FetchType.EAGER)
	List<Seat> seats;
  
	public List<Seat> getSeats() {
		return seats;
	
	}
public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getGenres() {
		return Genres;
	}

	public void setGenres(String genres) {
		Genres = genres;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getAntor() {
		return antor;
	}

	public void setAntor(String antor) {
		this.antor = antor;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

 
 
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Cascade({CascadeType.ALL})
    @OneToOne (fetch = FetchType.EAGER)
    Image image;



    

}
