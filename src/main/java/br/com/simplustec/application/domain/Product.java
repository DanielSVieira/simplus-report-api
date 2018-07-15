package br.com.simplustec.application.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
@EqualsAndHashCode @ToString
@Getter @Setter
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NonNull
	@Size(min = 13, max = 14, message="A quantidade de caracteres informada para o GTIN é inválida")
	private String gtin;
	
	@NotNull
	@NonNull
	@Size(max = 255, message="A descrição informada excede o tamanho suportado")
	private String description;
	
	@NotNull
	@Column(name="last_update")
	private Date lastUpdate;
	
	@NotNull
	@NonNull
	@JoinColumn(name = "company_id")
	@ManyToOne(fetch=FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Company company;
	
}
