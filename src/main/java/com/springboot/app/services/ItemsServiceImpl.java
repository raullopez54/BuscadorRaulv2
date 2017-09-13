package com.springboot.app.services;

import com.springboot.app.persistence.mappers.ItemsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.app.persistence.models.ItemsModel;
import com.springboot.app.utils.UtilStr;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class ItemsServiceImpl implements ItemsService
{

  @Autowired
  ItemsMapper iMapper;


  @Override
  public List<ItemsModel> getItemsService(ItemsModel obj) throws Exception
  {
    List<ItemsModel> x = iMapper.getItemsMapper(obj);

    return x;
  }


  @Override
  public List<ItemsModel> searchItemsService(ItemsModel obj) throws Exception
  {
    List<ItemsModel> x = iMapper.searchItemsMapper(obj);

    List<ItemsModel> list = this.replaceSearch(obj, x);

    return list;
  }


  /**
   * METODO PARA REEMPLAZAR LA CADENA BUSCADA EN UNA LISTA DE ITEMS.
   *
   * @param obj Cadena a buscar.
   * @param x   Lista a reemplazar.
   *
   * @return Lista de items reemplazada.
   */
  private List<ItemsModel> replaceSearch(ItemsModel obj, List<ItemsModel> x)
  {
	 //Creo una lista nueva
	 List<ItemsModel> busquedaItems = new ArrayList<ItemsModel>();
	 
	 //Cadena introducida para buscar
	 String buscado = obj.getNombre();
	 //Cadena introducida para buscar limpia
	 String buscadoUTF = UtilStr.replaceChar(buscado);
	 
	 System.out.println("Cadena buscado " + buscado );
	 System.out.println("Cadena buscado " + buscadoUTF );
	   
    for (ItemsModel item : x)
    {
    	
    	String original = item.getNombre();
    	String originalUTF = UtilStr.replaceChar(original);
   	    System.out.println("Cadena original " + originalUTF);
   	    
   	    Matcher match = UtilStr.compareStr(buscadoUTF, originalUTF);
    	
      
      if (match.find() && (buscadoUTF.length() > 0))
      {
    	  System.out.println("Cadena " + originalUTF);
    	  System.out.println("Longitud " + originalUTF.length() );
    	  //subrayo
    	  originalUTF = originalUTF.substring(match.start(), match.end());
  		  item.setNombre(UtilStr.pattern(buscadoUTF).matcher(originalUTF).replaceAll(UtilStr.patternReplaceHtml(original)));
    	  
  		  //añado a la lista
    	  busquedaItems.add(item);
      }
      
      
    	
    }
     
    //retorno lista nueva
    return busquedaItems;
  }
  

}