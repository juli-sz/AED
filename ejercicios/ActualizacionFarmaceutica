En una Empresa Farmacéutica se posee un archivo MAE_REMEDIOS (ordenado por Clave: Farmacia + Medicamento), el que se actualiza semanalmente, a traves de la información 
que se encuentra cargada en un archivo de MOVIMIENTOS (ordenado por Clavem: Farmacia + Medicamento, y Cod_Mov), de la siguiente forma:

Si Clave (MAE_REMEDIOS) es menor que Clavem (MOVIMIENTOS), simplemente se transfieren los datos del Maestro a la salida y se graban.

Si Clave (MAE_REMEDIOS) es igual a Clavem (MOVIMIENTOS) y el Codmov es 1, se considera error y se lista un mensaje indicando el tipo de error; pero si el Codmov es 2, 
entonces es un remedio que deja de fabricarse y se transfiere el registro al archivo de Remedios vencidos (REM_VENC) ; pero si el Cod_Mov es 3, se modifica la cantidad a
ctual con la cantidad recibida.

Si Clave (MAE_REMEDIOS) es mayor que Clavem (MOVIMIENTOS) y el Codmov es 1, se incorpora el remedio a nuestro Vademecum, considerando que la cantidad recibida configura la 
cantidad actual y la Fecha_Vencimiento es 30 días posterior a la fecha actual; pero si el Codmov es 2 o 3 se considera error y se deben producir los correspondientes mensajes de error.

Se considera que solo existe un registro de movimiento para cada registro del maestro.


Ambiente
    Fecha = registro
        Dia: N(2)
        Mes=("1",,,"12")
        año: N(5)
    Fin_registro   
    Maestro = registro
        Farmacia: AN(30)
        medicamento:AN(50)
        cantidad_actual:N(4)
        vencimiento:fecha
    fin_registro 
    Movimiento = registro
        Farmacia: AN(30)
        medicamento:AN(50)
        cod_mov:
        cantidad:
    fin_registro
    Rem_venc = registro
        medicamento:AN(50)
        unidadesvencidas:N(4)
    fin_registro
    mae: archivo de Maestro ordenado por farmacia y medicamentos
    mov: archivo de movimiento ordeando por famrmacia, medicamento y cod_movimiento
    venc: archivo de Rem_venc ordenado por medicamento
    sal: archivo de Maestro
    reg1,resg1:mae
    reg2:mov
    reg3:venc
    reg_sal:sal

Proceso
 
    Abrir E/ (mae); 
    Abrir E/ (mov)
    Abrir /S (venc)
    Abrir /S (salida)
    Leer(mae,reg1); Leer(mov,reg2)

    Mientras NFDA (mae) o NFDA (mov) hacer
        Si (reg1.Farmaacia = reg2.farmacia) entonces 
            Si (reg1.medicamento = reg2.medicamento) entonces  
                Segun (reg2.cod_mov) hacer
                    =1: Escribir ("error 927 en este tipo de medicamento") 
                    =2: Escribir ("este medicamento vencio")
                        reg3.medicamento:=reg1.medicamento
                        reg3.unidadesvencidas:=reg1.cantidad_actual
                        grabar(venc,reg3)
                    =3: reg1.cantidad_actual:=reg2.cantidad
                        grabar(sal,reg1)  
                Fin_segun
                Leer(mae,reg1)
                Leer(mov,reg2)
            Sino
                Si (reg1.medicamento < reg2.medicamento) entonces
                    Grabar(sal,reg1)
                    Leer(mae,reg1)
                Sino 
                    Segun reg2.cod_mov hacer
                        =1:
                            si fecha_actual-reg1.Fecha_Vencimiento > 30 hacer
                                reg_sal.farmacia:=reg1.farmacia
                                reg_sal.medicamento:=reg1.medicamento
                                reg_sal.cantidad_actual:=reg2.cantidad
                                reg_sal.vencimiento:=reg1.vencimiento
                                Grabar(sal,reg_sal)
                            fin_si
                        =2: Escribir ("ese medicamento no lo trabajamos ni trabajaremos")
                        =3: Escribir ("ese medicamento no lo trabajaos ni trambajaremos")
                    Fin_segun
                Fin_si
            Fin_si
        Sino
            Si reg1.farmacia < reg2.farmacia entonces
                resg1:=reg1
                mientras reg1.farmacia = resg1.farmacia hacer 
                    escribir(sal,reg1)
                    leer(mae,reg1)
                Fin_mientras    
            Sino
                resg2:=reg1
                Mientras resg2.farmacia=reg1.farmacia hacer
                    Segun reg2.cod_mov hacer
                        =1: si (fecha_actual-reg1.Fecha_Vencimiento) > 30 hacer
                                reg_sal.farmacia:=reg1.farmacia
                                reg_sal.medicamento:=reg1.medicamento
                                reg_sal.cantidad_actual:=reg2.cantidad
                                reg_sal.vencimiento:=reg1.vencimiento
                                Grabar(sal,reg_sal)
                            Fin_si   
                        =2 :Escribir ("ese medicamento no lo trabajamos ni trabajaremos")
                        =3 :Escribir ("ese medicamento no lo trabajaos ni trambajaremos")
                    Fin_segun  
                    Leer(mov,reg2)
                Fin_mientras
            Fin_si
        Fin_si
    Fin_mientras
    Cerrar(mae);Cerrar(mov)

Fin_Accion
                      



                
     
     Leer(mae)
     Leer(mov)

    Fin_mientras

    Cerrar(mae)
    Cerrar(mov)
    Cerrar(sal)
    Cerrar(venc)
     