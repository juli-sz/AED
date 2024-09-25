Accion 2.3.2 es
Ambiente
	Empleado = Registro
		nro_sucursal:N(2)
		cantegoria:("A","B","C")
		cod_curso:N(5)
		tecnico:("Si","No")
	Fin_registro
	empleados: archivo de Empleado ordenado por nro_sucursal y cantegoria
	e: empleado
	Fecha = Registro
		Dia
		Mes
		año
	Fin_registro
	Curso = Registro
		cod_curso: N(5)
		nombre: AN(30)
		fecha: Fecha
	Fin_registro
	cursos: archivo de Curso indexado por cod_curso
	c: Curso
	Salida = Registro
		nro_sucursal
		cantegoria
		nombre_empleado
		nombre_curso
	Fin_registro
	sal: archivo de Salida
	s:Salida
	btec,bnotec,btec_total,bnotec_total,atec,anotec,atec_total,anotec_total,ctec,cnotec,ctec_total,cnotec_total:entero
	res_sucursal:N(2)
	res_categoria:("A","B","C")

Proceso
	Abrir E/ (empleados); Abrir E/ (cursos); Abrir /S (sal)
	Leer(empleados,e)
	res_categoria:=e.cantegoria; res_sucursal:=e.nro_sucursal
	//inicializo todos los contadores
	Mientras NFDA(empleados) hacer
		Mientras res_sucursal=e.nro_sucursal hacer
			Mientras res_categoria=e.cantegoria hacer
				c.cod_curso:=e.cod_curso	
				Leer(cursos,c)
				Si EXISTE entonces
					s.nombre_curso:=c.nombre
					s.nro_sucursal:=e.nro_sucursal
					s.cantegoria:=e.cantegoria
					s.nombre_empleado:=e.nombre
				Si no
					Esc("hay un error, código de curso no encontrado")
				Fin si
				Segun e.cantegoria hacer
					="A":
						Si e.tecnico="Si" entonces
							atec:=atec+1
						si no
							anotec:=anotec+1
						fin si
					="B":
						Si e.tecnico="Si" entonces
							btec:=btec+1
						si no
							bnotec:=bnotec+1
						fin si
					="C":
					Si e.tecnico="Si" entonces
						ctec:=ctec+1
					si no
						cnotec:=cnotec+1
					fin si
					otro: Esc("hay un error con la categoria para el curso", e.cod_curso)
				Fin segun
				Leer(empleados,e)
			fin mientras
			Segun res_categoria hacer
				="A":
				Esc("el total de tecnicos para la sucursal",e.sucursal,"y la categoria",res_categoria,"es",atec,", de no tecnicos es",anotec, "y el total de empleados es:",atec+anotec);
				="B":
				Esc("el total de tecnicos para la sucursal",e.sucursal,"y la categoria",res_categoria,"es",btec,", de no tecnicos es",bnotec, "y el total de empleados es:",btec+bnotec);
				="C":
				Esc("el total de tecnicos para la sucursal",e.sucursal,"y la categoria",res_categoria,"es",ctec,", de no tecnicos es",cnotec, "y el total de empleados es:",ctec+cnotec);
			fin segun
			res_categoria:=e.cantegoria
		fin mientras
		Esc("el total de tecnicos por la sucursal",res_sucursal,"es: ",atec+btec+ctec,"la cantidad de no tecnicos es: ", anotec+bnotec+cnotec,"y la cnatidad general de la sucursal es: ",atec+btec+ctec+anotec+cnotec+bnotec)
		atec_total:=atec_total+atec
		btec_total:=btec_total+btec
		ctec_total:=ctec_total+ctec
		atec:=0
		btec:=0
		ctec:=0
		res_sucursal:=e.sucursal
	fin mientras
	Esc("el total general de empleados tecnicos de la categoria A es",atec_total,"de la categoria B",btec_total,"de la categoria C",ctec_total,"de no tecnicos, en el mismo orden es",anotec_total,bnotec_total,cnotec_total,"y el total general de toda la empresa es",atec_total+anotec_total+btec_total+bnotec_total+cnotec_total+ctec_total)
	Cerrar(cursos)
	Cerrar(empleados)
	Cerrar(sal)
Fin Accion









		


