package org.jsp.reservationapi.dto;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Bus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false,name = "from_loc")
	private String from;
	
	@Column(nullable = false,name = "to_loc")
	private String to;
	
	@Column(nullable = false)
	private String bus_no;
	
	@Column(nullable = false,name = "date_of_departure")
	private LocalDate dop;
	
	@Column(nullable = false)
	private int no_s;
	
	private Time dep_time;
	private Time arr_time;
	private String img_url;
	private double cost_per_seat;
	
	
	@ManyToOne()
	@JoinColumn(name="admin_id")
	@JsonIgnore
	private Admin admin;
	
	@OneToMany(mappedBy = "bus")
	private List<Ticket> tickets;

}
