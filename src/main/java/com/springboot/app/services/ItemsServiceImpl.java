package com.springboot.app.services;

import com.springboot.app.persistence.mappers.ItemsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.app.persistence.models.ItemsModel;
import java.text.Normalizer;
import java.util.List;
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

  private List<ItemsModel> replaceSearch(ItemsModel obj, List<ItemsModel> x)
  {

    for (ItemsModel item : x)
    {
      item.setNombre(this.pattern(this.replaceChar(obj.getNombre()))
              .matcher(this.replaceChar(item.getNombre()))
              .replaceAll(this.patternReplace(obj.getNombre())));

      item.setDescripcion(this.pattern(this.replaceChar(obj.getDescripcion()))
              .matcher(this.replaceChar(item.getDescripcion()))
              .replaceAll(this.patternReplace(obj.getDescripcion())));
    }

    return x;
  }

  /**
   * METODO PARA GENERAR UN PATRON.
   *
   * @param str Cadena a insertar en el patron de busqueda.
   * @return Patron generado.
   */
  private Pattern pattern(String str)
  {
    return Pattern.compile("(?i)" + str);
  }

  /**
   * METODO PARA REALIZAR UN REMPLAZO DE UNA CADENA POR UN TAG HTML.
   *
   * @param str Cadena a insertar en el tag.
   * @return tag generado en html.
   */
  private String patternReplace(String str)
  {
    return "<strong class=\"found\">" + str + "</strong>";
  }

  /**
   * CONVERSION DEL TEXTO A SU FORMA CANONICAL DECOMPOSITION, REPRESENTANDO LOS
   * CARACTERES UTF-8 COMPRENDIDOS ENTRE U+0300 HASTA U+036F.
   * ------------------------------------
   *
   * "[^\\p{ASCII}]"
   *
   * "[\\p{InCombiningDiacriticalMarks}]"
   *
   * -------------------------------------
   *
   *
   * @param str Cadena a procesar.
   * @return Cadena convertida a UTF-8.
   */
  private String replaceChar(String str)
  {
    String normalize = Normalizer.normalize(str, Normalizer.Form.NFD);

    return normalize.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
  }

}
