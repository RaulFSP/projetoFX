package application.model;

import java.util.Objects;

public class Usuario
{
	private String nome, cpf, telefone, endereco, numero, cidade;
	private Estado estado;


	public Usuario(String nome, String cpf, String telefone, String endereco, String numero, String cidade,
			Estado estado)
	{
		
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
	}



	public Usuario()
	{
		
	}



	public String getNome()
	{
		return nome;
	}



	public void setNome(String nome)
	{
		this.nome = nome;
	}



	public String getCpf()
	{
		return cpf;
	}



	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}



	public String getTelefone()
	{
		return telefone;
	}



	public void setTelefone(String telefone)
	{
		this.telefone = telefone;
	}



	public String getEndereco()
	{
		return endereco;
	}



	public void setEndereco(String endereco)
	{
		this.endereco = endereco;
	}



	public String getNumero()
	{
		return numero;
	}



	public void setNumero(String numero)
	{
		this.numero = numero;
	}



	public String getCidade()
	{
		return cidade;
	}



	public void setCidade(String cidade)
	{
		this.cidade = cidade;
	}



	public Estado getEstado()
	{
		return estado;
	}



	public void setEstado(Estado estado)
	{
		this.estado = estado;
	}



	@Override
	public int hashCode()
	{
		return Objects.hash(cidade, cpf, endereco, estado, nome, numero, telefone);
	}



	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(cidade, other.cidade) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(endereco, other.endereco) && estado == other.estado
				&& Objects.equals(nome, other.nome) && Objects.equals(numero, other.numero)
				&& Objects.equals(telefone, other.telefone);
	}

	

	
	

	
	
}
