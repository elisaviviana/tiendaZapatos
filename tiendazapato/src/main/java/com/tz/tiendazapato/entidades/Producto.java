package com.tz.tiendazapato.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name = "cod_producto", nullable = true, length = 150)
	private String codProducto;
	@Column(name = "cantidad", nullable = true, length = 150)
	private Integer cantidad;
	@Column(name = "marca", nullable = true, length = 255)
	private String marca;
	@Column(name = "modelo", nullable = true, length = 255)
	private String modelo;
	@Column(name = "categoria", nullable = true, length = 255)
	private String categoria;
	@Column(name = "genero", nullable = true, length = 255)
	private String genero;
	@Column(name = "descripcion", nullable = true, length = 255)
	private String descripcion;
	@Column(name="precio", nullable = true)	
	private Integer precio;
	@Column(name="activo", nullable = true)	
	private Integer activo=1;
	@Column(name="img", nullable = true)	
	private String img;		

	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Integer getActivo() {
		return activo;
	}
	public void setActivo(Integer activo) {
		this.activo = activo;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getCodProducto() {
		return codProducto;
	}
	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
