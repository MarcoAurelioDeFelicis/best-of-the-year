package it.madefelicis.best_of_the_year.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import it.madefelicis.best_of_the_year.model.Movie;
import it.madefelicis.best_of_the_year.model.Song;
import it.madefelicis.best_of_the_year.model.User;

@Controller
public class indexController {
	
	@GetMapping("/utente")
	public String users (Model model) {
		
		User io = new User();
		io.setName("Marco");
		io.setSurname("De Felicis");
		
		model.addAttribute("user", io);
		
		return "users";
	}
	

	private List<Movie> getBestMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "Movie1"));
        movies.add(new Movie(2, "Movie2"));
        movies.add(new Movie(3, "Movie3"));
        return movies;
    }
	private List<Song> getBestSongs() {
		List<Song> songs = new ArrayList<>();
		songs.add(new Song(1, "Song1"));
		songs.add(new Song(2, "Song2"));
		songs.add(new Song(3, "Song3"));
		return songs;
	}
	
	@RequestMapping("/movies")
    public String movies(Model model) {
        List<Movie> movies = getBestMovies();
        model.addAttribute("movies", movies);
        return "movies";
    }
	@RequestMapping("/songs")
	public String songs(Model model) {
		List<Song> songs = getBestSongs();
		model.addAttribute("songs", songs);
		return "songs";
	}
	
	@RequestMapping("/homes")
	public String homes(Model model) {
		return "homes";
		
	}
	
	 @RequestMapping("/movies/{id}")
	    public String movieDetail(@PathVariable int id, Model model) {
	        List<Movie> movies = getBestMovies();
	        for (Movie m : movies) {
	            if (m.getId() == id) {
	                model.addAttribute("movie", m);
	                break;
	            }
	        }
	        return "movieDetail";
	    }
	 @RequestMapping("/songs/{id}")
	 public String songDetail(@PathVariable int id, Model model) {
		 List<Song> songs = getBestSongs();
		 for (Song s : songs) {
			 if (s.getId() == id) {
				 model.addAttribute("song", s);
				 break;
			 }
		 }
		 return "songDetail";
	 }
}
