package com.springboot.app.persistence.mappers;


import com.springboot.app.persistence.models.ItemsModel;
import com.springboot.app.utils.UtilStr;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class ItemsMapperImpl implements ItemsMapper
{

  @Autowired
  JdbcTemplate JdbcTemplate;


  @Override
  public List<ItemsModel> getItemsMapper(ItemsModel obj) throws Exception
  {
    String sql = UtilStr.removeSpaces(
            " SELECT * " +
            " FROM items " +
            " ORDER BY id DESC ");

    return JdbcTemplate.query(sql, new BeanPropertyRowMapper(ItemsModel.class));
  }


  @Override
  public List<ItemsModel> searchItemsMapper(ItemsModel obj) throws Exception
  {
    String sql = UtilStr.removeSpaces(
            " SELECT * " +
            " FROM items " +
            " WHERE (nombre LIKE   '%" + obj.getNombre() + "%') " +
            " OR (descripcion LIKE '%" + obj.getDescripcion() + "%') " +
            " ORDER BY id DESC ");

    return JdbcTemplate.query(sql, new BeanPropertyRowMapper(ItemsModel.class));
  }


  @Override
  public int insertItemsMapper(ItemsModel obj) throws Exception
  {
    String sql = UtilStr.removeSpaces(
            " INSERT INTO items " +
            " (nombre, " +
            "  descripcion, " +
            "  url) " +
            " VALUES " +
            " ('" + obj.getNombre() + "'" +
            " ,'" + obj.getDescripcion() + "'" +
            " ,'" + obj.getUrl() + "')");

    return JdbcTemplate.update(sql);
  }


  @Override
  public int updateItemsMapper(ItemsModel obj) throws Exception
  {
    String sql = UtilStr.removeSpaces(
            " UPDATE items     " +
            " SET nombre=     '" + obj.getNombre() + "'" +
            "    ,descripcion='" + obj.getDescripcion() + "'" +
            "    ,url=        '" + obj.getUrl() + "'" +
            " WHERE id=        " + obj.getId());

    return JdbcTemplate.update(sql);
  }


  @Override
  public int deleteItemsMapper(ItemsModel obj) throws Exception
  {
    String sql = UtilStr.removeSpaces(
            " DELETE FROM items " +
            " WHERE id=         " + obj.getId());

    return JdbcTemplate.update(sql);
  }

}