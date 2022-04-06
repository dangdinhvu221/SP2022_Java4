package com.example.DAO;

import java.util.List;

public interface DAO <Entity, Keyword>{
   public abstract Entity insert(Entity entity) ;

   public abstract Entity update(Entity entity);

   public abstract void delete(Keyword key) throws Exception;

   public abstract List<Entity> findAll() ;

   public abstract Entity findByID(Keyword key);

   public List<Entity> findKeyword(String key);
}
