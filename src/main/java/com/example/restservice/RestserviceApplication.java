package com.example.restservice;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class RestserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestserviceApplication.class, args);
	}

	
}
/* Como o Lombok não estava nas dependências não sabia se podia criar
   essa dependência*/

@RestController
class CidadeDAO 
{
	@PostMapping("/cidade")
	public Cidade save(@RequestBody Cidade cidade)
	{
		return cidade;
	}

	@GetMapping("/cidade")
	public ArrayList<Cidade> read()
	{
		Estado e = new Estado();
		ArrayList<Cidade> cidades = new ArrayList<>();
		e.setId(new Long(0));
		e.setNome("São Paulo");

		for (int i = 0;i < 3;i++)
		{
			cidades.add(new Cidade(new Long(i),"Cidade "+i,e));
		}

		return cidades;
	}

	@PutMapping("/cidade")
	public Cidade update(@RequestBody Cidade cidade)
	{
		return cidade;
	}

	@DeleteMapping("/cidade/{id}")
	public int delete(@PathVariable Long id)
	{
		return 200;
	}
}

class Cidade 
{
	private Long id;
	private String nome;
	private Estado estado;

	public Cidade(Long id, String nome, Estado estado)
	{
		this.setId(id);
		this.setNome(nome);
		this.setEstado(estado);
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public void setEstado(Estado estado)
	{
		this.estado = estado;
	}

	public Long getId()
	{
		return this.id;
	}

	public String getNome()
	{
		return this.nome;
	}

	public Estado getEstado()
	{
		return this.estado;
	}
}

class Estado 
{
	private Long id;
	private String nome;

	public void setId(Long id)
	{
		this.id = id;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public Long getId()
	{
		return this.id;
	}

	public String getNome()
	{
		return this.nome;
	}
}