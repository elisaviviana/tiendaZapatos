package com.tz.tiendazapato.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tz.tiendazapato.entidades.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long>  {

	Producto findBycodProductoIs(String codProducto);

    @Query("select p from Producto p where p.codProducto = ?1")
    Producto findCodBarraIs(String codProducto);


}
