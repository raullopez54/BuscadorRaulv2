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
	 
	 //Cadena introducida para buscar nombre
	 String buscadoNombre = obj.getNombre();
	 //Cadena introducida para buscar limpia
	 String buscadoNombreUTF = UtilStr.replaceChar(buscadoNombre);
	 
	//Cadena introducida para buscar nombre
    String buscadoDescrip = obj.getDescripcion();
    //Cadena introducida para buscar limpia
    String buscadoDescripUTF = UtilStr.replaceChar(buscadoDescrip);
	 
	 System.out.println("Cadena buscado " + buscadoNombre );
	 System.out.println("Cadena buscado " + buscadoNombreUTF );
	 System.out.println("Cadena buscado " + buscadoDescrip );
	 System.out.println("Cadena buscado " + buscadoDescripUTF );
	   
    for (ItemsModel item : x)
    {
    	
			String originalNombre = item.getNombre();
			String originalNombreUTF = UtilStr.replaceChar(originalNombre);
			System.out.println("Cadena original nombre" + originalNombreUTF);

			Matcher match = UtilStr.compareStr(buscadoNombreUTF, originalNombreUTF);

			if (match.find() && (buscadoNombreUTF.length() > 0)) {
				System.out.println("Cadena Nombre" + originalNombreUTF);
				System.out.println("Longitud Nombre" + originalNombreUTF.length());
				// subrayo
				originalNombreUTF = originalNombreUTF.substring(match.start(), match.end());
				item.setNombre(UtilStr.pattern(buscadoNombreUTF).matcher(originalNombreUTF)
						.replaceAll(UtilStr.patternReplaceHtml(originalNombre)));

				// añado a la lista
				busquedaItems.add(item);
			}

			String originalDescrip = item.getDescripcion();
			String originalDescripUTF = UtilStr.replaceChar(originalDescrip);
			System.out.println("Cadena original " + originalDescripUTF);

			Matcher matchDescrip = UtilStr.compareStr(buscadoDescripUTF, originalDescripUTF);

			if (matchDescrip.find() && (buscadoDescripUTF.length() > 0)) {
				System.out.println("Cadena " + originalDescripUTF);
				System.out.println("Longitud " + originalDescripUTF.length());
				// subrayo
				originalDescripUTF = originalDescripUTF.substring(match.start(), match.end());
				item.setDescripcion(UtilStr.pattern(buscadoDescripUTF).matcher(originalDescripUTF)
						.replaceAll(UtilStr.patternReplaceHtml(originalDescrip)));

				// añado a la lista
				busquedaItems.add(item);
			}
      
      
    	
    }
     
    //retorno lista nueva
    return busquedaItems;
  }
  

}