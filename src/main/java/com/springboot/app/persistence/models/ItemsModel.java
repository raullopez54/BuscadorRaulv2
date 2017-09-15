package com.springboot.app.persistence.models;


public class ItemsModel
{

  private int id;
  private String nombre;
  private String descripcion;
  private String url;
  private int fila;


  public int getId()
  {
    return id;
  }


  public void setId(int id)
  {
    this.id = id;
  }


  public String getNombre()
  {
    return nombre;
  }


  public void setNombre(String nombre)
  {
    this.nombre = nombre;
  }


  public String getDescripcion()
  {
    return descripcion;
  }


  public void setDescripcion(String descripcion)
  {
    this.descripcion = descripcion;
  }


  public String getUrl()
  {
    return url;
  }


  public void setUrl(String url)
  {
    this.url = url;
  }


public int getFila() {
	return fila;
}


public void setFila(int fila) {
	this.fila = fila;
}


}
