UPDATE piezas P, proveedores PR, suministros SU
SET P.precio = IF(P.precio > 0, P.precio -(P.peso*SU.cantidad), P.precio + (P.peso*SU.cantidad))

WHERE P.id
IN (SELECT PR.id
   FROM proveedores PR)