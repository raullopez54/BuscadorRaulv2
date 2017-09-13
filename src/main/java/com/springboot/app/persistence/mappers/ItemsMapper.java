package com.springboot.app.persistence.mappers;

import com.springboot.app.persistence.models.ItemsModel;
import java.util.List;


public interface ItemsMapper
{

  /**
   * OBTIENE TODOS LOS ITEMS ALMACENADOS.
   *
   * @param obj Objeto tipo ItemsModel.
   *
   * @return Lista de objetos tipo ItemsModel.
   */
  public List<ItemsModel> getItemsMapper(ItemsModel obj) throws Exception;


  /**
   * OBTIENE TODOS LOS ITEMS ALMACENADOS BASADOS EN UN CRITERIO DE BUSQUEDA.
   *
   * @param obj Objeto tipo ItemsModel.
   *
   * @return Lista de objetos tipo ItemsModel.
   */
  public List<ItemsModel> searchItemsMapper(ItemsModel obj) throws Exception;


  /**
   * INSERTA UN NUEVO ITEM.
   *
   * @param obj Objeto tipo ItemsModel.
   *
   * @return Exito o fracaso de la consulta.
   */
  public int insertItemsMapper(ItemsModel obj) throws Exception;


  /**
   * ACTUALIZA UN ITEM REFERENCIADO POR SU ID.
   *
   * @param obj Objeto tipo ItemsModel.
   *
   * @return Exito o fracaso de la consulta.
   */
  public int updateItemsMapper(ItemsModel obj) throws Exception;


  /**
   * ELIMINA UN ITEM REFERENCIADO POR SU ID.
   *
   * @param obj Objeto tipo ItemsModel.
   *
   * @return Exito o fracaso de la consulta.
   */
  public int deleteItemsMapper(ItemsModel obj) throws Exception;

}