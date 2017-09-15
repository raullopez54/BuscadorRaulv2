package com.springboot.app.controllers;


import com.springboot.app.persistence.models.ItemsModel;
import com.springboot.app.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
public class ItemsController
{

  @Autowired
  ItemsService iService;


  @ResponseBody
  @RequestMapping(value = "/getItems",
                  method = RequestMethod.POST,
                  produces = MediaType.APPLICATION_JSON_VALUE)
  public List<ItemsModel> getItems(@RequestBody ItemsModel obj) throws Exception
  {
    List<ItemsModel> x = iService.getItemsService(obj);
    
    
    //***************OBJETO**************************************************
    ItemsModel objeto = new ItemsModel();
    objeto.setNombre("Palmera Kiki");
	objeto.setDescripcion("Descripcion de test");
    objeto.setUrl("https://media-cdn.tripadvisor.com/media/photo-s/0a/f4/3b/9e/caja-palmera.jpg");
	
    ItemsModel objeto1 = new ItemsModel();
    objeto.setNombre("Loca Kiki");
	objeto.setDescripcion("Descripcion de test");
    objeto.setUrl("http://4.bp.blogspot.com/-l0f01Ok20no/UzFf13cbrQI/AAAAAAAAABY/bTbgEXHjETg/s1600/LocaGigante.jpg");
    
    //****************************LISTA***********************************************
    
    ArrayList<ItemsModel> pasteles  = new ArrayList<ItemsModel>();
    pasteles.add(objeto);
    pasteles.add(objeto1);
    
  //********INSERTAR 1 ITEM*******************************************************
    /*int filaInsertada = iService.insertItemsService(objeto);
	  
    objeto.setFila(filaInsertada);
  
  	System.out.println("Se ha introducido " + objeto.getFila() + " fila.");*/
  //************************************************************************************
  	
  //********UPDATE 1 ITEM*******************************************************
    
    /*objeto.setNombre("PRUEBA UPDATED");
	objeto.setDescripcion("Descripcion de test UPDATED");
    objeto.setUrl("http://4.bp.blogspot.com/-l0f01Ok20no/UzFf13cbrQI/AAAAAAAAABY/bTbgEXHjETg/s1600/LocaGigante.jpg");
    objeto.setId(14);
    
    System.out.println("Descripcion " + objeto.getDescripcion() + ".");
    
    int filaUpdate = iService.updateItemsService(objeto);
	  
    objeto.setFila(filaUpdate);
  
  	System.out.println("Se ha modificado " + objeto.getFila() + " fila.");*/
  //************************************************************************************

//********DELETE 1 ITEM*******************************************************
    
    /*objeto.setId(14);
    int filaDeleted = iService.deleteItemsService(objeto);
	  
    objeto.setFila(filaDeleted);
  
  	System.out.println("Se ha borrado " + objeto.getFila() + " fila.");*/
  //************************************************************************************
  	
  //********INSERTAR 2 ITEMS*******************************************************
    
    int listaInsertada = iService.insertListService(pasteles);
	  
    objeto.setFila(filaInsertada);
  
  	System.out.println("Se ha introducido " + objeto.getFila() + " fila.");*/
    
    return x;
  }
  

  
  


  @ResponseBody
  @RequestMapping(value = "/searchItems",
                  method = RequestMethod.POST,
                  produces = MediaType.APPLICATION_JSON_VALUE)
  public List<ItemsModel> searchItems(@RequestBody ItemsModel obj) throws Exception
  {
    List<ItemsModel> x = iService.searchItemsService(obj);

    return x;
  }
  
  /*@ResponseBody
  @RequestMapping(value = "/insertItems",
                  method = RequestMethod.POST,
                  produces = MediaType.APPLICATION_JSON_VALUE)
    
  public boolean insertItems(ItemsModel obj) throws Exception
 
  {
	  ItemsModel objeto = new ItemsModel();
	  objeto.setNombre("PRUEBA");
	  objeto.setDescripcion("Descripcion de test");
	  objeto.setUrl("www.marca.es");
	  
	  
    boolean x = iService.insertItemsService(objeto);
    System.out.println("El resultado es ----> " + x );
    
    if(x) {
    	
    	System.out.println("Se ha introducido una fila");
    }

    return x;
  }*/

}
