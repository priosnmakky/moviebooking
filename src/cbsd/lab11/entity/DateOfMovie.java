package cbsd.lab11.entity;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
@Entity
public class DateOfMovie {
	   @Id
	   @GeneratedValue
	   Long id;
	   
//	   @NotNull(message = "Please Enter showtime")
//	    @Min(value = 8, message = "showtime must more than 8.0")
//	   @Max(value = 21, message = "showtime must less than 21.0")
//	     @NumberFormat(style = NumberFormat.Style.NUMBER)
	   @NumberFormat(pattern="#.##")
	   Double showtime;
//	   @NotNull(message = "Please Enter endtime")
//	    @Min(value = 8, message = "endtime must more than 8.0")
//	   @Max(value = 21, message = "endtime must less than 21.0")
	   
	   @NumberFormat(style = NumberFormat.Style.CURRENCY,pattern="#.##")
	   Double endtime;
      @OneToOne (fetch = FetchType.EAGER)
       @Cascade({CascadeType.ALL})
       Movie movie;
       
//       @Cascade({CascadeType.ALL})
//	   @OneToMany(fetch = FetchType.EAGER)
//    	List<Seat> seats;
    
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getShowtime() {
		return showtime;
	}
	public void setShowtime(Double showtime) {
		this.showtime = showtime;
	}
	public Double getEndtime() {
		return endtime;
	}
	public void setEndtime(Double endtime) {
		this.endtime = endtime;
	}
	public Movie getMovie() {
		return movie;
	}
	
       
       
}
