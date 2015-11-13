package cbsd.lab11.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Theatre {
	    @Id
	    @GeneratedValue
	    Long id;
	    int number;
//	    @Cascade({CascadeType.ALL})
//	   @OneToMany(fetch = FetchType.LAZY)
//    	List<Movie> movies;
	    
	
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
//	public List<Movie> getMovies() {
//		return movies;
//	}
//	public void setMovies(List<Movie> movies) {
//		this.movies = movies;
//	}
		}
	    
	    
	    

