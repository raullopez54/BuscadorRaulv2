package com.springboot.app.services;

import com.springboot.app.persistence.models.ItemsModel;
import java.util.List;


public interface ItemsService
{

  /**
   * OBTIENE TODOS LOS ITEMS ALMACENADOS.
   *
   * @param obj Objeto tipo ItemsModel.
   *
   * @return Lista de objetos tipo ItemsModel.
   */
  public List<ItemsModel> getItemsService(ItemsModel obj) throws Exception;


  /**
   * OBTIENE TODOS LOS ITEMS ALMACENADOS BASADOS EN UN CRITERIO DE BUSQUEDA.
   *
   * @param obj Objeto tipo ItemsModel.
   *
   * @return Lista de objetos tipo ItemsModel.
   */
  public List<ItemsModel> searchItemsService(ItemsModel obj) throws Exception;
  
  /**
   * INSERTA UN ITEM EN LA BBDD
   * @param obj Objeto tipo ItemsModel
   * @return
  
   */
  public int insertItemsService(ItemsModel obj) throws Exception;
  
  /**
   * ACTUALIZA UN ITEM EN LA BBDD
   * @param obj Objeto tipo ItemsModel
   * @return
   * @throws Exception
   */
  
  public int updateItemsService(ItemsModel obj) throws Exception;
  
  /**
   * BORRA UN ITEM EN LA BBDD
   * @param obj Objeto de tipo ItemsModel
   * @return
   * @throws Exception
   */
  
  public int deleteItemsService(ItemsModel obj) throws Exception;
  
  
  /**
   * INSERTA UN ITEM EN LA BBDD
   * @param obj Objeto tipo ItemsModel
   * @return
  
   */
  public int insertListService(ItemsModel objeto) throws Exception;
  
  /**
   * ACTUALIZA UN ITEM EN LA BBDD
   * @param obj Objeto tipo ItemsModel
   * @return
   * @throws Exception
   */
  
  public List<ItemsModel> updateListService(ItemsModel obj) throws Exception;
  
  /**
   * BORRA UN ITEM EN LA BBDD
   * @param obj Objeto de tipo ItemsModel
   * @return
   * @throws Exception
   */
  
  public List<ItemsModel> deleteListService(ItemsModel obj) throws Exception;

}


