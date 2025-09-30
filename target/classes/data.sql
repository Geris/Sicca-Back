
INSERT INTO estado_perfil(nombre) VALUES ('Activo');
INSERT INTO perfil(
	direccion, email, fecha_registro, nombre, password, telefono, ultima_modificacion, estado)
	VALUES ('Alvear 1212', 'juanDoe@gmail.com', '2025-07-01', 'Juan Doe', '12345', '1150504545', null, 1);

INSERT INTO estado_invernadero (nombre) VALUES ('Activo');
INSERT INTO public.invernadero(fecha_actualizacion, fecha_creacion, nombre, ubicacion, estado, id_perfil)
	VALUES (null, '2025-09-13', 'Invernadero Cannabis Indica X2', 'Los Hornos', 1, 1);

-- especie
INSERT INTO public.especie(
	nombre, nombre_cientifico)
	VALUES ('Sativa', 'Cannabis sativa');

INSERT INTO public.especie(
	nombre, nombre_cientifico)
	VALUES ('Indica', 'Cannabis indica');

-- cultivo
INSERT INTO public.cultivo(
	descripcion, fecha_fin, fecha_inicio, nombre, severidad, tipo, especie, estado_crecimiento, id_invernadero, id_parametro_cultivo)
	VALUES ('Cultivo Indica X2 - 1', '2026-09-09', '2025-09-09', 'Cultivo 1', null, null, 1, null, 1, null);

INSERT INTO public.cultivo(
	descripcion, fecha_fin, fecha_inicio, nombre, severidad, tipo, especie, estado_crecimiento, id_invernadero, id_parametro_cultivo)
	VALUES ('Cultivo Sativa X1 - 2', '2026-09-09', '2025-09-09', 'Cultivo 1 Sativa', null, null, 1, null, 1, null);


--select * from estado_perfil;
--select * from perfil;
--select * from estado_invernadero;
--select * from invernadero;
--select * from especie;
--select * from cultivo;