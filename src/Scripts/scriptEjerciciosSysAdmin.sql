

/*1.- Se necesita que un lote de bienes que fue dado por donación, se cambie el estado y que pase a que fue dado de baja.

seria a nivel de aplicacion
*/


/*2.- Se debe eliminar un docente que tiene asignados mas de 5 bienes que no aparecen físicamente y que ya se dieron por perdidos.


1er paso: ELIMINAR LOS bienes
2do paso: eliminarlo del sistema de personal

*/

DELETE FROM TRASLADO WHERE NOINVENTARIO='12-A-7-2020';
DELETE FROM BAJABIEN WHERE NOINVENTARIO='12-A-7-2020';

DELETE FROM BIEN WHERE NOINVENTARIO='12-A-7-2020';

DELETE FROM TRASLADO WHERE NOINVENTARIO='12-A-8-2020';
DELETE FROM BAJABIEN WHERE NOINVENTARIO='12-A-8-2020';

DELETE FROM BIEN WHERE NOINVENTARIO='12-A-8-2020';

DELETE FROM PERSONAL WHERE NOPERSONAL='123456';


/*3.- Se requiere un reporte que contenga los siguientes datos: { docente, división,año_ingreso_docente, totalBienesActivos DESC}

*/

SELECT  BIEN.ENCARGADOACTUAL AS NO_PERSONAL,PERSONAL.NOMBRECOMPLETO, PERSONAL.AREATRABAJO AS DIVISION, YEAR(PERSONAL.FECHACREACION) AS ANIO_INGRESO_DOCENTE, count(*) AS CANTIDAD_BIENES_ACTIVOS, SUM(BIEN.VALORBIEN) AS TOTAL_BIENES_ACTIVOS FROM BIEN INNER JOIN PERSONAL WHERE BIEN.ENCARGADOACTUAL=PERSONAL.NOPERSONAL AND BIEN.ESTADOACTUAL!=0 GROUP BY BIEN.ENCARGADOACTUAL ORDER BY TOTAL_BIENES_ACTIVOS DESC;


/*4.- Realice el siguiente caso: En el 2005 ingresa un docente a ingeniería y en el 2006 se le asigna equipo de computo; en el 2008 empieza a trabajar para económicas y sigue laborando además en ingeniería; en el 2010 se queda trabajando sólo para económicas y en el 2011 el CSU solicita el equipo de vuelta a ingeniería. Se requiere un reporte que muestre esos casos de docentes que realizaron un traslado de bienes, luego de cambiar de división.*/

/* NO APLICA PORQUE LOS TRASLADOS SE HACEN A PERSONAL(DOCENTE,ETC) NO A UNA DIVISION ESPECIFICA*/

SELECT PERSONAL.NOMBRECOMPLETO as ENCARGADO_VIEJO, PERSONAL.AREATRABAJO,getNombreCompletoPersonal( TRASLADO.RESPONSABLENUEVO) AS RESPONSABLE_NUEVO,TRASLADO.DIVISION FROM TRASLADO INNER JOIN PERSONAL WHERE TRASLADO.RESPONSABLEANTERIOR = PERSONAL.NOPERSONAL AND  PERSONAL.AREATRABAJO!=TRASLADO.DIVISION;




/*5/- Se requiere un reporte que contenga lo siguiente: {división, totalBienes, totalBieneActivos, TotalBajas, TotalTraslados, TotalOtros} correspondientes al año pasado.*/


/*mostrar toda la info solicitada por division*/
SELECT DIVISION, COUNT(VALORBIEN) AS TOTAL_BIENES, SUM(VALORBIEN) AS TOTAL_DINERO_BIENES , SUM(IF(ESTADOACTUAL!=0,1,0)) AS TOTAL_BIENES_ACTIVOS ,SUM(IF(ESTADOACTUAL!=0,VALORBIEN,0)) AS TOTAL_DINERO_BIENES_ACTIVOS , SUM(IF(ESTADOACTUAL=0,1,0)) AS TOTAL_BIENES_DE_BAJA, SUM(IF(ESTADOACTUAL=0,VALORBIEN,0)) AS TOTAL_DINERO_BIENES_DE_BAJA FROM BIEN where YEAR(FECHAINGRESO)='2020' GROUP BY DIVISION ;


/*mostrar toda la info solicitada por tipo de ingreso*/
SELECT TIPOINGRESO, COUNT(VALORBIEN) AS TOTAL_BIENES, SUM(VALORBIEN) AS TOTAL_DINERO_BIENES , SUM(IF(ESTADOACTUAL!=0,1,0)) AS TOTAL_BIENES_ACTIVOS ,SUM(IF(ESTADOACTUAL!=0,VALORBIEN,0)) AS TOTAL_DINERO_BIENES_ACTIVOS , SUM(IF(ESTADOACTUAL=0,1,0)) AS TOTAL_BIENES_DE_BAJA, SUM(IF(ESTADOACTUAL=0,VALORBIEN,0)) AS TOTAL_DINERO_BIENES_DE_BAJA FROM BIEN where YEAR(FECHAINGRESO)='2020' GROUP BY TIPOINGRESO;



