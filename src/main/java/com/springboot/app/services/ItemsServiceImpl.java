package com.springboot.app.services;

import com.springboot.app.persistence.mappers.ItemsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.app.persistence.models.ItemsModel;
import java.text.Normalizer;
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

    for (ItemsModel item : x)
    {
      item.setNombre(this.replaceStr(obj.getNombre(), item.getNombre()));

      item.setDescripcion(this.replaceStr(obj.getDescripcion(),
                                          item.getDescripcion()));
    }

    return x;
  }


  /**
   * METODO PARA REEMPLAZAR LA CADENA BUSCADA EN UN STRING.
   *
   * @param obj  Cadena buscada.
   * @param item Cadena a procesar.
   *
   * @return Cadena reemplazada.
   */
  private String replaceStr(String obj, String item)
  {
    String replace = item;

    obj = this.replaceChar(obj);
    item = this.replaceChar(item);

    Matcher x = this.pattern(obj).matcher(item);

    if (x.find())
    {
      replace = replace.substring(x.start(), x.end());
    }

    return this.pattern(obj).matcher(item)
            .replaceAll(this.patternReplaceHtml(replace));
  }


  /**
   * METODO PARA GENERAR UN PATRON.
   *
   * @param str Cadena a insertar en el patron de busqueda.
   *
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
   *
   * @return tag generado en html.
   */
  private String patternReplaceHtml(String str)
  {
    return "<span class=\"found\">" + str + "</span>";
  }


  /**
   * CONVERSION DEL TEXTO A SU FORMA CANONICAL DECOMPOSITION, REPRESENTANDO LOS
   * CARACTERES UTF-8 COMPRENDIDOS ENTRE U+0300 HASTA U+036F.
   * ------------------------------------
   * <p>
   * "[^\\p{ASCII}]"
   * <p>
   * "[\\p{InCombiningDiacriticalMarks}]"
   *
   * -------------------------------------
   *
   *
   * @param str Cadena a procesar.
   *
   * @return Cadena convertida a UTF-8.
   */
  private String replaceChar(String str)
  {
    String normalize = str.replace("ñ", "\001");

    normalize = Normalizer.normalize(normalize, Normalizer.Form.NFD);
    normalize = normalize.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

    normalize = normalize.replace("\001", "ñ");

    return normalize;
  }

}
