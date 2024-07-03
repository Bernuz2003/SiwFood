package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Cuoco {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@NotBlank(message = "{cuoco.nome.notblank}")
	private String nome;
	@NotBlank(message = "{cuoco.cognome.notblank}")
	private String cognome;
	@NotNull(message = "{cuoco.data.notnull}")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate data;
	@NotBlank(message = "{cuoco.email.notblank}")
	private String email;
	@OneToMany(mappedBy="cuoco")
	private List<Ricetta> ricette;
	private String image;



	public String getImage() {
		return image;
	}

	public void setImagePath(String imagePath) {
		this.image = imagePath;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate dataNascita) {
		this.data = dataNascita;
	}

	public List<Ricetta> getRicette() {
		return ricette;
	}

	public void setRicette(List<Ricetta> ricette) {
		this.ricette = ricette;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cognome, data, email, id, nome, ricette);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuoco other = (Cuoco) obj;
		return Objects.equals(cognome, other.cognome) && Objects.equals(data, other.data)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(ricette, other.ricette);
	}

}