/*Inicio de sesion*/
DELIMITER  $$
DROP PROCEDURE IF EXISTS getUsuario;
CREATE PROCEDURE getUsuario(usuarioo VARCHAR(30), contrasenaa TEXT)
BEGIN

	SELECT TipoUsuario,Estado from USUARIO where Usuario=usuarioo AND contrasena=contrasenaa ;
END;
$$
DELIMITER  ;

/*llenar usuarios*/
DELIMITER  $$
DROP PROCEDURE IF EXISTS fillUsuarios;
CREATE PROCEDURE fillUsuarios()
BEGIN
	SELECT usuario,nombreCompleto,dpi,areaTrabajo,tipoUsuario,estado,FECHACREACION,FECHAEDITADO from USUARIO Where usuario!='admin';
END;
$$
DELIMITER  ;


/*llenar proveedores*/
DELIMITER  $$
DROP PROCEDURE IF EXISTS fillProveedores;
CREATE PROCEDURE fillProveedores()
BEGIN
	SELECT * from PROVEEDOR WHERE NIT!=00000000 AND NIT!=10000000 ORDER BY NIT;
END;
$$
DELIMITER  ;


/*llenar personal*/
DELIMITER  $$
DROP PROCEDURE IF EXISTS fillPersonal;
CREATE PROCEDURE fillPersonal()
BEGIN
	SELECT * from PERSONAL WHERE NOPERSONAL!='0';
END;
$$
DELIMITER  ;


/*llenar tipo bien*/
DELIMITER  $$
DROP PROCEDURE IF EXISTS fillTiposBien;
CREATE PROCEDURE fillTiposBien()
BEGIN
	SELECT * from TIPOBIEN ORDER BY CODIGO;
END;
$$
DELIMITER  ;

/*llenar tipo bien*/
DELIMITER  $$
DROP PROCEDURE IF EXISTS fillCodigoBien;
CREATE PROCEDURE fillCodigoBien()
BEGIN
	SELECT Codigo from TIPOBIEN ORDER BY CODIGO;
END;
$$
DELIMITER  ;



DELIMITER $$
DROP TRIGGER IF EXISTS cambiarEstadoBien;
CREATE TRIGGER cambiarEstadoBien AFTER INSERT
ON BAJABIEN FOR EACH ROW  
BEGIN 
	
	UPDATE BIEN SET ESTADOACTUAL=0 WHERE NOINVENTARIO=NEW.NOINVENTARIO;

END;

$$

DELIMITER  ;



