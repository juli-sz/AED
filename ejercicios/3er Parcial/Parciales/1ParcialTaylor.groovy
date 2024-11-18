Accion ParcialTaylor1 (prim: puntero a entrada) es
  ambiente
    fecha= reg
      dia
      mes
      año
    finReg
    entrada = reg
      dni:
      nroFila: entero
      fechaFila: fecha
      fechaEntrada: fecha
      prox: puntero a entrada
    finReg
    p, ant: entrada
    a: arreglo de [1..12][1..31] de entero
    salida=reg
      fecha: fecha
      cantidad: entero
      codigo:
      dni:
    finReg
    Sal,Q,S: salida

    procedimiento borrarP() es
      prim:=*prim.prox
      disponer(p)
      p:=prim
    finProcedimiento

    procedimiento avanzarAtras() es
      mientras *x.fecha=nil hacer
        x:=*x.ant
      fin mientras
    finProcedimiento

    procedimiento avanzarAdelante() es
      mientras *x.fecha=nil hacer
        x:=*x.prox
      fin mientras
    finProcedimiento

    procedimiento cargarBorrar() es
      *q.ant:=x
      *q.prox:=*x.prox
      *(*x.prox).ant:=q
      *x.prox:=q
      *x.cantidad:=*x.cantidad+1
      borrarP()
    finProcedimiento

    procedimiento cargarFecha(d,m,a:entero)
      *q.fecha.dia:=d
      *q.fecha.mes:=m
      *q.fecha.año:=a
    finProcedimiento

  proceso
    p:=prim
    si Sal=nil entonces
      Nuevo(q)
      cargarFecha(9,11,23)
      Sal:=q
      Nuevo(q)
      *q.ant:=Sal
      cargarFecha(10,11,23)
      *Sal.prox:=q
      Nuevo(q)
      *q.ant:=*Sal.prox
      cargarFecha(11,11,23)
      *(*Sal.prox).prox:=q
      ult:=q
    fin si
    x:=Sal
    mientras p<>nil hacer
      nuevo(q)
      codigoCorrespondiente:=a[*p.fechaFila.mes][*p.fechaEntrada.dia]
      *q.codigo:=swiftieEncriptada(*p.nroFila,codigoCorrespondiente)
      *q.dni:=*p.dni
      avanzarAdelante()
      si *p.fechaEntrada=*x.fecha entonces
        cargarBorrar
      si no
        si *p.fechaEntrada<*x.fecha entonces
          avanzarAtras()
          si *p.fechaEntrada<*x.fecha entonces
            avanzarAtras()
          fin si
          cargarBorrar()
        si no 
          avanzarAdelante()
          si *p.fechaEntrada>*x.fecha entonces
            avanzarAdelante()
          finSi
          cargarBorrar()
        fin si
      fin si
    fin mientras
    x:=Sal
    mayor:=*x.cantidad
    mDia:=*x.fecha.dia
    x:=*x.prox
    avanzarAdelante()
    si *x.cantidad>mayor entonces
      mayor:=*x.cantidad
      mDia:=*x.fecha.dia
    fin si
    x:=*x.prox
    avanzarAdelante()
    si *x.cantidad>mayor entonces
      mayor:=*x.cantidad
      mDia:=*x.fecha.dia
    fin si
    Esc("el dia con mas swifties fue: ",mDia,"con ", mayor "swifties")


    

          
          
        
          
      
























    codigoCorrespondiente:=a[*p.fechaFila.mes][*p.fechaEntrada.dia]
    swiftieEncriptada(*p.nroFila,codigoCorrespondiente)